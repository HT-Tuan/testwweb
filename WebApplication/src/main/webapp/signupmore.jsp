<%@page language="java" contentType="text/html" pageEncoding="UTF-8" %>
    <!DOCTYPE html>
    <html>

    <head>
        <%@include file="/includes/head.jsp" %>
            <title>Đăng ký tài khoản phụ</title>
    </head>

    <body class="nen">

        <div class="container">
            <div class="card w-50 mx-auto my-5">
                <h1 class="card-header text-center">Tạo tài khoản phụ</h1>
                <div class="card-body">
                    <form action="DangKyThem" method="post">
                        <p class="text-danger">${messerror}</p>
                        <div class="form-group">
                            <label>Số tài khoản</label>
                            <p class="text-danger">${error1}</p>
                            <input type="tel" name="SoTK" class="form-control" placeholder="Nhập số tài khoản"
                                pattern="[0-9]{8}" title="Số tài khoản phải đủ có 8 chữ số" required value="${taikhoan}" />
                        </div>
                        <div class="form-group">
                            <label>Mật khẩu</label>
                            <input type="password" name="Matkhau" class="form-control" placeholder="Mật khẩu"
                                minlength="6" maxlength="6" title="Mẩu khẩu phải đúng 6 ký tự" required>
                        </div>
                        <div class="form-group">
                            <label>Nhập lại mật khẩu</label>
                            <input type="password" name="Xacnhan" class="form-control" placeholder="Mật khẩu"
                                minlength="6" maxlength="6" title="Mẩu khẩu phải đúng 6 ký tự" required>
                        </div>
                        <div class="text-center">
                            <button type="submit" class="btn btn-primary">Đăng ký</button>
                        </div>
                    </form>
                </div>
                <p class="para-2">
                    Bằng cách nhấn vào nút đăng ký, bạn đã đồng ý với<br />
                    <a href="#">Điều khoản & điều kiện</a> và <a href="#">chính sách của chúng tôi</a>
                </p>
            </div>
            <p class="para-2">
                Bạn đã có tài khoản? <a href="DangNhap">Đăng nhập tại đây</a>
            </p>
        </div>

        <%@include file="/includes/footer.jsp" %>
    </body>

    </html>