package org.xander.database;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class WorkWithDatabase {
    private Connection connection;

    public WorkWithDatabase(Connection connection) {
        this.connection = connection;
    }

    public void createTable() throws SQLException {
        Statement statement = null;
        String createTableSQL = "CREATE TABLE PRODUCT("
                + "PRODUCT_ID INT(5) NOT NULL, "
                + "PRODUCT_NAME VARCHAR(20), "
                + "PRIMARY KEY (PRODUCT_ID) "
                + ")";

        try {
            statement = connection.createStatement();
            statement.execute(createTableSQL);

            System.out.println("Table \"Product\" is created!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            if (statement != null)
                statement.close();
            if (connection != null)
                connection.close();
        }
    }
}
