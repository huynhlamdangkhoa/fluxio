/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import DAO.ProductDAO;
import DAO.CategoryDAO;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import model.Category;
import model.Product;
import service.Trie;
import util.DBConnection;

/**
 *
 * @author Administrator
 */
public class ProductPage extends javax.swing.JFrame {
    private int productId = 0;
    private int totalQuantity = 0;

    /**
     * Creates new form Page
     */
    public ProductPage() {
        initComponents();
        setLocationRelativeTo(null);
    }
    
    private void getAllCategory() {
        try{
            Connection con = DBConnection.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM Category");
            comboBoxCategory.removeAllItems();
            while(rs.next()) {
                comboBoxCategory.addItem(rs.getString("category_id")+"-"+rs.getString("category_name"));
            }
        }
        catch(Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    private boolean validateFields() {
        if (txtName.getText().trim().isEmpty() || txtPrice.getText().trim().isEmpty() || txtQuantity.getText().trim().isEmpty() || txtDescription.getText().trim().isEmpty()) {
            return false;
        }
        return true;
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        searchProduct = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        productTable = new javax.swing.JTable();
        txtName = new javax.swing.JTextField();
        txtPrice = new javax.swing.JTextField();
        txtQuantity = new javax.swing.JTextField();
        txtDescription = new javax.swing.JTextField();
        comboBoxCategory = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblQuantity = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btnSave = new javax.swing.JButton();
        btnClose = new javax.swing.JButton();
        btnReset1 = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        back = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(java.awt.SystemColor.controlHighlight);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 102, 0));

        jLabel1.setBackground(new java.awt.Color(255, 102, 0));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Manage Product");
        jLabel1.setDoubleBuffered(true);
        jLabel1.setOpaque(true);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(390, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(397, 397, 397))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(0, 12, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-4, 0, 1160, -1));

