package DAO;

import java.util.ArrayList;

public interface DAOInterface<T> {
    public int insert(T t);
    public int update(T t);
    public int delete(T t);
    public ArrayList<T> selectAll();
    public T selectById(T t);
}

//-- Create database
//CREATE DATABASE IF NOT EXISTS inventorydatabase;
//USE inventorydatabase;
//
//-- User(int userId, String username, String password, String email)
//CREATE TABLE IF NOT EXISTS User (
//    user_id INT AUTO_INCREMENT PRIMARY KEY,
//    username VARCHAR(50) NOT NULL UNIQUE,
//    password VARCHAR(255) NOT NULL,
//    email VARCHAR(100) NOT NULL UNIQUE,
//    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
//);
//
//-- Category(int categoryId, String categoryName)
//CREATE TABLE IF NOT EXISTS Category (
//    category_id INT AUTO_INCREMENT PRIMARY KEY,
//    category_name VARCHAR(100) NOT NULL UNIQUE,
//    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
//);
//
//-- Product(int productId, String productName, int quantity, Double price, String category)
//CREATE TABLE IF NOT EXISTS Product (
//    product_id INT AUTO_INCREMENT PRIMARY KEY,
//    product_name VARCHAR(100) NOT NULL,
//    quantity INT NOT NULL,
//    price DECIMAL(10, 2) NOT NULL,
//    category VARCHAR(100) NOT NULL,
//    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
//);
//
//
//-- Order(int orderId, double totalAmount, LocalDateTime orderDate, String status, String shippingAddress, String paymentMethod)
//CREATE TABLE IF NOT EXISTS `Order` (
//    order_id INT AUTO_INCREMENT PRIMARY KEY,
//    total_amount DECIMAL(10, 2) NOT NULL,
//    order_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
//    status ENUM('Pending', 'Completed', 'Cancelled') DEFAULT 'Pending',
//    shipping_address VARCHAR(255) NOT NULL,
//    payment_method VARCHAR(100) NOT NULL,
//	created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
//);
//
//INSERT IGNORE INTO User (username, password, email) VALUES
//('admin', 'admin123', 'admin@example.com');
//
//INSERT IGNORE INTO Category (category_id, category_name) VALUES
//(1514, 'Electronics'),
//(1437, 'Clothing');
//
//INSERT IGNORE INTO Product (product_name, category_id, price, quantity, description) VALUES
//('Smartphone', 1, 699.99, 50, 'Latest model smartphone'),
//('Jeans', 2, 49.99, 100, 'Denim jeans in various sizes');
//
//INSERT IGNORE INTO `Order` (customer_id, total_amount, status, shipping_address, payment_method) VALUES
//(1, 49.99, 'Completed', '144 Ton Duc Thang, District 2, HCMC', 'Credit Card');



