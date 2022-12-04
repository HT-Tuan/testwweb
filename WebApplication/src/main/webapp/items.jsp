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

<!-- Custom styles for this template -->
  <link href="css/style.css" rel="stylesheet" />
  <!-- responsive style -->
  <link href="css/responsive.css" rel="stylesheet" />
  <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@48,400,0,0" />
  <link href="assets/css/material-dashboard.css" rel="stylesheet" />
  <!--     Fonts and icons     -->
  <link rel="stylesheet" type="text/css" href="https://fonts.googleapis.com/csss?family=Roboto:300,400,500,700,900|Roboto+Slab:400,700" />
  
 
  


  <title> Items </title>
</head>

<body class="g-sidenav-show  bg-gray-200">
<!--side bar section-->
          <%@include file = "includes/admin/sidebar.jsp"%>

    <main class="main-content position-relative max-height-vh-100 h-100 border-radius-lg ">
    <!-- Navbar -->
    <nav class="navbar navbar-main navbar-expand-lg px-0 mx-4 shadow-none border-radius-xl" id="navbarBlur" data-scroll="true">
      <div class="container-fluid py-1 px-3">
        <nav aria-label="breadcrumb">
          
          <h6 class="font-weight-bolder mb-0 mycustomcss">Thức Uống</h6>
 
        </div>
    </nav>

    <!-- End Navbar -->
<div class="container-fluid py-4">
<div class="inputmenu">
   <button type="button" class="btn btn-primary "><a href="AddSanPham" class="color1">
       Thêm món uống
</a></button>
</div>
      <div class="row">
        <div class="col-12">
          <div class="card my-4">
            <div class="card-header p-0 position-relative mt-n4 mx-3 z-index-2">
              <div class="bg-gradient-primary shadow-primary border-radius-lg pt-4 pb-3">
                <h6 class="text-white text-capitalize ps-3">Menu</h6>
              </div>
            </div>
            <div class="card-body px-0 pb-2">
              <div class="table-responsive p-0">
                <table class="table align-items-center mb-0">
                  <thead>
                    <tr>
                      <th class="text-uppercase text-secondary text-xxs font-weight-bolder opacity-7"> Mã </th>
                      <th class="text-uppercase text-secondary text-xxs font-weight-bolder opacity-7 ps-2"> Sản Phẩm</th>
                      <th class="text-uppercase text-secondary text-xxs font-weight-bolder opacity-7"> Giá </th>
                      <th class="text-uppercase text-secondary text-xxs font-weight-bolder opacity-7 ps-2"> Ảnh</th>
                      <th class="text-uppercase text-secondary text-xxs font-weight-bolder opacity-7"> Mô Tả </th>
                      <th class="text-uppercase text-secondary text-xxs font-weight-bolder opacity-7 ps-2"> Loại </th>
                      
                      <th class="text-secondary opacity-7"></th>
                    </tr>
        <c:forEach items="${products}" var="product">
              <tr>
                      <td>
                        <div class="d-flex px-2 py-1 menu">
                        
                          <div class="d-flex flex-column justify-content-center">
                           <p class="text-xs text-secondary mb-0">${product.productID}</p>
                          </div>
                        </div>
                      </td>
                      <td>
                        <p class="text-xs font-weight-bold mb-0">${product.productName} </p>
                      </td>
                       <td>
                        <p class="text-xs font-weight-bold mb-0"> ${product.price} </p>
                      </td>

                      <td>
                            <img src="${product.image}" class="avatar avatar-sm me-3 border-radius-lg" alt="user1">
                       </td>
                       <td>
                        <p class="text-xs font-weight-bold mb-0"> ${product.description} </p>
                      </td>
                       <td>
                        <p class="text-xs font-weight-bold mb-0"> ${product.category.categoryName} </p>
                      </td>
                      
                        <td>
                       <a href="Edit?id=${product.productID}&productName=${product.productName}&image=${product.image}&price=${product.price}&cateId=${product.category.categoryID}" class="text-secondary font-weight-bold text-xs" data-toggle="tooltip" data-original-title="Update">
                          Sửa
                        </a>
                        </td>
                        <td>
                            <a  href="DeleteSP?id=${product.productID}" class="text-secondary font-weight-bold text-xs" data-toggle="tooltip" data-original-title="Delete">
                                Xoá
                            </a>
                        </td>
                      </td>
                    </tr>
          </c:forEach>
                        
                  </tbody>
                </table>
              </div>
            </div>
          </div>
        </div>
      </div>
      
          
      <footer class="footer py-4  ">
        
      </footer>
    </div>
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
