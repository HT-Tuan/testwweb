package com.DayDream.controller;

import java.io.IOException;
import java.security.MessageDigest;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.bind.DatatypeConverter;

import com.DayDream.model.dao.AccountDao;
import com.DayDream.model.entity.Account;
import com.DayDream.model.entity.Customer;

@WebServlet(urlPatterns = { "/DangKyThem" })
public class SignUpMore extends HttpServlet {
    private AccountDao accountDao = new AccountDao();
    private Account acc = new Account();
    private mailxn send = new mailxn();

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String sotk = req.getParameter("SoTK");
        String pass = req.getParameter("Matkhau");
        String xacnhan = req.getParameter("Xacnhan");

        if (sotk == null || pass == null || xacnhan == null) {
            resp.sendRedirect("/Project_Web/signupmore.jsp");
            return;
        }

        if (sotk.length() != 0 && pass.length() != 0 && xacnhan.length() != 0) {

            req.setAttribute("taikhoan", sotk);
            List<Account> account = accountDao.FindByID(sotk);
            if (account == null) {
                resp.sendRedirect("/Project_Web/handle_error");
                return;
            }
            if (account.isEmpty() == false) {
                req.setAttribute("error1", "Số tài khoản này không có sẵn");
                req.getRequestDispatcher("signupmore.jsp").forward(req, resp);
                return;
            }

            if (!pass.equals(xacnhan)) {
                req.setAttribute("messerror", "Mật khẩu không trùng khớp");
                req.getRequestDispatcher("signupmore.jsp").forward(req, resp);
                return;
            }

            acc.setAccountID(sotk);
            //
            try {
                MessageDigest md = MessageDigest.getInstance("MD5");
                byte[] digest = md.digest(pass.getBytes());
                pass = DatatypeConverter.printHexBinary(digest).toUpperCase();
            } catch (Exception e) {
                System.out.println(e);
            }
            //
            acc.setPassWord(pass);
            HttpSession session = req.getSession();
            Customer cus =(Customer)session.getAttribute("cus");
            String email = cus.getEmail();
            String hoten = cus.getFullName();
            String number = send.getRandom();
            if (send.sendEmail(email, number, hoten) == false) {
                resp.sendRedirect("/Project_Web/handle_error");
                return;
            }
            acc.setCustomer(cus);
            session.setAttribute("acc", acc);
            session.setAttribute("codenumber", number);
            session.setAttribute("email", cus.getEmail());
            resp.sendRedirect("/Project_Web/chungthuc.jsp");
        } else {
            if (sotk.length() != 0) {
                req.setAttribute("taikhoan", sotk);
            }
            req.getRequestDispatcher("signupmore.jsp").forward(req, resp);
        }
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
