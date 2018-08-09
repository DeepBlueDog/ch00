package com.bobby.loansystem.db;

import java.sql.*;

public class DBHelper {
    private Connection conn = null;
    private PreparedStatement pstmt = null;
    private static final String driver = "oracle.jdbc.driver.OracleDriver";
    private static final String url = "jdbc:oracle:thin:@127.0.0.1:1521:booksales";
    private static final String username = "bobby";
    private static final String password = "human";

    public DBHelper(String sql) {
        try{
            Class.forName(driver);
            conn = DriverManager.getConnection(url, username, password);
            pstmt = conn.prepareStatement(sql);
        }catch(Exception e) {
            e.printStackTrace();
        }
    }

    public PreparedStatement getPstmt() {
        return pstmt;
    }

    public void close() {
        try{
            this.pstmt.close();
            this.conn.close();
        }catch(SQLException e) {
            e.printStackTrace();
        }
    }

}
