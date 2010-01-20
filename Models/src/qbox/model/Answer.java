/**
 *
 * Appfrica Labs Uganda Ltd Copyrigth @since 2009
 * @version 2
 *
 * This class manages the queries that callers are asking about.
 *
 */
package qbox.model;


import java.util.*;
import java.sql.ResultSet;
/**
 *
 * @author ivank
 */
public class Answer {

    private long Answerid;
    private String Source;
    private String Details;
    private String Link_to_answer;
    private long Categoryid;

    public long getAnswerid()
    {
        return this.Answerid;
    }
    public void setAnswerid(long val)
    {
        this.Answerid = val;
    }
    public String getSource()
    {
        return this.Source;
    }
    public void setSource(String val)
    {
        this.Source = val;
    }
    public String getDetails()
    {
        return this.Details;
    }
    public void setDetails(String val)
    {
        this.Details = val;
    }
    public String getLink_to_answer()
    {
        return this.Link_to_answer;
    }
    public void setLink_to_answer(String val)
    {
        this.Link_to_answer = val;
    }
    public long getCategoryid()
    {
        return this.Categoryid;
    }
    public void setCategoryid(long val)
    {
        this.Categoryid = val;
    }


    /**
     * This function Searches in answers for those similary in natural language fulltext search
     * @param Searchquery
     * @param limit
     * @param CategoryID
     * @return
     * @throws Exception
     */
    public static ArrayList<Result> Search(String Searchquery,int limit,long CategoryID) throws Exception
    {
        ArrayList<Result> results = new ArrayList<Result>();

        String query = " SELECT AnswerID, "+
                    " MATCH ( Details ) AGAINST ( ? ) AS Score FROM qbanswer " +
                    " WHERE CategoryID = ? AND MATCH ( Details ) AGAINST ( ? ) ORDER BY score DESC LIMIT ?  ";


        Object[] parameter = {Searchquery,CategoryID,Searchquery,limit};

        ResultSet rs = DataAccess.ExecuteQuery(query, parameter);

        while (rs.next())
        {
            Result res = new Result();
           res.Key = getAnswer(rs.getLong("AnswerID"));
           res.Value = rs.getFloat("Score");
           results.add(res);
        }
        return results;
    }



    /**
     * This function save the answer object to the database.  It assumes that
     * all the attributes have been set.
     * @return true if successful otherwise false.
     * @throws Exception
     */
    public boolean AddAnswer() throws Exception
    {
        this.Answerid = Util.getNewid("answer");
         String query = " INSERT INTO qbanswer (AnswerID,Source,Details," +
                " Link_to_answer, CategoryID ,DateCreated, DateUpdated ) " +
                "values (?,?,?,?,?,?,?) ";

        Object[] parameter = {this.Answerid,this.Source,this.Details,
                              this.Link_to_answer,this.Categoryid,Util.Now(),Util.Now()};
       return DataAccess.ExecuteNonQuery(query,parameter );
    }

    /**
     * This function update the database with the changed information.
     * @return true if update is successful.
     * @throws Exception
     */
    public boolean UpdateAnswer() throws Exception
    {
         String query = " UPDATE qbanswer SET Source = ?,Details = ?," +
                " Link_to_answer = ?, CategoryID = ?, DateUpdated = ?  " +
                " WHERE AnswerID = ? ";

        Object[] parameter = {this.Source,this.Details,
                              this.Link_to_answer,this.Categoryid,Util.Now() ,this.Answerid };
       return DataAccess.ExecuteNonQuery(query,parameter );
    }

    /**
     * This function fetches the answer from the database and returns an answer object.
     * @param answerid
     * @return Answer object
     * @throws Exception
     */
    public static Answer getAnswer(long answerid) throws Exception
    {
        String query = " SELECT AnswerID,Source,Details," +
                " Link_to_answer, CategoryID FROM qbanswer WHERE AnswerID = ? ";

        Object[] parameter = {answerid};

        ResultSet rs = DataAccess.ExecuteQuery(query,parameter );

        Answer answer = new Answer();
        while(rs.next())
        {
            answer.setAnswerid(rs.getLong("AnswerID"));
            answer.setSource(rs.getString("Source"));
            answer.setDetails(rs.getString("Details"));
            answer.setLink_to_answer(rs.getString("Link_to_answer"));
            answer.setCategoryid(rs.getInt("CategoryID"));
        }
        return answer;
    }

}
