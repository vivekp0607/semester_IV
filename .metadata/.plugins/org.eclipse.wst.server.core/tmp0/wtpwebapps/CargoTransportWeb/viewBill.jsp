<%@page import="cargo.*"%>
<%@page import="java.sql.*"%>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <title>Logistica </title>
    <meta content="width=device-width, initial-scale=1.0" name="viewport">
    <meta content="" name="keywords">
    <meta content="" name="description">

    <!-- Favicon -->
    <link href="img/favicon.ico" rel="icon">

    <!-- Google Web Fonts -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Inter:wght@400;600&family=Roboto:wght@500;700&display=swap" rel="stylesheet">

    <!-- Icon Font Stylesheet -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css" rel="stylesheet">

    <!-- Libraries Stylesheet -->
    <link href="lib/animate/animate.min.css" rel="stylesheet">
    <link href="lib/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet">

    <!-- Customized Bootstrap Stylesheet -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- Template Stylesheet -->
    <link href="css/style.css" rel="stylesheet">
</head>

<body>
    <!-- Spinner Start -->
    <div id="spinner" class="show bg-white position-fixed translate-middle w-100 vh-100 top-50 start-50 d-flex align-items-center justify-content-center">
        <div class="spinner-grow text-primary" style="width: 3rem; height: 3rem;" role="status">
            <span class="sr-only">Loading...</span>
        </div>
    </div>
    <!-- Spinner End -->


    <!-- Navbar Start -->
    <nav class="navbar navbar-expand-lg bg-white navbar-light shadow border-top border-5 border-primary sticky-top p-0">
        <a href="index.html" class="navbar-brand bg-primary d-flex align-items-center px-4 px-lg-5">
            <h2 class="mb-2 text-white">Logistica</h2>
        </a>
        <button type="button" class="navbar-toggler me-4" data-bs-toggle="collapse" data-bs-target="#navbarCollapse">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarCollapse">
            <div class="navbar-nav ms-auto p-4 p-lg-0">
                <a href="usermain.html" class="nav-item nav-link ">Booking</a>
                <a href="admin.html" class="nav-item nav-link">View Location</a>
                 <div class="nav-item dropdown">
                    <a href="#" class="nav-link active dropdown-toggle" data-bs-toggle="dropdown">View</a>
                    <div class="dropdown-menu fade-up m-0">
                        <a href="viewCargo.jsp" class="dropdown-item">View Cargo</a>
                        <a href="userbookingstatus.jsp" class="dropdown-item">Booking Status</a>
                    </div>
                </div>
                <a href="userlogin.html" class="nav-item nav-link">Login</a>
            </div>
            <h4 class="m-0 pe-lg-5 d-none d-lg-block"><i class="fa fa-headphones text-primary me-3"></i>+91 9881678837</h4>
        </div>
    </nav>
    <!-- Navbar End -->
    

<div class="container-xxl py-5">
    <div class="container py-5">
        <p style="text-align: center; font-size: 50px;">Booking Bill </p>
        <div style="align-items: center; padding-left:5cm; padding-right: 5cm;" >
            <div class="bg-light text-center p-5 wow fadeIn" data-wow-delay="0.5s">
                  
                  <table style="width:100%">
                    <tr>
                      <th>Booking ID</th>
                      <th>Name</th>
                      <th>Company name</th>
                      <th>Source</th>
                      <th>Material</th>
                      <th>Quantity</th>
                      <th>Total Amount</th>
                      
                    </tr>
                   <%
			  int id = Integer.parseInt(request.getParameter("booking_id"));
			  	Connection con = ConnectDB.connect();
			  	try
			  	{
			  	
			  		PreparedStatement ps = con.prepareStatement("select * from booking_tbl where booking_id = ? ");
			  		ps.setInt(1, id);
			  		ResultSet rs = ps.executeQuery();
			  		while(rs.next())
			  		{
			  			int amount =0;
			  			if(rs.getString("material").equals("Regular like Fabrics,etc"))
			  			{
			  				amount=Integer.parseInt(rs.getString("quantity"))*150;
			  			}
			  			else if(rs.getString("material").equals("Glassy"))
						{
			  				amount=Integer.parseInt(rs.getString("quantity"))*500;
						}
			  			else if(rs.getString("material").equals("Furniture"))
						{
			  				amount=Integer.parseInt(rs.getString("quantity"))*400;
						}
			  			else if(rs.getString("material").equals("Food , Medicine"))
						{
			  				amount=Integer.parseInt(rs.getString("quantity"))*400;
						}
			  			else
						{
			  				amount=Integer.parseInt(rs.getString("quantity"))*100;
						}
			  			
			  %>
				  			 <tr>
				  			 	<td><%=rs.getString("booking_id")%></td>
							    <td><%=rs.getString("user_name")%></td>
							    <td><%=rs.getString("user_company") %></td>
							    <td><%=rs.getString("source") %></td>
							    <td><%=rs.getString("material")%></td>
							    <td><%=rs.getString("quantity")%></td>
								<td><%=amount%></td>
							   </tr>
			  			
			  <%
			  		}
			  	}
			  	catch(Exception e)
			  	{
			  		e.printStackTrace();
			  	}
			  
			  %>
			  
                  </table>
            </div>
        </div>
    </div>
</div>


   <!-- Page Header Start -->
   
   <div class="container-fluid page-header py-5" style="margin-bottom: 6rem;">
    <div class="container py-5">
        <h1 class="display-3 text-white mb-3 animated slideInDown">Logistica</h1>
        <nav aria-label="breadcrumb animated slideInDown">
            <ol class="breadcrumb">
                <h5 style="color: azure;">Cargo Transport</h5>
            </ol>
        </nav>
    </div>
</div>
<!-- Page Header End -->




    
    <!-- Footer End -->


    <!-- Back to Top -->
    <a href="#" class="btn btn-lg btn-primary btn-lg-square rounded-0 back-to-top"><i class="bi bi-arrow-up"></i></a>


    <!-- JavaScript Libraries -->
    <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"></script>
    <script src="lib/wow/wow.min.js"></script>
    <script src="lib/easing/easing.min.js"></script>
    <script src="lib/waypoints/waypoints.min.js"></script>
    <script src="lib/counterup/counterup.min.js"></script>
    <script src="lib/owlcarousel/owl.carousel.min.js"></script>

    <!-- Template Javascript -->
    <script src="js/main.js"></script>
</body>

</html>