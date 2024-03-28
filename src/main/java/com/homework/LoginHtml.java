package com.homework;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/loginHtml")
public class LoginHtml extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();
        Cookie[] cookies = request.getCookies();
        String pwd = CookieUtils.getValueByName(cookies, "hspedu");
        if (pwd!=null&"123456".equals(pwd)){
            writer.print("<h1>登录页面</h1></br>");
            writer.print("<form action=\"loginServlet\" method=\"post\">");
            writer.print("用户名：<input type=\"text\" name=\"usr\" value=\"hspedu\"><br>\n");
            writer.print("密码：<input type=\"text\" name=\"pwd\" value=\"123456\"><br>\n");
            writer.print("<input type=\"submit\" value=\"登陆\">\n");
            writer.print("</form>");
            System.out.println("走缓存");
        }else {
            writer.print("<h1>登录页面</h1></br>");
            writer.print("<form action=\"loginServlet\" method=\"post\">");
            writer.print("用户名：<input type=\"text\" name=\"usr\"><br>\n");
            writer.print("密码：<input type=\"text\" name=\"pwd\"><br>\n");
            writer.print("<input type=\"submit\" value=\"登陆\">\n");
            writer.print("</form>");
        }



    }
}
