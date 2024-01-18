<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <title>Đăng nhập tài khoản  - Mua sắm Online | Shopee Việt Nam</title>
    
    <meta content="width=device-width, initial-scale=1.0" name="viewport">
    <meta content="" name="keywords">
    <meta content="" name="description">

    <!-- Favicon -->
    <link href="img/favicon.ico" rel="icon">
	<link rel="icon" href="./assets/img/logoshopee-icon.png">
    <!-- Google Web Fonts -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Open+Sans:wght@400;600&family=Roboto:wght@500;700&display=swap" rel="stylesheet"> 
    
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
        <div id="spinner" class="show bg-dark position-fixed translate-middle w-100 vh-100 top-50 start-50 d-flex align-items-center justify-content-center">
            <div class="spinner-border text-primary" style="width: 3rem; height: 3rem;" role="status">
                <span class="sr-only">Loading...</span>
            </div>
        </div>
        <!-- Spinner End -->


        <!-- Sign Up Start -->
        <div class="container-fluid">
            <div class="row h-100 align-items-center justify-content-center" style="min-height: 100vh;">
                <div class="col-12 col-sm-8 col-md-6 col-lg-5 col-xl-4">
                    <div class="bg-secondary rounded p-4 p-sm-5 my-4 mx-3">
                        <div class="d-flex align-items-center justify-content-between mb-3">
                            <a href="AdminXacNhanController" class="">
                                <h3 class="text-primary">Shopee</h3>
                            </a>
                            <h3>Đăng nhập</h3>
                        </div>
	                    <span style="font-size: 14px; color: #EB1616;">
							<%
							if (request.getParameter("war") != null)
								out.print(request.getParameter("war"));
							%>
						</span>
						<%				
						String kt = (String) session.getAttribute("login");
						if(kt == null){
						%>
                        <form action="AdminLoginController" method="post">
	                        <div class="form-floating mb-3">
	                            <input type="text" name="un" class="form-control" id="floatingText" placeholder="Email/Số diện thoại/Tên đăng nhập">
	                            <label for="floatingText">Tên đăng nhập</label>
	                        </div>	                        
	                        <div class="form-floating mb-4">
	                            <input type="password" name="pass" class="form-control" id="floatingPassword" placeholder="Mật khẩu">
	                            <label for="floatingPassword">Mật khẩu</label>
	                        </div>                        
	                        <div class="d-flex align-items-center justify-content-between mb-4">
	                            <div class="form-check">
	                                <input type="checkbox" class="form-check-input" id="exampleCheck1">
	                                <label class="form-check-label" for="exampleCheck1">Kiểm tra</label>
	                            </div>
	                            <a href="">Quên mật khẩu</a>
	                        </div>
	                        <button type="submit" class="btn btn-primary py-3 w-100 mb-4">Đăng nhập</button>
                        </form>
                        <%} %>
                        <p class="text-center mb-0">Bạn mới biết đến Shopee? <a href="AdminRegisterController">Đăng ký</a></p>
                    </div>
                </div>
            </div>
        </div>
        <!-- Sign Up End -->
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