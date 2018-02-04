package sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

    private String url = "jdbc:mysql://localhost:3306/volkssporten";
    private String username = "rooot";
    private String password = "toor";

    public void connect() throws SQLException {
        Connection myConn = DriverManager.getConnection(url, username, password);
    }

}
