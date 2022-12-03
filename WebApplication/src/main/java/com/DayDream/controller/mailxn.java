package com.DayDream.controller;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
import java.util.Random;

public class mailxn {
    // tao so ngau nhien
    public String getRandom() {
        Random rnd = new Random();
        int number = rnd.nextInt(999999);
        return String.format("%06d", number);
    }

    // Gui email
    public boolean sendEmail(String toEmail, String codext, String nameKH) {

        boolean status = false;

        final String username = "laptrinhwinform2@gmail.com";
        final String password = "lasznhffgywdikzt";

        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });
        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(toEmail));
            message.setSubject("Mã xác minh DayDream");
            String htmlContent = "<h4>Cảm ơn" + nameKH + " đã đăng ký tại khoản tại DayDream</h4>" +
                    "<span>Đây là mã xác thực của bạn:</span>" +
                    "<h1 style=\"color: rgb(255, 0, 0); font-family: Helvetica\">" + codext + "</h1>";
            message.setContent(htmlContent, "text/html; charset=UTF-8");
            Transport.send(message);
            status = true;
        } catch (MessagingException ex) {
            ex.printStackTrace();
        }

        return status;
    }
}
