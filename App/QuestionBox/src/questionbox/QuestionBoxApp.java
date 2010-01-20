/*
 * QuestionBoxApp.java
 * Appfrica Labs Uganda Ltd Copyrigth @since 2009
 * @version 2
 *
 * This was the start up form but its just left here for the aplication to work.
 */

package questionbox;

import org.jdesktop.application.Application;
import org.jdesktop.application.SingleFrameApplication;


/**
 * The main class of the application.
 */
public class QuestionBoxApp extends SingleFrameApplication {

    

    /**
     * At startup create and show the main frame of the application.
     */
    @Override protected void startup() {
      
    }

    /**
     * This method is to initialize the specified window by injecting resources.
     * Windows shown in our application come fully initialized from the GUI
     * builder, so this additional configuration is not needed.
     */
    @Override protected void configureWindow(java.awt.Window root) {
    }

    /**
     * A convenient static getter for the application instance.
     * @return the instance of QuestionBoxApp
     */
    public static QuestionBoxApp getApplication() {


        return Application.getInstance(QuestionBoxApp.class);
    }

 /**
     * Main method launching the application.
     */
       
    public static void main(String[] args) {
        launch(QuestionBoxApp.class, args);
    }
}
