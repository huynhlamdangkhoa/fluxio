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
        if (product != null && product.getProductId() > 0) {
            productDAO.update(product);
            return true;
        }
        return false;
    }

    public boolean deleteProduct(Product product) {
        return productDAO.delete(product) > 0;
    }

    public List<Product> getAllProducts() {
        return productDAO.selectAll();
    }

    public Product getProductById(int productId) {
        return productDAO.selectById(new Product(productId, null, 0, 0.0, null));

    }

    public List<Product> getProductsByCategory(String category) {
        return productDAO.selectByCategory(category);
    }

    public List<Product> searchProductsByName(String name) {
        return productDAO.searchByName(name);
    }

    public List<Product> getLowStockProducts(int threshold) {
        return null;
    }

    private boolean isValidProduct(Product product) {
        return product != null
            && product.getProductName() != null && !product.getProductName().isEmpty()
            && product.getPrice() != null && product.getPrice() >= 0
            && product.getQuantity() >= 0
            && product.getCategory() != null && !product.getCategory().isEmpty();
    }
}
