package org.xander.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

public class JDBCConnector {
    static final String DB_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/test";
    static final String DB_USER = "root";
    static final String DB_PASSWORD = "password";
    ArrayList<String> groupNames = new ArrayList<String>();
    ArrayList<String> productNames = new ArrayList<String>();

    public void createDataOnDb() throws SQLException {
        Connection connection = checkForConnection();
        CreateAndInsertData createAndInsertData = new CreateAndInsertData(connection);
        createAndInsertData.executeQuery();
    }

    public ArrayList<String> obtainGroupsFromDb() throws SQLException {
        Connection connection = checkForConnection();
        GroupsFromDb groupsFromDb = new GroupsFromDb(connection);
        groupNames = groupsFromDb.getDataFromDb();
        return groupNames;
    }

    public ArrayList<String> obtainProductsFromDb() throws SQLException {
        Connection connection = checkForConnection();
        ProductsFromDb productsFromDb = new ProductsFromDb(connection);
        productNames = productsFromDb.getDataFromDb();
        return productNames;
    }

    private Connection checkForConnection() {
        Connection connection = null;

        if (isDriverPresent()) throw new RuntimeException();
        System.out.println("MySQL JDBC Driver Registered!");

        try {
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console");
            e.printStackTrace();
            throw new RuntimeException();
        }

        if (connection != null) {
            System.out.println("You made it, take control over your database now!");
        } else {
            System.out.println("Failed to make connection!");
            throw new RuntimeException();
        }
        return connection;
    }

    private boolean isDriverPresent() {
        try {
            Class.forName(DB_DRIVER);
        } catch (ClassNotFoundException e) {
            System.out.println("There is no MySQL JDBC Driver");
            e.printStackTrace();
            return true;
        }
        return false;
    }

}