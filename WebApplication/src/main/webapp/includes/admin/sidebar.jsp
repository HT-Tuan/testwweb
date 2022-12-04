<%@page contentType="text/html" pageEncoding="UTF-8" %>
  <%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
    <aside
      class="sidenav navbar navbar-vertical navbar-expand-xs border-0 border-radius-xl my-3 fixed-start ms-3   bg-gradient-dark"
      id="sidenav-main">
      <div class="sidenav-header">
        <i class="fas fa-times p-3 cursor-pointer text-white opacity-5 position-absolute end-0 top-0 d-none d-xl-none"
          aria-hidden="true" id="iconSidenav"></i>
        <a class="navbar-brand m-0" href="  " target="_blank">
          <img src="./images/logoMain.png" class="logo11" alt="main_logo">


        </a>
      </div>
      <hr class="horizontal light mt-0 mb-2">
      <div class="collapse navbar-collapse  w-auto " id="sidenav-collapse-main">
        <ul class="navbar-nav">

          <c:if test="${!empty status && status == true}">

            <span class="icon-button_badge">${totalProduct}</span>
            <li class="nav-item">
              <a class="nav-link text-white " href="Items">

                <span class="nav-link-text ms-1">Quản lý Menu</span>
              </a>
            </li>
            <li class="nav-item">
              <a class="nav-link text-white " href="Invoice">

                <span class="nav-link-text ms-1">Quản lý đơn hàng </span>
              </a>
            </li>
            <li class="nav-item">
              <a class="nav-link text-white " href="customer">

                <span class="nav-link-text ms-1">Quản lý khách hàng </span>
              </a>
            </li>

          </c:if>
          
        </ul>
      </div>
      <div class="sidenav-footer position-absolute w-100 bottom-0 ">
        <div class="mx-3">
          <a class="btn bg-gradient-primary mt-4 w-100" href="index" type="button">Thoát</a>
        </div>
      </div>
    </aside>