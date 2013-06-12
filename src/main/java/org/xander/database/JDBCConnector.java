package org.xander.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnector {
    static final String DB_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/test";
    static final String DB_USER = "root";
    static final String DB_PASSWORD = "xander";

    public static void main(String[] args) throws SQLException {
        Connection connection = null;

        if (isDriverPresent()) return;
        System.out.println("MySQL JDBC Driver Registered!");

        try {
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console");
            e.printStackTrace();
            return;
        }

        checkForConnection(connection);
        WorkWithDatabase workWithDatabase = new WorkWithDatabase(connection);
        workWithDatabase.createTable();
      //  workWithDatabase.createAnotherTable();
    }

    private static boolean isDriverPresent() {
        try {
            Class.forName(DB_DRIVER);
        } catch (ClassNotFoundException e) {
            System.out.println("There is no MySQL JDBC Driver");
            e.printStackTrace();
            return true;
        }
        return false;
    }

    private static void checkForConnection(Connection connection) {
        if (connection != null) {
            System.out.println("You made it, take control over your database now!");
        } else {
            System.out.println("Failed to make connection!");
            return;
        }
    }
}