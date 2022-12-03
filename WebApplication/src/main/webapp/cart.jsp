<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!-- CSS line 1299 -->
<!DOCTYPE html>
<html>

    <head>
        <%@include file = "includes/head.jsp"%>
        <script src="https://kit.fontawesome.com/a076d05399.js" crossorigin="anonymous"></script>
        <title> Day Dream </title>

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
                                    <a class="nav-link " href="ThucDon">THỰC ĐƠN</a>
                                </li>
                                <li class="nav-item  active ">
                                    <a class="nav-link" href="about.jsp">VỀ CHÚNG TÔI <span class="sr-only">(current)</span> </a>
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
        </div>

        <!-- cart section -->
        
        <section style="background: #f5f6f8">
            <h1 style="margin-left: 15%;font-family: 'Dancing Script', cursive;font-weight: bold; font-size: 50px;padding-top: 40px">Giỏ Hàng Của Bạn</h1>   
            <section id="cart-container-shopping" class="container my-5">
                <table width="100%">
                    <thead>
                        <tr>                       
                            <td style="width: 10%"></td>
                            <td style="width: 30%">Sản Phẩm</td>
                            <td>Đơn Giá</td>
                            <td>Số Lượng</td>
                            <td>Số Tiền</td>
                            <td style="width: 10%">Xóa</td>
                        </tr>                  
                    </thead>
                    <tbody>
                        <tr>
                            <td><img src="https://res.cloudinary.com/dlux9nebf/image/upload/v1665647450/Day%20dream/cafe3_lrtfan.png" alt=""></td>
                            <td><h5>Trà Hoa Đậu Biếc</h5></td>
                            <td><h5>$65</h5></td>
                            <td><input class="w-25 pl-1" type="number" min="0" value="1"></td>
                            <td><h5>$130.00</h5></td>
                            <td><a href="#"><i class="fa fa-trash-alt"></i></a></td>   
                        </tr>

                         <tr>
                            <td><img src="https://res.cloudinary.com/dlux9nebf/image/upload/v1665647450/Day%20dream/cafe3_lrtfan.png" alt=""></td>
                            <td><h5>Trà Hoa Đậu Biếc</h5></td>
                            <td><h5>$65</h5></td>
                            <td><input class="w-25 pl-1" type="number" min="0" value="1"></td>
                            <td><h5>$130.00</h5></td>
                            <td><a href="#"><i class="fa fa-trash-alt"></i></a></td>   
                        </tr>          

                         <tr>
                            <td><img src="https://res.cloudinary.com/dlux9nebf/image/upload/v1665647450/Day%20dream/cafe3_lrtfan.png" alt=""></td>
                            <td><h5>Trà Hoa Đậu Biếc</h5></td>
                            <td><h5>$65</h5></td>
                            <td><input class="w-25 pl-1" type="number" min="0" value="1"></td>
                            <td><h5>$130.00</h5></td>
                            <td><a href="#"><i class="fa fa-trash-alt"></i></a></td>   
                        </tr>          
                    </tbody>
                </table>
            </section>
            <section id="cart-bottom-shopping" class="container">
                <form action="/about.jsp" method="post">
                    <div class="row">
                        <div class="coupon-shopping col-lg-6 col-md-6 col-12 mb-4">
                            <div>
                                <h5>ĐỊA CHỈ NHẬN HÀNG</h5>
                                <p>Vui lòng nhập chính xác địa chỉ nhận hàng.</p>
                                <input type="text" placeholder="Địa Chỉ" style="width: 95.58%">

                            </div>
                        </div>
                        <div class="total-shopping col-lg-6 col-md-6 col-12">
                            <div>
                                <h5>THANH TOÁN</h5>
                                <div class="d-flex justify-content-between">
                                    <h6>Tổng tiền sản phẩm</h6>
                                    <p>$215.00</p>
                                </div>
                                <div class="d-flex justify-content-between">
                                    <h6>Phí vận chuyển</h6>
                                    <p>30.000 VNĐ</p>
                                </div>
                                <hr class="second-hr">
                                <div class="d-flex justify-content-between">
                                    <h6>Tổng thanh toán</h6>
                                    <p>$215.00</p>
                                </div>
                                <button class="ml-auto" type="submit">ĐẶT HÀNG</button>           
                            </div>
                        </div>>
                    </div>
                </form>
            </section>
        </section>
        <!-- end cart section -->
        <!-- footer -->
        <%@include file="includes/footer.jsp" %>

    </body>

</html>
