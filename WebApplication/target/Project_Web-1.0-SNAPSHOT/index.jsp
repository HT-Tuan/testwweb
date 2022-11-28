<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <head>
        <%@include file = "includes/head.jsp"%>
        <title> Trang chủ </title>

    </head>

    <body>

        <div class="hero_area">
            <div class="bg-box">
                <img src="https://lh3.googleusercontent.com/QkG_QcJAlGAbDg61bpwW4_Oy_jWd2YpBLlwJB6gVafLFAa4ei15oVTSkKHiaOPqmlG5zp01koKWKXdHBa32eO-LRE4bdaZ5d-Ecoy_DdVgG9mU6LPaYZcOHPMNCzILZs8k6Az-dS=w2400" alt="">
            </div>
            <!-- header section strats -->
            <header class="header_section">
                <div class="container">
                    <nav class="navbar navbar-expand-lg custom_nav-container ">
                        <a class="navbar-brand" href="index.jsp">
                             <div class="logo">
                                <img src="./images/logoMain.png" class="logo" alt="">
                                 </div>
                        </a>

                        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
                                aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                            <span class=""> </span>
                        </button>

                        <div class="collapse navbar-collapse" id="navbarSupportedContent">
                            <ul class="navbar-nav  mx-auto ">
                                <li class="nav-item active">
                                    <a class="nav-link" href="index.jsp">TRANG CHỦ <span class="sr-only">(current)</span> </a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" href="ThucDon">THỰC ĐƠN</a>
                                </li>
                                <li class="nav-item ">
                                    <a class="nav-link" href="about.jsp">VỀ CHÚNG TÔI  </a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" href="contact.jsp">LIÊN HỆ</a>
                                </li>
                            </ul>
                            <div class="user_option">
                                <button type="button" class="icon-button">
                                    <span class="material-symbols-outlined">
                                        shopping_bag
                                    </span>
                                    <span class="icon-button__badge">0</span>

                                </button>

                                <% if (session.getAttribute("username") == null) {%>
                                <a href="login.jsp" class="order_online"> Đăng nhập </a>
                                <% } else {%>
                                <a href="" class="order_online"> ${username} </a>
                                <%}%>

                            </div>
                        </div>
                    </nav>
                </div>
            </header>
            <!-- end header section -->
            <!-- slider section -->
            <section class="slider_section ">
                <div id="customCarousel1" class="carousel slide" data-ride="carousel">
                    <div class="carousel-inner">
                        <div class="carousel-item active">
                            <div class="container ">
                                <div class="row">
                                    <div class="col-md-7 col-lg-6 ">
                                        <div class="detail-box">
                                            <h1>
                                                Đậm Vị Thiên Nhiên
                                            </h1>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="carousel-item ">
                            <div class="container ">
                                <div class="row">
                                    <div class="col-md-7 col-lg-6 ">
                                        <div class="detail-box">
                                            <h1>
                                                Hạnh Phúc Trọn Đời
                                            </h1>
                                            <div class="btn-box">
                                                <a href="" class="btn1">
                                                    Đặt ngay bây giờ
                                                </a>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="carousel-item">
                            <div class="container ">
                                <div class="row">
                                    <div class="col-md-7 col-lg-6 ">
                                        <div class="detail-box">
                                            <h1>
                                                Day Dream
                                            </h1>
                                            <p>
                                                Với sứ mệnh mang đến niềm vui và hạnh phúc, Day Dream hy vọng sẽ tạo nên một
                                                nét văn hoá giải trí bên cạnh những ly trà sữa Ngon - Sạch - Tươi.
                                            </p>
                                            <div class="btn-box">
                                                <a href="" class="btn1">
                                                    Đặt ngay bây giờ
                                                </a>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="container">
                        <ol class="carousel-indicators">
                            <li data-target="#customCarousel1" data-slide-to="0" class="active"></li>
                            <li data-target="#customCarousel1" data-slide-to="1"></li>
                            <li data-target="#customCarousel1" data-slide-to="2"></li>
                        </ol>
                    </div>
                </div>

            </section>
            <!-- end slider section -->
        </div>


        <section class="food_section layout_padding-bottom">
            <div class="container">
                <div class="card-header my-3">
                    <h2>
                        CÁC SẢN PHẨM NỔI BẬT
                    </h2>
                </div>
                <div class="row">
                    <div class="col-md-3">
                        <div class="box">
                             <div class="img-box">
                                        <img src="https://lh3.googleusercontent.com/YrAPyPUrzhxeuKCVPqh_vmppi9AnPGJby-TewgLolDNCELbYxAOhoymgBUgrZd7tiIvh_zTCflUcFxVTC7mxNRTmzOOiHm9NWqleXeH8ifo9eJKmoluicB8YWfkZIp_YuQnng4a5=w2400"
                                             alt="">
                                    </div>
                            <div class="detail-box">
                                <h5 class="card-title">TRÀ HOA ĐẬU BIẾC</h5>
                                <h6 class="price">Giá: 25.000 vnđ </h6>
                                <h6 class="category">Loại đồ uống: Trà</h6>
                                <div class="mt-3 d-flex justify-content-between">
                                    <a href="#" class="btn btn-primary ">Thêm vào <br> giỏ hàng</a>
                                    <a href="#" class="btn btn-primary center">Mua ngay</a>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-3">
                        <div class="box">
                             <div class="img-box">
                                        <img src="https://lh3.googleusercontent.com/BA0Rx4n791g7PHNVoe4m1FzYmmncZ6eIQmpk1dPwE5ssZcs_a3VORzrqAZ4XVKDrzU0QgHoLj692bZyu8dCawCbnZxY8ASk9Goy0CNziaFDnZtuZeZrxZD8eAXUOC0jg8zITwZ7I=w2400"
                                             alt="">
                                    </div>
                            <div class="detail-box">
                                <h5 class="card-title">CÀ PHÊ SỮA</h5>
                                <h6 class="price">Giá: 25.000 vnđ</h6>
                                <h6 class="category">Loại đồ uống: Cafe</h6>
                                <div class="mt-3 d-flex justify-content-between">
                                    <a href="#" class="btn btn-primary ">Thêm vào <br> giỏ hàng</a>
                                    <a href="#" class="btn btn-primary center">Mua ngay</a>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-3">
                        <div class="box">
                             <div class="img-box">
                                        <img src="https://lh3.googleusercontent.com/SZGw-VuSHpw-NM5DSJVfIdORjhXYioRWbA7LgK_SzCrtYxw4iY8zF9PIRLqkGo9GwEROCbVLRBiPmpD3Q7ufTEuSkjCPIFrtNAlXn0EdW1rFszFotJP-KVsRLPtFlC3TcyPTviVf=w2400"
                                             alt="">
                                    </div>
                            <div class="detail-box">
                                <h5 class="card-title">TRÀ SỮA THÁI LAN</h5>
                                <h6 class="price">Giá: 25.000 vnđ</h6>
                                <h6 class="category">Loại đồ uống: Trà sữa</h6>
                                <div class="mt-3 d-flex justify-content-between">
                                    <a href="#" class="btn btn-primary ">Thêm vào <br> giỏ hàng</a>
                                    <a href="#" class="btn btn-primary center">Mua ngay</a>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-3">
                        <div class="box">
                             <div class="img-box">
                                       <img src="https://res.cloudinary.com/df3n1pqoz/image/upload/v1665977712/imageWebnuoc/cafe3_lrtfan_v4a2gq.png"
                                            alt="">
                                    </div>
                            <div class="detail-box">
                                <h5 class="card-title">SỮA TƯƠI CÀ PHÊ</h5>
                                <h6 class="price">Giá: 25.000 vnđ</h6>
                                <h6 class="category">Category: mot so sp</h6>
                                <div class="mt-3 d-flex justify-content-between">
                                    <a href="#" class="btn btn-primary ">Thêm vào <br> giỏ hàng</a>
                                    <a href="#" class="btn btn-primary center">Mua ngay</a>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="col-md-3">
                        <div class="box">
                             <div class="img-box">
                                        <img src="https://res.cloudinary.com/dlux9nebf/image/upload/v1665644756/Day%20dream/TRASUA2_mhcd4o.png"
                                             alt="">
                                    </div>
                            <div class="detail-box">
                                <h5 class="card-title">TRÀ SỮA XANH THÁI</h5>
                                <h6 class="price">Giá: 25.000 vnđ</h6>
                                <h6 class="category">Loại đồ uống: Trà sữa</h6>
                                <div class="mt-3 d-flex justify-content-between">
                                    <a href="#" class="btn btn-primary ">Thêm vào <br> giỏ hàng</a>
                                    <a href="#" class="btn btn-primary center">Mua ngay</a>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-3">
                        <div class="box">
                             <div class="img-box">
                                        <img src="https://lh3.googleusercontent.com/r5rU4RF1xr7olYz98rpXOKLWdxhal8FFFQQoHA9sQ4HIf31I-kJ-Kd5nKe36oUQN6GTtWaP6IoIg5rSqCIF_vJPPhzsRcde__XuLxijoIhch-kydNvwtSTxQDw1l16Gu0hhNiygp=w2400"
                                             alt="">
                                    </div>
                            <div class="detail-box">
                                <h5 class="card-title">TRÀ SỮA KHOAI MÔN</h5>
                                <h6 class="price">Giá: 30.000 vnđ</h6>
                                <h6 class="category">Loại đồ uống: Trà sữa</h6>
                                <div class="mt-3 d-flex justify-content-between">
                                    <a href="#" class="btn btn-primary ">Thêm vào <br> giỏ hàng</a>
                                    <a href="#" class="btn btn-primary center">Mua ngay</a>
                                </div>
                            </div>
                        </div>
                    </div>

                </div>


        </section>
        <!-- SP BEST -->
        <section class="food_section layout_padding-bottom">
            <div class="container">
                <div class="card-header my-3">
                    <h2>
                        CÁC SẢN PHẨM BÁN CHẠY NHẤT
                    </h2>
                </div>
                <div class="row">
                    <div class="col-md-3">
                        <div class="box">
                             <div class="img-box">
                                        <img src="https://res.cloudinary.com/df3n1pqoz/image/upload/v1665977431/imageWebnuoc/anh9_mrqj8c.jpg"
                                             alt="">
                                    </div>
                            <div class="detail-box">
                                <h5 class="card-title">TRÀ CHANH MẬT</h5>
                                <h6 class="price">Giá: 30.000 vnđ</h6>
                                <h6 class="category">Loại đồ uống: Trà</h6>
                                <div class="mt-3 d-flex justify-content-between">
                                    <a href="#" class="btn btn-primary ">Thêm vào <br> giỏ hàng</a>
                                    <a href="#" class="btn btn-primary center">Mua ngay</a>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-3">
                        <div class="box">
                             <div class="img-box">
                                        <img src="https://res.cloudinary.com/dlux9nebf/image/upload/v1665640120/Day%20dream/TRASUA3_fex7qo.jpg"
                                             alt="">
                                    </div>
                            <div class="detail-box">
                                <h5 class="card-title">TRÀ ĐÀO</h5>
                                <h6 class="price">Giá: 25.000 vnđ</h6>
                                <h6 class="category">Loại đồ uống: Trà</h6>
                                <div class="mt-3 d-flex justify-content-between">
                                    <a href="#" class="btn btn-primary ">Thêm vào <br> giỏ hàng</a>
                                    <a href="#" class="btn btn-primary center">Mua ngay</a>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-3">
                        <div class="box">
                             <div class="img-box">
                                        <img src="https://lh3.googleusercontent.com/taN14P-oMdQIDcHrdAD4ku3X5sAYPnJ-0O-Uq7unBDIpIOMZhf1n54vbjqZnFdMeVI0VhGKv4WIWVRm2aOYl3RWLOUdb7hwuJr8wwlMMbV6QF300JQOFqcz-KAH0KtAmb2TgAzN6=w2400"
                                             alt="">
                                    </div>
                            <div class="detail-box">
                                <h5 class="card-title">TRÀ SEN</h5>
                                <h6 class="price">Giá: 25.000 vnđ</h6>
                                <h6 class="category">Loại đồ uống: Trà</h6>
                                <div class="mt-3 d-flex justify-content-between">
                                    <a href="#" class="btn btn-primary ">Thêm vào <br> giỏ hàng</a>
                                    <a href="#" class="btn btn-primary center">Mua ngay</a>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-3">
                        <div class="box">
                             <div class="img-box">
                                        <img src="https://lh3.googleusercontent.com/QKZvDUIpYTu3NBz1M6Fd9EV1ZBCoL29eKR7neu3Ya1BEs7_ApTOoT8XdaRLdXy5Bf-JGAAwtW-p_qOFY9exDcC-UmWH7ssRzhYYY453C7iv3O6-qKPIR4aR0x7RASxGeAsEqb7YY=w2400"
                                             alt="">
                                    </div>
                            <div class="detail-box">
                                <h5 class="card-title">CÀ PHÊ LATTE</h5>
                                <h6 class="price">Giá: 25.000 vnđ</h6>
                                <h6 class="category">Loại đồ uống: Cafe</h6>
                                <div class="mt-3 d-flex justify-content-between">
                                    <a href="#" class="btn btn-primary ">Thêm vào <br> giỏ hàng</a>
                                    <a href="#" class="btn btn-primary center ">Mua ngay</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
        </section>
        <!-- KET THUC SP BEST -->
        <!-- about section -->

        <section class="about_section layout_padding nenA">
            <div class="container  ">

                <div class="row">
                    <div class="col-md-6 ">
                        <div class="img-box">
                            <img src="images/tra-sua.jpg" alt="">
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="detail-box">
                            <div class="heading_container">
                                <h2>
                                    Về chúng tôi
                                </h2>
                            </div>
                            <p>
                                Bên cạnh niềm tự hào về những ly trà sửa ngon - sạch -tươi, chúng tôi luôn
                                tự tin mang đến cho khách hàng những trãi nghiệm tốt nhất về dịch vụ và không gian.
                            </p>
                            <a href="readmore.jsp">
                                Đọc thêm
                            </a>
                        </div>
                    </div>
                </div>
            </div>
        </section>

        <!-- end about section -->

        <!-- footer -->
        <%@include file="includes/footer.jsp" %>
    </body>

</html>