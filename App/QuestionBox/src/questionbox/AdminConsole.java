/**
 *
 * Appfrica Labs Uganda Ltd Copyrigth @since 2009
 * @version 2
 *
 * AdminConsole.java
 *
 * The admin Console is what the add ministrator users add and remove status,recommended sites and operators.
 *
 * Created on Oct 16, 2009, 10:21:10 AM
 */

package questionbox;

import qbox.model.*;

/**
 *
 * @author Victor Miclovich
 */
public class AdminConsole extends javax.swing.JFrame {

    /** Creates new form AdminConsole */
    public AdminConsole() {
        initComponents();
        buttonAddOperator.setText("Add Operator");
        btnAddCategory.setText("Add Category");
        btnAddAnswer.setText("Add Answer");
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

        desktopPane = new javax.swing.JDesktopPane();
        buttonAddOperator = new javax.swing.JButton();
        btnAddCategory = new javax.swing.JButton();
        btnAddAnswer = new javax.swing.JButton();
        jSplitPane1 = new javax.swing.JSplitPane();
        menuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        saveMenuItem = new javax.swing.JMenuItem();
        saveAsMenuItem = new javax.swing.JMenuItem();
        exitMenuItem = new javax.swing.JMenuItem();
        editMenu = new javax.swing.JMenu();
        cutMenuItem = new javax.swing.JMenuItem();
        copyMenuItem = new javax.swing.JMenuItem();
        pasteMenuItem = new javax.swing.JMenuItem();
        deleteMenuItem = new javax.swing.JMenuItem();
        helpMenu = new javax.swing.JMenu();
        contentMenuItem = new javax.swing.JMenuItem();
        aboutMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setName("Form"); // NOI18N

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(questionbox.QuestionBoxApp.class).getContext().getResourceMap(AdminConsole.class);
        desktopPane.setBackground(resourceMap.getColor("desktopPane.background")); // NOI18N
        desktopPane.setName("desktopPane"); // NOI18N

        buttonAddOperator.setText(resourceMap.getString("buttonAddOperator.text")); // NOI18N
        buttonAddOperator.setName("buttonAddOperator"); // NOI18N
        buttonAddOperator.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAddOperatorActionPerformed(evt);
            }
        });
        buttonAddOperator.setBounds(20, 20, 110, 30);
        desktopPane.add(buttonAddOperator, javax.swing.JLayeredPane.DEFAULT_LAYER);

        btnAddCategory.setText(resourceMap.getString("btnAddCategory.text")); // NOI18N
        btnAddCategory.setName("btnAddCategory"); // NOI18N
        btnAddCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddCategoryActionPerformed(evt);
            }
        });
        btnAddCategory.setBounds(20, 60, 110, 30);
        desktopPane.add(btnAddCategory, javax.swing.JLayeredPane.DEFAULT_LAYER);

        btnAddAnswer.setText(resourceMap.getString("btnAddAnswer.text")); // NOI18N
        btnAddAnswer.setName("btnAddAnswer"); // NOI18N
        btnAddAnswer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddAnswerActionPerformed(evt);
            }
        });
        btnAddAnswer.setBounds(20, 100, 110, 30);
        desktopPane.add(btnAddAnswer, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jSplitPane1.setName("jSplitPane1"); // NOI18N

        menuBar.setName("menuBar"); // NOI18N

        fileMenu.setText(resourceMap.getString("fileMenu.text")); // NOI18N
        fileMenu.setName("fileMenu"); // NOI18N

        saveMenuItem.setText(resourceMap.getString("saveMenuItem.text")); // NOI18N
        saveMenuItem.setName("saveMenuItem"); // NOI18N
        fileMenu.add(saveMenuItem);

        saveAsMenuItem.setText(resourceMap.getString("saveAsMenuItem.text")); // NOI18N
        saveAsMenuItem.setName("saveAsMenuItem"); // NOI18N
        fileMenu.add(saveAsMenuItem);

        exitMenuItem.setText(resourceMap.getString("exitMenuItem.text")); // NOI18N
        exitMenuItem.setName("exitMenuItem"); // NOI18N
        exitMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(exitMenuItem);

        menuBar.add(fileMenu);

        editMenu.setText(resourceMap.getString("editMenu.text")); // NOI18N
        editMenu.setName("editMenu"); // NOI18N

        cutMenuItem.setText(resourceMap.getString("cutMenuItem.text")); // NOI18N
        cutMenuItem.setName("cutMenuItem"); // NOI18N
        editMenu.add(cutMenuItem);

        copyMenuItem.setText(resourceMap.getString("copyMenuItem.text")); // NOI18N
        copyMenuItem.setName("copyMenuItem"); // NOI18N
        editMenu.add(copyMenuItem);

        pasteMenuItem.setText(resourceMap.getString("pasteMenuItem.text")); // NOI18N
        pasteMenuItem.setName("pasteMenuItem"); // NOI18N
        editMenu.add(pasteMenuItem);

        deleteMenuItem.setText(resourceMap.getString("deleteMenuItem.text")); // NOI18N
        deleteMenuItem.setName("deleteMenuItem"); // NOI18N
        editMenu.add(deleteMenuItem);

        menuBar.add(editMenu);

        helpMenu.setText(resourceMap.getString("helpMenu.text")); // NOI18N
        helpMenu.setName("helpMenu"); // NOI18N

        contentMenuItem.setText(resourceMap.getString("contentMenuItem.text")); // NOI18N
        contentMenuItem.setName("contentMenuItem"); // NOI18N
        helpMenu.add(contentMenuItem);

        aboutMenuItem.setText(resourceMap.getString("aboutMenuItem.text")); // NOI18N
        aboutMenuItem.setName("aboutMenuItem"); // NOI18N
        helpMenu.add(aboutMenuItem);

        menuBar.add(helpMenu);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(desktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 378, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(desktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE)
                .addGap(22, 22, 22))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuItemActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitMenuItemActionPerformed

    /**
     * This function opens the Operator form to add more operators.
     * @param evt
     */
    private void buttonAddOperatorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAddOperatorActionPerformed
        // TODO add your handling code here:
        // code to call form to add new operators
        UserForm frmoperator = new UserForm(1);
        frmoperator.show();

    }//GEN-LAST:event_buttonAddOperatorActionPerformed

    /**
     * This function opens the form that adds categories.
     * @param evt
     */
    private void btnAddCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddCategoryActionPerformed
        // TODO add your handling code here:
        CatFrm catform =  new CatFrm();
        catform.show();
    }//GEN-LAST:event_btnAddCategoryActionPerformed

    /**
     * This function opens the form for adding new answers.
     * @param evt
     */
    private void btnAddAnswerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddAnswerActionPerformed
        // TODO add your handling code here:
        AnswerFrm frmanswer = new AnswerFrm(null);
        frmanswer.show();
    }//GEN-LAST:event_btnAddAnswerActionPerformed

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                AdminConsole adminConsole = new AdminConsole();
                adminConsole.setResizable(false);
                adminConsole.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem aboutMenuItem;
    private javax.swing.JButton btnAddAnswer;
    private javax.swing.JButton btnAddCategory;
    private javax.swing.JButton buttonAddOperator;
    private javax.swing.JMenuItem contentMenuItem;
    private javax.swing.JMenuItem copyMenuItem;
    private javax.swing.JMenuItem cutMenuItem;
    private javax.swing.JMenuItem deleteMenuItem;
    private javax.swing.JDesktopPane desktopPane;
    private javax.swing.JMenu editMenu;
    private javax.swing.JMenuItem exitMenuItem;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JMenu helpMenu;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem pasteMenuItem;
    private javax.swing.JMenuItem saveAsMenuItem;
    private javax.swing.JMenuItem saveMenuItem;
    // End of variables declaration//GEN-END:variables

}
