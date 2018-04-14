<%
     String empid=(String)session.getAttribute("empid");
     String empname=(String)session.getAttribute("empname");
     String emppassword=(String)session.getAttribute("emppassword");
        if(empid==null||empname==null||emppassword==null){
        out.println("<script type=\"text/javascript\">");
        out.println("alert('You Are Not Logged In...Login First');");
        out.println("location='Index.jsp';");
        out.print("</script>");
    }
%>
<!DOCTYPE html>
<html lang="en">
	<head>
	<title>Home</title>
	<meta charset="utf-8">
	<meta name = "format-detection" content = "telephone=no" />
	<link rel="icon" href="images/favicon.ico" type="image/x-icon">
	<link rel="stylesheet" href="css/grid.css">
	<link rel="stylesheet" href="css/style.css">
	<link rel="stylesheet" href="css/camera.css">
	<link rel="stylesheet" href="css/owl.carousel.css">

	<script src="js/jquery.js"></script>
	<script src="js/jquery-migrate-1.2.1.js"></script>
	<script src='js/camera.js'></script>
	<script src="js/owl.carousel.js"></script>
	<script src="js/jquery.stellar.js"></script>
	<script src="js/script.js"></script>
	<!--[if (gt IE 9)|!(IE)]><!-->
	<script src="js/jquery.mobile.customized.min.js"></script>
	<script src="js/wow.js"></script>
	<script>
		$(document).ready(function () {
			if ($('html').hasClass('desktop')) {
				new WOW().init();
			}
		});
	</script>
	<!--<![endif]-->
	<!--[if lt IE 8]>
	<div style=' clear: both; text-align:center; position: relative;'>
	 <a href="http://windows.microsoft.com/en-US/internet-explorer/products/ie/home?ocid=ie6_countdown_bannercode">
		 <img src="images/ie8-panel/warning_bar_0000_us.jpg" border="0" height="42" width="820" alt="You are using an outdated browser. For a faster, safer browsing experience, upgrade for free today." />
	 </a>
	</div>
	<![endif]-->
	<!--[if lt IE 9]>
		<script src="js/html5shiv.js"></script>
		<link rel="stylesheet" type="text/css" media="screen" href="css/ie.css">
	<![endif]-->
	</head>
<body class="index">
<!--==============================header=================================-->
<header id="header">
	<div id="stuck_container">
		<div class="container">
			<div class="row">
				<div class="grid_12">
					<h1><a href="Home.jsp">iBANK</a></h1>
					<nav>
						<ul class="sf-menu">
							<li class="current"><a href="#">Home</a></li>
							
							<li >
								<a href="#">Registration</a>
								<ul>
									<li><a href="NewCustomer.jsp">New Customer</a></li>                                                                    
									<li><a href="NewAccount.jsp">New Account</a></li>
								</ul>
							</li>

							<li >
								<a href="#">Transfer Funds</a>
								<ul>
									<li><a href="Deposit.jsp">Deposit Money</a></li>
									<li><a href="Withdraw.jsp">Withdraw Money</a></li>
									<li><a href="Transfer.jsp">Transfer Money</a></li>
								</ul>
							</li>
							<li>
                                                            <a href="#">Account Details</a>
                                                            <ul>
                                                                <li><a href="ViewCustomerInfo.jsp">Customer Details</a></li>
                                                                <li><a href="ShowTransaction.jsp">View Transactions</a></li>
                                                            </ul>
                                                        </li>
							<li>
                                                            <a href="#">Loan</a>
                                                            <ul>
                                                                <li><a href="GetLoan.jsp">Get Loan</a></li>
                                                                <li><a href="GetLoanInfo.jsp">View Loan Info</a></li>
                                                            </ul>                                                            
                                                        </li>
							<li><a href="#">Close Accounts</a>
                                                            <ul>
                                                                <li><a href="CloseAccount.jsp">Close Account</a></li>
                                                                <li><a href="RemoveCustomer.jsp">Remove Customer</a></li>
                                                            </ul>                                                                                                                    
                                                        </li>
							<li><a href="Logout">Log Out</a></li>
						</ul>
					</nav>
				</div>
			</div>
		</div>
	</div>
</header>

<!--=======content================================-->

<section id="content">
	<div class="full-width-container block-1">
		<div class="camera_container">
			<div id="camera_wrap">
				<div class="item" data-src="images/index_img_slider-1.jpg">
					<div class="camera_caption fadeIn">
						<h3>We will help you in banking</h3>
						<p>Contact Us by</p>
						<a href="#" class="btn bd-ra"><span class="fa fa-envelope-o"></span></a>
						<a href="#" class="btn bd-ra"><span class="fa fa-phone"></span></a>
						<a href="#" class="btn bd-ra"><span class="fa fa-map-marker"></span></a>
					</div>
				</div>
				<div class="item" data-src="images/index_img_slider-2.jpg">
					<div class="camera_caption fadeIn">
						<h3>We will help you in banking</h3>
						<p>Contact Us by</p>
						<a href="#" class="btn bd-ra"><span class="fa fa-envelope-o"></span></a>
						<a href="#" class="btn bd-ra"><span class="fa fa-phone"></span></a>
						<a href="#" class="btn bd-ra"><span class="fa fa-map-marker"></span></a>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="full-width-container block-2">
		<div class="container">
			<div class="row">
				<div class="grid_12">
					<header>
						<h2><span>Welcome to Our iBANK</span></h2>
					</header>
					
					
					<a href="#" class="btn">more</a>
				</div>
			</div>
		</div>
	</div>
	
	
	
</section>

<!--=======footer=================================-->
<footer id="footer">
	<div class="container">
		<div class="row">
			<div class="grid_12 copyright">
				<h2><span>Follow Us</span></h2>
				<a href="#" class="btn bd-ra"><span class="fa fa-facebook"></span></a>
				<a href="#" class="btn bd-ra"><span class="fa fa-tumblr"></span></a>
				<a href="#" class="btn bd-ra"><span class="fa fa-google-plus"></span></a>
				<pre>© <span id="copyright-year"></span> |  Privacy Policy</pre>
			</div>
		</div>
	</div>
	
</footer>
<script>
	jQuery(function(){
		jQuery('#camera_wrap').camera({
			height: '34.58333333333333%',
			thumbnails: false,
			pagination: true,
			fx: 'simpleFade',
			loader: 'none',
			hover: false,
			navigation: false,
			playPause: false,
			minHeight: "139px",
		});
	});
</script>
<script>
	$(document).ready(function() { 
			if ($('html').hasClass('desktop')) {
				$.stellar({
					horizontalScrolling: false,
					verticalOffset: 20,
					resposive: true,
					hideDistantElements: true,
				});
			}
		});
</script>
<script>
	$(document).ready(function() {
		$(".owl-carousel").owlCarousel({
			navigation: true,
			pagination: false,
			items : 3,
			itemsDesktop : [1199,3],
			itemsDesktopSmall : [979,3],
			itemsTablet: [750,1],
			itemsMobile : [479,1],
			navigationText: false
		});
	});
</script>

</body>
</html>