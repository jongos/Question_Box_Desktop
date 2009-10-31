/**
 *
 * Appfrica Labs Uganda Ltd Copyright @since 2009
 * @version 2
 *
 * This class Manages RecommendedSites which are used for the search of the caller queries.
 *
 * @author Ivan Kavuma
 */
package qbox.model;

import java.util.*;
import java.sql.ResultSet;


/**
 *
 * @author Ivan Kavuma
 */
public class RecommendedSite {

    private long Recommendedsiteid;
    private String Url;
    private String Name;


 public long getRecommendedsiteid()
    {
        return this.Recommendedsiteid;
    }

    public void setRecommendedsiteid(long val)
    {
        this.Recommendedsiteid = val;
    }

    public String getUrl()
    {
        return this.Url;
    }
    public void setUrl(String val)
    {
        this.Url = val;
    }
    public String getName()
    {
        return this.Name;
    }
    public void setName(String val)
    {
        this.Name = val;
    }


    /**
     * This function adds recommended site to the database for use in the online search later.
     * @return true if added successfully otherwise false.
     * @throws Exception
     */
    public boolean AddRecommendedSite() throws Exception
    {
        this.Recommendedsiteid = Util.getNewid("RecommendedSite");
        String query = " INSERT INTO qbrecommendedsite (RecommendedsiteID,Url,Name "+
                " ,DateCreated,DateUpdated ) " +
                " VALUES (?,?,?,?,?) ";

        Object[] parameter = {this.Recommendedsiteid,this.Url,this.Name,
                              Util.Now(),Util.Now()};

       return DataAccess.ExecuteNonQuery(query,parameter );

    }

    /**
     * This function updates the recommented sites
     * @return true if added successfully otherwise false.
     * @throws Exception
     */
    public boolean UpdateRecommendedSite() throws Exception
    {

        String query = " UPDATE qbrecommendedsite SET Url =? ,Name = ? "+
                " ,DateUpdated = ? WHERE RecommendedsiteID = ? " ;

        Object[] parameter = {this.Url,this.Name,
                              Util.Now(),this.Recommendedsiteid};

       return DataAccess.ExecuteNonQuery(query,parameter );

    }

    /**
     * Get the whole list of recommented sites from the database.
     * To be used in the dropdowns and combo-boxes.
     * @return ArrayList<RecommendedSite>
     * @throws Exception
     */
     public static ArrayList<RecommendedSite> getRecommendedSites() throws Exception
    {

        String query = " SELECT RecommendedsiteID,Url,Name FROM qbrecommendedsite " ;

        ResultSet rs = DataAccess.ExecuteQuery2(query);

        ArrayList<RecommendedSite> recSites = new  ArrayList<RecommendedSite>();

        while (rs.next())
        {
           RecommendedSite site = new RecommendedSite();
           site.setRecommendedsiteid(rs.getLong("RecommendedsiteID"));
           site.setName(rs.getString("Name"));
           site.setUrl(rs.getString("Url"));
           recSites.add(site);
         }
        return recSites;
    }


}


