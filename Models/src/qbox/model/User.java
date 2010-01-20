

package qbox.model;

/**
 *
 * Appfrica Labs Uganda Ltd Copyrigth @since 2009
 * @version 2
 *
 * This class Manages users who include operators, adminstrator, and experts and callers
 * 
 * @author ivank
 */

import java.util.*;
import java.sql.ResultSet;

public class User {

   private long userid;
   private String email;
   private String Fname;
   private String Lname;
   private String phone;
   private String gender;
   private long typeid;
   private String username;
   private String password;
   private String expertize;

   public User()
   {
       
   }

   /**
    * public String getFname()
    * @return String
    */
   public String getFname()
   {
       return this.Fname;
   }

   /**
    * public void setFname(String val)
    * @param val String
    */
   public void setFname(String val)
   {
       this.Fname = val;
   }

   /**
    *  public String getLname()
    * @return String
    */
   public String getLname()
   {
       return this.Lname;
   }

   /**
    *  public void setLname(String val)
    * @param val String
    */
   public void setLname(String val)
   {
       this.Lname = val;
   }

   /**
    * public long getUserid()
    * @return String
    */
   public long getUserid()
   {
       return this.userid;
   }
   
   /**
    * public void setUserid(long val)
    * @param val
    */
   public void setUserid(long val)
   {
       this.userid = val;
   }
   
   /**
    * public String getEmail()
    * @return String
    */
   public String getEmail()
   {
       return email;
   }

   /**
    * public void setEmail(String val)
    * @param val
    */
   public void setEmail(String val)
   {
       this.email = val;
   }
   
   /**
    * public String getPhone()
    * @return String
    */
   public String getPhone()
   {
       return this.phone;
   }

   /**
    * public void setPhone(String val)
    * @param val String
    */
   public void setPhone(String val)
   {
       this.phone = val;
   }
   
   /**
    *  public String getGender()
    * @return String
    */
   public String getGender()
   {
       return this.gender;
   }

   /**
    * public void setGender(String val)
    * @param val
    */
   public void setGender(String val)
   {
       this.gender = val;
   }
   
   /**
    * public long getType()
    * @return long
    */
   public long getTypeid()
   {
       return this.typeid;
   }
   public void setTypeid(long val)
   {
       this.typeid = val;
   }
   
   /**
    * public String getUsername()
    * @return String
    */
   public String getUsername()
   {
       return this.username;
   }

   /**
    * public void setUsername(String val)
    * @param val
    */
   public void setUsername(String val)
   {
       this.username = val;
   }
   
   /**
    * public String getPassword()
    * @return
    */
   public String getPassword()
   {
       return this.password;
   }
   
   /**
    * public void setPassword(String val)
    * @param val
    */
   public void setPassword(String val)
   {
       this.password = val;
   }

   /**
    * public String getExpertize()
    * @return
    */
   public String getExpertize()
   {
       return this.expertize;
   }
   
   /**
    *  public void setExpertize(String val)
    * @param val
    */
   public void setExpertize(String val)
   {
       this.expertize = val;
   }

 
   /**
    * This function Saves the user information to the database.
    * @return true if row is added successfully, else false.
    * @throws Exception
    */
    public boolean AddUser() throws Exception
    {
          if( !this.username.equals("") && !Exists(this.username) )
         {
            this.userid = Util.getNewid("user");
            String query = " INSERT INTO qbuser (UserID,FirstName,LastName,Email," +
                    " PhoneNumber,Gender,TypeID,UserName,Password, Expertize ," +
                    " DateCreated, DateUpdated ) " +
                    " VALUES (?,?,?,?,?,?,?,?,?,?,?,?) ";

            Object[] parameter = {this.userid,this.Fname,this.Lname,this.email,
                                  this.phone,this.gender,this.typeid,
                                  this.username,this.password,
                                  this.expertize,Util.Now(),Util.Now()};

           return DataAccess.ExecuteNonQuery(query,parameter );
         }
         else
         {
             throw new Exception("The username " + this.username + " already exists");
         }

    }

    /**
     * This function is used to update the user at the database level.
     * @return true if user is update successfully and false otherwise.
     * @throws Exception
     */
     public boolean UpdateUser() throws Exception
     {
       
            String query = " UPDATE qbuser SET FirstName = ?,LastName = ?,Email = ?," +
                            " PhoneNumber = ?,Gender = ?,TypeID = ?,UserName = ?,Password = ?, Expertize = ? " +
                            " , DateUpdated  = ? " +
                            " WHERE UserID = ?  ";

            Object[] parameter = {this.Fname,this.Lname,this.email,
                                  this.phone,this.gender,this.typeid,
                                  this.username,this.password,
                                  this.expertize,Util.Now(),
                                  this.userid};

            return DataAccess.ExecuteNonQuery(query,parameter );
        
     }

