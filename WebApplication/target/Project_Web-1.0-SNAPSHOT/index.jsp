<%@page language="java" contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
    <!DOCTYPE html>
    <html>

    <head>
        <%@include file="includes/head.jsp" %>
            <title> Trang chủ </title>

    </head>

    <body>

        <div class="hero_area">
            <div class="bg-box">
                <img src="https://lh3.googleusercontent.com/QkG_QcJAlGAbDg61bpwW4_Oy_jWd2YpBLlwJB6gVafLFAa4ei15oVTSkKHiaOPqmlG5zp01koKWKXdHBa32eO-LRE4bdaZ5d-Ecoy_DdVgG9mU6LPaYZcOHPMNCzILZs8k6Az-dS=w2400"
                    alt="">
            </div>
            <!-- header section strats -->
            <header class="header_section">
                <div class="container">
                    <nav class="navbar navbar-expand-lg custom_nav-container ">
                        <a class="navbar-brand" href="index.jsp">
                             <div class="logo">
                               <img src="./images/logoMain_1.png" class="logo" alt="">
                                 </div>
                        </a>

                        <button class="navbar-toggler" type="button" data-toggle="collapse"
                            data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
                            aria-expanded="false" aria-label="Toggle navigation">
                            <span class=""> </span>
                        </button>

                        <div class="collapse navbar-collapse" id="navbarSupportedContent">
                            <ul class="navbar-nav  mx-auto ">
                                <li class="nav-item active">
                                    <a class="nav-link" href="index.jsp">TRANG CHỦ <span
                                            class="sr-only">(current)</span> </a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" href="menu.jsp">THỰC ĐƠN</a>
                                </li>
                                <li class="nav-item ">
                                    <a class="nav-link" href="about.jsp">VỀ CHÚNG TÔI </a>
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
                                    <span class="icon-button_badge">0</span>
                                </button>

                                <% if (session.getAttribute("username")==null) {%>
                                    <a href="DangNhap" class="order_online"> Đăng nhập </a>
                                    <% } else {%>
                                        <div class="dropdown show">
                                            <a class="btn btn-secondary dropdown-toggle order_online" href="#" role="button" id="dropdownMenuLink"
                                                data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                                ${username}
                                            </a>
                                        
                                            <div class="dropdown-menu" aria-labelledby="dropdownMenuLink">
                                                <a class="dropdown-item" href="#">Giỏ hàng của tôi</a>
                                                <a class="dropdown-item" href="DangKyThem">Tạo tài khoản phụ</a>
                                                <a class="dropdown-item" href="DangXuat">Đăng xuất</a>
                                            </div>
                                        </div>
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
                                                Với sứ mệnh mang đến niềm vui và hạnh phúc, Day Dream hy vọng sẽ tạo nên
                                                một
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
                <div class="row grid">
                    <c:forEach items="${productgood}" var="productgd">
                        <div class="col-sm-6 col-lg-4 all">
                            <div class="box">
                                <div>
                                    <div class="img-box">
                                        <img src="${productgd.image}" loading="lazy">
                                    </div>
                                    <div class="detail-box">
                                        <h5>
                                            ${productgd.productName}
                                        </h5>
                    
                                        <div class="options">
                                            <h6>
                                                ${productgd.price} VND
                                            </h6>
                                            <a href="">
                                                <svg version="1.1" id="Capa_1" xmlns="http://www.w3.org/2000/svg"
                                                    xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px" viewBox="0 0 456.029 456.029"
                                                    style="enable-background:new 0 0 456.029 456.029;" xml:space="preserve">
                                                    <g>
                                                        <g>
                                                            <path
                                                                d="M345.6,338.862c-29.184,0-53.248,23.552-53.248,53.248c0,29.184,23.552,53.248,53.248,53.248
                                                                                          c29.184,0,53.248-23.552,53.248-53.248C398.336,362.926,374.784,338.862,345.6,338.862z" />
                                                        </g>
                                                    </g>
                                                    <g>
                                                        <g>
                                                            <path d="M439.296,84.91c-1.024,0-2.56-0.512-4.096-0.512H112.64l-5.12-34.304C104.448,27.566,84.992,10.67,61.952,10.67H20.48
                                                                                          C9.216,10.67,0,19.886,0,31.15c0,11.264,9.216,20.48,20.48,20.48h41.472c2.56,0,4.608,2.048,5.12,4.608l31.744,216.064
                                                                                          c4.096,27.136,27.648,47.616,55.296,47.616h212.992c26.624,0,49.664-18.944,55.296-45.056l33.28-166.4
                                                                                          C457.728,97.71,450.56,86.958,439.296,84.91z" />
                                                        </g>
                                                    </g>
                                                    <g>
                                                        <g>
                                                            <path
                                                                d="M215.04,389.55c-1.024-28.16-24.576-50.688-52.736-50.688c-29.696,1.536-52.224,26.112-51.2,55.296
                                                                                        c1.024,28.16,24.064,50.688,52.224,50.688h1.024C193.536,443.31,216.576,418.734,215.04,389.55z" />
                                                        </g>
                                                    </g>
                                                    <g>
                                                    </g>
                                                    <g>
                                                    </g>
                                                    <g>
                                                    </g>
                                                    <g>
                                                    </g>
                                                    <g>
                                                    </g>
                                                    <g>
                                                    </g>
                                                    <g>
                                                    </g>
                                                    <g>
                                                    </g>
                                                    <g>
                                                    </g>
                                                    <g>
                                                    </g>
                                                    <g>
                                                    </g>
                                                    <g>
                                                    </g>
                                                    <g>
                                                    </g>
                                                    <g>
                                                    </g>
                                                    <g>
                                                    </g>
                                                </svg>
                                            </a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
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
                <div class="row grid">
                    <c:forEach items="${productbest}" var="productbs">
                        <div class="col-sm-6 col-lg-4 all">
                            <div class="box">
                                <div>
                                    <div class="img-box">
                                        <img src="${productbs.image}" loading="lazy">
                                    </div>
                                    <div class="detail-box">
                                        <h5>
                                            ${productbs.productName}
                                        </h5>

                                        <div class="options">
                                            <h6>
                                                ${productbs.price} VND
                                            </h6>
                                            <a href="">
                                                <svg version="1.1" id="Capa_1" xmlns="http://www.w3.org/2000/svg"
                                                    xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px"
                                                    viewBox="0 0 456.029 456.029"
                                                    style="enable-background:new 0 0 456.029 456.029;"
                                                    xml:space="preserve">
                                                    <g>
                                                        <g>
                                                            <path
                                                                d="M345.6,338.862c-29.184,0-53.248,23.552-53.248,53.248c0,29.184,23.552,53.248,53.248,53.248
                                                                      c29.184,0,53.248-23.552,53.248-53.248C398.336,362.926,374.784,338.862,345.6,338.862z" />
                                                        </g>
                                                    </g>
                                                    <g>
                                                        <g>
                                                            <path d="M439.296,84.91c-1.024,0-2.56-0.512-4.096-0.512H112.64l-5.12-34.304C104.448,27.566,84.992,10.67,61.952,10.67H20.48
                                                                      C9.216,10.67,0,19.886,0,31.15c0,11.264,9.216,20.48,20.48,20.48h41.472c2.56,0,4.608,2.048,5.12,4.608l31.744,216.064
                                                                      c4.096,27.136,27.648,47.616,55.296,47.616h212.992c26.624,0,49.664-18.944,55.296-45.056l33.28-166.4
                                                                      C457.728,97.71,450.56,86.958,439.296,84.91z" />
                                                        </g>
                                                    </g>
                                                    <g>
                                                        <g>
                                                            <path
                                                                d="M215.04,389.55c-1.024-28.16-24.576-50.688-52.736-50.688c-29.696,1.536-52.224,26.112-51.2,55.296
                                                                    c1.024,28.16,24.064,50.688,52.224,50.688h1.024C193.536,443.31,216.576,418.734,215.04,389.55z" />
                                                        </g>
                                                    </g>
                                                    <g>
                                                    </g>
                                                    <g>
                                                    </g>
                                                    <g>
                                                    </g>
                                                    <g>
                                                    </g>
                                                    <g>
                                                    </g>
                                                    <g>
                                                    </g>
                                                    <g>
                                                    </g>
                                                    <g>
                                                    </g>
                                                    <g>
                                                    </g>
                                                    <g>
                                                    </g>
                                                    <g>
                                                    </g>
                                                    <g>
                                                    </g>
                                                    <g>
                                                    </g>
                                                    <g>
                                                    </g>
                                                    <g>
                                                    </g>
                                                </svg>
                                            </a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
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
