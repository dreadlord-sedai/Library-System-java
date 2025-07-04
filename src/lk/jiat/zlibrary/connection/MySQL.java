package lk.jiat.zlibrary.connection;

import java.io.FileInputStream;
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

    public static Connection getConnection() {
        appProperties = new Properties();
        String filePath = System.getProperty("user.dir") + "//zlibrary.properties";
        
        try {
            FileInputStream fis = new FileInputStream(filePath);
            appProperties.load(fis);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        String DB_URL = appProperties.getProperty("db.url");
        String DB_USERNAME = appProperties.getProperty("db.username");
        String DB_PASSWORD = appProperties.getProperty("db.password");
        
        try {
            if (connection == null || connection.isClosed()) {
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            }
        } catch (ClassNotFoundException | SQLException e) {
        }
        return connection;
    }

    public static ResultSet executeSearch(String query) throws SQLException {
        Connection conn = getConnection();
        return conn.createStatement().executeQuery(query);
    }

    public static int executeIUD(String query) throws SQLException {
        int rowCount = 0;
        rowCount = getConnection().createStatement().executeUpdate(query);
        return rowCount;
    }
}
