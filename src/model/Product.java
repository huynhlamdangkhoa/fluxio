package model;

import java.util.List;
import model.Category;

public class Product {
    private int productId;
    private String productName;
    private int quantity;
    private Double price;
    private int categoryId;
    private String description;
    private Category category;
    
    public Product(int productId, String productName, int stockQuantity, double price, int categoryId, String description) {
        this.productId = productId;
        this.productName = productName;
        this.quantity = stockQuantity;
        this.price = price;
        this.categoryId = categoryId;
        this.description = description;
    }
    
    public int getProductId() {
        return productId;
    }

    public void setProductId(int productIds) {
        this.productId = productId;
    }
    
    public String getProductName() {
        return productName;
    }
    
    public void setProductName(String productName) {
        this.productName = productName;
    }
    
    public int getQuantity() {
        return quantity;
    }
    
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public Double getPrice() {
        return price;
    }
    
    public void setPrice(Double price) {
        this.price = price;
    }
    
    public int getCategoryId() {
        return category.getCategoryId();
    }
    
    public void setCategoryId(Category category) {
        this.category = category;
    }
    
    public String getDescription() {
        return description;
    }

    public void setDescription(List<Integer> productIds) {
        this.description = description;
    }
}

