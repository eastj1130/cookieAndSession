package com.east.cookie;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/aaa/setCookieAge")
public class SetCookieAge extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        Cookie username = new Cookie("username", "jd");
        Cookie password = new Cookie("password", "123456");
        username.setPath("/cs/aaa");
        response.addCookie(username);
        response.addCookie(password);
        PrintWriter writer = response.getWriter();
        writer.print("<h1>Cookie写入成功</h1>");
        writer.flush();
        writer.close();
    }
}
