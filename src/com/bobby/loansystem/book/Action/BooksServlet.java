package com.bobby.loansystem.book.Action;

import com.bobby.loansystem.db.DBHelper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BooksServlet extends HttpServlet{
    //响应登录请求
    public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, java.io.IOException{
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        String errMsg = "";
        PrintWriter out = response.getWriter();
        System.out.println("插入成功！1");
        String bookname = request.getParameter("bookname").trim();
        String booknumber = request.getParameter("booknumber").trim();
        String author1 = request.getParameter("author1").trim();
        String author2 = request.getParameter("author2").trim();
        String translator1 = request.getParameter("translator1").trim();
        String translator2 = request.getParameter("translator2").trim();
        String publishor = request.getParameter("publishor").trim();
        String language = request.getParameter("language").trim();
        String price = request.getParameter("price").trim();
        String quantity = request.getParameter("quantity").trim();
        String abstractText = request.getParameter("abstractText").trim();
        String author = author1 + "/" +author2;
        String translator = translator1 + "/" + translator2;
        String insert_sql = "insert into book(booknumber, bookname, author, translator, quantity, publishor " + "," +
                "language, price, onnumber, abstract) values(?,?,?,?,?,?,?,?,?,?)" ;
        try {
            System.out.println("插入成功！2");
            DBHelper db = new DBHelper(insert_sql);
            PreparedStatement pstmt = db.getPstmt();
            System.out.println("插入成功3！");
            pstmt.setString(1, booknumber);
            pstmt.setString(2, bookname);
            pstmt.setString(3, author);
            pstmt.setString(4, translator);
            pstmt.setInt(5, Integer.parseInt(quantity));
            pstmt.setString(6, publishor);
            pstmt.setString(7, language);
            pstmt.setDouble(8, Double.parseDouble(price));
            pstmt.setInt(9, Integer.parseInt(quantity));
            pstmt.setString(10, abstractText);
            System.out.println("插入成功！4");
            pstmt.executeUpdate();
            System.out.println("插入成功！");
            pstmt.close();
            out.print("success");
        }catch(SQLException e) {
            //如果出错，显示错误信息
            errMsg += "无法插入成功！";
            out.print(errMsg);
            System.out.println("插入错误！");
            e.printStackTrace();
        }

    }

    public void doGet(HttpServletRequest request,HttpServletResponse response) throws java.io.IOException,ServletException{
        doPost(request,response);
    }
}