        jTextField1.setBackground(new java.awt.Color(255, 255, 255));
        jTextField1.setForeground(new java.awt.Color(0, 0, 0));
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, 370, 32));

        searchProduct.setBackground(new java.awt.Color(255, 102, 0));
        searchProduct.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        searchProduct.setForeground(new java.awt.Color(255, 255, 255));
        searchProduct.setText("Search");
        searchProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchProductActionPerformed(evt);
            }
        });
        getContentPane().add(searchProduct, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 100, -1, 32));

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));

        productTable.setBackground(new java.awt.Color(255, 255, 255));
        productTable.setForeground(new java.awt.Color(0, 0, 0));
        productTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Price", "Quantity", "Description", "Category ID", "Category Name"
            }
        ));
        productTable.setGridColor(new java.awt.Color(51, 51, 51));
        productTable.setSelectionBackground(new java.awt.Color(0, 0, 0));
        productTable.setSelectionForeground(new java.awt.Color(0, 0, 102));
        productTable.setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        productTable.setShowGrid(true);
        productTable.setShowHorizontalLines(false);
        productTable.setShowVerticalLines(false);
        productTable.setSurrendersFocusOnKeystroke(true);
        productTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                productTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(productTable);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, 730, 580));

        txtName.setBackground(new java.awt.Color(255, 255, 255));
        txtName.setForeground(new java.awt.Color(0, 0, 0));
        getContentPane().add(txtName, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 180, 325, 36));

        txtPrice.setBackground(new java.awt.Color(255, 255, 255));
        txtPrice.setForeground(new java.awt.Color(0, 0, 0));
        getContentPane().add(txtPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 270, 325, 35));

        txtQuantity.setBackground(new java.awt.Color(255, 255, 255));
        txtQuantity.setForeground(new java.awt.Color(0, 0, 0));
        getContentPane().add(txtQuantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 360, 325, 37));

        txtDescription.setBackground(new java.awt.Color(255, 255, 255));
        txtDescription.setForeground(new java.awt.Color(0, 0, 0));
        getContentPane().add(txtDescription, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 450, 325, 40));

        comboBoxCategory.setBackground(new java.awt.Color(255, 255, 255));
        comboBoxCategory.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        comboBoxCategory.setForeground(new java.awt.Color(0, 0, 0));
        comboBoxCategory.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboBoxCategory.setOpaque(true);
        getContentPane().add(comboBoxCategory, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 550, 325, 35));

        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Name");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 160, 37, -1));

        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Price");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 250, 37, -1));

        lblQuantity.setForeground(new java.awt.Color(0, 0, 0));
        lblQuantity.setText("Quantity");
        getContentPane().add(lblQuantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 340, 53, -1));

        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Description");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 430, 75, -1));

        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Category");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 530, 59, -1));

        btnSave.setBackground(new java.awt.Color(0, 0, 102));
        btnSave.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnSave.setForeground(new java.awt.Color(255, 255, 255));
        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        getContentPane().add(btnSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 620, 325, -1));

        btnClose.setBackground(new java.awt.Color(0, 0, 102));
        btnClose.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnClose.setForeground(new java.awt.Color(255, 255, 255));
        btnClose.setText("Close");
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });
        getContentPane().add(btnClose, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 710, 325, -1));

        btnReset1.setBackground(new java.awt.Color(0, 0, 102));
        btnReset1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnReset1.setForeground(new java.awt.Color(255, 255, 255));
        btnReset1.setText("Reset");
        btnReset1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReset1ActionPerformed(evt);
            }
        });
        getContentPane().add(btnReset1, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 680, 325, -1));

        btnUpdate.setBackground(new java.awt.Color(0, 0, 102));
        btnUpdate.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnUpdate.setForeground(new java.awt.Color(255, 255, 255));
        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });
        getContentPane().add(btnUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 650, 325, -1));

        back.setBackground(new java.awt.Color(255, 102, 0));
        back.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        back.setForeground(new java.awt.Color(255, 255, 255));
        back.setText("Back to Home");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });
        getContentPane().add(back, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 760, -1, -1));

        jPanel2.setBackground(java.awt.SystemColor.controlHighlight);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1160, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 720, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 1160, 720));

        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 1160, 730));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void searchProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchProductActionPerformed
        // TODO add your handling code here:
        String searchText = jTextField1.getText().trim().toLowerCase();

        // Kiểm tra nếu người dùng chưa nhập gì thì không tìm kiếm
        if (searchText.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter a product name to search.");
            return;
        }

        // Làm mới bảng (xóa tất cả các dòng hiện tại)
        DefaultTableModel model = (DefaultTableModel) productTable.getModel();
        model.setRowCount(0);

        try {
            Connection con = DBConnection.getConnection();
            Statement st = con.createStatement();
            // Sử dụng câu lệnh SQL để tìm kiếm sản phẩm theo tên
            String query = "SELECT Product.product_id, Product.product_name, Product.price, Product.stock_quantity, Product.description, "
                    + "Category.category_id, Category.category_name AS category_name "
                    + "FROM Product "
                    + "INNER JOIN Category ON Product.category_id = Category.category_id "
                    + "WHERE LOWER(Product.product_name) LIKE '%" + searchText + "%'"; // Dùng LIKE và toLowerCase để tìm kiếm không phân biệt chữ hoa chữ thường

            ResultSet rs = st.executeQuery(query);

            // Thêm các dòng kết quả vào bảng
            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getString("product_id"),
                    rs.getString("product_name"),
                    rs.getString("price"),
                    rs.getString("stock_quantity"),
                    rs.getString("description"),
                    rs.getString("category_id"),
                    rs.getString("category_name")
                });
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }//GEN-LAST:event_searchProductActionPerformed

    private void productTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_productTableMouseClicked
        // TODO add your handling code here:
        int index = productTable.getSelectedRow();
        TableModel model = productTable.getModel();
        String id = model.getValueAt(index, 0).toString();
        productId = Integer.parseInt(id);

        String name = model.getValueAt(index, 1).toString();
        txtName.setText(name);

        String price = model.getValueAt(index, 2).toString();
        txtPrice.setText(price);

        String quantity = model.getValueAt(index, 3).toString();
        totalQuantity = 0;
        lblQuantity.setText("Add quantity");
        totalQuantity = Integer.parseInt(quantity);

        String description = model.getValueAt(index, 4).toString();
        txtQuantity.setText(description);

        comboBoxCategory.removeAllItems();
        String categoryId = model.getValueAt(index, 5).toString();
        String categoryName = model.getValueAt(index, 6).toString();
        comboBoxCategory.addItem(categoryId + "-" + categoryName);

        try{
            Connection con = DBConnection.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM Category");
            while(rs.next()) {
                if(Integer.parseInt(categoryId) != rs.getInt(1))
                comboBoxCategory.addItem(rs.getString("category_id")+"-"+rs.getString("category_name"));
            }
        }
        catch(Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

        btnSave.setEnabled(false);
        btnUpdate.setEnabled(true);
    }//GEN-LAST:event_productTableMouseClicked

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        String name = txtName.getText();
        String priceText = txtPrice.getText();
        String quantityText = txtQuantity.getText();
        String description = txtDescription.getText();
        String category = (String) comboBoxCategory.getSelectedItem();

        // Split the category string (e.g., "1-CategoryName") to get the category ID
        String[] categoryId = category.split("-", 0);

        // Validate all fields
        if (!validateFields()) {
            JOptionPane.showMessageDialog(null, "All fields are required");
        } else {
            try {
                // Parse price and quantity to their correct types
                double price = Double.parseDouble(priceText); // Parse price as double
                int quantity = Integer.parseInt(quantityText); // Parse quantity as int
                int categoryIdInt = Integer.parseInt(categoryId[0]); // Parse category ID as integer

                // Create a Product object
                ProductDAO productDAO = ProductDAO.getInstance();
                int productId = productDAO.generateProductId();

                // Create a Product instance
                Product product = new Product(productId, name, quantity, price, categoryIdInt, description);

                // Insert the product into the database
                int result = productDAO.insert(product);

                if (result > 0) {
                    JOptionPane.showMessageDialog(null, "Product added successfully");
                    setVisible(false);
                    new ProductPage().setVisible(true);  // Correct this to navigate to the ProductPage
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        // TODO add your handling code here:
        setVisible(false);
    }//GEN-LAST:event_btnCloseActionPerformed

    private void btnReset1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReset1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnReset1ActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        // TODO add your handling code here:
        getAllCategory();
        DefaultTableModel model = (DefaultTableModel) productTable.getModel();
        try {
            Connection con = DBConnection.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(
                "SELECT Product.product_id, Product.product_name, Product.price, Product.stock_quantity, Product.description, " +
                "Category.category_id, Category.category_name AS category_name " +
                "FROM Product INNER JOIN Category ON Product.category_id = Category.category_id"
            );
            while(rs.next()) {
                model.addRow(new Object[]{rs.getString("product_id"), rs.getString("product_name"), rs.getString("price"), rs.getString("stock_quantity"), rs.getString("description"), rs.getString("category_id")});
            }
        }
        catch(Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        
        btnUpdate.setEnabled(false);
    }//GEN-LAST:event_formComponentShown

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        // TODO add your handling code here:
        PageGraph pageGraph = PageGraph.getInstance();
        List<String> adjacentPages = pageGraph.getAdjacentPages("ProductPage");

        System.out.println("Adjacent pages for ProductPage: " + adjacentPages);

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
    }//GEN-LAST:event_backActionPerformed

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
            java.util.logging.Logger.getLogger(ProductPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProductPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProductPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProductPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ProductPage().setVisible(true);
            }
        });
    }
    
    private void loadProductTable() {
        try {
            Connection con = DBConnection.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM Product INNER JOIN Category ON Product.category_id = Category.category_id");
            DefaultTableModel model = (DefaultTableModel) productTable.getModel();
            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getString("product_id"),
                    rs.getString("product_name"),
                    rs.getString("price"),
                    rs.getString("stock_quantity"),
                    rs.getString("description"),
                    rs.getString("category_id"),
                   });
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    
    private void refreshProductTable() {
        DefaultTableModel model = (DefaultTableModel) productTable.getModel();
        model.setRowCount(0); // Clear the table
        loadProductTable(); // Call a method to reload data from the database
    }
    
    private void updateProductTable(List<Product> products) {
        // Create the table model with the new data
        DefaultTableModel model = (DefaultTableModel) productTable.getModel();
        model.setRowCount(0);  // Clear existing rows

        // Add the filtered products to the table
        for (Product product : products) {
            model.addRow(new Object[] {
                product.getProductId(),
                product.getProductName(),
                product.getPrice(),
                product.getQuantity(),
                product.getDescription(),
                product.getCategoryId(),
                getCategoryNameById(product.getCategoryId())
            });
        }
    }

    private String getCategoryNameById(int categoryId) {
        // Create an instance of CategoryDAO
        CategoryDAO categoryDAO = CategoryDAO.getInstance();

        // Create a Category object with the given categoryId
        Category category = new Category(categoryId, null);

        // Retrieve the category from the database using selectById
        category = categoryDAO.selectById(category);

        // Return the category name if found, or a default value if not
        return (category != null) ? category.getCategoryName() : "Category Not Found";
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back;
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnReset1;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> comboBoxCategory;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel lblQuantity;
    private javax.swing.JTable productTable;
    private javax.swing.JButton searchProduct;
    private javax.swing.JTextField txtDescription;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPrice;
    private javax.swing.JTextField txtQuantity;
    // End of variables declaration//GEN-END:variables
}
