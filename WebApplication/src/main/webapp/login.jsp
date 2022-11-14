<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="/includes/head.jsp"%>
        <title>Đăng nhập</title>
    </head>
    <body class="nen">
        <% if(session.getAttribute("trangthai") != null) {%>      
        <p class="alert-warning chudo ">Đăng Nhập Không Thành Công !!! Nhập lại</p>
        <%}%>
        <div class="container">
            <div class="card w-50 mx-auto my-5">
                <div class="card-header text-center">Đăng nhập</div>
                <div class="card-body">
                    <form action="DangNhap" method="post">
                        <div class="form-group">
                            <label>Địa chỉ Email</label> 
                            <input type="email" name="login-email" class="form-control" placeholder="Địa chỉ email">
                        </div>
                        <div class="form-group">
                            <label>Mật khẩu</label> 
                            <input type="password" name="login-password" class="form-control" placeholder="Mật khẩu">
                        </div>
                        <div class="text-center">
                            <button type="submit" class="btn btn-primary">Đăng nhập</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>

        <%@include file="/includes/footer.jsp"%>
    </body>
</html>