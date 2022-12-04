<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@page contentType="text/html" pageEncoding="UTF-8" %>
        <!-- CSS line 1299 -->
        <!DOCTYPE html>
        <html>

        <head>
            <%@include file="includes/head.jsp" %>
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

                            <button class="navbar-toggler" type="button" data-toggle="collapse"
                                data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
                                aria-expanded="false" aria-label="Toggle navigation">
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
                                    <li class="nav-item ">
                                        <a class="nav-link" href="about.jsp">VỀ CHÚNG TÔI </a>
                                    </li>
                                    <li class="nav-item">
                                        <a class="nav-link" href="contact.jsp">LIÊN HỆ</a>
                                    </li>
                                </ul>
                                <div class="user_option">
                                    <form action="Cart" method="post">
                                        <button type="submit" class="icon-button">
                                            <input type="hidden" name="action" value="view">
                                            <span class="material-symbols-outlined">
                                                shopping_bag
                                            </span>
                                            <span class="icon-button_badge">${totalProduct}</span>
                                        </button>
                                    </form>
                                    <% if (session.getAttribute("cus")==null) {%>
                                        <a href="DangNhap" class="order_online"> Đăng nhập </a>
                                        <% } else {%>
                                            <div class="dropdown show">
                                                <a class="btn btn-secondary dropdown-toggle order_online" href="#"
                                                    role="button" id="dropdownMenuLink" data-toggle="dropdown"
                                                    aria-haspopup="true" aria-expanded="false">
                                                    ${cus.fullName}
                                                </a>
                                                <div class="dropdown-menu" aria-labelledby="dropdownMenuLink">
                                                    <a class="dropdown-item" href="Cart?action=view">Giỏ hàng của
                                                        tôi</a>
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

            <!-- cart section -->

            <section style="background: #f5f6f8">
                <h1
                    style="margin-left: 15%;font-family: 'Dancing Script', cursive;font-weight: bold; font-size: 50px;padding-top: 40px">
                    Giỏ Hàng Của Bạn</h1>
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
                            <c:forEach var="item" items="${cartItem}">
                                <tr>
                                    <td><img src="${item.product.image}" alt=""></td>
                                    <td>
                                        <h5>${item.product.productName}</h5>
                                    </td>
                                    <td>
                                        <h5>${item.product.price} VND</h5>
                                    </td>
                                    <td style="padding-bottom: 12px">
                                        <a href="UpdateCart?action=substract&amp;productId=${item.product.productID}"><i
                                                class="fas fa-minus" style="font-size: 12px; margin-right: 1px"></i></a>
                                        <input style="width:15%; text-align: center" type="text" disabled="true" min="0"
                                            value=${item.quantity}>
                                        <a href="UpdateCart?action=add&amp;productId=${item.product.productID}"><i
                                                class="fas fa-plus" style="font-size: 12px; margin-left: 1px"></i></a>
                                    </td>
                                    <td>
                                        <h5>${item.quantity * item.product.price} VND</h5>
                                    </td>
                                    <td><a href="UpdateCart?action=delete&amp;productId=${item.product.productID}"><i
                                                class="fa fa-trash-alt"></i></a></td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </section>
                <section id="cart-bottom-shopping" class="container">
                    <form action="OrderCart" method="get">
                        <div class="row">
                            <div class="coupon-shopping col-lg-6 col-md-6 col-12 mb-4">
                                <div>
                                    <h5>ĐỊA CHỈ NHẬN HÀNG</h5>
                                    <p>Vui lòng nhập chính xác địa chỉ nhận hàng.</p>
                                    <input type="text" placeholder="Địa Chỉ" style="width: 95.58%" required="true"
                                        name="address">

                                </div>
                            </div>
                            <div class="total-shopping col-lg-6 col-md-6 col-12">
                                <div>
                                    <h5>THANH TOÁN</h5>
                                    <div class="d-flex justify-content-between">
                                        <h6>Tổng tiền sản phẩm</h6>
                                        <p>${totalAmount} VND</p>
                                    </div>
                                    <div class="d-flex justify-content-between">
                                        <h6>Phí vận chuyển</h6>
                                        <p>30.000 VND</p>
                                    </div>
                                    <hr class="second-hr">
                                    <div class="d-flex justify-content-between">
                                        <h6>Tổng thanh toán</h6>
                                        <p><span>${totalAmount + 30} VND</span></p>
                                    </div>
                                    <button class="ml-auto" type="submit">ĐẶT HÀNG</button>
                                </div>
                            </div>
                        </div>
                    </form>
                </section>
            </section>
            <!-- end cart section -->
            <!-- footer -->
            <%@include file="includes/footer.jsp" %>

        </body>

        </html>