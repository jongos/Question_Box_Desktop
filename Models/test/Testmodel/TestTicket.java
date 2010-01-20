/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Testmodel;

import junit.framework.*;
import qbox.model.*;
import java.util.*;

/**
 *
 * @author ivank
 */
public class TestTicket extends TestCase  {





   //Add a test for the ticket.
   public void testAdd()
   {
       TestTicket();

   }


    public static long AddUser(long Type,String name ) throws Exception
    {
        User user = new User();
        user.setUsername(name);
        user.setTypeid(Type);
        user.AddUser();
        System.out.println("User " + name + " of the type " + Type );
        return user.getUserid();
    }

    public static long AddCategory() throws Exception
    {
        Category cat =  new Category();
        cat.setTitle("Heroscope");
        cat.AddCategory();
        System.out.println("Category was added Successfully!");
        return cat.getCategoryID();
    }


    public static long AddQuery() throws Exception
    {
        Query qry = new Query();
        qry.setDetails("When is moses's birthday");
        qry.setCategoryid(AddCategory());
        qry.AddQuery();
        System.out.println("Query was added successfully!");
        return qry.getQueryid();
    }

    public static long AddStatus(String state) throws Exception
    {
        Status status =  new Status();
        status.setDescr(state);
        status.AddStatus();
         System.out.println("Status was added successfully!");
         return status.getStatusID();
    }

    public static long AddAnswer() throws Exception
    {
        Answer ans =  new Answer();
        ans.SetDetails("Some time in August ");
        ans.AddAnswer();
        System.out.println("Answer was added successfully!");
        return ans.getAnswerid();
    }




    public static void TestTicket()
    {
        try
        {
            Ticket ticket =  new Ticket();
            ticket.setStartTime(Util.Now());
            ticket.setEndTime(Util.Now());
            ticket.setOperatorid(AddUser(1,"Ivan"));
            ticket.setCallerid(AddUser(4,"Jerry"));
            ticket.setQueryid(AddQuery());
            ticket.setStatusid(AddStatus("UnAnswered"));
            ticket.setAnserid(AddAnswer());
            ticket.setExpertid(AddUser(3,"Jon"));

            ticket.AddTicket();

            assertEquals(Ticket.getTicket(ticket.getTicketid()).getOperatorid() ,ticket.getOperatorid());
            //    System.out.println("Add Ticket Test Passed!");
           // else
           //     System.out.println("Add Ticket Test Failed!");

            ticket.setStatusid(AddStatus("Completed"));
            ticket.UpdateTicket();

            if(Status.getStatus(Ticket.getTicket(ticket.getTicketid()).getStatusid()).getDescr().equals("Completed"))
                System.out.println("Update Ticket Test Passed!");
            else
                System.out.println("Update Ticket Test Failed!");



        }
        catch(Exception ex)
        {
            System.out.println(ex.getMessage());
            System.out.println("One of the tests in Adding a Ticket failed!");
        }
    }




    public static void main(String[] args) throws Exception
    {

       Ticket.getPendingTickets(1);

       // TestTicket();
    }
}

