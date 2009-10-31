/**
 *
 * Appfrica Labs Uganda Ltd Copyrigth @since 2009
 * @version 2
 *
 * Answer.java
 *
 * used for adding answers to the database.
 * this is used to add answer to commonly asked questions.
 *
 * Created on Oct 22, 2009, 12:27:04 PM
 */

package questionbox;

import java.util.ArrayList;
import qbox.model.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Emmanuel Oluka
 */
public class AnswerFrm extends javax.swing.JFrame {

    /**
     * The Answer object used to set and get answer information to
     * interact with the user.
     */ 
    private Answer answer;
    
    /** 
     * Creates new form Answer
     * and initializes the answer object and other
     * startup requirements.
     */
    public AnswerFrm(Answer ans ) {

        //The code below asigns names to labels and buttons
        //These were being lost when set via the properties tab.
        answer = ans;
        initComponents();
        lblSource.setText("Source");
        lblDetails.setText("Details");
        lblLinktoanswer.setText("Link to Answer");
        lblCategoryID.setText("Category ID");
        btnCancel.setText("Cancel");
        btnSave.setText("Save & Clear");
        setLocationRelativeTo(null);
        setResizable(false);
        intializeCategoryID();
       

    }

    /**
     * This function loads the answer fields from the answer object.
     */
    private void loadanswer()
    {
        txtSource.setText(answer.getSource());
        txtDetails.setText(answer.getDetails());
        txtLinktoanswer.setText(answer.getLink_to_answer());

    }

    /**
     * This function initializes the category combo-box with the categories.
     */
     private void intializeCategoryID()
    {
        try{
            cmbCategoryID.removeAllItems();
                ArrayList<Category> cats = Category.getAllCategorys();
                for(Category c:cats)
                {
                    cmbCategoryID.addItem(c.getTitle());
                }

        }catch(Exception e)
        {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(this, "Loading category ids Failed!\n","Error",JOptionPane.ERROR_MESSAGE);
        }

    }



    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblSource = new javax.swing.JLabel();
        lblDetails = new javax.swing.JLabel();
        lblLinktoanswer = new javax.swing.JLabel();
        txtSource = new javax.swing.JTextField();
        txtLinktoanswer = new javax.swing.JTextField();
        lblCategoryID = new javax.swing.JLabel();
        cmbCategoryID = new javax.swing.JComboBox();
        btnCancel = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDetails = new javax.swing.JTextArea();
        btnSave = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setName("Form"); // NOI18N

        lblSource.setName("lblSource"); // NOI18N

        lblDetails.setName("lblDetails"); // NOI18N

        lblLinktoanswer.setName("lblLinktoanswer"); // NOI18N

        txtSource.setName("txtSource"); // NOI18N

        txtLinktoanswer.setName("txtLinktoanswer"); // NOI18N

        lblCategoryID.setName("lblCategoryID"); // NOI18N

        cmbCategoryID.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbCategoryID.setName("cmbCategoryID"); // NOI18N

        btnCancel.setName("btnCancel"); // NOI18N
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        txtDetails.setColumns(20);
        txtDetails.setRows(5);
        txtDetails.setName("txtDetails"); // NOI18N
        jScrollPane1.setViewportView(txtDetails);

        btnSave.setName("btnSave"); // NOI18N
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblLinktoanswer)
                    .addComponent(lblDetails, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCategoryID)
                    .addComponent(lblSource))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(189, 189, 189)
                                .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                                .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 385, Short.MAX_VALUE)
                            .addComponent(txtSource, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 385, Short.MAX_VALUE)
                            .addComponent(txtLinktoanswer, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 385, Short.MAX_VALUE))
                        .addGap(117, 117, 117))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cmbCategoryID, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDetails)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtSource, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSource))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtLinktoanswer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblLinktoanswer))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbCategoryID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCategoryID))
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(80, 80, 80))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * To close the form.
     * @param evt
     */
    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        // TODO add your handling code here:
        this.dispose();


    }//GEN-LAST:event_btnCancelActionPerformed

    /**
     * This function save and updates the answer information given by the user.
     * @param evt
     * 
     */
    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed

        // Make sure all the fields are field in before proceeding to save.
        if(txtDetails.getText().length() == 0 ||txtSource.getText().length()==0 || txtLinktoanswer.getText().length()==0)
        {  JOptionPane.showMessageDialog(this, "Please Enter Details, Source and Link to answers");
           return;
        }
        try
        {
            //if answer is not null and answerid is set do an update
            if (answer != null && answer.getAnswerid() != 0)  
            {
                //set all the objects values with the corresponding field data.
                answer.setDetails(txtDetails.getText ());
                answer.setSource(txtSource.getText ());
                answer.setLink_to_answer(txtLinktoanswer.getText());

                //Get the category id from the combobox of the selected item. use the getCategoryIDByTitle to get the id.
                long catid = Category.getCategoryIDByTitle(cmbCategoryID.getSelectedItem().toString());

                answer.setCategoryid(catid);
                answer.UpdateAnswer();
            }
            else //otherwise if its a new object then add a new answer object to the database.
            {
                 //set all the objects values with the corresponding field data.
                answer = new Answer();                  //add new answer
                answer.setDetails(txtDetails.getText ());
                answer.setSource(txtSource.getText ());
                answer.setLink_to_answer(txtLinktoanswer.getText ());
                long catid = Category.getCategoryIDByTitle(cmbCategoryID.getSelectedItem().toString());
                answer.setCategoryid(catid);
                answer.AddAnswer();

            }

            System.out.println("Answer was added or updated successfully");

            //clear the textboxes from more input.
            txtSource.setText("");
            txtLinktoanswer.setText("");
            txtDetails.setText("");
            answer = new Answer(); //clear out the answer object to prepare for a new object.


        }catch(Exception e)
        {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(this, "Update/Insert failed!\n","Error",JOptionPane.ERROR_MESSAGE);

        }



    }//GEN-LAST:event_btnSaveActionPerformed

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                AnswerFrm answerFrm = new AnswerFrm(null);
                answerFrm.setResizable(false);
                answerFrm.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox cmbCategoryID;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCategoryID;
    private javax.swing.JLabel lblDetails;
    private javax.swing.JLabel lblLinktoanswer;
    private javax.swing.JLabel lblSource;
    private javax.swing.JTextArea txtDetails;
    private javax.swing.JTextField txtLinktoanswer;
    private javax.swing.JTextField txtSource;
    // End of variables declaration//GEN-END:variables

}
