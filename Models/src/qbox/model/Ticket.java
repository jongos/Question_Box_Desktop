/**
 * 
 * Appfrica Labs Uganda Ltd Copyrigth @since 2009
 * @version 2
 *
 * This class manages the tickets that are added to the system to track the
 * queries that callers have from start then the query comes in to when
 * it end or is closed out.
 *
 */

package qbox.model;

import java.util.*;
import java.sql.ResultSet;

/**
 * Ticket
 * @author ivank
 */
public class Ticket {

    private long ticketid;
    private java.sql.Timestamp startTime;
    private java.sql.Timestamp endTime;
    private long operatorid;
    private long callerid;
    private long queryid;
    private long statusid;
    private long answerid;
    private long expertid;

    public long getTicketid()
    {
        return this.ticketid;
    }
    public void setTicketid(long val)
    {
        this.ticketid = val;
    }
    public java.sql.Timestamp getStartTime()
    {
        return this.startTime;
    }
    public void setStartTime(java.sql.Timestamp val)
    {
        this.startTime = val;
    }

    public java.sql.Timestamp getEndTime()
    {
        return this.endTime;
    }
    public void setEndTime(java.sql.Timestamp val)
    {
        this.endTime =  val;
    }
    public long getOperatorid()
    {
        return this.operatorid;
    }
    public void setOperatorid(long val)
    {
        this.operatorid = val;
    }
    public long getCallerid()
    {
       return this.callerid;
    }
    public void setCallerid(long val)
    {
        this.callerid = val;
    }
    public long getQueryid()
    {
        return this.queryid;
    }
    public void setQueryid(long val)
    {
        this.queryid = val;
    }
    public long getStatusid()
    {
        return this.statusid;
    }
    public void setStatusid(long val)
    {
        this.statusid = val;
    }
    public long getAnserid()
    {
        return this.answerid;
    }
    public void setAnserid(long val)
    {
        this.answerid = val;
    }
    public long getExpertid()
    {
        return this.expertid;
    }
    public void setExpertid(long val)
    {
        this.expertid = val;
    }

    /**
    * This function Saves the ticket information to the database.
    * @return true if row is added successfully, else false.
    * @throws Exception
    */
    public boolean AddTicket() throws Exception
    {
        this.ticketid = Util.getNewid("ticket");
        String query = " INSERT INTO qbticket (TicketID,Starttime,Endtime,OperatorID," +
                " CallerID,QueryID,StatusID,AnswerID,ExpertID," +
                " DateUpdated ) " +
                " VALUES (?,?,?,?,?,?,?,?,?,?) ";

        Object[] parameter = {this.ticketid,this.startTime,this.endTime,this.operatorid,
                              this.callerid,this.queryid,this.statusid,
                              this.answerid,this.expertid,
                              Util.Now()};

       return DataAccess.ExecuteNonQuery(query,parameter );

    }
        /**
    * This function Saves updates the ticket information to the database.
    * @return true if row is added successfully, else false.
    * @throws Exception
    */
    public boolean UpdateTicket() throws Exception
    {
        String query = " UPDATE qbticket SET Starttime = ? ,Endtime = ? ,OperatorID = ? ," +
                " CallerID = ? ,QueryID = ? ,StatusID = ? ,AnswerID = ? ,ExpertID = ? " +
                " , DateUpdated = ?  " +
                " WHERE TicketID = ? ";

        Object[] parameter = {this.startTime,this.endTime,this.operatorid,
                              this.callerid,this.queryid,this.statusid,
                              this.answerid,this.expertid,
                              Util.Now(),this.ticketid };

       return DataAccess.ExecuteNonQuery(query,parameter );
    }


    public static Ticket getTicketByQuery(long QueryID) throws Exception
    {
        Ticket ticket =  new Ticket();
        String query = " SELECT TicketID FROM qbticket WHERE QueryID = ? LIMIT 1 " ;

        Object[] parameter = {QueryID};

        ResultSet rs = DataAccess.ExecuteQuery(query, parameter);

        while(rs.next())
        {
            return getTicket(rs.getLong("TicketID"));
        }
        return null;
    }


