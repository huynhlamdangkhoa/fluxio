package DAO;

import util.DBConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.Category;

public class CategoryDAO implements DAOInterface<Category> {
    public static CategoryDAO getInstance() {
        return new CategoryDAO();
    }

    @Override
    public int insert(Category category) {
        String sql = "INSERT IGNORE INTO Category (category_id, category_name) VALUES (?, ?)";
        try (Connection connection = DBConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, category.getCategoryId());
            statement.setString(2, category.getCategoryName());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error inserting category", e);
        }
        return 0;
    }

    @Override
    public int update(Category category) {
        String sql = "UPDATE Category SET category_name = ? WHERE category_id = ?";
        try (Connection connection = DBConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, category.getCategoryName());
            statement.setInt(2, category.getCategoryId());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error updating category", e);
        }
        return 0;
    }

    @Override
    public int delete(Category category) {
        String sql = "DELETE FROM Category WHERE category_id = ?";
        try (Connection connection = DBConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, category.getCategoryId());
            return statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public ArrayList<Category> selectAll() {
        List<Category> category = new ArrayList<>();
        String sql = "SELECT * FROM Category";
        try (Connection connection = DBConnection.getConnection();
            Statement statement = connection.createStatement(); 
            ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                int id = resultSet.getInt("category_id");
                String categoryName = resultSet.getString("category_name");
                category.add(new Category(id, categoryName));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving all categories", e);
        }
        return null;
    }

    @Override
    public Category selectById(Category category) {
        String sql = "SELECT * FROM Category WHERE category_id = ?";
        try (Connection connection = DBConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, category.getCategoryId());
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                int id = resultSet.getInt("category_id");
                String categoryName = resultSet.getString("category_name");
                return new Category(id, categoryName);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving category by ID", e);
        }
        return null;
    }
}
