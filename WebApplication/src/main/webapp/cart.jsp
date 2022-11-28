<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!-- CSS line 1299 -->
<!DOCTYPE html>
<html>

    <head>
        <%@include file = "includes/head.jsp"%>
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
        <div class="cart-page-shopping">
            <table>
                <tr>
                    <th>Product</th>
                    <th>Quantity</th>
                    <th>Subtotal</th>
                </tr>
                <tr>
                    <td>Product Name</td>
                    <td><input type="number" valie="1"></td>
                    <td>$50.00</td>
                </tr>
            </table>
        </div>
        <!-- end cart section -->
        <!-- footer -->
        <%@include file="includes/footer.jsp" %>

    </body>

</html>