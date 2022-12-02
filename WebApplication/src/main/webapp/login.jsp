<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="/includes/head.jsp"%>
        <title>Đăng nhập</title>
    </head>
    <body class="nen">
        
        <div class="container">
            <div class="card w-50 mx-auto my-5">
                <h1 class="card-header text-center">Đăng nhập</h1>
                <div class="card-body">
                    <form action="DangNhap" method="post">
                        <p class="text-success">${messuc}</p>
                        <p class="text-danger">${mess}</p>
                        <p class="text-danger">${mess1}</p>
                        <p class="text-danger">${mess2}</p>
                        <div class="form-group">
                            <label>Số tài khoản</label>
                            <input type="tel" name="SoTK" class="form-control" placeholder="Nhập số tài khoản" pattern="[0-9]{8}"
                                title="Số tài khoản phải đủ có 8 chữ số" value="${TaiKhoan}" />
                        </div>
                        <div class="form-group">
                            <label>Mật khẩu</label> 
                            <input type="password" name="Matkhau" class="form-control" placeholder="Mật khẩu" minlength="6" maxlength="6" title="Mẩu khẩu phải đúng 6 ký tự">
                        </div>
                        <div class="text-center">
                            <button type="submit" class="btn btn-primary">Đăng nhập</button>
                        </div>
                    </form>
                </div>
            </div>
            <p class="para-2">
                Bạn chưa có tài khoản? <a href="DangKy">Đăng ký tại đây</a>
            </p>
        </div>

        <%@include file="/includes/footer.jsp"%>
    </body>
</html>
