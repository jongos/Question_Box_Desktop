package qbox.model;
/*
 * Appfrica Labs Uganda Ltd Copyrigth @since 2009
 * @version 2
 *
 * This class Manages users who include operators, adminstrator, and experts and callers
 * 
 *
 */

import java.util.*;
import java.sql.ResultSet;


/**
 *
 * @author ivank
 */
public class UserType {

    private long usertypeid;
    private String descr;

    /**
     * getUsertypeid()
     * @return long
     */
    public long getUsertypeid()
    {
        return this.usertypeid;
    }

    /**
     * setUsertypeid(long val)
     * @param val long
     */
    public void setUsertypeid(long val)
    {
        this.usertypeid = val;
    }

    /**
     * getDescr()
     * @return String
     */
    public String getDescr()
    {
        return this.descr;
    }
    
    /**
     * setDescr(String val)
     * @param val String
     */
    public void setDescr(String val)
    {
        this.descr = val;
    }

    /**
     * ArrayList<UserType> getUserTypes() throws Exception
     * @return ArrayList<UserType>
     * @throws Exception
     */
    public static ArrayList<UserType> getUserTypes() throws Exception
    {
       String query = " SELECT UsertypeID, Descr FROM  qbusertype WHERE  Active = 1  ";
       ResultSet rs =  DataAccess.ExecuteQuery2(query);
       ArrayList<UserType> userTypes = new ArrayList<UserType>();

       while(rs.next())
       {
          UserType userType = new UserType();
          userType.setUsertypeid(rs.getLong("UsertypeID"));
          userType.setDescr(rs.getString("Descr"));
          userTypes.add(userType);
       }
       return userTypes;
    }

}
