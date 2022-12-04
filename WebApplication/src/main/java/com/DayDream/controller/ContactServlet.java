/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.DayDream.controller;

import com.DayDream.model.dao.CustomerDao;
import com.DayDream.model.entity.Customer;
import com.DayDream.utils.EmailUtils;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet ("/Contact")
public class ContactServlet extends HttpServlet { 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {             
        request.setCharacterEncoding("UTF-8");
    	response.setContentType("text/html;charset=UTF-8");
    	response.setCharacterEncoding("utf-8");
        
        String subject = "Response of customer from DayDream Website";
        String managerEmail = "phanhongson234@gmail.com";
        HttpSession session = request.getSession();
        
        String fullName = request.getParameter("fullName");
        String email = request.getParameter("email");
        String reply = request.getParameter("reply");
        
        String codeHtml = "<html>\n"
                    + "  <head>\n"
                    + "    <style>\n"
                    + "      .colored {\n"
                    + "        color: blue;\n"
                    + "      }\n"
                    + "      #body {\n"
                    + "        font-size: 14px;\n"
                    + "      }\n"
                    + "    </style>\n"
                    + "  </head>\n"
                    + "  <body>\n"
                    + "    <div id='body'>\n"
                    + "      <p>Hệ thống Day Dream gửi thông tin phản hồi và yêu cầu của Khách Hàng với dịch vụ website</p>\n\n\n"
                    + "      <p>Tên Khách Hàng: " + fullName + "</p>\n"
                    + "      <p>Email:  " + email + "</p>\n"
                    + "      <p class='colored'>" + "Nội dung phản hồi/yêu cầu: " + reply + "</p>\n"
                    + "      <p>DayDream</p>\n"
                    + "    </div>\n"
                    + "  </body>\n"
                    + "</html>";     
             
        
        if (EmailUtils.sendEmail(managerEmail, subject, codeHtml)) {
            response.sendRedirect("announce_contact.jsp");
        }
        else {
            response.sendRedirect("handle_error.jsp");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        doPost(request, response);
    }      
}
