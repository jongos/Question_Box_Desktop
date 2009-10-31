/**
 *
 * Appfrica Labs Uganda Ltd Copyrigth @since 2009
 * @version 2
 *
 * This class manages the queries that callers are asking about.
 *
 */
package qbox.model;

import java.lang.*;
import java.util.*;
import java.sql.ResultSet;

/**
 *
 * @author Ivan Kavuma
 */
public class Query {
    private long queryid;
    private long categoryid;
    private String details;
    private String querySource;

    public long getQueryid()
    {
        return this.queryid;
    }
    public void setQueryid(long val)
    {
        this.queryid = val;
    }
    public long getCategoryid()
    {
        return this.categoryid;
    }
    public void setCategoryid(long val)
    {
        this.categoryid = val;
    }
    public String getDetails()
    {
        return this.details;
    }
    public void setDetails(String val)
    {
        this.details = val;
    }
    public String getQuerySource()
    {
        return this.querySource;
    }
    public void setQuerySource(String val)
    {
        this.querySource = val;
    }

    /**
     * This function adds the Query to the database.
     * @return true if successfully added otherwise false.
     * @throws Exception
     */
    public boolean AddQuery() throws Exception
    {
        this.queryid = Util.getNewid("query");
         String query = " INSERT INTO qbQuery (QueryID,CategoryID,Details," +
                " Querysource, DateUpdated ) " +
                " VALUES (?,?,?,?,?) ;";

        Object[] parameter = {this.queryid,this.categoryid,this.details,
                              this.querySource,Util.Now()};
       return DataAccess.ExecuteNonQuery(query,parameter );
    }


/**
 *  This function searches queries in Natural language fulltext search for question that where answered previously.
 * @param Searchquery
 * @param limit number of results to return
 * @param CategoryID
 * @return ArrayList<Result>
 * @throws Exception
 */
    public static ArrayList<Result> Search(String Searchquery,int limit,long CategoryID) throws Exception
    {
        ArrayList<Result> results = new ArrayList<Result>();

        //This query looks in the qbquery table for the query in a given category and limits the number of
        //results.  It also uses a score of relevance from the text search.
        String query = " SELECT QueryID, CategoryID, Details, Querysource, "+
                    " MATCH ( Details ) AGAINST ( ? ) AS Score FROM qbquery " +
                    " WHERE CategoryID = ? AND MATCH ( Details ) AGAINST ( ? ) ORDER BY score DESC LIMIT ?  ";


        Object[] parameter = {Searchquery,CategoryID,Searchquery,limit};

        ResultSet rs = DataAccess.ExecuteQuery(query, parameter);
        
        while (rs.next())
        {
            Result res = new Result();

            //Try to find a ticket from database corresponding to the query found.
            Ticket tick = Ticket.getTicketByQuery(rs.getLong("QueryID"));

            //If ticket is found and the its status is completed, then return the ticket and the score/relevance
            //of the ticket.
            if(tick != null && tick.getStatusid() == Status.getStatusbyDesc("Completed").getStatusID())
            {   res.Key = tick;
                res.Value = rs.getFloat("Score");
                results.add(res);
            }

        }
        return results;
    }

    /**
     * To update the Query table all value must be set before calling this
     * message.
     * @return false if successful otherwise false.
     * @throws Exception
     */
    public boolean UpdateQuery() throws Exception
    {
         String query = " UPDATE qbquery SET CategoryID = ?, Details = ?," +
                " QuerySource = ? , DateUpdated = ? " +
                " WHERE QueryID = ? ";

        Object[] parameter = {this.categoryid,this.details,
                              this.querySource,Util.Now(),this.queryid};

       return DataAccess.ExecuteNonQuery(query,parameter );
    }

    /**
     * Search the database for a query by the given query id.
     * @param queryid
     * @return Query object.
     * @throws Exception
     */
    public static Query getQuery(Long queryid) throws Exception
    {
        String query = " SELECT QueryID,CategoryID,Details," +
                " Querysource FROM qbquery WHERE QueryID = ? ";
        Object[] parameter = {queryid};

        ResultSet rs = DataAccess.ExecuteQuery(query, parameter);
        Query qry = new Query();
        while (rs.next())
        {
            qry.setQueryid(rs.getLong("QueryID"));
            qry.setCategoryid(rs.getInt("CategoryID"));
            qry.setDetails(rs.getString("Details"));
            qry.setQuerySource(rs.getString("Querysource"));
        }
        return qry;
    }
}
