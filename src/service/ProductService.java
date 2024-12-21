package dao;

import model.Product;
import java.util.List;

public interface ProductDAO extends GenericDAO<Product, Long>{
    List<Product> findByCategory(Long categoryId);
    List<Product> searchByName(String name);
    List<Product> findLowStockItems(int threshold);
}
package service;

import dao.ProductDAO;
import model.Product;
import java.util.List;

public class ProductService{
    private final ProductDAO productDAO;
    public ProductService(ProductDAO productDAO){
        this.productDAO = productDAO;
    }
    public boolean addProduct(Product product){
        if(isValidProduct(product)){
            productDAO.insert(product);
            return true;
        }
        return false;
    }
    public boolean updateProduct(Product product){
        if(product != null && product.getId() != null){
            productDAO.update(product);
            return true;
        }
        return false;
    }
    public boolean deleteProduct(Long id){
        return productDAO.delete(id) > 0;
    }
    public List<Product> getAllProducts(){
        return productDAO.findAll();
    }
    public Product getProductById(Long id){
        return productDAO.findById(id);
    }
    public List<Product> getProductsByCategory(Long categoryId){
        return productDAO.findByCategory(categoryId);
    }
    public List<Product> searchProductsByName(String name){
        return productDAO.searchByName(name);
    }
    public List<Product> getLowStockProducts(int threshold){
        return productDAO.findLowStockItems(threshold);
    }
    private boolean isValidProduct(Product product){
        return product != null
            && product.getName() != null && !product.getName().isEmpty()
            && product.getPrice() >= 0
            && product.getStockQuantity() >= 0;
    }
}
