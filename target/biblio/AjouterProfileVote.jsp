<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">

<head>

	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">

	<!-- Title Of Site -->
	
	<title>Jvoting</title>
	
	<!-- CSS Plugins -->
	<link rel="stylesheet" type="text/css" href="bootstrap/css/bootstrap.min.css" media="screen">	
	<link href="css/animate.css" rel="stylesheet">
	<link href="css/main.css" rel="stylesheet">
	<link href="css/component.css" rel="stylesheet">
	
	<!-- CSS Font Icons -->
	<link rel="stylesheet" href="icons/linearicons/style.css">
	<link rel="stylesheet" href="icons/font-awesome/css/font-awesome.min.css">
	<link rel="stylesheet" href="icons/simple-line-icons/css/simple-line-icons.css">
	<link rel="stylesheet" href="icons/ionicons/css/ionicons.css">
	<link rel="stylesheet" href="icons/pe-icon-7-stroke/css/pe-icon-7-stroke.css">
	<link rel="stylesheet" href="icons/rivolicons/style.css">
	<link rel="stylesheet" href="icons/flaticon-line-icon-set/flaticon-line-icon-set.css">
	<link rel="stylesheet" href="icons/flaticon-streamline-outline/flaticon-streamline-outline.css">
	<link rel="stylesheet" href="icons/flaticon-thick-icons/flaticon-thick.css">
	<link rel="stylesheet" href="icons/flaticon-ventures/flaticon-ventures.css">

	<!-- CSS Custom -->
	<link href="css/style.css" rel="stylesheet">

	<!--[if lt IE 9]>
	
		<script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
		<script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
	
	<![endif]-->
	
</head>

<body class="not-transparent-header">

	<!-- start Container Wrapper -->
	<div class="container-wrapper">

		<!-- start Header -->
		<header id="header">
			<!-- start Navbar (Header) -->
			<nav class="navbar navbar-default navbar-fixed-top navbar-sticky-function">

				<div class="container">

					<div id="navbar" class="navbar-nav-wrapper navbar-arrow">

						<ul class="nav navbar-nav" id="responsive-menu">

							<li>
								<a href="accueil.jsp">Accueil</a>
								
							</li>

							<li>
								<a href="vote.jsp">Vote</a>
							</li>
							
							<li>
								<a href="vote.jsp">Add Profile</a>
								<ul>
									<li><a href="UrlDeProfileVote.jsp">Add Profile - URL</a></li>
									<li><a href="AjouterProfileVote.jsp">Add Profile - LOCAL</a></li>
								</ul>
							</li>
							
							<li>
								<a href="listesProfilVotes.jsp">Vote Profile</a>
							</li>
						</ul>

					</div><!--/.nav-collapse -->

					<div class="nav-mini-wrapper">
						<ul class="nav-mini sign-in">
							<li><a href="index.jsp">login</a></li>
							<li><a href="index.jsp">enregistrer</a></li>
						</ul>
					</div>

				</div>

				<div id="slicknav-mobile"></div>

			</nav>
			<!-- end Navbar (Header) -->
		</header>
		<!-- end Header -->
		</header>
		<!-- end Header -->

		<!-- start Main Wrapper -->
		<div class="main-wrapper">
		
			<!-- start breadcrumb -->
			<div class="breadcrumb-wrapper">
			
				<div class="container">
				
					<ol class="breadcrumb-list booking-step">
						<li><a href="index.jsp">Accueil</a></li>
						<li><span>Vote</span></li>
					</ol>
					
				</div>
				
			</div>
			<!-- end breadcrumb -->
			
			<div class="admin-container-wrapper">

				<div class="container">
				
					<div class="GridLex-gap-15-wrappper">
					
						<div class="GridLex-grid-noGutter-equalHeight">
						
							<div class="GridLex-col-3_sm-4_xs-12">
							
								<div class="admin-sidebar">
										
								</div>

							</div>
							
							<div class="GridLex-col-9_sm-8_xs-12">
							
								<div class="admin-content-wrapper">

									<div class="admin-section-title">
									
										<h2>Profile de Vote</h2>
										<p>Ajouter un profile de vote</p>
										
									</div>
									
									<form   action="upload" method="post" enctype="multipart/form-data" >
								
											<div class="row gap-20">
										
												<div class="col-sm-6 col-md-4">
												
													<div class="form-group ">
														<label >Profile</label>
														<input type="file"   name="file">
														<span class="font12 font-italic">** Choisiez votre profile depuis votre ordinateur</span>
													</div>
													
													
													
												</div>
												
												<div class="clear"></div>
												
												<div class="col-sm-12 col-md-8">
												
													<div class="form-group">
														<label>Nom de fichiere:</label>
														<input type="text"   name="nameProfilVote" class="form-control" value="Nom de fichier">
													</div>
													
												</div>
												<div class="clear"></div>
												
												<div class="col-sm-12 mt-10">
													<input type="submit"  value="Envoyer" class="btn btn-primary">
													<a href="restaurant-owner-dashboard.html#" class="btn btn-warning">Annuler</a>
												</div>

											</div>
											
										</form>
									
								</div>

							</div>
							
						</div>

					</div>

				</div>
			
			</div>

				<!-- start footer area -->
				<div class="footer-area-content">
					<!-- Newsletter -->
					<div id="footer-newsletter" class="pt-40 pb-40">
						<div class="container">
							<div class="row">
								<div class="col-md-12 text-center">
									<h3><i class="fa fa-envelope-o"></i>Restez en contact, Rejoignez notre newsletter</h3>
								</div>
							</div>
							<div class="row">
								<div class="col-md-6 col-md-offset-3">
									<div class="newsletter-02">
										<div class="form-group">
											<input class="form-control" placeholder="Entrer ton mail ">
											<button class="btn btn-primary">Souscrire</button>
										</div>
									</div>

								</div>
							</div>
						</div>
					</div>
					<!-- END: Newsletter -->
				
				<div class="bottom-footer">
				
					<div class="container">
					
						<div class="row">
						
							<div class="col-sm-4 col-md-4">
					
								<p class="copy-right">&#169; Université Paris-Dauphine</p>
								
							</div>
							
							<div class="col-sm-4 col-md-4">
							
								<ul class="bottom-footer-menu">
										<li><a href="accueil.jsp">Accueil</a></li>
										<li><a href="vote.jsp">Vote</a></li>
										<li><a href="index.jsp">login</a></li>
										<li><a href="index.jsp">s'enregistrer</a></li>
								</ul>
							
							</div>
							
							<div class="col-sm-4 col-md-4">
								<ul class="bottom-footer-menu for-social">
									<li><a href="index.html#"><i class="ri ri-twitter" data-toggle="tooltip" data-placement="top" title="twitter"></i></a></li>
									<li><a href="index.html#"><i class="ri ri-facebook" data-toggle="tooltip" data-placement="top" title="facebook"></i></a></li>
									<li><a href="index.html#"><i class="ri ri-google-plus" data-toggle="tooltip" data-placement="top" title="google plus"></i></a></li>
									<li><a href="index.html#"><i class="ri ri-youtube-play" data-toggle="tooltip" data-placement="top" title="youtube"></i></a></li>
								</ul>
							</div>
						
						</div>

					</div>
					
				</div>
			
			</footer>
			<!-- end footer -->
			
		</div>
		<!-- end Main Wrapper -->

	</div> <!-- / .wrapper -->
	<!-- end Container Wrapper -->
 
 
