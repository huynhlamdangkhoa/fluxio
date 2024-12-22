package DAO;

import model.Product;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import util.DBConnection;

public class ProductDAO implements DAOInterface<Product> {
    public static ProductDAO getInstance() {
        return new ProductDAO();
    }

    @Override
    public int insert(Product product) {
        String sql = "INSERT INTO products (product_name, quantity, price, category) VALUES (?, ?, ?, ?)";
        try (Connection connection = DBConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, product.getProductName());
            statement.setInt(2, product.getQuantity());
            statement.setDouble(3, product.getPrice());
            statement.setString(4, product.getCategory());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error inserting product", e);
        }
        return 0;
    }

    @Override
    public int update(Product product) {
        String sql = "UPDATE products SET product_name = ?, quantity = ?, price = ?, category = ? WHERE product_id = ?";
        try (Connection connection = DBConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, product.getProductName());
            statement.setInt(2, product.getQuantity());
            statement.setDouble(3, product.getPrice());
            statement.setString(4, product.getCategory());
            statement.setInt(5, product.getProductId()); 
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error updating product", e);
        }
        return 0;
    }

    @Override
    public int delete(Product product) {
        String sql = "DELETE FROM products WHERE product_id = ?";
        try (Connection connection = DBConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, product.getProductId());
            return statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();        }
        return 0;
    }

    @Override
    public ArrayList<Product> selectAll() {
        String sql = "SELECT * FROM products";
        List<Product> products = new ArrayList<>();
        try (Connection connection = DBConnection.getConnection();
            Statement statement = connection.createStatement(); 
            ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                int id = resultSet.getInt("product_id");
                String productName = resultSet.getString("product_name");
                int quantity = resultSet.getInt("quantity");
                double price = resultSet.getDouble("price");
                String category = resultSet.getString("category");
                products.add(new Product(id, productName, quantity, price, category));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving all products", e);
        }
        return (ArrayList<Product>) products;
    }

    @Override
    public Product selectById(Product product) {
        String sql = "SELECT * FROM products WHERE product_id = ?";
        try (Connection connection = DBConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, product.getProductId());
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    int id = resultSet.getInt("product_id");
                String productName = resultSet.getString("product_name");
                int quantity = resultSet.getInt("quantity");
                double price = resultSet.getDouble("price");
                String category = resultSet.getString("category");
                return new Product(id, productName, quantity, price, category);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving product by ID", e);
        }
        return null;
    }

    public ArrayList<Product> selectByCategory(String category) {
        String sql = "SELECT * FROM products WHERE category = ?";
        List<Product> products = new ArrayList<>();
        try (Connection connection = DBConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, category);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    int id = resultSet.getInt("product_id");
                    String productName = resultSet.getString("product_name");
                    int quantity = resultSet.getInt("quantity");
                    double price = resultSet.getDouble("price");
                    category = resultSet.getString("category");
                    products.add(new Product(id, productName, quantity, price, category));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving products by category", e);
        }
        return (ArrayList<Product>) products;
    }

    public ArrayList<Product> searchByName(String productName) {
        String sql = "SELECT * FROM products WHERE product_name LIKE ?";
        List<Product> products = new ArrayList<>();
        try (Connection connection = DBConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, "%" + productName + "%");
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    int id = resultSet.getInt("product_id");
                    productName = resultSet.getString("product_name");
                    int quantity = resultSet.getInt("quantity");
                    double price = resultSet.getDouble("price");
                    String category = resultSet.getString("category");
                    products.add(new Product(id, productName, quantity, price, category));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error searching products by name", e);
        }
        return (ArrayList<Product>) products;
    }
}
