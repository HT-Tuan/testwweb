<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <head>
        <%@include file = "includes/head.jsp"%>
        <title> Liên hệ </title>

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
                                <img src="./images/logoMain_1.png" class="logo" alt="">
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
                                <li class="nav-item">
                                    <a class="nav-link" href="about.jsp">VỀ CHÚNG TÔI </a>
                                </li>
                                <li class="nav-item  active">
                                    <a class="nav-link" href="contact.jsp">LIÊN HỆ <span class="sr-only">(current)</span> </a>
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

        <!-- about section -->
        <section class="contact_interface">
            <div class="content" style='margin-left: 25px'>
                <h2>LIÊN HỆ VỚI CHÚNG TÔI</h2>
                <p>
                    DAYDREAM sẵn sàng hỗ trợ bạn mọi lúc mọi nơi bất cứ khi nào bạn cần<br>
                    Được hỗ trợ khách hàng là niềm vinh hạnh của chúng tôi<br>
                </p>
            </div>
            <div class="container_interface">
                <div class="contactInfo">
                    <div class="box">
                        <div class="icon"><i class="fa fa-map-marker" aria-hidden="true"></i></div>
                        <div class="text">
                            <h3>Địa chỉ</h3>
                            <p>1 Võ Văn Ngân,Phường Linh Chiểu,<br>Thành phố Thủ Đức,Thành phố Hồ Chí Minh</p>
                        </div>
                    </div>
                    <div class="box">
                        <div class="icon"><i class="fa fa-phone" aria-hidden="true"></i></div>
                        <div class="text">
                            <h3>Phone</h3>
                            <p>+84 336484577</p>
                        </div>
                    </div>
                    <div class="box">
                        <div class="icon"><i class="fa fa-envelope-o" aria-hidden="true"></i></div>
                        <div class="text">
                            <h3>Email</h3>
                            <p>daydream@gmail.com</p>
                        </div>
                    </div>
                </div>
                <div class="contactForm">
                    <form>
                        <h2>Gửi phản hồi của bạn</h2>
                        <div class="inputBox">
                            <input type="text" name="" required="required">
                            <span>Họ và tên</span>
                        </div>
                        <div class="inputBox">
                            <input type="text" name="" required="required">
                            <span>Email</span>
                        </div>
                        <div class="inputBox">
                            <textarea required="required"></textarea>
                            <span>Nhập phản hồi của bạn...</span>
                        </div>
                        <div class="inputBox">
                            <input type="submit" name="" value="Gửi">                          
                        </div>
                    </form>
                </div>
            </div>     
        </section>


        <!-- end about section -->

        <!-- footer -->
        <%@include file="includes/footer.jsp" %>

    </body>

</html>
