package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectionUtil {

    // Private static variable to hold the single instance of the class
    private static Connection connection;

    // Private constructor to prevent instantiation from outside
    private DBConnectionUtil(){

    }

    // Public static method to return the single instance of the class
    public static Connection getDBConnection() throws ClassNotFoundException, SQLException {

        try {
            if(connection == null || connection.isClosed()) {

                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/vrs?useSSL=false","root","105680");

            }
        }
        catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return connection;
    }

}
