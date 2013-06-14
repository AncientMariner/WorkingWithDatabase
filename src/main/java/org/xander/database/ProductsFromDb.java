package org.xander.database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ProductsFromDb {
    private Connection connection;
    String selectGroups = "SELECT name from products";

    public ProductsFromDb(Connection connection) {
        this.connection = connection;
    }

    public ArrayList<String> getDataFromDb() throws SQLException {
        Statement statement = null;
        String selectTableSQL = selectGroups;
        ArrayList<String> productList = new ArrayList<String>();

        try {
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(selectTableSQL);

            while (rs.next()) {
                productList.add(rs.getString("name"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            if (statement != null)
                statement.close();
            if (connection != null)
                connection.close();
        }
        return productList;
    }
}

