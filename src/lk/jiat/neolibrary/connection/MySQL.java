package lk.jiat.neolibrary.connection;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;


public class MySQL {

    private static Properties appProperties = null;
    private static Connection connection = null;
    private static boolean propertiesLoaded = false;

    private static void loadProperties() {
        if (!propertiesLoaded) {
            appProperties = new Properties();
            String filePath = System.getProperty("user.dir") + "//neolibrary.properties";
            try (FileInputStream fis = new FileInputStream(filePath)) {
                appProperties.load(fis);
                propertiesLoaded = true;
            } catch (FileNotFoundException e) {
                throw new RuntimeException("Database properties file not found: " + filePath, e);
            } catch (IOException e) {
                throw new RuntimeException("Error loading database properties file: " + filePath, e);
            }
        }
    }

    public static Connection getConnection() {
        loadProperties();
        String DB_URL = appProperties.getProperty("db.url");
        String DB_USERNAME = appProperties.getProperty("db.username");
        String DB_PASSWORD = appProperties.getProperty("db.password");

        try {
            if (connection == null || connection.isClosed()) {
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            }
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException("Failed to connect to the database. Please check your configuration and database server.", e);
        }
        return connection;
    }

    public static ResultSet executeSearch(String query) throws SQLException {
        Connection conn = getConnection();
        if (conn == null) {
            throw new SQLException("Database connection is not available.");
        }
        return conn.createStatement().executeQuery(query);
    }

    public static int executeIUD(String query) throws SQLException {
        Connection conn = getConnection();
        if (conn == null) {
            throw new SQLException("Database connection is not available.");
        }
        return conn.createStatement().executeUpdate(query);
    }
}
