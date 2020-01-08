package com.blb.Servlet;

import com.blb.User;
import com.blb.jdbc.jdbcTest;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/UserList")
public class UserListServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        //查询数据库，显示所有用户
        jdbcTest jdbc = new jdbcTest();
        List<User> userList=jdbc.foundAll();
        req.setAttribute("list",userList);
        req.getRequestDispatcher("success.jsp").forward(req, resp);
    }
}
