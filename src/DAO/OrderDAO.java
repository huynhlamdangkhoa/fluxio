package DAO;

import model.Order;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import util.DBConnection;

public class OrderDAO implements DAOInterface<Order> {
    public static OrderDAO getInstance() {
        return new OrderDAO();
    }

    @Override
    public int insert(Order order) {
        String sql = "INSERT INTO orders (total_amount, order_date, status, shipping_address, payment_method) VALUES (?, ?, ?, ?, ?)";
        try (Connection connection = DBConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            statement.setDouble(1, order.getTotalAmount());
            statement.setTimestamp(2, Timestamp.valueOf(order.getOrderDate()));
            statement.setString(3, order.getStatus());
            statement.setString(4, order.getShippingAddress());
            statement.setString(5, order.getPaymentMethod());
            statement.executeUpdate();

            try (ResultSet keys = statement.getGeneratedKeys()) {
                if (keys.next()) {
                    order.setOrderId(keys.getInt(1));
                }
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

