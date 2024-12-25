package DAO;

import util.DBConnection;
import model.Category;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

public class CategoryDAO implements DAOInterface<Category> {
    private static final HashSet<Integer> usedCategoryIds = new HashSet<>();

    public static CategoryDAO getInstance() {
        return new CategoryDAO();
    }

    public int generateCategoryId() {
        Random random = new Random();
        int categoryId;
        do {
            categoryId = 1000 + random.nextInt(9999);
        } while (usedCategoryIds.contains(categoryId) || idExistsInDatabase(categoryId));
        usedCategoryIds.add(categoryId);
        return categoryId;
    }

    private boolean idExistsInDatabase(int categoryId) {
        String sql = "SELECT 1 FROM Category WHERE category_id = ?";
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, categoryId);
            try (ResultSet resultSet = statement.executeQuery()) {
                return resultSet.next();
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error checking category ID existence", e);
        }
    }

    @Override
    public int insert(Category category) {
        String sql = "INSERT IGNORE INTO Category (category_id, category_name) VALUES (?, ?)";
        try (Connection connection = DBConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)) {
            int categoryId = generateCategoryId(); 
            category.setCategoryId(categoryId); 
            statement.setInt(1, categoryId);
            statement.setString(2, category.getCategoryName());
            return statement.executeUpdate(); 
        } catch (SQLException e) {
            throw new RuntimeException("Error inserting category", e);
        }
    }

    @Override
    public int update(Category category) {
        String sql = "UPDATE Category SET category_name = ? WHERE category_id = ?";
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, category.getCategoryName());
            statement.setInt(2, category.getCategoryId()); // Use existing ID
            return statement.executeUpdate(); // Return rows affected
        } catch (SQLException e) {
            throw new RuntimeException("Error updating category", e);
        }
    }

    @Override
    public int delete(Category category) {
        String sql = "DELETE FROM Category WHERE category_id = ?";
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, category.getCategoryId());
            return statement.executeUpdate(); // Return rows affected
        } catch (SQLException e) {
            throw new RuntimeException("Error deleting category", e);
        }
    }

    @Override
    public ArrayList<Category> selectAll() {
        ArrayList<Category> categories = new ArrayList<>();
        String sql = "SELECT * FROM Category";
        try (Connection connection = DBConnection.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                int id = resultSet.getInt("category_id");
                String categoryName = resultSet.getString("category_name");
                categories.add(new Category(id, categoryName));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving all categories", e);
        }
        return categories; // Return the populated list
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
        return null; // Return null if not found
    }
}
