package com.blb.Servlet;

import com.blb.User;
import com.blb.jdbc.jdbcTest;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
    /*    System.out.println("login!");
        System.out.println(req.getParameter("username"));
        System.out.println(req.getParameter("password"));
        if(req.getParameter("username").equals("root")&&req.getParameter("password").equals("root")) {
            req.getRequestDispatcher("success.jsp").forward(req, resp);
        }else {
            req.getRequestDispatcher("fail.jsp").forward(req,resp);
        }*/

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        jdbcTest jdbcTest = new jdbcTest();
        try {
            String msg = "";
            User user = null;
            try {
                user = jdbcTest.foundone(username);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            if (user == null) {
                System.out.println("用户不存在");
                msg = "用户不存在";
                req.setAttribute("msg", msg);
                req.getRequestDispatcher("fail.jsp").forward(req, resp);
            } else {

                if (password.equals(user.getPassword())) {
                    System.out.println("欢迎您登录");
                    req.getRequestDispatcher("UserList").forward(req, resp);
                } else {
                    System.out.println("密码错误哦");
                    msg = "密码错误哦";
                    req.setAttribute("msg", msg);
                    req.getRequestDispatcher("fail.jsp").forward(req, resp);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    }
