/**
 *
 * Appfrica Labs Uganda Ltd Copyrigth @since 2009
 * @version 2
 *
 * This class manages the Status of tickets created by operators.
 *
 */

package qbox.model;


import java.util.*;
import java.sql.ResultSet;
/**
 *
 * @author ivank
 */
public class Status {

    private long StatusID;
    private String Descr;

    public long getStatusID()
    {
        return this.StatusID;
    }
    public void setStatusID(long val)
    {
        this.StatusID = val;
    }
    public String getDescr()
    {
        return this.Descr;
    }
    public void setDescr(String val)
    {
        this.Descr = val;
    }

    /**
     * Allows admin to define status for the tickets.
     * @return true if inserted successfully otherwise false.
     * @throws Exception
     */
    public boolean AddStatus() throws Exception
    {
        this.StatusID = Util.getNewid("status");
         String query = " INSERT INTO qbstatus (StatusID,Descr )" +
                            "values (?,?) ";

        Object[] parameter = {this.StatusID,this.Descr};
       return DataAccess.ExecuteNonQuery(query,parameter );
    }

     /**
     * Updates status for the tickets.
     * @return true if inserted successfully otherwise false.
     * @throws Exception
     */
     public boolean UpdateStatus() throws Exception
    {
         String query = " UPDATE qbstatus SET StatusID = ? ,Descr = ?" +
                            " WHERE  StatusID = ? ";

        Object[] parameter = {this.Descr,this.StatusID};
       return DataAccess.ExecuteNonQuery(query,parameter );
    }

    public static Status getStatusbyDesc(String Descr) throws Exception
    {
           String query = " SELECT StatusID,Descr  " +
                        " FROM  qbstatus  WHERE Descr = ? AND Active = 1   ";

           Object[] parameter = {Descr};

           ResultSet rs =  DataAccess.ExecuteQuery(query,parameter);

           Status status = new Status();

           while(rs.next())
           {
              status.setStatusID(rs.getLong("StatusID"));
              status.setDescr(rs.getString("Descr"));
           }
           return status;
    }




    public static Status getStatus(long Statusid) throws Exception
    {
           String query = " SELECT StatusID,Descr  " +
                        " FROM  qbstatus  WHERE StatusID = ? AND Active = 1   ";

           Object[] parameter = {Statusid};

           ResultSet rs =  DataAccess.ExecuteQuery(query,parameter);

           Status status = new Status();

           while(rs.next())
           {
              status.setStatusID(rs.getLong("StatusID"));
              status.setDescr(rs.getString("Descr"));
           }
           return status;
    }
     /**
      * This function returns a list of all the status in the system.
      * @return ArrayList<Status>
      * @throws Exception
      */
     public static ArrayList<Status> getAllStatuss() throws Exception
     {
            String query = " SELECT StatusID,Descr  " +
                        " FROM  qbstatus  WHERE Active = 1   ";

          ResultSet rs =  DataAccess.ExecuteQuery2(query);

          ArrayList<Status> statuses = new ArrayList<Status>();

           while(rs.next())
           {
              Status status = new Status();
              status.setStatusID(rs.getLong("StatusID"));
              status.setDescr(rs.getString("Descr"));
              statuses.add(status);
           }
           return statuses;
     }

}
