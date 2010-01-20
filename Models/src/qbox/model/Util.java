/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package qbox.model;

import java.util.Calendar;
import java.util.Date;
import java.text.*;
import java.sql.*;
import java.lang.*;


/**
 *
 * @author ivank
 */
public class Util {

    public static String Capitalize(String val)
    {
        String returnVal = "";
        if (val.length() > 0)
            returnVal = val.substring(0, 1).toUpperCase() + val.substring(1, val.length());
        return returnVal;

    }



    /**
     * This function details the next index from a given table name.
     * @param tablename
     * @return long
     * @throws Exception
     */
    public static long getNewid(String tablename) throws Exception
    {
      try
      {
           long  Nextid = 0;
           String query = " SELECT Max("+ Util.Capitalize(tablename) +"ID ) as Newid FROM qb"+ tablename ;
           ResultSet rs = DataAccess.ExecuteQuery2(query);
           while(rs.next())
           {  Nextid = rs.getLong("Newid");   }
           Nextid++;
           return Nextid;
       }
        catch(Exception ex)
       {
            throw new Exception("Fail to obtain an index for " + tablename );
       }

    }

/**
 * Gets the current Timestamp of default format EEE MMM dd H:mm:ss z yyyy
 * @return java.sql.Timestamp
 */
    public static java.sql.Timestamp Now()
    {
        java.sql.Timestamp returnVal = null;
      try{
            Calendar cal = Calendar.getInstance();
           returnVal = toTimestamp(cal.getTime().toString());
        }
        catch(Exception e)
        {
            System.out.print(e.getMessage());
        }
           return returnVal;
    }

    public static java.sql.Timestamp toTimestamp(Object dateobj) throws Exception
    {
        return toTimestamp(dateobj.toString());
    }

    /**
     * Converts date from String to sql timeStamp type using the default Format (EEE MMM dd H:mm:ss z yyyy).
     * @param DateString
     * @return java.sql.Timestamp
     * @throws Exception
     */
    public static java.sql.Timestamp toTimestamp(String DateString) throws Exception
    {
         long longDate = (long)new Date().getTime();
        try
        {
            java.sql.Date sdt ;
            SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM dd H:mm:ss z yyyy");
            java.util.Date  udt  = (java.util.Date)sdf.parse(DateString);

            longDate = (long)udt.UTC(udt.getYear(), udt.getMonth(), udt.getDate(), udt.getHours(), udt.getMinutes(), udt.getSeconds());
         }
        catch (ParseException e){
            throw new Exception(e.getMessage());
        }
           return   new java.sql.Timestamp(longDate);
    }



}
