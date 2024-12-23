package DAO;

import util.DBConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import util.DBConnection;
import model.User;

public class UserDAO implements DAOInterface<User> {
    private static final HashSet<Integer> usedUserIds = new HashSet<>();

    public static UserDAO getInstance() {
        return new UserDAO();
    }
    
   public int generateUserId() {
        Random random = new Random();
        int userId;
        do {
            userId = 10000 + random.nextInt(90000); // Generates a number between 100 and 999
        } while (usedUserIds.contains(userId));
        usedUserIds.add(userId);
        return userId;
    }

    @Override
    public int insert(User user) {
        String sql = "INSERT IGNORE INTO User (username, password, email) VALUES (?, ?, ?, ?)";
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, user.getUsername());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getEmail());

            return statement.executeUpdate(); 
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int update(User user) {
        String sql = "UPDATE User SET username=?, password=?, email=?, WHERE user_id=?";
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, user.getUsername());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getEmail());
            statement.setInt(5, user.getUserId());

            return statement.executeUpdate(); 
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int delete(User user) {
        String sql = "DELETE FROM User WHERE user_id=?";
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, user.getUserId());
            return statement.executeUpdate(); 
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public ArrayList<User> selectAll() {
        List<User> user = new ArrayList<>();
        String sql = "SELECT * FROM User";
        try (Connection connection = DBConnection.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                int id = resultSet.getInt("user_id");
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                String email = resultSet.getString("email");
                user.add(new User(id, username, password, email));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (ArrayList<User>) user;
    }

    @Override
    public User selectById(User user) {
        String sql = "SELECT * FROM User WHERE user_id=?";
        try (Connection connection = DBConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, user.getUserId()); 

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    int id = resultSet.getInt("user_id");
                    String username = resultSet.getString("username");
                    String password = resultSet.getString("password");
                    String email = resultSet.getString("email");
                    return new User(id, username, password, email);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null; 
    }

    public ArrayList<User> selectByCondition(String condition) {
                String sql = "SELECT * FROM Users WHERE " + condition; // Note: Be cautious of SQL injection risks.
        ArrayList<User> user = new ArrayList<>();
        try (Connection connection = DBConnection.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                int id = resultSet.getInt("user_id");
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                String email = resultSet.getString("email");
                user.add(new User(id, username, password, email));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (ArrayList<User>) user;
    }
}