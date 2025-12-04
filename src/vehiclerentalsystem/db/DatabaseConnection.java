package vehiclerentalsystem.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private static final String URL = "jdbc:mysql://localhost:3306/vrs_db?useSSL=false&serverTimezone=UTC";
    private static final String USER = "root"; // change if needed
    private static final String PASSWORD = ""; // change if needed

    private static Connection conn = null;

    public static Connection getConnection() {
        if (conn == null) {
            try {
                // Load the MySQL JDBC Driver
                Class.forName("com.mysql.cj.jdbc.Driver");
                // Establish connection
                conn = DriverManager.getConnection(URL, USER, PASSWORD);
                System.out.println("Connected to DB successfully!");
            } catch (ClassNotFoundException e) {
                System.out.println("MySQL JDBC Driver not found!");
                e.printStackTrace();
            } catch (SQLException e) {
                System.out.println("DB Connection Failed!");
                e.printStackTrace();
            }
        }
        return conn;
    }

    // Optional: close connection
    public static void closeConnection() {
        if (conn != null) {
            try {
                conn.close();
                conn = null;
                System.out.println("Connection closed.");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