     /**
      * This function should be used to check if a user exist in the system or not.
      * @param Username
      * @return true if the user exist otherwise false if a user does not.
      * @throws Exception
      */
      public static boolean Exists(String Username) throws Exception
      {
        String query = " SELECT  UserName  FROM   qbuser WHERE UserName = ?  AND Active = 1 ";
        Object[] parameter = {Username};
        ResultSet rs =  DataAccess.ExecuteQuery(query,parameter );

         while(rs.next()){
             if(rs.getString("UserName").equals(Username)){
                  return true;
              }
         }
        return false;
     }

      /**
       * This function gets all the user information from the database based given a user id.
       * if no user is found an empty user object is returned.
       * @param username
       * @return a user object with all the attributes filled in.
       * @throws Exception
       */
      public static User getUserByUsername(String username) throws Exception
      {
          User user = new User();

         String query = " SELECT UserID ,FirstName,LastName,UserName, Password ," +
                        " Email, PhoneNumber, Gender , TypeID, Expertize  " +
                        " FROM  qbuser  WHERE Username = ?  AND Active = 1   ";
         Object[] parameter = {username};
         ResultSet rs =  DataAccess.ExecuteQuery(query,parameter );

         while(rs.next()) {
              user.setUserid(rs.getLong("UserID"));
              user.setTypeid(rs.getLong("TypeID"));
              user.setFname(rs.getString("FirstName"));
              user.setLname(rs.getString("LastName"));
              user.setEmail(rs.getString("Email"));
              user.setGender(rs.getString("Gender"));
              user.setPhone(rs.getString("PhoneNumber"));
              user.setExpertize(rs.getString("Expertize"));
              user.setUsername(rs.getString("UserName"));
              user.setPassword(rs.getString("Password"));
          }

         return user;
      }



     /**
      * This function gets all the user information from the database based given a user id.
      * if no user is found an empty user object is returned.
      * @param userid
      * @return a user object with all the attributes filled in.
      * @throws Exception
      */
     public static User getUser(Long userid) throws Exception
     {
         User user = new User();

         String query = " SELECT UserID ,FirstName,LastName,UserName, Password ," +
                        " Email, PhoneNumber, Gender , TypeID, Expertize  " +
                        " FROM  qbuser  WHERE UserID = ?  AND Active = 1   ";
         Object[] parameter = {userid};
         ResultSet rs =  DataAccess.ExecuteQuery(query,parameter );

         while(rs.next()) {
              user.setUserid(rs.getLong("UserID"));
              user.setTypeid(rs.getLong("TypeID"));
              user.setFname(rs.getString("FirstName"));
              user.setLname(rs.getString("LastName"));
              user.setEmail(rs.getString("Email"));
              user.setGender(rs.getString("Gender"));
              user.setPhone(rs.getString("PhoneNumber"));
              user.setExpertize(rs.getString("Expertize"));
              user.setUsername(rs.getString("UserName"));
              user.setPassword(rs.getString("Password"));
          }

         return user;
     }
      
      /**
       * This function is used for login into the application.
       * it check if the user is authorized to login and then returns the
       * user object with all the fields filed in. Otherwise a null object is return.
       * @param username
       * @param Password
       * @return user object.
       * @throws Exception
       */
      public static User Login(String username,String Password) throws Exception
     {
        String query = " SELECT  UserID FROM  qbuser WHERE UserName = ? AND Password = ?  AND Active = 1  ";
        Object[] parameter = {username,Password};
        ResultSet rs = DataAccess.ExecuteQuery(query,parameter );

        Long userid = null;

        while(rs.next())
        {
           userid = rs.getLong("UserID") ;
        }

        if(userid == null)
        {
            return null;
        }else
            return User.getUser(userid);

     }
      
      
      /**
       * This function gets all the active users from the database
       * and returns an arraylist of objects.
       * @return ArrayList<user>
       * @throws Exception
       */
      public static ArrayList<User> getAllUsers() throws Exception
     {
            String query = " SELECT UserID ,FirstName,LastName,UserName, Password ," +
                        " Email, PhoneNumber, Gender , TypeID, Expertize  " +
                        " FROM  qbuser  WHERE Active = 1   ";

          ResultSet rs =  DataAccess.ExecuteQuery2(query);

          ArrayList<User> Users = new ArrayList<User>();

           while(rs.next())
           {
              User user = new User();
              user.setUserid(rs.getLong("UserID"));
              user.setTypeid(rs.getLong("TypeID"));
              user.setFname(rs.getString("FirstName"));
              user.setLname(rs.getString("LastName"));
              user.setEmail(rs.getString("Email"));
              user.setGender(rs.getString("Gender"));
              user.setPhone(rs.getString("PhoneNumber"));
              user.setExpertize(rs.getString("Expertize"));
              user.setUsername(rs.getString("UserName"));
              user.setPassword(rs.getString("Password"));
              Users.add(user);
           }
           return Users;
     }

     public boolean DeleteUser() throws Exception
     {

          String query = " UPDATE qbuser SET Active = 0 , DateUpdated = ?" +
                            " WHERE UserID = ?  ";

            Object[] parameter = {Util.Now(), this.userid};

            return DataAccess.ExecuteNonQuery(query,parameter );
     }


}
