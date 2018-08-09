package com.bobby.loansystem.admin.Dao;

import com.bobby.loansystem.admin.Domain.User;
import com.bobby.loansystem.db.DBHelper;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO implements IUserDAO{
    private static final String FIELDS_INSERT = "username,password";
    private static final String INSERT_SQL = "insert into Administrator(" + FIELDS_INSERT + ")" + "values(?,?)";
    private static final String SELECT_SQL = "select " + FIELDS_INSERT + " from Administrator where username=?";
    private static final String UPDATE_SQL = "update Administrator set " + "password=? where username=?";
    private static final String DELETE_SQL = "delete from Administrator where username=?";

    @Override
    public User find(String username) {
        DBHelper db = new DBHelper(SELECT_SQL);
        PreparedStatement pstmt = db.getPstmt();
        ResultSet rst;
        User user2 = null;
        try{
            pstmt.setString(1, username);
            rst = pstmt.executeQuery();
            if (rst.next()) {
                user2 = new User();
                user2.setUsername(rst.getString(1));
                user2.setPassword(rst.getString(2));
            }else{
                user2=new User();
                user2.setUsername("");
                user2.setPassword("");
            }
            db.close();
        }catch(SQLException e) {
            e.printStackTrace();
        }
        return user2;
    }

    @Override
    public void update(User user){
        try {
            DBHelper db = new DBHelper(UPDATE_SQL);
            PreparedStatement pstmt = db.getPstmt();
            pstmt.setString(1, user.getUsername());
            pstmt.setString(2,user.getPassword());
            int rowConut = pstmt.executeUpdate();
            if(rowConut == 0) {
                throw new Exception("Update Error:Student Id:"+user.getUsername());
            }
            db.close();
        }catch(Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void remove(User user) {
        try {
            DBHelper db = new DBHelper(DELETE_SQL);
            PreparedStatement pstmt = db.getPstmt();
            pstmt.setString(1, user.getUsername());
            pstmt.executeUpdate();
            db.close();
        }catch(Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void create(User user) throws SQLException {
        DBHelper db = new DBHelper(INSERT_SQL);
        PreparedStatement pstmt = db.getPstmt();
        pstmt.setString(1, user.getUsername());
        pstmt.setString(2, user.getPassword());
        pstmt.executeUpdate();
        db.close();
    }

}
