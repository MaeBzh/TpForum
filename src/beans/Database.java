package beans;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

public class Database {

    protected static Database instance;
    protected static final String DATABASE = "forum";
    protected static final String USERNAME = "root";
    protected static final String PASSWORD = "";

    Connection connection;

    protected Database() throws SQLException {
        String url = String.format("jdbc:mysql://localhost:3306/%s?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC", DATABASE);
        System.out.println(url);
        /* Chargement du driver JDBC pour MySQL */
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.connection = DriverManager.getConnection(url, USERNAME, PASSWORD);
        } catch (ClassNotFoundException e) {
            /* Gérer les éventuelles erreurs ici. */
        }

    }

    public static Database getInstance() throws SQLException {
        if (instance == null) {
            instance = new Database();
        }

        return instance;
    }

    public Connection getConnection() {
        return this.connection;
    }

    public void closeConnection() throws SQLException {
        this.connection.close();
    }
}
