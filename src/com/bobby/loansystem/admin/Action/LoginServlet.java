package com.bobby.loansystem.admin.Action;

import com.bobby.loansystem.admin.Domain.User;
import com.bobby.loansystem.admin.Dao.IUserDAO;
import com.bobby.loansystem.admin.Dao.UserDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;

public class LoginServlet extends HttpServlet{
    //响应登录请求
    public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, java.io.IOException{
        response.setContentType("text/html;charset=UTF-8");
        String errMsg="";
        HttpSession session = request.getSession();
        PrintWriter out=response.getWriter();
        String password = request.getParameter("password").trim();
        String username = request.getParameter("username").trim();
        /*System.out.println("username = " + username);
        System.out.println("password = " + password);*/
        IUserDAO userDAO = new UserDAO();
        User user2 = null;

        //验证账号密码
        try{
            user2 = userDAO.find(username);
        }catch(Exception e) {
            e.printStackTrace();
        }

        if(!user2.getUsername().equals("")) {
            if(!user2.getPassword().equals(password)) {
                errMsg += "您的用户名和密码不匹配，请重新输入";
            }else {
                session.setAttribute("username", username);
                session.setAttribute("password", password);
                out.print("success");
            }
        }else {
            errMsg += "您的用户名不存在，请先注册";
        }

        //如果出错，显示错误信息
        if(!errMsg.equals("")) {
            out.print(errMsg);
        }
    }

    public void doGet(HttpServletRequest request,HttpServletResponse response) throws java.io.IOException,ServletException{
        doPost(request,response);
    }
}
