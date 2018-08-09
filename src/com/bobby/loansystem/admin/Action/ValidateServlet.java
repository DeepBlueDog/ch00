package com.bobby.loansystem.admin.Action;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;

public class ValidateServlet  extends HttpServlet {
    //响应验证请求
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, java.io.IOException{
        response.setContentType("text/html;charset=UTF-8");
        String errMsg="";
        HttpSession session = request.getSession();
        PrintWriter out=response.getWriter();
        String input_password = request.getParameter("search").trim();

        if(input_password.equals(((String)session.getAttribute("password")))) {
            out.print("success");
        }
    }
}
