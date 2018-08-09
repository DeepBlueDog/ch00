package com.bobby.loansystem.book.Action;

import com.bobby.loansystem.book.Domain.Book;
import com.bobby.loansystem.db.DBHelper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class BookSearchServlet extends HttpServlet {
    //响应登录请求
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, java.io.IOException{
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        String booknumber = request.getParameter("search");
        String search_SQL = "select *from book where booknumber=?";
        DBHelper db = new DBHelper(search_SQL);
        PreparedStatement pstmt = db.getPstmt();
        ResultSet rst;
        Book book = new Book();
        try{
            pstmt.setString(1, booknumber);
            rst = pstmt.executeQuery();
            if(rst.next()) {
                book.setBooknumber(rst.getString(1));
                book.setAuthor(rst.getString(2));
                book.setTranslator(rst.getString(3));
                book.setQuantity(rst.getInt(4));
                book.setPublishor(rst.getString(5));
                book.setLanuage(rst.getString(6));
                book.setOnnumber(rst.getInt(7));
                book.setPrice(rst.getDouble(8));
                book.setAbstractText(rst.getString(9));
                book.setBookname(rst.getString(10));
            }
            db.close();
        }catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public void doGet(HttpServletRequest request,HttpServletResponse response) throws java.io.IOException,ServletException{
        doPost(request,response);
    }
}

