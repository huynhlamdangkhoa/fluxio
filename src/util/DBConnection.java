package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DBConnection {

    private static final String URL = "jdbc:mysql://localhost:3306/inventorydatabase";
    private static final String USER = "root"; // Change to your MySQL username
    private static final String PASSWORD = "12345"; // Change to your MySQL password

    private static Connection connection = null;

    public static Connection getConnection() {
        if (connection == null) {
            try {
                // Register MySQL driver
                Class.forName("com.mysql.cj.jdbc.Driver");
                // Create the connection
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
                System.out.println("Database connection established successfully!");
            } catch (ClassNotFoundException e) {
                System.err.println("MySQL driver not found: " + e.getMessage());
            } catch (SQLException e) {
                System.err.println("Error connecting to the database: " + e.getMessage());
            }
        }
        return connection;
    }

    public static void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Database connection closed.");
            } catch (SQLException e) {
                System.err.println("Error closing the database connection: " + e.getMessage());
            }
        }
    }

    public static void runSQLScript(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            Statement stmt = connection.createStatement();
            String line;
            StringBuilder sql = new StringBuilder();
            
            while ((line = reader.readLine()) != null) {
                sql.append(line).append("\n");
                if (line.trim().endsWith(";")) {
                    stmt.execute(sql.toString());
                    sql.setLength(0); // Clear the SQL buffer
                }
            }
            System.out.println("SQL script executed successfully.");
        } catch (SQLException | IOException e) {
            System.err.println("Error executing SQL script: " + e.getMessage());
        }
    }
}
