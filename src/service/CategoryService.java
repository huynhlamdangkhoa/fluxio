package dao;

import model.Category;

public interface CategoryDAO extends GenericDAO<Category, Long>{
}
package service;

import dao.CategoryDAO;
import model.Category;
import java.util.List;

public class CategoryService{
    private final CategoryDAO categoryDAO;
    public CategoryService(CategoryDAO categoryDAO){
        this.categoryDAO = categoryDAO;
    }
    public boolean addCategory(Category category){
        if (isValidCategory(category)){
            categoryDAO.insert(category);
            return true;
        }
        return false;
    }
    public boolean updateCategory(Category category){
        if (category != null && category.getId() != null){
            categoryDAO.update(category);
            return true;
        }
        return false;
    }
    public boolean deleteCategory(Long id){
        return categoryDAO.delete(id) > 0;
    }
    public List<Category> getAllCategories(){
        return categoryDAO.findAll();
    }
    public Category getCategoryById(Long id){
        return categoryDAO.findById(id);
    }
    private boolean isValidCategory(Category category){
        return category != null && category.getName() != null && !category.getName().isEmpty();
    }
}
