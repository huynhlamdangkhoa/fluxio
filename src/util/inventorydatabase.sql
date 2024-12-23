-- Create database
CREATE DATABASE IF NOT EXISTS inventorydatabase;
USE inventorydatabase;

-- User(int userId, String username, String password, String email)
CREATE TABLE IF NOT EXISTS User (
    user_id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Category(int categoryId, String categoryName)
CREATE TABLE IF NOT EXISTS Category (
    category_id INT AUTO_INCREMENT PRIMARY KEY,
    category_name VARCHAR(100) NOT NULL UNIQUE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Product(int productId, String productName, int quantity, Double price, int categoryID)
CREATE TABLE IF NOT EXISTS Product (
    product_id INT AUTO_INCREMENT PRIMARY KEY,
    product_name VARCHAR(100) NOT NULL,
    category_id INT NOT NULL,
    price DECIMAL(10, 2) NOT NULL,
    stock_quantity INT NOT NULL,
    description TEXT NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (category_id) REFERENCES Category(category_id)
);

-- Order(int orderId, double totalAmount, LocalDateTime orderDate, String status, String shippingAddress, String paymentMethod)
CREATE TABLE IF NOT EXISTS `Order` (
    order_id INT AUTO_INCREMENT PRIMARY KEY,
    total_amount DECIMAL(10, 2) NOT NULL,
    order_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    status ENUM('Pending', 'Completed', 'Cancelled') DEFAULT 'Pending',
    shipping_address VARCHAR(255) NOT NULL,
    payment_method VARCHAR(100) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Insert some initial data into User, Category, Product, and Order
INSERT IGNORE INTO User (username, password, email) VALUES
('admin', 'admin123', 'admin@example.com');

INSERT IGNORE INTO Category (category_name) VALUES
('Electronics'),
('Clothing');

INSERT IGNORE INTO Product (product_name, category_id, price, stock_quantity, description) VALUES
('Smartphone', 1, 699.99, 50, 'Latest model smartphone'),
('Jeans', 2, 49.99, 100, 'Denim jeans in various sizes');

INSERT IGNORE INTO `Order` (total_amount, status, shipping_address, payment_method) VALUES
(49.99, 'Completed', '144 Ton Duc Thang, District 2, HCMC', 'Credit Card');
