package com.blb.Servlet;

import com.blb.jdbc.jdbcTest;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/add")
public class AddServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        String username = req.getParameter("username");
        String password=req.getParameter("password");
        int age;
        if (req.getParameter("age")==null) {
            age = Integer.parseInt(req.getParameter("age"));
        }else {
            age=0;
        }


        jdbcTest jdbctest=new jdbcTest();
        jdbctest.add(username,password,age);
        req.getRequestDispatcher("UserList").forward(req,resp);
    }
}
