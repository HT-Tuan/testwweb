<%@page contentType="text/html" pageEncoding="UTF-8"%>

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
                                    <a class="nav-link" href="index.jsp">TRANG CHỦ </a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" href="menu.jsp">THỰC ĐƠN</a>
                                </li>
                                <li class="nav-item active">
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

        <!-- about section -->

        <section class="about_section layout_padding nenB">
            <div class="container">

                <div class="row">        
                    <div class="col-md-6">
                        <div class="detail-box">           
                            <div class="heading_container_readmore">           
                                <h2>
                                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;VỀ CHÚNG TÔI
                                </h2> <br>
                                <h3>
                                    KHỞI NGUỒN
                                </h3> </br>    
                                <h5>
                                    Thương hiệu bắt nguồn từ cà phê và trà
                                </h5>
                                <p>
                                    Từ tình yêu với Việt Nam và niềm đam mê cà phê và trà, năm 1999, thương hiệu DAYDREAM ra đời với khát vọng nâng 
                                    tầm di sản cà phê lâu đời của Việt Nam và lan rộng tinh thần tự hào, kết nối hài hoà giữa truyền thống 
                                    với hiện đại.
                                </p>
                                <p>
                                    Bắt đầu với sản phẩm cà phê và trà đóng gói tại Hà Nội vào năm 2000, chúng tôi đã nhanh chóng phát triển và mở 
                                    rộng thành thương hiệu quán cà phê nổi tiếng và không ngừng mở rộng hoạt động trong và ngoài nước từ năm 
                                    2002.
                                </p>          
                                <p>
                                    Qua một chặng đường dài, chúng tôi đã không ngừng mang đến những sản phẩm cà phê và những tách trà thơm ngon, 
                                    sánh đượm trong không gian thoải mái và lịch sự. Những ly cà phê của chúng tôi không chỉ đơn thuần là thức uống 
                                    quen thuộc mà còn mang trên mình một sứ mệnh văn hóa phản ánh một phần nếp sống hiện đại của người Việt Nam.
                                </p>
                                <p>
                                    Đến nay, DAYDREAM vẫn duy trì khâu phân loại cà phê bằng tay để chọn ra từng hạt cà phê chất lượng nhất, 
                                    rang mới mỗi ngày và phục vụ quý khách với nụ cười rạng rỡ trên môi. Bí quyết thành công của chúng tôi là đây: không 
                                    gian quán tuyệt vời, sản phẩm tuyệt hảo và dịch vụ chu đáo với mức giá phù hợp.
                                </p>
                                <p>
                                    Chúng tôi tin rằng từng sản phẩm trà và cà phê sẽ càng thêm hảo hạng khi được tạo ra từ sự phấn đấu không ngừng cùng 
                                    niềm đam mê. Và chính kết nối dựa trên niềm tin, sự trung thực và tin yêu góp phần mang đến những nét đẹp trong văn 
                                    hóa thưởng trà và cà phê ngày càng bay cao và vươn xa. Tiếp nối nỗ lực, từ một cửa hàng đầu tiên, đến nay, DAYDREAM 
                                    xây dựng được 4 chi nhánh phục vụ những thức uống tươi ngon từ trà và cà phê. Không dừng lại tại đó, chúng tôi tiếp tục 
                                    định hướng phát triển mở rộng hệ thống cửa hàng trải dài từ Nam ra Bắc. Tăng độ phủ của sản phẩm đến tất cả các hệ thống: 
                                    siêu thị, cửa hàng tiện lợi…
                                </p></br>

                                <h3>
                                    TẦM NHÌN
                                </h3>                      
                                <p>
                                    <b>1. Trở thành người tiên phong của thời đại</b> với những ý tưởng sáng tạo đi đầu trong ngành trà và cà phê.
                                </p>
                                <p>
                                    <b>2. Cùng đưa thương hiệu tỏa sáng</b>, tạo động lực cho nhau, cùng biến ý tưởng thành hiện thực bằng tinh 
                                    thần gắn kết, tương tác, biết lắng nghe và tôn trọng.
                                </p>
                                <p>
                                    <b>3. Để tạo niềm vui và tình cảm cho khách hàng</b>, mỗi chúng ta phải thường xuyên liên tục tỏa sáng. Không
                                    được để cho năng lực của bản thân bị ngủ quên, không ngừng thách thức khó khăn, phải luôn luôn tự đổi mới bản thân.
                                </p>
                                <p>
                                    <b>4. Tạo ra giá trị cao</b> bằng sự thấu hiểu, đồng cảm và những đề xuất có giá trị thật sự, thỏa mãn sự hài lòng 
                                    cho khách hàng.
                                </p>

                                <br>
                                <h3>
                                    GIÁ TRỊ CỐT LÕI
                                </h3>                      
                                <p>
                                    <b>1. Đối với khách hàng:</b> Cam kết cung cấp sản phẩm chất lượng và dịch vụ tốt nhất. 
                                </p>
                                <p>
                                    <b>2. Đối với nhân viên:</b> Xây dựng môi trường làm việc chuyên nghiệp, năng động, sáng tạo 
                                    và nhân văn, tạo điều kiện thu nhập cao và cơ hội phát triển công bằng.
                                </p>
                                <p>
                                    <b>3. Đối với xã hội:</b> Hài hòa lợi ích doanh nghiệp với lợi ích xã hội, đóng góp tích cực 
                                    vào các hoạt động hướng về cộng đồng, thể hiện tinh thần trách nhiệm đối với xã hội.
                                </p>             

                                <br>
                                <h3>
                                    LĨNH VỰC HOẠT ĐỘNG
                                </h3>                      
                                <p>
                                    <b>1. Sản xuất, xuất khẩu, kinh doanh</b> các sản phẩm trà và cà phê thành phẩm (đóng gói) 
                                </p>
                                <p>
                                    <b>2. Kinh doanh dịch vụ</b> ăn uống tại hệ thống cửa hàng: <br><br>
                                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                    Các loại thức ăn, thức uống <br><br>
                                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                    Dịch vụ giao hàng tận nơi 
                                </p>             

                                <br>
                                <h3>
                                    DỊCH VỤ KHÁCH HÀNG
                                </h3> </br>             
                                <h5>
                                    Hãy chia sẻ với chúng tôi:
                                </h5>
                                <p>
                                    Chúng tôi mong muốn mang đến cho bạn những trải nghiệm đáng nhớ mỗi lần đến DAYDREAM. Hãy góp ý cho 
                                    chúng tôi để chúng tôi có thể mang đến cho bạn những trải nghiệm tuyệt vời hơn thế.
                                </p></br>
                                <h5>
                                    Chăm sóc khách hàng:
                                </h5>
                                <p>
                                    Hãy chia sẻ với chúng tôi tại: <u><i>https://www.facebook.com/daydream/</i></u> hoặc bạn có thể gửi email cho chúng tôi theo địa chỉ: 
                                    <u><i>daydream@gmail.com</i></u>, chúng tôi sẽ trả lời bạn trong thời gian sớm nhất có thể.
                                </p>
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