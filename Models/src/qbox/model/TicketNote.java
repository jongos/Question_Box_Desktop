/**
 *
 * Appfrica Labs Uganda Ltd Copyrigth @since 2009
 * @version 2
 *
 * This class Manages Ticket Notes. Ticket notes are the notes that are added to a ticket
 * as it progress between different statuses or stages. So that other operators know what is going
 * on with a particular ticket from day to day.
 *
 * @author ivank
 */
package qbox.model;

import java.util.*;
import java.sql.ResultSet;



/**
 *
 * @author Administrator
 */
public class TicketNote {

    private long Ticketid;
    private long TicketNoteid;
    private String Notes;
    private java.sql.Timestamp DateUpdated;

    public java.sql.Timestamp getDateUpdated()
    {
        return this.DateUpdated;
    }
    private void setDateUpdated(java.sql.Timestamp val)
    {
        this.DateUpdated = val;
    }


    public long getTicketid()
    {
        return this.Ticketid;
    }

    public void setTicketid(long val)
    {
        this.Ticketid = val;
    }

    public long getTicketNoteid()
    {
        return this.getTicketNoteid();
    }


    public void setTicketNoteid(long val)
    {
        this.TicketNoteid = val;
    }
    
     public String getNote()
    {
        return this.Notes;
    }

    public void setNotes(String val)
    {
        this.Notes = val;
    }


     /**
    * This function Saves the ticketNotes information to the database.
    * @return true if row is added successfully, else false.
    * @throws Exception
    */
    public boolean AddTicketNote() throws Exception
    {
        this.TicketNoteid = Util.getNewid("TicketNote");
        String query = " INSERT INTO qbticketnote (TicketnoteID,TicketID,Notes "+
                " ,DateCreated,DateUpdated ) " +
                " VALUES (?,?,?,?,?) ";

        Object[] parameter = {this.TicketNoteid,this.Ticketid,this.Notes,
                              Util.Now(),Util.Now()};

       return DataAccess.ExecuteNonQuery(query,parameter );

    }
        /**
    * This function Saves updates the ticketNotes information to the database.
    * @return true if row is added successfully, else false.
    * @throws Exception
    */
    public boolean UpdateTicketNote() throws Exception
    {
        String query =" UPDATE qbticketnote SET Notes = ?,DateUpdated = ? "+
                " WHERE TicketnoteID = ? ";

        Object[] parameter = {this.Notes, Util.Now(),this.TicketNoteid};

       return DataAccess.ExecuteNonQuery(query,parameter );
    }



    /**
     * this function gets one ticketnotes object from the the database based on the ticketnotesid passed.
     * @return TicketNote object
     * @throws Exception
     */
    public static TicketNote getTicketNote(long TicketNoteid) throws Exception
    {
       String query = " SELECT TicketID, TicketnoteID, Notes,DateUpdated FROM  qbticketnote  WHERE TicketnoteID = ? Active = 1  ";
       Object[] parameter = {TicketNoteid};
       ResultSet rs =  DataAccess.ExecuteQuery(query,parameter);

       TicketNote ticknote = new TicketNote();

       while(rs.next())
       {
          ticknote.setTicketNoteid(rs.getLong("TicketnoteID"));
          ticknote.setTicketid(rs.getLong("TicketID"));
          ticknote.setNotes(rs.getString("Notes"));
          ticknote.setDateUpdated(rs.getTimestamp("DateUpdated"));
       }
       return ticknote;
    }

 /**
 * Returns all the ticket notes associated with ticket.
 * @param TicketID
 * @return
 * @throws Exception
 */
     public static ArrayList<TicketNote> getTicketNotes(long TicketID) throws Exception
    {
       String query = " SELECT TicketID, TicketnoteID, Notes FROM  qbticketnote  WHERE TicketID = ?  ";
       Object[] parameter = {TicketID};
       ResultSet rs =  DataAccess.ExecuteQuery(query,parameter);

       ArrayList<TicketNote> ticknotes = new ArrayList<TicketNote>();

       while(rs.next())
       {
          TicketNote ticknote = new TicketNote();
          ticknote.setTicketNoteid(rs.getLong("TicketnoteID"));
          ticknote.setTicketid(rs.getLong("TicketID"));
          ticknote.setNotes(rs.getString("Notes"));
          ticknote.setDateUpdated(rs.getTimestamp("DateUpdated"));
          ticknotes.add(ticknote);
       }
       return ticknotes;
    }

}

