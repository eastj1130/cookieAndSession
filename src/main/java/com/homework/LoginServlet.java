package com.homework;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
@WebServlet(urlPatterns = "/loginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();
        String usr = request.getParameter("usr");
        String pwd = request.getParameter("pwd");
        if ("hspedu".equals(usr)&&"123456".equals(pwd)){
            Cookie[] cookies = request.getCookies();
            if (CookieUtils.getValueByName(cookies,"hspedu")==null){
                Cookie cookie = new Cookie("hspedu", pwd);
                cookie.setMaxAge(60*60*24*3);
                response.addCookie(cookie);
            }
            writer.print("<h1>登陆成功</h1>");
        }else {
            writer.print("<h1>登陆失败</h1>");
        }
        writer.flush();
        writer.close();
    }
}