<!-- start Back To Top -->
<div id="back-to-top">
   <a href="index.html#"><i class="ion-ios-arrow-up"></i></a>
</div>
<!-- end Back To Top -->


<!-- JS -->
<script type="text/javascript" src="js/jquery-1.11.3.min.js"></script>
<script type="text/javascript" src="js/jquery-migrate-1.2.1.min.js"></script>
<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/bootstrap-modalmanager.js"></script>
<script type="text/javascript" src="js/bootstrap-modal.js"></script>
<script type="text/javascript" src="js/smoothscroll.js"></script>
<script type="text/javascript" src="js/jquery.easing.1.3.js"></script>
<script type="text/javascript" src="js/jquery.waypoints.min.js"></script>
<script type="text/javascript" src="js/wow.min.js"></script>
<script type="text/javascript" src="js/jquery.slicknav.min.js"></script>
<script type="text/javascript" src="js/jquery.placeholder.min.js"></script>
<script type="text/javascript" src="js/bootstrap-tokenfield.js"></script>
<script type="text/javascript" src="js/typeahead.bundle.min.js"></script>
<script type="text/javascript" src="js/bootstrap-select.min.js"></script>
<script type="text/javascript" src="js/jquery-filestyle.min.js"></script>
<script type="text/javascript" src="js/bootstrap-select.js"></script>
<script type="text/javascript" src="js/ion.rangeSlider.min.js"></script>
<script type="text/javascript" src="js/handlebars.min.js"></script>
<script type="text/javascript" src="js/jquery.countimator.js"></script>
<script type="text/javascript" src="js/jquery.countimator.wheel.js"></script>
<script type="text/javascript" src="js/slick.min.js"></script>
<script type="text/javascript" src="js/easy-ticker.js"></script>
<script type="text/javascript" src="js/jquery.introLoader.min.js"></script>
<script type="text/javascript" src="js/jquery.responsivegrid.js"></script>
<script type="text/javascript" src="js/customs.js"></script>


</body>



</html>