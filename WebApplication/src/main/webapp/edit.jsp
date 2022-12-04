<!--
=========================================================
* Material Dashboard 2 - v3.0.4
=========================================================

* Product Page: https://www.creative-tim.com/product/material-dashboard
* Copyright 2022 Creative Tim (https://www.creative-tim.com)
* Licensed under MIT (https://www.creative-tim.com/license)
* Coded by Creative Tim

=========================================================

* The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
-->

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

<!DOCTYPE html>
<html lang="en">

<head>

  <!--     Fonts and icons     -->
  <link rel="stylesheet" type="text/css" href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700,900|Roboto+Slab:400,700" />
  <!-- Nucleo Icons -->
  <link href="./assets/css/nucleo-icons.css" rel="stylesheet" />
  <link href="./assets/css/nucleo-svg.css" rel="stylesheet" />
  <!-- Font Awesome Icons -->
  <script src="https://kit.fontawesome.com/42d5adcbca.js" crossorigin="anonymous"></script>
  <!-- Material Icons -->
  <link href="https://fonts.googleapis.com/icon?family=Material+Icons+Round" rel="stylesheet">
  <!-- CSS Files -->
  <link id="pagestyle" href="./assets/css/material-dashboard.css?v=3.0.4" rel="stylesheet" />
  <link href="./assets/css/mystyles.css" rel="stylesheet" />
  <!-- bootstrap core css -->
  <link rel="stylesheet" type="text/css" href="./css/bootstrap.css" />

<!-- Custom styles for this template -->
  <link href="css/style.css" rel="stylesheet" />
  <!-- responsive style -->
  <link href="css/responsive.css" rel="stylesheet" />
  <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@48,400,0,0" />
  <link href="assets/css/material-dashboard.css" rel="stylesheet" />
  <!--     Fonts and icons     -->
  <link rel="stylesheet" type="text/css" href="https://fonts.googleapis.com/csss?family=Roboto:300,400,500,700,900|Roboto+Slab:400,700" />

  <title> Edit </title>
</head>

<body class="g-sidenav-show  bg-gray-200">
<!--side bar section-->
          <%@include file = "includes/admin/sidebar.jsp"%>

  <main class="main-content position-relative max-height-vh-100 h-100 border-radius-lg ">
    <!-- Navbar -->
    <nav class="navbar navbar-main navbar-expand-lg px-0 mx-4 shadow-none border-radius-xl" id="navbarBlur" data-scroll="true">
      <div class="container-fluid py-1 px-3">
        <nav aria-label="breadcrumb">
          
          <h6 class="font-weight-bolder mb-0 mycustomcss">Cập nhật thực uống</h6>
       
       

                </li>
              </ul>
            </li>
          </ul>
        </div>
      </div>
    </nav>
    <!-- End Navbar -->


<form action="Edit-action" class="container">
 <div class="form-group">
    <label for="exampleInputEmail1">Sửa ảnh</label>
   <div class="form-group col-md-6">
     
    <img src="${productimg}" class="img-fluid" alt="Responsive image">

    
  </div>
  </div>

  <div style="display: flex; flex-direction: column" class="form-group">
    <label style="margin-right: 1rem" > product id </label>
    <input name="id" readonly type="text" value=${productId} class="form-control11">
</div>


 <div style="display: flex; flex-direction: column" class="form-group">
    <label style="margin-right: 1rem" > URL Hinh anh </label>
    <input name="img-url" type="text" value="${productimg}" class="form-control11" placeholder="Nhap vao url hinh anh">
</div>

 <div style="display: flex; flex-direction: column" class="form-group">
    <label style="margin-right: 1rem" for="exampleInputEmail1">${productName} </label>
    <input name="productName" type="text" value="${productName}" class="form-control11" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Nhap vao ten">
  </div>

 <div style="display: flex; flex-direction: column" class="form-group">
    <label style="margin-right: 1rem" for="exampleInputEmail1">Giá</label>
    <input name="price" type="text" value=${productPrice} class="form-control11" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Nhap Gia">
  </div>

<div style="display: flex; flex-direction: column" class="form-group">
    <label style="margin-right: 1rem" for="exampleInputEmail1">Mô Tả Sản Phẩm </label>

    <select name="desc" id="desc">
     <option value="good" 
     <% if(session.getAttribute("productDesc")=="good"){%> selected <%}%> 
     >Good</option>

     <option value="normal" 
     <% if(session.getAttribute("productDesc")=="normal"){%> selected <%}%> 
     >Normal</option>

     <option value="bad" 
     <% if(session.getAttribute("productDesc")=="bad"){%> selected <%}%> 
     >Bad</option>
    </select>
    
  </div>

  <div style="display: flex; flex-direction: column" class="form-group">
    <label style="margin-right: 1rem" for="exampleInputEmail1">Loại Thức Uống</label>
    <select name="category" id="cate">
    <c:forEach  items="${categories}" var="categories">
        <!-- <option value=${categories.categoryID}>${categories.categoryName}</option> -->
        <option value=${categories.categoryID}
        <% if(session.getAttribute("cateId")=="3"){%> selected <%}%> 
        >${categories.categoryName}</option>
    </c:forEach>
    </select>
  </div>

  <button type="submit" class="btn btn-primary">Xác nhận</button>
  <button class="btn btn-danger">
<a class ="color1" href="Items" >
    Thoát
  </a>

</button>      


</form>


  </main>
  
      
  <!--   Core JS Files   -->
  <script src="./assets/js/core/popper.min.js"></script>
  <script src="./assets/js/core/bootstrap.min.js"></script>
  <script src="./assets/js/plugins/perfect-scrollbar.min.js"></script>
  <script src="./assets/js/plugins/smooth-scrollbar.min.js"></script>
  <script>
    var win = navigator.platform.indexOf('Win') > -1;
    if (win && document.querySelector('#sidenav-scrollbar')) {
      var options = {
        damping: '0.5'
      }
      Scrollbar.init(document.querySelector('#sidenav-scrollbar'), options);
    }
  </script>
  <!-- Github buttons -->
  <script async defer src="https://buttons.github.io/buttons.js"></script>
  <!-- Control Center for Material Dashboard: parallax effects, scripts for the example pages etc -->
  <script src="./assets/js/material-dashboard.min.js?v=3.0.4"></script>
</body>

</html>
