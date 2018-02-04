package sample;

import java.sql.*;
import java.util.Vector;

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

    public Vector<User> getUsers() throws SQLException {

        Vector<User> userVector = new Vector<User>();

        try{

            ResultSet users;
            this.connect();

            Statement insert = myConn.createStatement();

            users = insert.executeQuery(User.getAllUsers());

            while(users.next()){
                userVector.add(new User(
                        users.getString("voornaam"),
                        users.getString("achternaam"),
                        Integer.parseInt(users.getString("nummer")),
                        Integer.parseInt(users.getString("sjoelbak")),
                        Integer.parseInt(users.getString("tonspel")),
                        Integer.parseInt(users.getString("toptafel")),
                        Integer.parseInt(users.getString("rolbiljart")),
                        Integer.parseInt(users.getString("mannetjesspel"))
                ));
            }

            this.close();

        } catch (SQLException e){
            throw e;
        }

        return userVector;
    }

}
