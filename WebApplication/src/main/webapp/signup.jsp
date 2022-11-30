<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="/includes/head.jsp"%>
        <title>Đăng nhập</title>
    </head>
    <body class="nen">
        <% if (session.getAttribute("trangthai") != null) {%>      
        <p class="alert-warning chudo ">Đăng Nhập Không Thành Công !!! Nhập lại</p>
        <%}%>
        <div class="container">
            <div class="card w-50 mx-auto my-5">
                <h1 class="card-header text-center">Tạo tài khoản</h1>
                <div class="card-body">
                    <form action="DangKy" method="post">
                        <div class="form-group">
                            <label>Họ</label>
                            <input type="text" class="form-control" placeholder="" />
                        </div>
                        <div class="form-group">
                            <label>Tên</label>
                            <input type="text" class="form-control" placeholder="" />
                        </div>
                        <div class="form-group">
                            <label>Email</label>
                            <input type="email" class="form-control" placeholder="" />
                        </div>
                        <div class="form-group">
                            <label>Mật khẩu</label>
                            <input type="password" class="form-control" placeholder="" />
                        </div>
                        <div class="form-group">
                            <label>Nhập lại mật khẩu</label>
                            <input type="password" class="form-control" placeholder="" />
                        </div>
                        <div class="text-center">
                            <button type="submit" class="btn btn-primary">Đăng ký</button>
                        </div>
                    </form>
                </div>
                <p class="text-center">
                    Bằng cách nhấn vào nút đăng ký, bạn đã đồng ý với<br />
                    <a href="#">Điều khoản & điều kiện</a> và <a href="#">chính sách của chúng tôi</a>
                </p>
            </div>
        </div>

        <%@include file="/includes/footer.jsp"%>
    </body>
</html>