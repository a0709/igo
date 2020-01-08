package com.blb.Servlet;
import com.blb.jdbc.jdbcTest;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Update")
public class UpdateServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        Long id= Long.valueOf(req.getParameter("id"));
        String username=req.getParameter("username");
        String password=req.getParameter("password");
        int age;
        if (req.getParameter("age")==null) {
            age=0;
        }else {
            age = Integer.parseInt(req.getParameter("age"));
        }
        //更新数据库
        jdbcTest jdbc = new jdbcTest();
        jdbc.update(id,username,password,age);
        req.getRequestDispatcher("/UserList").forward(req, resp);
}
}