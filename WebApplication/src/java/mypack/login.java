/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mypack;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.*;
import javax.servlet.http.*;

/**
 *
 * @author huynh
 */
public class login extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html; charset= UTF-8");

        String name = request.getParameter("login-email");
        String password = request.getParameter("login-password");
        String status = null;
        HttpSession setssion = request.getSession();
        if (name.equals("nhom8@gmail.com") && password.equals("admin")) {
            setssion.setAttribute("username", name);
            setssion.setAttribute("trangthai", status);
            response.sendRedirect("index.jsp");
        } else {
            status = "1";
            setssion.setAttribute("trangthai", status);
            RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
            dispatcher.include(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
}
