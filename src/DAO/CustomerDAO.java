package DAO;

import model.Customer;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import util.DBConnection;

public class CustomerDAO implements DAOInterface<Customer> {
    public static CustomerDAO getInstance() {
        return new CustomerDAO();
    }

    @Override
    public int insert(Customer customer) {
        String sql = "INSERT INTO customers (customer_id, first_name, last_name, email, phone_number, address) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection connection = DBConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, customer.getCustomerId());
            statement.setString(2, customer.getFirstName());
            statement.setString(3, customer.getLastName());
            statement.setString(4, customer.getEmail());
            statement.setString(5, customer.getPhoneNumber());
            statement.setString(6, customer.getAddress());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error inserting customer", e);
        }
        return 0;
    }

    @Override
    public int update(Customer customer) {
        String sql = "UPDATE customers SET first_name = ?, last_name = ?, email = ?, phone_number = ?, address = ? WHERE customer_id = ?";
        try (Connection connection = DBConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, customer.getFirstName());
            statement.setString(2, customer.getLastName());
            statement.setString(3, customer.getEmail());
            statement.setString(4, customer.getPhoneNumber());
            statement.setString(5, customer.getAddress());
            statement.setInt(6, customer.getCustomerId());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error updating customer", e);
        }
        return 0;
    }

    @Override
    public int delete(Customer customer) {
        String sql = "DELETE FROM customers WHERE customer_id = ?";
        try (Connection connection = DBConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, customer.getCustomerId());
            return statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error deleting customer", e);
        }
    }

    @Override
    public ArrayList<Customer> selectAll() {
        List<Customer> customer = new ArrayList<>();
        String sql = "SELECT * FROM customers";
        try (Connection connection = DBConnection.getConnection();
            Statement statement = connection.createStatement(); 
            ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
            int id = resultSet.getInt("customer_id");
            String firstName = resultSet.getString("first_name");
            String lastName = resultSet.getString("last_name");
            String email = resultSet.getString("email");
            String phoneNumber = resultSet.getString("phone_number");
            String address = resultSet.getString("address");
            customer.add(new Customer(id, firstName, lastName, email, phoneNumber, address));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving all customers", e);
        }
        return null;
    }

    @Override
    public Customer selectById(Customer customer) {
        String sql = "SELECT * FROM customers WHERE customer_id = ?";
     try (Connection connection = DBConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, customer.getCustomerId());            
            try (ResultSet resultSet = statement.executeQuery()) {
               if (resultSet.next()) {
                    int id = resultSet.getInt("customer_id");
                    String firstName = resultSet.getString("first_name");
                    String lastName = resultSet.getString("last_name");
                    String email = resultSet.getString("email");
                    String phoneNumber = resultSet.getString("phone_number");
                    String address = resultSet.getString("address");
                    return new Customer(id, firstName, lastName, email, phoneNumber, address);
               }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving customer by ID", e);
        }
        return null;
    }

    public Customer selectByEmail(Customer customer) {
        String sql = "SELECT * FROM customers WHERE email = ?";
        try (Connection connection = DBConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, customer.getEmail());
         try (ResultSet resultSet = statement.executeQuery()) {
               if (resultSet.next()) {
                    int id = resultSet.getInt("customer_id");
                    String firstName = resultSet.getString("first_name");
                    String lastName = resultSet.getString("last_name");
                    String email = resultSet.getString("email");
                    String phoneNumber = resultSet.getString("phone_number");
                    String address = resultSet.getString("address");
                    return new Customer(id, firstName, lastName, email, phoneNumber, address);
               }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving customer by email", e);
        }
        return null;
    }

    public ArrayList<Customer> selectByName(Customer customer) {
        List<Customer> customers = new ArrayList<>();
        String sql = "SELECT * FROM customers WHERE first_name LIKE ? OR last_name LIKE ?";
        try (Connection connection = DBConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, "%" + customer.getFirstName() + "%");
            statement.setString(2, "%" + customer.getLastName() + "%");
               try (ResultSet resultSet = statement.executeQuery()) {
               if (resultSet.next()) {
                    int id = resultSet.getInt("customer_id");
                    String firstName = resultSet.getString("first_name");
                    String lastName = resultSet.getString("last_name");
                    String email = resultSet.getString("email");
                    String phoneNumber = resultSet.getString("phone_number");
                    String address = resultSet.getString("address");
                    customers.add(new Customer(id, firstName, lastName, email, phoneNumber, address));
               }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving customers by name", e);
        }
        return (ArrayList<Customer>) customers;
    }
}
