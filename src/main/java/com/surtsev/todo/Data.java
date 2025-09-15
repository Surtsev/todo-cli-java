package com.surtsev.todo;

import java.sql.*;

public class Data {

    private Connection conn;

    public Data(String url, String db, String usr) {
        // "jdbc:postgresql://localhost:5432/"
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url + db, usr, "");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
