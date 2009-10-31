/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Testmodel;

import junit.framework.*;
import qbox.model.*;
/**
 *
 * @author ivank
 */
public class TestUser  extends TestCase {

    public void TestAdd()
    {
        testUserAddition();
        TestLogin();
    }


    public static void TestLogin()
    {
        try
        {

            User user = User.Login("Jerry", null);
          //  assertEquals(user,null
            System.out.println(user.getUsername());
        }
        catch(Exception e)
        {

        }

    }

    public static void testUserAddition()
    {
        try
        {
        //Setup the first user.
        User user = new User();
        user.setEmail("jerry@appfrica.org");
        user.setExpertize("Computer Guy");
        user.setGender("F");
        user.setFname("jerry");
        user.setLname("Opolot");
        user.setPassword("pass");
        user.setPhone("8328230023");
        user.setUsername("xhah");
        user.setTypeid(1);


        user.AddUser();

        //check that the user was added.
         User user2 = User.getUser(user.getUserid());
         assertEquals(user2.getUsername(),"xhah");
             

         //check that the update works.
         user.setPassword("Confidential");
         user.UpdateUser();

        assertEquals(User.getUser(user.getUserid()).getPassword(),"Confidential");



         //check that the logical delete works
         user.DeleteUser();
         assertEquals(User.getUser(user.getUserid()).getUsername() , null);
      
        }
        catch(Exception ex)
        {
            System.out.println(ex.getMessage());
            System.out.println("One of the User Tests Failed!");
        }
        finally
        {
              //Clean up code
            Object[] param = {"xhah"};
            try{
            DataAccess.ExecuteNonQuery("delete from qbuser where username = ?;", param);
            }catch(Exception ex){}

        }
     }

    public static void main(String[] args) throws Exception
    {
       // testUserAddition();
       TestLogin();
    }

}