    /**
     * This function gets a ticket from the database based on the ticketid passed.
     * @param ticketid
     * @return ticket object
     * @throws Exception
     */
    public static Ticket getTicket(long ticketid) throws Exception
    {
        Ticket ticket =  new Ticket();
        String query = " SELECT TicketID ,Starttime,Endtime,OperatorID," +
                " CallerID,QueryID,StatusID,AnswerID,ExpertID" +
                " FROM qbticket WHERE TicketID = ? " ;
        
        Object[] parameter = {ticketid};

        ResultSet rs = DataAccess.ExecuteQuery(query, parameter);

        while(rs.next())
        {
            ticket.setTicketid(rs.getLong("TicketID"));
            ticket.setStartTime(rs.getTimestamp("Starttime"));
            ticket.setEndTime(rs.getTimestamp("Endtime"));
            ticket.setOperatorid(rs.getLong("OperatorID"));
            ticket.setCallerid(rs.getLong("CallerID"));
            ticket.setQueryid(rs.getLong("QueryID"));
            ticket.setStatusid(rs.getLong("StatusID"));
            ticket.setAnserid(rs.getLong("AnswerID"));
            ticket.setExpertid(rs.getLong("ExpertID"));

        }
        
        return ticket;

    }

    /**
     * This function returns a list of tickets based on the status of tickets required
     * for a given operator.
     * @param Statusid, operator
     * @return ArrayList<Ticket>
     * @throws Exception
     */
    public static ArrayList<Ticket> getTicketsByStatus(long Statusid,long operatorid) throws Exception
    {
        ArrayList<Ticket> tickets = new ArrayList<Ticket>();

        String query = " SELECT TicketID ,Starttime,Endtime,OperatorID," +
                " CallerID,QueryID,StatusID,AnswerID,ExpertID" +
                " FROM qbticket " +
                " WHERE  StatusID = ? AND OperatorID = ? " ;
        
        Object[] parameter = { Statusid , operatorid };

        ResultSet rs = DataAccess.ExecuteQuery(query, parameter);

        while(rs.next())
        {
            Ticket ticket =  new Ticket();
            ticket.setTicketid(rs.getLong("TicketID"));
            ticket.setStartTime(rs.getTimestamp("Starttime"));
            ticket.setEndTime(rs.getTimestamp("Endtime"));
            ticket.setOperatorid(rs.getLong("OperatorID"));
            ticket.setCallerid(rs.getLong("CallerID"));
            ticket.setQueryid(rs.getLong("QueryID"));
            ticket.setStatusid(rs.getLong("StatusID"));
            ticket.setAnserid(rs.getLong("AnswerID"));
            ticket.setExpertid(rs.getLong("ExpertID"));

            tickets.add(ticket);
        }

        return tickets;
    }


    /**
     *
     * @param Statusid
     * @param operatorid
     * @return
     * @throws Exception
     */
     public static ArrayList<Ticket> getPendingTickets(long operatorid) throws Exception
    {
        ArrayList<Ticket> tickets = new ArrayList<Ticket>();

        String query = " SELECT TicketID ,Starttime , Endtime , OperatorID," +
                " CallerID,QueryID,StatusID,AnswerID,ExpertID " +
                " FROM qbticket " +
                " WHERE  StatusID <> 7 AND OperatorID = ? " ;  //need to fix the hard coded statusid

        Object[] parameter = {  operatorid };

        ResultSet rs = DataAccess.ExecuteQuery(query, parameter);

        while(rs.next())
        {
            Ticket ticket =  new Ticket();
           System.out.println(" TicketID " + rs.getLong("TicketID"));
            ticket.setTicketid(rs.getLong("TicketID"));
            ticket.setStartTime(rs.getTimestamp("Starttime"));
            ticket.setEndTime(rs.getTimestamp("Endtime"));
            ticket.setOperatorid(rs.getLong("OperatorID"));
            ticket.setCallerid(rs.getLong("CallerID"));
            ticket.setQueryid(rs.getLong("QueryID"));
            ticket.setStatusid(rs.getLong("StatusID"));
            ticket.setAnserid(rs.getLong("AnswerID"));
            ticket.setExpertid(rs.getLong("ExpertID"));

            tickets.add(ticket);
        }

        return tickets;
    }
}
