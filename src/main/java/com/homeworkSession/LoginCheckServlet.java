package com.homeworkSession;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import javax.imageio.plugins.tiff.TIFFDirectory;
import java.io.IOException;
@WebServlet(urlPatterns = "/loginCheckServlet")
public class LoginCheckServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if ("123456".equals(password)&&username!=null){
            HttpSession session = request.getSession();
            session.setAttribute("username",username);
            session.setAttribute("password",password);
            response.sendRedirect(request.getContextPath()+"/manageServlet");
        }else {
            response.sendRedirect(request.getContextPath()+"/error.html");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
