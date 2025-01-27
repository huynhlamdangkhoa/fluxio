
package GUI;

import java.util.List;
import javax.swing.JOptionPane;

public class HomePage extends javax.swing.JFrame {

    public HomePage() {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnUser = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        btnLogOut = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Fluxio");
        setBackground(new java.awt.Color(51, 0, 153));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnUser.setBackground(new java.awt.Color(204, 204, 204));
        btnUser.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        btnUser.setForeground(new java.awt.Color(51, 51, 51));
        btnUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/user.png"))); // NOI18N
        btnUser.setText("User");
        btnUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUserActionPerformed(evt);
            }
        });
        getContentPane().add(btnUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 260, 380, 100));

        jButton2.setBackground(new java.awt.Color(204, 204, 204));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jButton2.setForeground(new java.awt.Color(51, 51, 51));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/category.png"))); // NOI18N
        jButton2.setText("Category");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 260, 380, 100));

        jButton3.setBackground(new java.awt.Color(204, 204, 204));
        jButton3.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jButton3.setForeground(new java.awt.Color(51, 51, 51));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/product.png"))); // NOI18N
        jButton3.setText("Product");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 410, 380, 100));

        jButton5.setBackground(new java.awt.Color(204, 204, 204));
        jButton5.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jButton5.setForeground(new java.awt.Color(51, 51, 51));
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/order-.png"))); // NOI18N
        jButton5.setText("Order");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 410, 380, 100));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/LogoSmall.png"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, -1, 110));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/LogoTextSmall.png"))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, -1, 40));

        jLabel1.setFont(new java.awt.Font("UTM Aurora", 1, 60)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 0, 204));
        jLabel1.setText("INVENTORY MANAGEMENT SYSTEM");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 70, 750, 60));

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, 1000, 210));

        jPanel3.setBackground(new java.awt.Color(255, 102, 0));
        jPanel3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel3.setName(""); // NOI18N
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setForeground(new java.awt.Color(255, 255, 255));
        jPanel3.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 920, 310));

        btnLogOut.setBackground(new java.awt.Color(0, 0, 217));
        btnLogOut.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnLogOut.setForeground(new java.awt.Color(255, 255, 255));
        btnLogOut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/log-out.png"))); // NOI18N
        btnLogOut.setText("Log Out");
        btnLogOut.setBorder(null);
        btnLogOut.setBorderPainted(false);
        btnLogOut.setFocusPainted(false);
        btnLogOut.setFocusable(false);
        btnLogOut.setRequestFocusEnabled(false);
        btnLogOut.setRolloverEnabled(false);
        btnLogOut.setVerifyInputWhenFocusTarget(false);
        btnLogOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogOutActionPerformed(evt);
            }
        });
        jPanel3.add(btnLogOut, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 370, 180, 40));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 1000, 430));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUserActionPerformed
        /// Use the singleton instance of PageGraph
        PageGraph pageGraph = PageGraph.getInstance();
        List<String> adjacentPages = pageGraph.getAdjacentPages("HomePage");

        System.out.println("Adjacent pages for HomePage: " + adjacentPages);

        // Navigate to UserPage if it exists in adjacent pages
        boolean userPageFound = false;
        for (String nextPage : adjacentPages) {
            System.out.println("Checking page: " + nextPage);  // Debug each page being checked

            if (nextPage.equals("UserPage")) {  // Check for UserPage
                userPageFound = true;
                System.out.println("UserPage found! Navigating...");  // Debug
                UserPage userPage = new UserPage();  // Create an instance of UserPage
                userPage.setVisible(true);
                this.setVisible(false);  // Hide the current page (HomePage)
                break;  // Exit after navigation
            }
        }

        if (!userPageFound) {
            System.out.println("UserPage not found in adjacent pages.");  // Debug if UserPage was not found
        }
    }//GEN-LAST:event_btnUserActionPerformed

    private void btnLogOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogOutActionPerformed
        int a = JOptionPane.showConfirmDialog(null, "Do you want to log out?", "Log out", JOptionPane.YES_NO_OPTION);
        if(a == 0) {
            setVisible(false);
            new LoginPage().setVisible(true);
        }
        this.setVisible(false); 
    }//GEN-LAST:event_btnLogOutActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        PageGraph pageGraph = PageGraph.getInstance();
        List<String> adjacentPages = pageGraph.getAdjacentPages("HomePage");

        System.out.println("Adjacent pages for HomePage: " + adjacentPages);

        boolean categoryPageFound = false;
        for (String nextPage : adjacentPages) {
            System.out.println("Checking page: " + nextPage);  

            if (nextPage.equals("CategoryPage")) { 
                categoryPageFound = true;
                System.out.println("CategoryPage found! Navigating...");  
                CategoryPage categoryPage = new CategoryPage();
                categoryPage.setVisible(true);
                this.setVisible(false);  
                break;  //
            }
        }

        if (!categoryPageFound) {
            System.out.println("UserPage not found in adjacent pages.");  // Debug if UserPage was not found
        }  
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        PageGraph pageGraph = PageGraph.getInstance();
        List<String> adjacentPages = pageGraph.getAdjacentPages("HomePage");

        System.out.println("Adjacent pages for HomePage: " + adjacentPages);

        boolean productPageFound = false;
        for (String nextPage : adjacentPages) {
            System.out.println("Checking page: " + nextPage);  

            if (nextPage.equals("ProductPage")) {  
                productPageFound = true;
                System.out.println("ProductPage found! Navigating...");  
                ProductPage productPage = new ProductPage();  
                productPage.setVisible(true);
                HomePage homePage = new HomePage();
                homePage.dispose();
                break; 
            }
        }

        if (!productPageFound) {
            System.out.println("ProductPage not found in adjacent pages.");  
        }  
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        /// Use the singleton instance of PageGraph
        PageGraph pageGraph = PageGraph.getInstance();
        List<String> adjacentPages = pageGraph.getAdjacentPages("HomePage");

        // Debug: Print adjacent pages for HomePage (instead of UserPage)
        System.out.println("Adjacent pages for HomePage: " + adjacentPages);

        // Navigate to UserPage if it exists in adjacent pages
        boolean orderPageFound = false;
        for (String nextPage : adjacentPages) {
            System.out.println("Checking page: " + nextPage);  // Debug each page being checked

            if (nextPage.equals("OrderPage")) {  // Check for UserPage
                orderPageFound = true;
                System.out.println("OrderPage found! Navigating...");  // Debug
                OrderPage orderPage = new OrderPage();  // Create an instance of UserPage
                orderPage.setVisible(true);
                this.setVisible(false);  // Hide the current page (HomePage)
                break;  // Exit after navigation
            }
        }

        if (!orderPageFound) {
            System.out.println("UserPage not found in adjacent pages.");  // Debug if UserPage was not found
        } 
    }//GEN-LAST:event_jButton5ActionPerformed

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
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HomePage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogOut;
    private javax.swing.JButton btnUser;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    // End of variables declaration//GEN-END:variables
}
