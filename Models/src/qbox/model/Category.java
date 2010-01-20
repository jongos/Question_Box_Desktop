/**
 *
 * Appfrica Labs Uganda Ltd Copyrigth @since 2009
 * @version 2
 *
 * This class manages the Categories of queries that callers are asking about.
 *
 */
package qbox.model;

import java.util.*;
import java.sql.ResultSet;

/**
 *
 * @author Administrator
 */
public class Category {
    
    private long CategoryID;
    private String Descr;
    private String Title;
    
    public long getCategoryID()
    {
        return this.CategoryID;
    }
    public void setCategoryID(long val)
    {
        this.CategoryID = val;
    }
    public String getDescr()
    {
        return this.Descr;
    }

    public void setDescr(String val)
    {
        this.Descr = val;
    }
    public String getTitle()
    {
        return this.Title;
    }
    public void setTitle(String val)
    {
        this.Title = val;
    }

    public static long getCategoryIDByTitle(String title)
    {
        try{
             String query = " SELECT CategoryID , Title " +
                        " FROM  qbcategory  WHERE Title = ? AND Active = 1   ";

             Object[] parameter = {title};
             ResultSet rs =  DataAccess.ExecuteQuery(query,parameter);

              ArrayList<Category> categorys = new ArrayList<Category>();

               while(rs.next())
               {
                   return rs.getLong("CategoryID");
               }
             
        }catch(Exception e) { }
         return 0;
    }

    public boolean Exists() throws Exception
    {
         String query = " SELECT Title " +
                        " FROM  qbcategory  WHERE Title = ? AND Active = 1   ";

         Object[] parameter = {this.Title};
         ResultSet rs =  DataAccess.ExecuteQuery(query,parameter);

          ArrayList<Category> categorys = new ArrayList<Category>();

           while(rs.next())
           {
              return true;
           }
           return false;
    }

    public boolean AddCategory() throws Exception
    {
        if(!Exists()){
            this.CategoryID = Util.getNewid("category");
             String query = " INSERT INTO qbcategory (CategoryID,Descr,Title," +
                    " DateCreated, DateUpdated ) " +
                "values (?,?,?,?,?) ";

            Object[] parameter = {this.CategoryID,this.Descr,this.Title,
                              Util.Now(),Util.Now()};
            return DataAccess.ExecuteNonQuery(query,parameter );
        }
        else
            return false;
    }

    public boolean UpdateCategory() throws Exception
    {
       String query = " UPDATE qbcategory SET Descr = ?,Title = ? " +
                " , DateUpdated = ?  " +
                " WHERE CategoryID = ? ";

        Object[] parameter = {this.Descr,this.Title,
                              Util.Now(),this.CategoryID};
       return DataAccess.ExecuteNonQuery(query,parameter );
    }


    public static Category getCategory(long CategoryID) throws Exception
    {
         String query = " SELECT CategoryID,Descr,Title " +
                        " FROM  qbcategory  WHERE  CategoryID = ? AND Active = 1   ";

         Object[] parameter =  {CategoryID};

          ResultSet rs =  DataAccess.ExecuteQuery( query, parameter);

           Category category = new Category();
           while(rs.next())
           {
              
              category.setCategoryID(rs.getLong("CategoryID"));
              category.setDescr(rs.getString("Descr"));
              category.setTitle(rs.getString("Title"));
 
           }
           return category;
    }

     public static ArrayList<Category> getAllCategorys() throws Exception
     {
            String query = " SELECT CategoryID,Descr,Title " +
                        " FROM  qbcategory  WHERE Active = 1   ";

          ResultSet rs =  DataAccess.ExecuteQuery2(query);

          ArrayList<Category> categorys = new ArrayList<Category>();

           while(rs.next())
           {
              Category category = new Category();
              category.setCategoryID(rs.getLong("CategoryID"));
              category.setDescr(rs.getString("Descr"));
              category.setTitle(rs.getString("Title"));
         
              categorys.add(category);
           }
           return categorys;
     }




}
