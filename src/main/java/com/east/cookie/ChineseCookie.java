package com.east.cookie;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.Base64;

@WebServlet(urlPatterns = "/chineseCookie")
public class ChineseCookie extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
//        String 中文 = URLEncoder.encode("中文");
        String username = URLEncoder.encode("姓名");
        Cookie cookie = new Cookie(username, "小明");
        response.addCookie(cookie);
        PrintWriter writer = response.getWriter();
        writer.print("Cookie写入完成");
        writer.flush();
        writer.close();
    }
}
