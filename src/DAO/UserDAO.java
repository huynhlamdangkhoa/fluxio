package DAO;

import util.DBConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
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
            userId = 10000 + random.nextInt(99999); 
        } while (usedUserIds.contains(userId));
        usedUserIds.add(userId);
        return userId;
    }

    @Override
    public int insert(User user) {
        String sql = "INSERT INTO User (user_id, username, password, email) VALUES (?, ?, ?, ?)";
        try (Connection connection = DBConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            statement.setInt(1, generateUserId());
            statement.setString(2, user.getUsername());
            statement.setString(3, user.getPassword());
            statement.setString(4, user.getEmail());

            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        user.setUserId(generatedKeys.getInt(1));
                    }
                }
            }
            return rowsAffected;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int update(User user) {
        String sql = "UPDATE User SET username=?, password=?, email=? WHERE user_id=?";
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, user.getUsername());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getEmail());
            statement.setInt(4, user.getUserId());

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
        ArrayList<User> users = new ArrayList<>();
        String sql = "SELECT * FROM User";
        try (Connection connection = DBConnection.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                users.add(mapResultSetToUser(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public User selectById(User user) {
        String sql = "SELECT * FROM User WHERE user_id=?";
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, user.getUserId());

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return mapResultSetToUser(resultSet);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<User> selectByCondition(String columnName, String value) {
        String sql = "SELECT * FROM User WHERE " + columnName + "=?";
        ArrayList<User> users = new ArrayList<>();
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, value);

            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    users.add(mapResultSetToUser(resultSet));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    private User mapResultSetToUser(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("user_id");
        String username = resultSet.getString("username");
        String password = resultSet.getString("password");
        String email = resultSet.getString("email");
        return new User(id, username, password, email);
    }
}
