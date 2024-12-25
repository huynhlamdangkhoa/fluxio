-- Create database
CREATE DATABASE IF NOT EXISTS inventorydatabase;
USE inventorydatabase;

-- User(int userId, String username, String password, String email)
CREATE TABLE IF NOT EXISTS User (
    user_id INT PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Category(int categoryId, String categoryName)
CREATE TABLE IF NOT EXISTS Category (
    category_id INT PRIMARY KEY,
    category_name VARCHAR(100) NOT NULL UNIQUE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Product(int productId, String productName, int quantity, Double price, int categoryID, String description)
CREATE TABLE IF NOT EXISTS Product (
    product_id INT PRIMARY KEY,
    product_name VARCHAR(100) NOT NULL,
    stock_quantity INT NOT NULL,
	price DECIMAL(10, 2) NOT NULL,
    category_id INT NOT NULL,
    description TEXT NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (category_id) REFERENCES Category(category_id)
);

-- Order(int orderId, double totalAmount, LocalDateTime orderDate, String status, String shippingAddress, String paymentMethod)
CREATE TABLE IF NOT EXISTS `Order` (
	order_id INT PRIMARY KEY,
    total_amount DECIMAL(10, 2) NOT NULL,
    order_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    status ENUM('Pending', 'Completed', 'Cancelled') DEFAULT 'Pending',
    shipping_address VARCHAR(255) NOT NULL,
    payment_method VARCHAR(100) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Insert some initial data into User, Category, Product, and Order
INSERT IGNORE INTO User (user_id, username, password, email) VALUES
(83476, 'admin', 'admin123', 'admin@example.com');

INSERT IGNORE INTO Category (category_id, category_name) VALUES
(1543, 'Electronics'),
(7365, 'Clothing'),
(1234, 'Books'),
(5067, 'Instruments'),
(1121, 'Beauty & Personal Care'),
(5161, 'Sports'),
(3141, 'Toys & Games');

INSERT IGNORE INTO Product (product_id, product_name, stock_quantity, price, category_id, description) VALUES
(522, 'Smartwatch', 15, 199.99, 1543, 'Advanced smartwatch with fitness tracking'),
(743, 'Smart Speaker', 30, 129.99, 1543, 'Voice-activated smart speaker'),
(914, 'Smart TV', 10, 999.99, 1543, '4K Ultra HD Smart TV'),
(835, 'Wireless Earbuds', 50, 59.99, 1543, 'High-quality wireless earbuds'),
(236, 'Laptop', 25, 1099.99, 1543, 'High-performance gaming laptop'),
(152, 'Sweater', 35, 39.99, 7365, 'Cozy wool sweater'),
(703, 'Sports Watch', 25, 129.99, 5161, 'Smart sports watch with GPS tracking'),
(654, 'Yoga Mat', 30, 24.99, 5161, 'Non-slip yoga mat for exercise'),
(601, 'Puzzle', 50, 14.99, 3141, '500-piece jigsaw puzzle'),
(453, 'Jersey', 20, 29.99, 7365, 'Sports team jersey'),
(374, 'Jacket', 15, 89.99, 7365, 'Waterproof winter jacket'),
(715, 'Suit', 10, 199.99, 7365, 'Formal suit with a modern fit'),
(316, 'Waistcoat', 12, 79.99, 7365, 'Classic waistcoat for formal occasions'),
(201, 'Science Fiction Novel', 40, 14.99, 1234, 'Bestselling sci-fi adventure'),
(432, 'Self-Help Book', 35, 19.99, 1234, 'Inspirational and motivational book'),
(503, 'Java Programming Guide', 50, 39.99, 1234, 'Comprehensive Java programming tutorial'),
(987, 'Electric Guitar', 8, 349.99, 5067, 'Electric guitar with amplifier and accessories'),
(321, 'Flute', 12, 149.99, 5067, 'Silver-plated flute for students and professionals'),
(432, 'Trumpet', 6, 399.99, 5067, 'Professional trumpet with carrying case'),
(876, 'Cello', 4, 799.99, 5067, 'Full-size cello with bow and case'),
(401, 'Shampoo', 60, 9.99, 1121, 'Herbal shampoo for strong and shiny hair'),
(542, 'Skin Cream', 40, 14.99, 1121, 'Moisturizing skin cream for daily use'),
(703, 'Perfume', 25, 49.99, 1121, 'Luxury perfume with a floral scent'),
(612, 'T-Shirt', 60, 19.99, 7365, 'Comfortable cotton t-shirt'),
(345, 'Winter Coat', 10, 129.99, 7365, 'Insulated winter coat for extreme weather'),
(478, 'Formal Trousers', 25, 49.99, 7365, 'Slim-fit formal trousers for office wear'),
(890, 'Athletic Shorts', 35, 24.99, 7365, 'Lightweight shorts for running and workouts'),
(213, 'Leather Jacket', 12, 179.99, 7365, 'Classic leather jacket with a modern twist'),
(589, 'Mystery Novel', 35, 14.99, 1234, 'Suspenseful mystery that keeps you guessing'),
(901, 'Building Blocks', 40, 29.99, 3141, 'Colorful interlocking blocks for kids'),
(234, 'Dollhouse', 12, 149.99, 3141, 'Wooden dollhouse with furniture set'),
(567, 'Action Figure', 25, 19.99, 3141, 'Collectible superhero action figure'),
(914, 'Makeup Kit', 20, 29.99, 1121, 'All-in-one makeup kit for women'),
(901, 'Soccer Ball', 50, 19.99, 5161, 'Standard-size soccer ball'),
(812, 'Sneakers', 40, 59.99, 5161, 'Lightweight running sneakers'),
(732, 'Board Game', 30, 24.99, 3141, 'Classic strategy board game');




INSERT IGNORE INTO `Order` (order_id, total_amount, status, shipping_address, payment_method) VALUES
(353, 120.50, 'Pending', '23 Nguyen Trai, District 1, HCMC', 'Credit Card'),
(364, 85.75, 'Completed', '56 Tran Hung Dao, District 5, HCMC', 'Cash'),
(375, 230.00, 'Cancelled', '12 Le Loi, District 3, HCMC', 'PayPal'),
(386, 19.99, 'Shipped', '89/12 Bui Vien, District 1, HCMC', 'Debit Card'),
(397, 310.45, 'Completed', '34 Ly Tu Trong, District 10, HCMC', 'Credit Card'),
(408, 45.00, 'Processing', '78 Nguyen Thi Minh Khai, District 3, HCMC', 'Cash'),
(419, 150.00, 'Completed', '65 Hoang Hoa Tham, Tan Binh, HCMC', 'PayPal'),
(430, 99.99, 'Cancelled', '22 Pasteur, District 1, HCMC', 'Debit Card'),
(441, 75.50, 'Shipped', '44 Bach Dang, District 2, HCMC', 'Credit Card'),
(452, 189.25, 'Processing', '10 Dinh Tien Hoang, District 1, HCMC', 'Cash');
