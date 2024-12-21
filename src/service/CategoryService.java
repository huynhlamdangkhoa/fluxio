package service;

import DAO.CategoryDAO;
import model.Category;
import java.util.List;

public class CategoryService {
    private final CategoryDAO categoryDAO;

    public CategoryService(CategoryDAO categoryDAO) {
        this.categoryDAO = categoryDAO;
    }

    public boolean addCategory(Category category) {
        if (isValidCategory(category)) {
            categoryDAO.insert(category);
            return true;
        }
        return false;
    }

    public boolean updateCategory(Category category) {
        if (category != null && category.getCategoryId() > 0) {
            categoryDAO.update(category);
            return true;
        }
        return false;
    }

    public boolean deleteCategory(int categoryId) {
        return categoryDAO.delete(categoryId) > 0;
    }

    public List<Category> getAllCategories() {
        return categoryDAO.findAll();
    }

    public Category getCategoryById(int categoryId) {
        return categoryDAO.findById(categoryId);
    }

    private boolean isValidCategory(Category category) {
        return category != null && category.getCategoryName() != null && !category.getCategoryName().isEmpty();
    }
}
