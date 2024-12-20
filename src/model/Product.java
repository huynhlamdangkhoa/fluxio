package model;

import java.util.List;

public class Product {
    private List<Integer> productId;
    private String productName;
    private int quantity;
    private Double price;
    private String category;
    
    public Product(String productName, int quantity, Double price, String category, List<Integer> productId){
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
        this.category = category;
    }
    
    public List<Integer> getProductId() {
        return productId;
    }

    public void setProductId(List<Integer> productIds) {
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
    
    public String getCategory() {
        return category;
    }
    
    public void setCategory(String category) {
        this.category = category;
    }
}

