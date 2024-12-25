package DAO;

import model.Order;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import util.DBConnection;

public class OrderDAO implements DAOInterface<Order> {
    private static final HashSet<Integer> usedOrderIds = new HashSet<>();

    public static OrderDAO getInstance() {
        return new OrderDAO();
    }

    public int generateOrderId() {
        Random random = new Random();
        int userId;
        do {
            userId = 100 + random.nextInt(999); 
        } while (usedOrderIds.contains(userId) || idExistsInDatabase(userId));
        usedOrderIds.add(userId);
        return userId;
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
    public int insert(Order order) {
        String sql = "INSERT INTO orders (order_id, total_amount, order_date, status, shipping_address, payment_method) VALUES (?, ?, ?, ?, ?, ?)";
        int userId = generateOrderId();
        try (Connection connection = DBConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, userId);
            statement.setDouble(2, order.getTotalAmount());
            statement.setTimestamp(3, Timestamp.valueOf(order.getOrderDate()));
            statement.setString(4, order.getStatus());
            statement.setString(5, order.getShippingAddress());
            statement.setString(6, order.getPaymentMethod());
            int rowsInserted = statement.executeUpdate();

            if (rowsInserted > 0) {
                order.setOrderId(userId);
                return userId;
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error inserting order", e);
        }
        return 0;
    }


    @Override
    public int update(Order order) {
        String sql = "UPDATE orders SET total_amount = ?, order_date = ?, status = ?, shipping_address = ?, payment_method = ? WHERE order_id = ?";
        try (Connection connection = DBConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setDouble(1, order.getTotalAmount());
            statement.setTimestamp(2, Timestamp.valueOf(order.getOrderDate()));
            statement.setString(3, order.getStatus());
            statement.setString(4, order.getShippingAddress());
            statement.setString(5, order.getPaymentMethod());
            statement.setInt(6, order.getOrderId());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error updating order", e);
        }
        return 0;
    }

    @Override
    public int delete(Order order) {
        String sql = "DELETE FROM orders WHERE order_id = ?";
        try (Connection connection = DBConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, order.getOrderId());
            return statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error deleting order", e);
        }
    }

    @Override
    public ArrayList<Order> selectAll() {
        String sql = "SELECT * FROM orders";
        List<Order> orders = new ArrayList<>();
        try (Connection connection = DBConnection.getConnection();
            Statement statement = connection.createStatement(); 
            ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                int id = resultSet.getInt("order_id");
                double totalAmount = resultSet.getDouble("total_amount");
                LocalDateTime orderDate = resultSet.getTimestamp("order_date").toLocalDateTime();
                String status = resultSet.getString("status");
                String shippingAddress = resultSet.getString("shipping_address");
                String paymentMethod = resultSet.getString("payment_method");
                orders.add(new Order(id, totalAmount, orderDate, status, shippingAddress, paymentMethod));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving all orders", e);
        }
        return (ArrayList<Order>) orders;
    }

    @Override
    public Order selectById(Order order) {
        String sql = "SELECT * FROM orders WHERE order_id = ?";
        try (Connection connection = DBConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, order.getOrderId());
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    int id = resultSet.getInt("order_id");
                    double totalAmount = resultSet.getDouble("total_amount");
                    LocalDateTime orderDate = resultSet.getTimestamp("order_date").toLocalDateTime();
                    String status = resultSet.getString("status");
                    String shippingAddress = resultSet.getString("shipping_address");
                    String paymentMethod = resultSet.getString("payment_method");
                    return new Order(id, totalAmount, orderDate, status, shippingAddress, paymentMethod);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving order by ID", e);
        }
        return null;
    }
}

