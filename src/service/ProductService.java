package service;

import DAO.ProductDAO;
import model.Product;
import java.util.List;

public class ProductService {
    private final ProductDAO productDAO;

    public ProductService(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    public boolean addProduct(Product product) {
        if (isValidProduct(product)) {
            productDAO.insert(product);
            return true;
        }
        return false;
    }

    public boolean updateProduct(Product product) {
        if (product != null && product.getProductId() != null && !product.getProductId().isEmpty()) {
            productDAO.update(product);
            return true;
        }
        return false;
    }

    public boolean deleteProduct(int productId) {  // Changed to accept a single int as productId
        return productDAO.delete(productId) > 0;
    }

    public List<Product> getAllProducts() {
        return productDAO.findAll();
    }

    public Product getProductById(int productId) {  // Changed to accept a single int as productId
        return productDAO.findById(productId);
    }

    public List<Product> getProductsByCategory(String category) {  // Changed to accept String category
        return productDAO.findByCategory(category);
    }

    public List<Product> searchProductsByName(String name) {
        return productDAO.searchByName(name);
    }

    public List<Product> getLowStockProducts(int threshold) {
        return productDAO.findLowStockItems(threshold);
    }

    private boolean isValidProduct(Product product) {
        return product != null
            && product.getProductName() != null && !product.getProductName().isEmpty()
            && product.getPrice() != null && product.getPrice() >= 0
            && product.getQuantity() >= 0
            && product.getCategory() != null && !product.getCategory().isEmpty();  // Ensure valid category
    }
}
