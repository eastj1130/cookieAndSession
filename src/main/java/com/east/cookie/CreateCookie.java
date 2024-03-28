package com.east.cookie;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet(urlPatterns = "/createCookie")
public class CreateCookie extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Cookie username = new Cookie("username", "jack");
        username.setMaxAge(20);
        Cookie password = new Cookie("password", "123456");
        response.addCookie(username);
        response.addCookie(password);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
