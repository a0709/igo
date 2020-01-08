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

@WebServlet("/FindOne")
public class FindOneServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) {
        Long id= Long.valueOf(req.getParameter("id"));
        jdbcTest jdbcTest=new jdbcTest();
        try {
            User user=jdbcTest.foundoneById(id);
            req.setAttribute("user",user);
            req.getRequestDispatcher("update.jsp").forward(req,resp);
        } catch (SQLException | ClassNotFoundException | ServletException | IOException e) {
            e.printStackTrace();
            System.out.println("修改失败！");
        }
    }
}
