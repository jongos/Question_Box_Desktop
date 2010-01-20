/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package qbox.model;

import java.sql.*;
import java.lang.*;
import java.util.*;

// import org.apache.log4j.Logger;

/**
 *
 * @author ivank
 */
public class DataAccess {

    public static String DataSource = "jdbc:mysql://localhost/questionbox";
    public static String Username = "root";
    public static String Password = "kanasepc";

    //        static Logger logger = Logger.getLogger("ftl.DataAccess");

  //  public static String ConfigFileName = "C:\\Program Files\\Apache Software Foundation\\Tomcat 5.5\\webapps\\FTWeb\\WEB-INF\\web.xml";

     public   static Connection getConnection() throws Exception {
        try {



           // Config config = new Config();
           // AppConfigParser ACP =  new AppConfigParser(ConfigFileName);
          //  config.DataSource =

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

    public static ResultSet ExecuteQuery2(String Query) throws Exception
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
                    return prepstm.executeQuery();

             }
               catch(Exception e)
             {
                 throw new Exception("<br/>" + prepstm.toString() + " <br/> "+ e.getMessage() +"<br/>"+ e.getStackTrace());
             }
    }


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

    private static  PreparedStatement ParseParameter(PreparedStatement prepstm, Object[] parameter) throws Exception
    {
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

                    /*
                        prepstm.setString(1, town);  */
           }
             return prepstm;
    }

    public static boolean ExecuteNonQuery(String Query , Object[] parameter) throws Exception
    {
                    String param = "";
                    Connection dbconnection = null;
                    PreparedStatement prepstm = null;
                try {


                         if(DataAccess.getConnection() == null)
                         {
                          throw new Exception("Database Connection was not successfully.");
                         }

                        dbconnection = DataAccess.getConnection() ;
                        prepstm =   dbconnection.prepareStatement(Query);

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
                      throw new Exception(prepstm.toString() + "<br/>" + Query + " <br/> "+ e.getMessage() +"<br/>"+ e.getStackTrace());
                    //  return false;
                }

    }


}
