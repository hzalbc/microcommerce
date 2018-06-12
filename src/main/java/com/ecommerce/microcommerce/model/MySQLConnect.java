package com.ecommerce.microcommerce.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnect {

    private String url = "jdbc:mysql://localhost/port/db";
    private String user = "";
    private String password = "";

    /**
     * Connect to the MySQL database
     *
     * @return a Connection object
     */
    public Connection Connect(String url, String usr, String pass) {
        this.url = url;
        this.user = usr;
        this.password = pass;
        Connection conn = null;

        try {
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the MySQL server successfully.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return conn;

    }

}