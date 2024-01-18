<%@page import="bean.khachhangbean"%>
<%@page import="bean.loaibean"%>
<%@page import="bean.sachbean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <title>ADMIN - Quản Lý Sách</title>
    <meta content="width=device-width, initial-scale=1.0" name="viewport">
    <meta content="" name="keywords">
    <meta content="" name="description">

    <!-- Favicon -->
    <link href="img/favicon.ico" rel="icon">
    <link rel="icon" href="./assets/img/logoshopee-icon.png">

    <!-- Google Web Fonts -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Open+Sans:wght@400;600&family=Roboto:wght@500;700&display=swap"
        rel="stylesheet">

    <!-- Icon Font Stylesheet -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css" rel="stylesheet">

    <!-- Libraries Stylesheet -->
    <link href="lib/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet">
    <link href="lib/tempusdominus/css/tempusdominus-bootstrap-4.min.css" rel="stylesheet" />

    <!-- Customized Bootstrap Stylesheet -->
    <link href="assets/css/bootstrap.min.css" rel="stylesheet">

    <!-- Template Stylesheet -->
    <link href="assets/css/styleAdmin.css" rel="stylesheet">
</head>

<body>
    <div class="container-fluid position-relative d-flex p-0">
        <!-- Spinner Start -->
        <div id="spinner"
            class="show bg-dark position-fixed translate-middle w-100 vh-100 top-50 start-50 d-flex align-items-center justify-content-center">
            <div class="spinner-border text-primary" style="width: 3rem; height: 3rem;" role="status">
                <span class="sr-only">Loading...</span>
            </div>
        </div>
        <!-- Spinner End -->


        <!-- Sidebar Start -->
        <div class="sidebar pe-4 pb-3">
            <nav class="navbar bg-secondary navbar-dark">
                <a href="AdminXacNhanController" class="navbar-brand mx-4 mb-3">
                    <h3 class="text-primary"></i>Shopee</h3>
                </a>
                <%
				// gan session vao bien
				khachhangbean kh = (khachhangbean) session.getAttribute("login");
				if(kh!=null){ %>
                <div class="d-flex align-items-center ms-4 mb-4">
                    <div class="position-relative">
                        <img class="rounded-circle" src="assets/img/avt.jpg" alt="" style="width: 40px; height: 40px; object-fit: cover;">
                        <div class="bg-success rounded-circle border border-2 border-white position-absolute end-0 bottom-0 p-1"></div>
                    </div>
                    <div class="ms-3">
                        <h6 class="mb-0"><%=kh.getHoten() %></h6>
                        <span>Admin</span>
                    </div>
                </div>
                <%} else{%>
                <%} %>
                <div class="navbar-nav w-100">
                    <a href="AdminXacNhanController" class="nav-item nav-link active"><i class="fa fa-tachometer-alt me-2"></i>Trang chủ</a>                                                        
                    <a href="AdminSachController" class="nav-item nav-link"><i class="fa fa-th me-2"></i>Sản phẩm</a>
                    <a href="AdminLoaiController" class="nav-item nav-link"><i class="fa fa-table me-2"></i></i>Danh mục</a>                    
                    <div class="nav-item dropdown">
                        <a href="#" class="nav-link dropdown-toggle" data-bs-toggle="dropdown"><i class="far fa-file-alt me-2"></i>Trang khác</a>
                        <div class="dropdown-menu bg-transparent border-0">
                           	<a href="AdminRegisterController" class="dropdown-item">Đăng ký</a>
                            <a href="AdminLoginController" class="dropdown-item">Đăng nhập</a>                        
                        </div>
                    </div>
                </div>
            </nav>
        </div>
        <!-- Sidebar End -->


        <!-- Content Start -->
        <div class="content">
            <!-- Navbar Start -->
            <nav class="navbar navbar-expand bg-secondary navbar-dark sticky-top px-4 py-0">
                <a href="index.html" class="navbar-brand d-flex d-lg-none me-4">
                    <h2 class="text-primary mb-0"><i class="fa fa-user-edit"></i></h2>
                </a>
                <a href="#" class="sidebar-toggler flex-shrink-0">
                    <i class="fa fa-bars"></i>
                </a>
                <form class="d-none d-md-flex ms-4">
                    <input class="form-control bg-dark border-0" type="search" placeholder="Search">
                </form>
                <div class="navbar-nav align-items-center ms-auto">
                    <div class="nav-item dropdown">
                        <a href="#" class="nav-link dropdown-toggle" data-bs-toggle="dropdown">
                            <i class="fa fa-envelope me-lg-2"></i>
                            <span class="d-none d-lg-inline-flex">Tin nhắn</span>
                        </a>
                        <div class="dropdown-menu dropdown-menu-end bg-secondary border-0 rounded-0 rounded-bottom m-0">
                            <a href="#" class="dropdown-item">
                                <div class="d-flex align-items-center">
                                    <img class="rounded-circle" src="assets/img/avt.jpg" alt=""
                                        style="width: 40px; height: 40px; object-fit: cover;">
                                    <div class="ms-2">
                                        <h6 class="fw-normal mb-0">Jhon send you a message</h6>
                                        <small>15 minutes ago</small>
                                    </div>
                                </div>
                            </a>
                            <hr class="dropdown-divider">
                            <a href="#" class="dropdown-item">
                                <div class="d-flex align-items-center">
                                    <img class="rounded-circle" src="assets/img/avt.jpg" alt=""
                                        style="width: 40px; height: 40px; object-fit: cover;">
                                    <div class="ms-2">
                                        <h6 class="fw-normal mb-0">Jhon send you a message</h6>
                                        <small>15 minutes ago</small>
                                    </div>
                                </div>
                            </a>
                            <hr class="dropdown-divider">
                            <a href="#" class="dropdown-item">
                                <div class="d-flex align-items-center">
                                    <img class="rounded-circle" src="assets/img/avt.jpg" alt=""
                                        style="width: 40px; height: 40px; object-fit: cover;">
                                    <div class="ms-2">
                                        <h6 class="fw-normal mb-0">Jhon send you a message</h6>
                                        <small>15 minutes ago</small>
                                    </div>
                                </div>
                            </a>
                            <hr class="dropdown-divider">
                            <a href="#" class="dropdown-item text-center">See all message</a>
                        </div>
                    </div>
                    <div class="nav-item dropdown">
                        <a href="#" class="nav-link dropdown-toggle" data-bs-toggle="dropdown">
                            <i class="fa fa-bell me-lg-2"></i>
                            <span class="d-none d-lg-inline-flex">Thông báo</span>
                        </a>
                        <div class="dropdown-menu dropdown-menu-end bg-secondary border-0 rounded-0 rounded-bottom m-0">
                            <a href="#" class="dropdown-item">
                                <h6 class="fw-normal mb-0">Profile updated</h6>
                                <small>15 minutes ago</small>
                            </a>
                            <hr class="dropdown-divider">
                            <a href="#" class="dropdown-item">
                                <h6 class="fw-normal mb-0">New user added</h6>
                                <small>15 minutes ago</small>
                            </a>
                            <hr class="dropdown-divider">
                            <a href="#" class="dropdown-item">
                                <h6 class="fw-normal mb-0">Password changed</h6>
                                <small>15 minutes ago</small>
                            </a>
                            <hr class="dropdown-divider">
                            <a href="#" class="dropdown-item text-center">See all notifications</a>
                        </div>
                    </div>
                     <%				    	
				    	if(kh!=null){ %>
                    <div class="nav-item dropdown">
                        <a href="#" class="nav-link dropdown-toggle" data-bs-toggle="dropdown">
                            <img class="rounded-circle me-lg-2" src="assets/img/avt.jpg" alt="" style="width: 40px; height: 40px; object-fit: cover;">
                            <span class="d-none d-lg-inline-flex"><%=kh.getHoten() %></span>
                        </a>
                        <div class="dropdown-menu dropdown-menu-end bg-secondary border-0 rounded-0 rounded-bottom m-0">
                            <a href="#" class="dropdown-item">My Profile</a>
                            <a href="#" class="dropdown-item">Cài đặt</a>
                            <a href="AdminLogoutController" class="dropdown-item">Đăng xuất</a>
                        </div>
                    </div>
                    <%} else{%>
                    <div class="nav-item dropdown">
                        <a href="#" class="nav-link dropdown-toggle" data-bs-toggle="dropdown">
                            <img class="rounded-circle me-lg-2" src="assets/img/nologinavt.jpg" alt="" style="width: 40px; height: 40px; object-fit: cover;">                            
                        </a>
                        <div class="dropdown-menu dropdown-menu-end bg-secondary border-0 rounded-0 rounded-bottom m-0">
                            <a href="AdminRegisterController" class="dropdown-item">Đăng ký</a>
                            <a href="AdminLoginController" class="dropdown-item">Đăng nhập</a>                            
                        </div>
                    </div>
                    <%} %>
                </div>
            </nav>
            <!-- Navbar End -->

			<%
			ArrayList<sachbean> ds = null;
			if (request.getAttribute("ds") != null) {
				ds = (ArrayList<sachbean>) request.getAttribute("ds");
			}
			%>
              <!-- Form Start -->
            <div class="container-fluid pt-4 px-4">
                <div class="row g-4">
                    <div class="col-sm-12 col-xl-8">
                        <div class="bg-secondary rounded h-100 p-4">
                            <h6 class="mb-4" style="text-align: center; font-size: 20px;">QUẢN LÝ SÁCH</h6>
                            <form action='AdminSachController' method='post'>
                            <div>
                                <div class="mb-3">
                                    <label class="form-label" style="color: #fff;">
                                        Mã Sách
                                    </label>
                                    <input type="text" name='txtms' class="form-control" 
                                    	value='<%=ds != null ? ds.get(0).getMasach() : ""%>' required>
                                </div>
                                <div class="mb-3">
                                    <label class="form-label" style="color: #fff;">
                                        Tên Sách
                                    </label>
                                    <input type="text" name='txtts' class="form-control"
                                    	value='<%=ds != null ? ds.get(0).getTensach() : ""%>' required>
                                </div>
                                <div class="mb-3">
                                    <label class="form-label" style="color: #fff;">
                                        Tác Giả
                                    </label>
                                    <input type="text" name='txttg' class="form-control"
                                    	value='<%=ds != null ? ds.get(0).getTacgia() : ""%>' required>
                                </div>
                                <div class="mb-3">
                                    <label class="form-label" style="color: #fff;">
                                        Số Lượng
                                    </label>
                                    <input type="text" name='txtsl' class="form-control"
                                    	value='<%=ds != null ? ds.get(0).getSoluong() : ""%>' required>
                                </div>
                                <div class="mb-3">
                                    <label class="form-label" style="color: #fff;">
                                        Giá
                                    </label>
                                    <input type="text" name='txtg' class="form-control"
                                    	value='<%=ds != null ? ds.get(0).getGia() : ""%>' required>
                                </div>
                                <div class="mb-3">
                                    <label class="form-label" style="color: #fff;">
                                        Mã Danh Mục
                                    </label>
                                    <select class="form-select" name='txtml'>
                                    <%
									ArrayList<loaibean> dsloai = (ArrayList<loaibean>) request.getAttribute("dsloai");
									int sl = dsloai.size();
									for (loaibean l : dsloai) {
										if (dsloai != null && dsloai.get(0).getMaloai().equals(l.getMaloai())) {
									%>
                                        <option value='<%=l.getMaloai()%>' selected><%=l.getMaloai()%></option>
                                        <%
										} else {
										%>
                                        <option value='<%=l.getMaloai()%>'><%=l.getTenloai()%></option>  
                                        <%}}%>                                    
                                    </select>
                                </div> 
                                <div class="mb-3">
                                    <label class="form-label" style="color: #fff;">
                                        Ảnh
                                    </label>
                                    <form method="post" action="uploadAnh" enctype="multipart/form-data">
                                    	<input class="form-control bg-dark" type="file" name='txta'
                                    		value='<%=ds != null ? ds.get(0).getAnh() : ""%>' required>
                                    </form>
                                </div>
                                <div style="display: flex; justify-content: flex-end;">
                                    <button type="submit" class="btn btn-primary"
                                        style="margin-right: 16px; width: 20%;" name='butsua' value='sua'>
                                        Sửa
                                    </button>
                                    <button type="submit" class="btn btn-success" style=" width: 20%;" name='butthem' value='them'>
                                        Thêm
                                    </button>
                                </div>
                                </div>
                            </form>
                        </div>
                    </div>
                    <div class="col-sm-12 col-md-6 col-xl-4">
                        <div class="bg-secondary rounded p-4">
                            <div class="d-flex align-items-center justify-content-between mb-4">
                                <h6 class="mb-0">Calender</h6>
                                <a href="">Show All</a>
                            </div>
                            <div id="calender"></div>
                        </div>
                        <div class="bg-secondary rounded p-4" style="margin-top: 44px;">
                            <div class="d-flex align-items-center justify-content-between mb-4">
                                <h6 class="mb-0">To Do List</h6>
                                <a href="">Show All</a>
                            </div>
                            <div class="d-flex mb-2">
                                <input class="form-control bg-dark border-0" type="text" placeholder="Enter task">
                                <button type="button" class="btn btn-primary ms-2">Add</button>
                            </div>
                            <div class="d-flex align-items-center border-bottom py-2">
                                <input class="form-check-input m-0" type="checkbox">
                                <div class="w-100 ms-3">
                                    <div class="d-flex w-100 align-items-center justify-content-between">
                                        <span>Short task goes here...</span>
                                        <button class="btn btn-sm"><i class="fa fa-times"></i></button>
                                    </div>
                                </div>
                            </div>
                            <div class="d-flex align-items-center border-bottom py-2">
                                <input class="form-check-input m-0" type="checkbox">
                                <div class="w-100 ms-3">
                                    <div class="d-flex w-100 align-items-center justify-content-between">
                                        <span>Short task goes here...</span>
                                        <button class="btn btn-sm"><i class="fa fa-times"></i></button>
                                    </div>
                                </div>
                            </div>
                            <div class="d-flex align-items-center border-bottom py-2">
                                <input class="form-check-input m-0" type="checkbox" checked>
                                <div class="w-100 ms-3">
                                    <div class="d-flex w-100 align-items-center justify-content-between">
                                        <span><del>Short task goes here...</del></span>
                                        <button class="btn btn-sm text-primary"><i class="fa fa-times"></i></button>
                                    </div>
                                </div>
                            </div>
                            <div class="d-flex align-items-center border-bottom py-2">
                                <input class="form-check-input m-0" type="checkbox">
                                <div class="w-100 ms-3">
                                    <div class="d-flex w-100 align-items-center justify-content-between">
                                        <span>Short task goes here...</span>
                                        <button class="btn btn-sm"><i class="fa fa-times"></i></button>
                                    </div>
                                </div>
                            </div>
                            <div class="d-flex align-items-center pt-2">
                                <input class="form-check-input m-0" type="checkbox">
                                <div class="w-100 ms-3">
                                    <div class="d-flex w-100 align-items-center justify-content-between">
                                        <span>Short task goes here...</span>
                                        <button class="btn btn-sm"><i class="fa fa-times"></i></button>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>                                                               
                </div>
            </div>
            <!-- Form End -->
            <!-- Table Start -->
            <div class="container-fluid pt-4 px-4">
                <div class="bg-secondary text-center rounded p-4">
                    <div class="d-flex align-items-center justify-content-between mb-4">
                        <h6 class="mb-0">Danh Mục</h6>
                        <a href="">Show All</a>
                    </div>
                    <div class="table-responsive">
                        <table class="table text-start align-middle table-bordered table-hover mb-0">
                            <thead>
                                <tr class="text-white">                                
                                    <th scope="col">Mã Sách</th>
                                    <th scope="col">Tên Sách</th>
                                    <th scope="col">Tác Giả</th>
                                    <th scope="col">Số Lượng</th>
                                    <th scope="col">Giá</th>
                                    <th scope="col">Ảnh</th>
                                    <th scope="col">Mã Loại</th>
                                    <th colspan="2">Thao Tác</th>
                                </tr>
                            </thead>
                            <%
							ArrayList<sachbean> dssach = (ArrayList<sachbean>) request.getAttribute("dssach");
							int ss = dssach.size();
							for (sachbean s : dssach) {
							%>
                            <tbody>
                                <tr>                                    
                                    <td><%=s.getMasach() %></td>
                                    <td><%=s.getTensach() %></td>
                                    <td><%=s.getTacgia() %></td>
                                    <td><%=s.getSoluong() %></td>
                                    <td><%=s.getGia() %></td>
                                    <td><%=s.getAnh() %></td>
                                    <td><%=s.getMaloai() %></td>
                                    <td style="text-align: center;">
                                    	<a class="btn btn-sm btn-primary" href="AdminSachController?butxoa=<%=s.getMasach()%>&tab=delete">
                                    		Xóa
                                    	</a>
                                    </td>
                                    <td style="text-align: center;">
                                    	<a class="btn btn-sm btn-success" href="AdminSachController?ms=<%=s.getMasach()%>">
                                    		Chọn
                                    	</a>
                                    </td>
                                </tr>
                                <%} %>                               
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
            <!-- Table End -->
            <!-- Footer Start -->
            <div class="container-fluid pt-4 px-4">
                <div class="bg-secondary rounded-top p-4">
                    <div class="row">
                        <div class="col-12 col-sm-6 text-center text-sm-start">
                            &copy; <a href="#">Nguyễn Tâm Phước</a>, All Right Reserved.
                        </div>
                        <div class="col-12 col-sm-6 text-center text-sm-end">
                            <!--/*** This template is free as long as you keep the footer author’s credit link/attribution link/backlink. If you'd like to use the template without the footer author’s credit link/attribution link/backlink, you can purchase the Credit Removal License from "https://htmlcodex.com/credit-removal". Thank you for your support. ***/-->
                            Designed By <a href="https://htmlcodex.com">Nguyễn Tâm Phước</a>
                            <br>Distributed By: <a href="https://themewagon.com" target="_blank">Nguyễn Tâm Phước</a>
                        </div>
                    </div>
                </div>
            </div>
            <!-- Footer End -->
        </div>
        <!-- Content End -->


        <!-- Back to Top -->
        <a href="#" class="btn btn-lg btn-primary btn-lg-square back-to-top"><i class="bi bi-arrow-up"></i></a>
    </div>

    <!-- JavaScript Libraries -->
    <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"></script>
    <script src="lib/chart/chart.min.js"></script>
    <script src="lib/easing/easing.min.js"></script>
    <script src="lib/waypoints/waypoints.min.js"></script>
    <script src="lib/owlcarousel/owl.carousel.min.js"></script>
    <script src="lib/tempusdominus/js/moment.min.js"></script>
    <script src="lib/tempusdominus/js/moment-timezone.min.js"></script>
    <script src="lib/tempusdominus/js/tempusdominus-bootstrap-4.min.js"></script>

    <!-- Template Javascript -->
    <script src="js/main.js"></script>
</body>

</html>