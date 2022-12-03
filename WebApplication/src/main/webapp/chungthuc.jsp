<%-- Created on : 03-Dec-2022, 08:05:54 Author : huynh --%>
    <%@page language="java" contentType="text/html" pageEncoding="UTF-8" %>
        <!DOCTYPE html>
        <html>

        <head>
            <%@include file="/includes/head.jsp" %>
                <title>Xác nhận danh tính</title>
        </head>

        <body class="nen">
            <div class="container">
                <div class="card w-50 mx-auto my-5">
                    <h1 class="card-header text-center">Vui lòng nhập mã</h1>
                    <div class="pl-2"> <span>Đã gửi mã đến địa chỉ email</span> <small>${email}</small> </div>
                    <p class="text-danger pl-2">${mess}</p>
                    <div class="card-body">
                        <form action="authentication" method="post">

                            <div class="inputs d-flex flex-row justify-content-center">
                                <input class="m-2 text-center form-control rounded" name="one" type="text" maxlength="1"
                                    required />
                                <input class="m-2 text-center form-control rounded" name="two" type="text" maxlength="1"
                                    required />
                                <input class="m-2 text-center form-control rounded" name="three" type="text"
                                    maxlength="1" required />
                                <input class="m-2 text-center form-control rounded" name="four" type="text"
                                    maxlength="1" required />
                                <input class="m-2 text-center form-control rounded" name="five" type="text"
                                    maxlength="1" required />
                                <input class="m-2 text-center form-control rounded" name="six" type="text" maxlength="1"
                                    required />
                            </div>
                            <div class="text-center pt-2">
                                <button type="submit" class="btn btn-danger px-4 validate">Xác thực</button>
                            </div>
                        </form>
                    </div>
                </div>

            </div>
            <p class="para-2">
                Quay trở lại<a href="index"> trang chủ</a>
            </p>
            </div>
            <%@include file="/includes/footer.jsp" %>
        </body>

        </html>