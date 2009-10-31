/**
 *
 * Appfrica Labs Uganda Ltd Copyrigth @since 2009
 * @version 2
 *
 * This class manages the Categories of queries that callers are asking about.
 *
 */
package qbox.model;

import java.sql.*;
import java.lang.*;
import java.util.*;

// import org.apache.log4j.Logger;

/**
 *
 * @author Ivan Kavuma
 * 
 */
public class DataAccess {

    //These parameter are used to set the database connection information.
    public static String DataSource;// = "jdbc:mysql://localhost/questionbox";
    public static String Username ;//= "root";
    public static String Password ;//= "kanasepc";


    /**
     * This function sets up the connection to the database. it takes the parameters set above
     * to connect to the database.
     * @return
     * @throws Exception
     */
    public   static Connection getConnection() throws Exception {
        try {


             Class.forName("com.mysql.jdbc.Driver").newInstance();

             return DriverManager.getConnection(
                                       DataSource,
                                       Username,
                                       Password);
        }
        catch (ClassNotFoundException e) {
            throw new SQLException("No driver found for " + "com.mysql.jdbc.Driver");
        }
        catch (InstantiationException e) {
            throw new SQLException("Driver " + "com.mysql.jdbc.Driver" + " could not be instantiated.");
        }
        catch (IllegalAccessException e) {
            throw new SQLException("Driver " + "com.mysql.jdbc.Driver" + " could not be instantiated: " + e.getMessage());
        }
        catch (Exception e)
        {
            throw new Exception(e.getMessage());
        }
    }

    /**
     * This function is used to execute queries agained the above connection that return a resultset.
     * It is for queries that don't have parameters.
     * @param Query
     * @return ResultSet
     * @throws Exception
     */
    public static ResultSet ExecuteQuery2(String Query) throws Exception
    {
        return ExecuteQuery(Query,null);
    }

    /**
     * This function is used to execute queries agained the above connection that return a resultset.
     * It takes an array of objects as parameters.
     * @param Query
     * @param parameter
     * @return
     * @throws Exception
     */
    public static ResultSet ExecuteQuery(String Query, Object[] parameter) throws Exception
    {

                    Connection dbconnection = null;
                     PreparedStatement prepstm = null;
         try{
                     if(DataAccess.getConnection() == null)
                     {
                      throw new Exception("Database Connection was not successfully.");
                     }

                    dbconnection = DataAccess.getConnection() ;
                    prepstm =   dbconnection.prepareStatement(Query);
                    if(parameter != null)
                    {
                        prepstm = ParseParameter(prepstm,parameter);
                    }
                    return    prepstm.executeQuery();

             }
               catch(Exception e)
             {
                 throw new Exception("<br/>" + prepstm.toString() + " <br/> "+ e.getMessage() +"<br/>"+ e.getStackTrace());
             }
    }

    /**
     * This function parses parameters from an array of objects and assigns the parameter list in the prepared Statement.
     *
     * @param prepstm
     * @param parameter
     * @return
     * @throws Exception
     */
    private static  PreparedStatement ParseParameter(PreparedStatement prepstm, Object[] parameter) throws Exception
    {
            //For each of the parameters determine the type and then convert the value of that
            // parameter to the corresponding type as you assign it to the prepared statement value
            // in that position.
             for(int index = 0;index < parameter.length ; index++)
            {
                 if (parameter[index] == null)
                     parameter[index] = "";

                  if(parameter[index] instanceof String || parameter[index] instanceof UUID )
                   {
                       prepstm.setString(index+1,parameter[index].toString());
                   }
                   else if(parameter[index].getClass().getName().equals("java.lang.Integer"))
                   {
                       int valueInt = Integer.parseInt(parameter[index].toString());
                       prepstm.setInt(index+1,valueInt);
                   }
                   else if(parameter[index].getClass().getName().equals("java.sql.Timestamp"))
                   {
                              Calendar cal = Calendar.getInstance();
                            prepstm.setTimestamp(index+1,Util.Now(),cal);

                   }
                   else if(parameter[index].getClass().getName().equals("java.lang.Float"))
                   {
                       prepstm.setFloat(index+1,Float.parseFloat(parameter[index].toString()));
                   }
                   else if(parameter[index].getClass().getName().equals("java.lang.Double"))
                   {
                        prepstm.setDouble(index+1,Double.parseDouble(parameter[index].toString()));
                   }
                   else if(parameter[index].getClass().getName().equals("java.lang.Long"))
                   {
                       prepstm.setDouble(index+1,Long.parseLong(parameter[index].toString()));
                   }
                    else if(parameter[index].getClass().getName().equals("java.lang.Boolean"))
                   {
                       prepstm.setBoolean(index+1,Boolean.parseBoolean(parameter[index].toString()));
                   }

           }
             return prepstm;
    }

    /**
     * This function is used to execute inserts and updates that don't need to return results.
     * @param Query
     * @param parameter
     * @return
     * @throws Exception
     */
    public static boolean ExecuteNonQuery(String Query , Object[] parameter) throws Exception
    {
                    String param = "";
                    Connection dbconnection = null;
                    PreparedStatement prepstm = null;
               try
               {
                       if(DataAccess.getConnection() == null)
                       {
                          throw new Exception("Database Connection was not successfully.");
                       }

                    dbconnection = DataAccess.getConnection() ;
                    prepstm =   dbconnection.prepareStatement(Query);

                    //This checks that number of "?" in the prepared statement matches the number of parameters.
                    //If not an error is thrown.
                    String[] paramList = Query.split("\\?");
                    if(paramList == null || parameter == null )
                        throw new Exception("Either No ? characters or parameter and null");

                     if(parameter.length != paramList.length-1)
                        throw new Exception("Parameters in the String don't match Parameter in the array object");

                    prepstm = ParseParameter(prepstm,parameter);

                    prepstm.executeUpdate();

                    return true;
                 }
                catch(Exception e)
                {
                    //  logger.error("Error in DataAcess.Insert: "+e.getMessage());
                      throw new Exception(prepstm.toString() + "<br/>\n" + Query + " <br/> \n"+ e.getMessage() +"<br/>\n"+ e.getStackTrace());
                    //  return false;
                }

    }


}
