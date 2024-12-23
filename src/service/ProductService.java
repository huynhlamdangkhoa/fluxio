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
            int productId = productDAO.insert(product);
            product.setProductId(productId); // Update product with generated ID
            return true;
        }
        return false;
    }

    public boolean updateProduct(Product product) {
        if (product != null && product.getProductId() > 0) {
            return productDAO.update(product) > 0;
        }
        return false;
    }

    public boolean deleteProduct(Product product) {
        if (product != null && product.getProductId() > 0) {
            return productDAO.delete(product) > 0;
        }
        return false;
    }

    public List<Product> getAllProducts() {
        return productDAO.selectAll();
    }

    public Product getProductById(int productId) {
        Product dummyProduct = new Product(productId, null, 0, 0.0, 0, null);
        return productDAO.selectById(dummyProduct);
    }

    public List<Product> getProductsByCategory(String category) {
        return productDAO.selectByCategory(category);
    }

    public List<Product> searchProductsByName(String name) {
        return productDAO.searchByName(name);
    }

    private boolean isValidProduct(Product product) {
        return product != null
            && product.getProductName() != null && !product.getProductName().isEmpty()
            && product.getPrice() != null && product.getPrice() >= 0
            && product.getQuantity() >= 0
            && product.getCategoryId() > 0; // Validates category ID existence
    }
}
