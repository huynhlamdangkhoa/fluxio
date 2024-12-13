-- Create database
CREATE DATABASE IF NOT EXISTS inventorydatabase;
USE inventorydatabase;

-- Table: User
CREATE TABLE IF NOT EXISTS User (
    user_id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    role ENUM('Admin', 'Staff') DEFAULT 'Staff',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Table: Category
CREATE TABLE IF NOT EXISTS Category (
    category_id INT AUTO_INCREMENT PRIMARY KEY,
    category_name VARCHAR(100) NOT NULL UNIQUE,
    description TEXT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Table: Product
CREATE TABLE IF NOT EXISTS Product (
    product_id INT AUTO_INCREMENT PRIMARY KEY,
    product_name VARCHAR(100) NOT NULL,
    category_id INT,
    price DECIMAL(10, 2) NOT NULL,
    stock_quantity INT NOT NULL,
    description TEXT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (category_id) REFERENCES Category(category_id) ON DELETE SET NULL
);

-- Table: Customer
CREATE TABLE IF NOT EXISTS Customer (
    customer_id INT AUTO_INCREMENT PRIMARY KEY,
    customer_name VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    phone VARCHAR(15),
    address TEXT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Table: `Order`
CREATE TABLE IF NOT EXISTS `Order` (
    order_id INT AUTO_INCREMENT PRIMARY KEY,
    customer_id INT NOT NULL,
    total_amount DECIMAL(10, 2) NOT NULL,
    order_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    status ENUM('Pending', 'Completed', 'Cancelled') DEFAULT 'Pending',
    FOREIGN KEY (customer_id) REFERENCES Customer(customer_id) ON DELETE CASCADE
);

-- Table: OrderDetails
CREATE TABLE IF NOT EXISTS OrderDetails (
    order_detail_id INT AUTO_INCREMENT PRIMARY KEY,
    order_id INT NOT NULL,
    product_id INT NOT NULL,
    quantity INT NOT NULL,
    price DECIMAL(10, 2) NOT NULL,
    FOREIGN KEY (order_id) REFERENCES `Order`(order_id) ON DELETE CASCADE,
    FOREIGN KEY (product_id) REFERENCES Product(product_id) ON DELETE CASCADE
);

-- Insert sample data
INSERT IGNORE INTO User (username, password, email, role) VALUES
('admin', 'admin123', 'admin@example.com', 'Admin'),
('staff1', 'staff123', 'staff1@example.com', 'Staff');

INSERT IGNORE INTO Category (category_name, description) VALUES
('Electronics', 'Devices and gadgets'),
('Clothing', 'Apparel and accessories');

INSERT IGNORE INTO Product (product_name, category_id, price, stock_quantity, description) VALUES
('Smartphone', 1, 699.99, 50, 'Latest model smartphone'),
('Jeans', 2, 49.99, 100, 'Denim jeans in various sizes');

INSERT IGNORE INTO Customer (customer_name, email, phone, address) VALUES
('John Doe', 'john.doe@example.com', '123456789', '123 Elm Street');

INSERT IGNORE INTO `Order` (customer_id, total_amount, status) VALUES
(1, 749.98, 'Completed');

INSERT IGNORE INTO OrderDetails (order_id, product_id, quantity, price) VALUES
(1, 1, 1, 699.99),
(1, 2, 1, 49.99);
