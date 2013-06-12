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
        String createTableSQL = "CREATE TABLE GROUP("
                + "GROUP_ID INT NOT NULL,"
                + "GROUP_NAME VARCHAR(20),"
                + "PRIMARY KEY (GROUP_ID)"
                + ")";

        try {
            statement = connection.createStatement();
            statement.execute(createTableSQL);

            System.out.println("Table \"GROUP\" is created!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            if (statement != null)
                statement.close();
            if (connection != null)
                connection.close();
        }
    }

    public void createAnotherTable() throws SQLException {
        Statement statement = null;
        String createTableSQL = "DROP TABLE IF EXISTS PRODUCT;"
                + "CREATE TABLE PRODUCT("
                + "PRODUCT_ID INT(5) NOT NULL, "
                + "PRODUCT_NAME VARCHAR(20), "
                + "PRODUCT_DESCRIPTION VARCHAR(30), "
                + "CONSTRAINT FK_GROUP_ID FOREIGN KEY (GROUP_ID)" +
                  "REFERENCES GROUP (GROUP_ID) ON DELETE CASCADE ON UPDATE CASCADE,"
                + "PRIMARY KEY (PRODUCT_ID) "
                + ") ENGINE=InnoDB DEFAULT CHARSET=utf8";

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
