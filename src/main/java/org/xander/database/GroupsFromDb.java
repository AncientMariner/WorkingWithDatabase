package org.xander.database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class GroupsFromDb {
    private Connection connection;
    String selectGroups = "SELECT name from groups";

    public GroupsFromDb(Connection connection) {
        this.connection = connection;
    }

    public ArrayList<String> getDataFromDb() throws SQLException {
        Statement statement = null;
        String selectTableSQL = selectGroups;
        ArrayList<String> groupsList = new ArrayList<String>();

        try {
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(selectTableSQL);

            while (rs.next()) {
                groupsList.add(rs.getString("name"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            if (statement != null)
                statement.close();
            if (connection != null)
                connection.close();
        }
        return groupsList;
    }
}

