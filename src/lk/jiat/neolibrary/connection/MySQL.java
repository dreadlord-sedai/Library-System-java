package lk.jiat.neolibrary.connection;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class MySQL {

    private static Properties appProperties;
    private static Connection connection;

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            appProperties = new Properties();
            String filePath = System.getProperty("user.dir") + "\\zlibrary.properties";

            try (java.io.InputStream fis = new java.io.FileInputStream(filePath);) {
                appProperties.load(fis);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    private static final String DB_URL = appProperties.getProperty("db.url");
    private static final String DB_USERNAME = appProperties.getProperty("db.username");
    private static final String DB_PASSWORD = appProperties.getProperty("db.password");

    public static Connection getConnection() {

        try {
            if (connection == null || connection.isClosed()) {
                connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static ResultSet executeSearch(String query) throws SQLException {
        return getConnection().createStatement().executeQuery(query);
    }

    public static void executeIUD(String query) throws SQLException {
        getConnection().createStatement().executeUpdate(query);
    }

    public static void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
        }
    }

    public static Properties getAppProperties() {
        return appProperties;
    }
    
}
