package org.xander.database;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DataFromDb {
    private Connection connection;

    String createTable = "CREATE TABLE groups (id INT AUTO INCREMENT, " +
                                                    "name VARCHAR(20), PRIMARY KEY (id)) " +
                                                    "ENGINE=InnoDB DEFAULT CHARSET=utf8";
    String createAnotherTable = "CREATE TABLE products(id INT(5) AUTO_INCREMENT, " +
                                                    "name VARCHAR(20), " +
                                                    "description VARCHAR(30), " +
                                                    "groups_id INT, " +
                                                    "PRIMARY KEY (id)," +
                                                    "FOREIGN KEY (groups_id) REFERENCES groups(id) ON DELETE CASCADE ON UPDATE CASCADE)" +
                                                    "ENGINE=InnoDB DEFAULT CHARSET=utf8;";

    String insertIntoGroups1 = "INSERT INTO groups (name) VALUES ('PC');";
    String insertIntoGroups2 = "INSERT INTO groups (name) VALUES ('HDD');";
    String insertIntoGroups3 = "INSERT INTO groups (name) VALUES ('Monitor');";

    String insertIntoProducts1 = "INSERT INTO products (name, description, groups_id) VALUES ('Macintosh', 'expensive', 1);";
    String insertIntoProducts11 = "INSERT INTO products (name, description, groups_id) VALUES ('Dell', 'powerful', 1);";

    String insertIntoProducts2 = "INSERT INTO products (name, description, groups_id) VALUES ('WD', 'medium and powerful', 2);";
    String insertIntoProducts22 = "INSERT INTO products (name, description, groups_id) VALUES ('SeaGate', 'powerful', 2);";

    String insertIntoProducts3 = "INSERT INTO products (name, description, groups_id) VALUES ('LG', 'brilliant', 3);";
    String insertIntoProducts33 = "INSERT INTO products (name, description, groups_id) VALUES ('Samsung', 'good', 3);";

    String selectingQuery = "select p.name from products p join groups g on g.id = p.groups_id where g.id = 2;";

    public DataFromDb(Connection connection) {
        this.connection = connection;
    }

    public void executeQuery() throws SQLException {
        Statement statement = null;
        try {
            statement = connection.createStatement();
            statement.execute(insertIntoProducts33);
            System.out.println("Query was executed");
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
