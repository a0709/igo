package com.blb.Servlet;
import com.blb.jdbc.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id=Long.valueOf(req.getParameter("id"));
        jdbcTest jdbcTest=new jdbcTest();
        try {
            jdbcTest.delete(id);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        req.getRequestDispatcher("UserList").forward(req,resp);
    }
}
