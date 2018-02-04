package sample;

import java.sql.*;

public class Database {

    private String url = "jdbc:mysql://localhost:3306/volkssporten";
    private String username = "root";
    private String password = "toor";

    Connection myConn;

    private void connect() throws SQLException {
        myConn = DriverManager.getConnection(url, username, password);
    }

    private void close() throws SQLException {
        myConn.close();
    }

    public void insertScore(User user) throws SQLException{

        try{

            this.connect();

            Statement insert = myConn.createStatement();

            insert.executeUpdate(user.getInsertStatementSql());

            this.close();

        } catch (SQLException e){
            throw e;
        }

    }

}
