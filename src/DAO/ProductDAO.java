package DAO;

import model.Product;
import model.Category;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import util.DBConnection;

public class ProductDAO implements DAOInterface<Product> {
    private static final HashSet<Integer> usedProductIds = new HashSet<>();

    public static ProductDAO getInstance() {
        return new ProductDAO();
    }

    public int generateProductId() {
        Random random = new Random();
        int productId;
        do {
            productId = 100000 + random.nextInt(900000); // Generates a number between 100 and 999
        } while (usedProductIds.contains(productId));
        usedProductIds.add(productId);
        return productId;
    }
    
    private boolean idExistsInDatabase(int productId) {
        String sql = "SELECT 1 FROM Category WHERE category_id = ?";
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, productId);
            try (ResultSet resultSet = statement.executeQuery()) {
                return resultSet.next();
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error checking category ID existence", e);
        }
    }

    @Override
    public int insert(Product product) {
        String sql = "INSERT IGNORE INTO Product (product_id, product_name, category_id, price, stock_quantity, description) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection connection = DBConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)) {
            int productId = generateProductId();
            product.setProductId(productId);
            statement.setInt(1, productId);
            statement.setString(2, product.getProductName());
            statement.setInt(3, product.getCategoryId());
            statement.setDouble(4, product.getPrice());
            statement.setInt(5, product.getQuantity());
            statement.setString(6, product.getDescription());
            return statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error inserting product", e);
        }
    }

    @Override
    public int update(Product product) {
        String sql = "UPDATE Product SET product_name = ?, category_id = ?, price = ?, stock_quantity = ?, description = ? WHERE product_id = ?";
        try (Connection connection = DBConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, product.getProductName());
            statement.setInt(2, product.getCategoryId());
            statement.setDouble(3, product.getPrice());
            statement.setInt(4, product.getQuantity());
            statement.setString(5, product.getDescription());
            statement.setInt(6, product.getProductId());
            return statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error updating product", e);
        }
    }

    @Override
    public int delete(Product product) {
        String sql = "DELETE FROM Product WHERE product_id = ?";
        try (Connection connection = DBConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, product.getProductId());
            return statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error deleting product", e);
        }
    }

    @Override
    public ArrayList<Product> selectAll() {
        String sql = "SELECT * FROM Product";
        List<Product> products = new ArrayList<>();
        try (Connection connection = DBConnection.getConnection();
            Statement statement = connection.createStatement(); 
            ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                int id = resultSet.getInt("product_id");
                String productName = resultSet.getString("product_name");
                int categoryId = resultSet.getInt("category_id");
                double price = resultSet.getDouble("price");
                int quantity = resultSet.getInt("stock_quantity");
                String description = resultSet.getString("description");
                products.add(new Product(id, productName, categoryId, price, quantity, description));
                usedProductIds.add(id); // Populate used IDs to prevent duplicates
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving all products", e);
        }
        return (ArrayList<Product>) products;
    }

    @Override
    public Product selectById(Product product) {
        String sql = "SELECT * FROM Product WHERE product_id = ?";
        try (Connection connection = DBConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, product.getProductId());
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    int id = resultSet.getInt("product_id");
                    String productName = resultSet.getString("product_name");
                    int categoryId = resultSet.getInt("category_id");
                    double price = resultSet.getDouble("price");
                    int quantity = resultSet.getInt("stock_quantity");
                    String description = resultSet.getString("description");
                    return new Product(id, productName, categoryId, price, quantity, description);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving product by ID", e);
        }
        return null;
    }

    public ArrayList<Product> selectByCategory(String categoryName) {
        String sql = "SELECT * FROM Product WHERE category_id = (SELECT category_id FROM Category WHERE category_name = ?)";
        List<Product> products = new ArrayList<>();
        try (Connection connection = DBConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, categoryName);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    int id = resultSet.getInt("product_id");
                    String productName = resultSet.getString("product_name");
                    int categoryId = resultSet.getInt("category_id");
                    double price = resultSet.getDouble("price");
                    int quantity = resultSet.getInt("stock_quantity");
                    String description = resultSet.getString("description");
                    products.add(new Product(id, productName, categoryId, price, quantity, description));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving products by category", e);
        }
        return (ArrayList<Product>) products;
    }

    public ArrayList<Product> searchByName(String productName) {
        String sql = "SELECT * FROM Product WHERE product_name LIKE ?";
        List<Product> products = new ArrayList<>();
        try (Connection connection = DBConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, "%" + productName + "%");
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    int id = resultSet.getInt("product_id");
                    productName = resultSet.getString("product_name");
                    int categoryId = resultSet.getInt("category_id");
                    double price = resultSet.getDouble("price");
                    int quantity = resultSet.getInt("stock_quantity");
                    String description = resultSet.getString("description");
                    products.add(new Product(id, productName, categoryId, price, quantity, description));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error searching products by name", e);
        }
        return (ArrayList<Product>) products;
    }
}
