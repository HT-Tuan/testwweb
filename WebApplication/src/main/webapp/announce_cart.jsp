<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html>
<html>

    <head>
        <%@include file = "includes/head.jsp"%>
        <title>Đọc thêm </title>

    </head>

    <body class="sub_page">

        <div class="hero_area">
            <div class="bg-box">
                <img src="images/hero-bg.jpg" alt="">
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

                        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                            <span class=""> </span>
                        </button>

                        <div class="collapse navbar-collapse" id="navbarSupportedContent">
                            <ul class="navbar-nav  mx-auto ">
                                <li class="nav-item ">
                                    <a class="nav-link" href="index">TRANG CHỦ </a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" href="ThucDon">THỰC ĐƠN</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" href="about.jsp">VỀ CHÚNG TÔI</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" href="contact.jsp">LIÊN HỆ</a>
                                </li>
                            </ul>
                            <div class="user_option">
                                <form action="Cart" method="get">
                                    <input type="hidden" name="action" value="view">
                                    <button type="submit" class="icon-button">
                                    <span class="material-symbols-outlined">
                                        shopping_bag
                                    </span>
                                    <c:if test="${!empty totalProduct}">
                                        <span class="icon-button_badge">${totalProduct}</span>
                                    </c:if>
                                </button>
                                </form> 

                                <% if (session.getAttribute("cus")==null) {%>
                                    <a href="DangNhap" class="order_online"> Đăng nhập </a>
                                    <% } else {%>
                                        <div class="dropdown show">
                                            <a class="btn btn-secondary dropdown-toggle order_online" href="#" role="button" id="dropdownMenuLink"
                                                data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                                ${cus.fullName}
                                            </a>
                                
                                            <div class="dropdown-menu" aria-labelledby="dropdownMenuLink">
                                                <a class="dropdown-item" href="Cart?action=view">Giỏ hàng của tôi</a>
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
        </div>

        <!-- about section -->

        <section class="about_section layout_padding nenB">
            <div class="container">

                <div class="row">        
                    <div class="col-md-6">
                        <div class="detail-box">           
                            <div class="heading_container_readmore">           
                                <h2 style="margin-left: 28%">
                                    ĐẶT HÀNG THÀNH CÔNG
                                </h2> <br>
                               
                                <h5 style="margin-left: 40px">
                                    Cảm ơn bạn đã cho chúng tôi cơ hội được phục vụ !
                                    Chúng tôi đã gửi email thông tin về đơn hàng của bạn và sẽ liên hệ với bạn sau 15 phút.
                                    Liên hệ 0336484577 để biết thêm thêm thông tin
                                    Cảm ơn bạn đã ủng hộ Day Dream.
                                </h5>
                                
                            </div>           
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