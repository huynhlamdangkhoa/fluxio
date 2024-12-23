package service;

import DAO.CategoryDAO;
import model.Category;
import java.util.ArrayList;
import java.util.List;

public class CategoryService {
    private final CategoryDAO categoryDAO;

    public CategoryService() {
        this.categoryDAO = CategoryDAO.getInstance();
    }

    public boolean addCategory(Category category) {
        if (isValidCategory(category)) {
            return categoryDAO.insert(category) > 0;
        }
        return false;
    }

    public boolean updateCategory(Category category) {
        if (isValidCategory(category) && category.getCategoryId() > 0) {
            return categoryDAO.update(category) > 0;
        }
        return false;
    }

    public boolean deleteCategory(Category category) {
        if (category != null && category.getCategoryId() > 0) {
            return categoryDAO.delete(category) > 0;
        }
        return false;
    }

    public List<Category> getAllCategories() {
        ArrayList<Category> categories = categoryDAO.selectAll();
        return categories != null ? categories : new ArrayList<>();
    }

    public Category getCategoryById(int categoryId) {
        Category category = new Category(categoryId, null);
        return categoryDAO.selectById(category);
    }

    private boolean isValidCategory(Category category) {
        return category != null && category.getCategoryName() != null && !category.getCategoryName().isEmpty();
    }
}
