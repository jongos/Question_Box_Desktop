/**
 *
 * Appfrica Labs Uganda Ltd Copyrigth @since 2009
 * @version 2
 *
 * Login.java
 *
 * This is the login form.  It determines which form should open depending on if a user
 * is an adminitrator or operator.
 *
 * Created on Oct 19, 2009, 1:13:08 PM
 */


package questionbox;


import javax.swing.JOptionPane;
import java.io.*;
import qbox.model.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Victor Miclovich
 */
public class Login extends javax.swing.JFrame{

    /**
     * the configuration file with the database connect.
     */
    private static String ConfigfilePath = "DatabaseConfig.txt";

    /**
     * This function reads the database configuration file
     * and set the database connection information of the dataaccess class.
     */
    private static void readDatabaseConfig()
    {
        File file = new File(ConfigfilePath);
        try {
            BufferedReader br = new BufferedReader(
                                new InputStreamReader(
                                new FileInputStream(file)));
            String line;
            while((line = br.readLine()) != null)
            {   System.out.println(line);
                if(line.contains("DataSource="))
                    DataAccess.DataSource=line.replace("DataSource=","");
                else if(line.contains("Username="))
                    DataAccess.Username=line.replace("Username=","");
                else if(line.contains("Password="))
                    DataAccess.Password=line.replace("Password=","");
            }
            br.close();

            Category.getAllCategorys();

        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, "Failed to read the " + ConfigfilePath + " Or Failed to connect with the information supplied.\n"+
                                                "Make sure the " + ConfigfilePath + " is in the root location of\n" +
                                                "the application and the connection information is accurate and " +
                                                "try again!\n","Error",JOptionPane.ERROR_MESSAGE);
            System.out.println(e.getMessage());
            System.exit(1);
        }

    }




    /**
     * Creates new form Login
     * and sets the label text and button text
     */
    public Login() {
        initComponents();
        this.setTitle("Login Form");
        lblUsername.setText("Username");
        lblPassword.setText("Password");
        btnCancel.setText("Cancel");
        btnLogin.setText("Login");
        
        setLocationRelativeTo(null);
        setResizable(false);

    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtUsername = new javax.swing.JTextField();
        lblUsername = new javax.swing.JLabel();
        lblPassword = new javax.swing.JLabel();
        txtpassword = new javax.swing.JPasswordField();
        btnLogin = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(questionbox.QuestionBoxApp.class).getContext().getResourceMap(Login.class);
        setTitle(resourceMap.getString("Form.title")); // NOI18N
        setName("Form"); // NOI18N

        txtUsername.setText(resourceMap.getString("txtUsername.text")); // NOI18N
        txtUsername.setName("txtUsername"); // NOI18N

        lblUsername.setText(resourceMap.getString("lblUsername.text")); // NOI18N
        lblUsername.setName("lblUsername"); // NOI18N

        lblPassword.setText(resourceMap.getString("lblPassword.text")); // NOI18N
        lblPassword.setName("lblPassword"); // NOI18N

        txtpassword.setText(resourceMap.getString("txtpassword.text")); // NOI18N
        txtpassword.setName("txtpassword"); // NOI18N

        btnLogin.setText(resourceMap.getString("btnLogin.text")); // NOI18N
        btnLogin.setName("btnLogin"); // NOI18N
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        btnCancel.setText(resourceMap.getString("btnCancel.text")); // NOI18N
        btnCancel.setName("btnCancel"); // NOI18N
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblPassword)
                    .addComponent(lblUsername))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtpassword)
                    .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(48, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addComponent(btnCancel)
                .addGap(37, 37, 37))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblUsername)
                    .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPassword)
                    .addComponent(txtpassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLogin)
                    .addComponent(btnCancel))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        // TODO add your handling code here:
        if(txtUsername.getText().length() ==0 || txtpassword.getText().length() == 0)
        {
            JOptionPane.showMessageDialog(this,"Enter User Name and or Password");
            return;
        }
        
        try
        {
            User user = User.Login(txtUsername.getText(), txtpassword.getText());
            if(user != null)
            {
                StaticMain.loggedinuser = user;
                if(user.getTypeid() == 2) // admin ID is 2! 
                {    // if admin type go to the admin console
                    StaticMain.adminconsole = new AdminConsole();
                    this.dispose();
                    StaticMain.adminconsole.show();
                    
                }// if Operator type go to the Operator console
                else if(user.getTypeid() == 1){
                    StaticMain.operatorconsole = new OperatorConsole();
                    this.dispose();
                    StaticMain.operatorconsole.show();
                    
                }
            }
            else{
                 JOptionPane.showMessageDialog(this, "Invalid User name or password!\n","Login Information",JOptionPane.ERROR_MESSAGE);

            }

        }catch(Exception e){
            JOptionPane.showMessageDialog(this, "Login failed!\n","Error",JOptionPane.ERROR_MESSAGE);
            System.out.println(e.getMessage());
            }
    }//GEN-LAST:event_btnLoginActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnCancelActionPerformed

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

                readDatabaseConfig();
                Login login = new Login();
                login.setResizable(false);
                login.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnLogin;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblUsername;
    private javax.swing.JTextField txtUsername;
    private javax.swing.JPasswordField txtpassword;
    // End of variables declaration//GEN-END:variables

}
