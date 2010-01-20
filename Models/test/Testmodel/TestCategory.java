/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Testmodel;

import qbox.model.*;
/**
 *
 * @author ivank
 */
public class TestCategory {

    private static void TestCategory()
    {
        try{
        Category cat = new Category();
        cat.setTitle("Health");
        cat.AddCategory();

        Category cat1 = new Category();
        cat1.setTitle("Agriculture");
        cat1.AddCategory();

        Category cat2 = new Category();
        cat2.setTitle("History");
        cat2.AddCategory();

        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

     public static void main(String[] args) throws Exception
    {
        TestCategory();
    }

}
