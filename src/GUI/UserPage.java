/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import DAO.UserDAO;
import java.awt.Color;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;
import model.User;
import util.DBConnection;


public class UserPage extends javax.swing.JFrame {
    private int user_id = 0;

    /**
     * Creates new form ManageUser
     */
    public UserPage() {
        initComponents();
        setLocationRelativeTo(null);
    }
    
    private boolean validateFields(String formType) {
        if(formType.equals("edit") && !txtUserName.getText().equals("") && !txtEmail.getText().equals("") && !txtPassword.getText().equals("")) {
            return false;
        } else if(formType.equals("new") && !txtUserName.getText().equals("") && !txtEmail.getText().equals("") && !txtPassword.getText().equals("")) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        userTable = new javax.swing.JTable();
        jLable1 = new javax.swing.JLabel();
        txtUserName = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtPassword = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        btnSave = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        btnClose = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        Back = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Fluxio");
        setFocusable(false);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Mange User");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 0, -1, -1));

        userTable.setBackground(new java.awt.Color(255, 255, 255));
        userTable.setForeground(new java.awt.Color(0, 0, 0));
        userTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Name", "Password", "Email"
            }
        ));
        userTable.setShowGrid(false);
        userTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                userTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(userTable);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 430, 450));

        jLable1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLable1.setForeground(new java.awt.Color(0, 0, 0));
        jLable1.setText("User Name");
        getContentPane().add(jLable1, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 110, -1, -1));

        txtUserName.setBackground(new java.awt.Color(255, 255, 255));
        txtUserName.setForeground(new java.awt.Color(0, 0, 0));
        getContentPane().add(txtUserName, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 130, 342, 30));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Password");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 180, -1, -1));

        txtPassword.setBackground(new java.awt.Color(255, 255, 255));
        txtPassword.setForeground(new java.awt.Color(0, 0, 0));
        getContentPane().add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 200, 340, 30));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Email");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 260, 37, -1));

        txtEmail.setBackground(new java.awt.Color(255, 255, 255));
        txtEmail.setForeground(new java.awt.Color(0, 0, 0));
        getContentPane().add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 280, 340, 30));

        btnSave.setBackground(new java.awt.Color(0, 0, 102));
        btnSave.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnSave.setForeground(new java.awt.Color(255, 255, 255));
        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        getContentPane().add(btnSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 350, -1, -1));

        btnUpdate.setBackground(new java.awt.Color(0, 0, 102));
        btnUpdate.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnUpdate.setForeground(new java.awt.Color(255, 255, 255));
        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });
        getContentPane().add(btnUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 350, -1, -1));

        btnReset.setBackground(new java.awt.Color(0, 0, 102));
        btnReset.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnReset.setForeground(new java.awt.Color(255, 255, 255));
        btnReset.setText("Reset");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });
        getContentPane().add(btnReset, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 350, -1, -1));

        btnClose.setBackground(new java.awt.Color(0, 0, 102));
        btnClose.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnClose.setForeground(new java.awt.Color(255, 255, 255));
        btnClose.setText("Close");
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });
        getContentPane().add(btnClose, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 350, -1, -1));

        jPanel1.setBackground(new java.awt.Color(255, 102, 0));
        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 850, 70));

        Back.setBackground(new java.awt.Color(255, 102, 0));
        Back.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Back.setForeground(new java.awt.Color(255, 255, 255));
        Back.setText("Back to Home");
        Back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackActionPerformed(evt);
            }
        });
        getContentPane().add(Back, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 560, -1, -1));

        jPanel3.setBackground(java.awt.SystemColor.controlHighlight);
        jPanel3.setForeground(new java.awt.Color(0, 0, 0));
        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 850, 530));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) userTable.getModel(); // Lấy model từ bảng userTable
        try {
            Connection con = DBConnection.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM User WHERE role='Staff'"); // Sửa lỗi câu lệnh SQL
            while (rs.next()) {
                model.addRow(new Object[]{rs.getString("user_id"), rs.getString("username"), rs.getString("password"), rs.getString("email"), rs.getString("role")});
            }
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        btnUpdate.setEnabled(false);
    }//GEN-LAST:event_formComponentShown

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        String username = txtUserName.getText();
        String password = txtPassword.getText();
        String email = txtEmail.getText();

        if (validateFields("new")) {
            JOptionPane.showMessageDialog(null, "All fields are required");
        } else {
            try {
                UserDAO userDAO = UserDAO.getInstance();
                int userId = userDAO.generateUserId(); // Sinh ID người dùng mới
                User user = new User(userId, username, password, email); // Tạo đối tượng User

                int result = userDAO.insert(user); // Thêm người dùng vào cơ sở dữ liệu

                if (result > 0) {
                    JOptionPane.showMessageDialog(null, "User added successfully");
                    setVisible(false);
                    new UserPage().setVisible(true); // Chuyển trang sau khi thêm
                } else {
                    JOptionPane.showMessageDialog(null, "Failed to add user");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void userTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_userTableMouseClicked
        // TODO add your handling code here:
        int index = userTable.getSelectedRow();
        TableModel model = userTable.getModel();

        // Lấy ID của người dùng từ bảng
        user_id = Integer.parseInt(model.getValueAt(index, 0).toString());

        UserDAO userDAO = UserDAO.getInstance();
        User user = userDAO.selectById(new User(user_id, null, null, null)); // Lấy thông tin người dùng theo userId

        if (user != null) {
            txtUserName.setText(user.getUsername());
            txtPassword.setText(user.getPassword());
            txtEmail.setText(user.getEmail());

            txtPassword.setEditable(false);
            txtPassword.setBackground(Color.DARK_GRAY);

            btnSave.setEnabled(false);
            btnUpdate.setEnabled(true);
        } else {
            JOptionPane.showMessageDialog(null, "Failed to fetch user details");
        }
    }//GEN-LAST:event_userTableMouseClicked

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        String username = txtUserName.getText();
        String email = txtEmail.getText();

        if (validateFields("edit")) {
            JOptionPane.showMessageDialog(null, "All fields are required");
        } else {
            try {
                UserDAO userDAO = UserDAO.getInstance();
                User user = new User(user_id, username, null, email); // Cập nhật user, bỏ qua password (không thay đổi)

                int result = userDAO.update(user); // Cập nhật thông tin người dùng trong cơ sở dữ liệu

                if (result > 0) {
                    JOptionPane.showMessageDialog(null, "User updated successfully");
                    setVisible(false);
                    new UserPage().setVisible(true); // Chuyển trang sau khi cập nhật
                } else {
                    JOptionPane.showMessageDialog(null, "Failed to update user");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        // TODO add your handling code here:
        setVisible(false);
        new UserPage().setVisible(true);
    }//GEN-LAST:event_btnResetActionPerformed

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        // TODO add your handling code here:
        setVisible(false);
    }//GEN-LAST:event_btnCloseActionPerformed

    private void BackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackActionPerformed
        PageGraph pageGraph = PageGraph.getInstance();
        List<String> adjacentPages = pageGraph.getAdjacentPages("UserPage");

        System.out.println("Adjacent pages for UserPage: " + adjacentPages);

        boolean homePageFound = false;
        for (String nextPage : adjacentPages) {
            System.out.println("Checking page: " + nextPage);  

            if (nextPage.equals("HomePage")) { 
                homePageFound = true;
                System.out.println("homePageFound found! Navigating back to home...");  
                HomePage homePage = new HomePage();
                homePage.setVisible(true);
                this.setVisible(false);  
                break;  //
            }
        }

        if (!homePageFound) {
            System.out.println("HomePage not found in adjacent pages.");  // Debug if UserPage was not found
        }
    }//GEN-LAST:event_BackActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(UserPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UserPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Back;
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLable1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtPassword;
    private javax.swing.JTextField txtUserName;
    private javax.swing.JTable userTable;
    // End of variables declaration//GEN-END:variables
}
