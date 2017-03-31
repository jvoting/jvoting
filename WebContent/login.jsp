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
								<a href="index.jsp">Accueil</a>
								
							</li>

							<li>
								<a href="vote.jsp">Vote</a>
							</li>
						</ul>

					</div><!--/.nav-collapse -->

					<div class="nav-mini-wrapper">
						<ul class="nav-mini sign-in">
							<li><a href="login.jsp">login</a></li>
							<li><a href="login.jsp">register</a></li>
						</ul>
					</div>

				</div>

				<div id="slicknav-mobile"></div>

			</nav>
			<!-- end Navbar (Header) -->
		</header>
		<!-- end Header -->

		<!-- start Main Wrapper -->
		<div class="main-wrapper">

			<!-- start hero-header -->
			<div class="breadcrumb-wrapper">
			
				<div class="container">
				
					<ol class="breadcrumb-list">
						<li><a href="index.jsp">Accueil</a></li>
						<li><span>Login</span></li>
					</ol>
					
				</div>
				
			</div>
			<!-- end hero-header -->

			<div class="error-page-wrapper">
		
				<div class="container">

					<div class="row">

							<!-- login container -->

							<div class="login-container">
								<!-- Combined Form Content -->
								<div class="login-container-content">
									<ul class="nav nav-tabs nav-justified">
										<li class="active link-one"><a href="login.jsp#login-block" data-toggle="tab"><i class="fa fa-sign-in"></i>Se connecter</a></li>
										<li class="link-two"><a href="login.jsp#register-block" data-toggle="tab"><i class="fa fa-pencil"></i>S'inscrire</a></li>
										<li class="link-three"><a href="login.jsp#contact-block" data-toggle="tab"><i class="fa fa-envelope"></i>Contact</a></li>
									</ul>
									<div class="tab-content">
										<div class="tab-pane active fade in" id="login-block">
											<!-- Login Block Form -->
											<div class="login-block-form">
												<!-- Heading -->
												<h4>Connectez-vous à votre compte</h4>
												<!-- Border -->
												<div class="bor bg-orange"></div>
												<!-- Form -->
												<form class="form" role="form" 	action="/jvoting/Authentification">
													<!-- Form Group -->
													<div class="form-group">
														<!-- Label -->
														<label class="control-label">Nom d'utilisateur</label>
														<!-- Input -->
														<input name="login" type="text" class="form-control" placeholder="Entrer Nom d'utilisateur">
													</div>
													<div class="form-group">
														<label class="control-label">Mot de passe</label>
														<input name="mdp" type="password" class="form-control" placeholder="Entrer Mot de passe">
													</div>
													<div class="form-group">
													<div class="form-group">
														<!-- Button -->
														<button type="submit" class="btn btn-primary">Se connecter</button>&nbsp;
														<button type="submit" class="btn btn-primary btn-inverse">Réinitialiser</button>
													</div>
													</div>
													<div class="form-group">
														<a href="account-forgot-password-page.html" class="black">Mot de passe oublié ?</a>
													</div>
												</form>
											</div>
										</div>
										<div class="tab-pane fade" id="register-block">
											<div class="register-block-form">
												<!-- Heading -->
												<h4>Créer le nouveau compte</h4>
												<!-- Border -->
												<div class="bor bg-orange"></div>
												<!-- Form -->
												<form class="form" role="form" method="post"action="/jvoting/AddUser">
													<!-- Form Group -->
													<div class="form-group">
														<!-- Label -->
														<label class="control-label">Nom</label>
														<!-- Input -->
														<input name="nom" type="text" class="form-control"  placeholder="Entrer Nom">
													</div>
													<div class="form-group">
														<label class="control-label">Prénom</label>
														<input name="prenom" type="text" class="form-control" placeholder="Entrer Prénom">
													</div>
													<div class="form-group">
														<label class="control-label">Email</label>
														<input name="email" type="text" class="form-control" placeholder="Entrer Email">
													</div>
													<div class="form-group">
														<label class="control-label">Mot de passe</label>
														<input name="password" type="password" class="form-control" placeholder="Enter Password">
													</div>
													<div class="form-group">
														<!-- Buton -->
														<button type="submit" class="btn btn-primary">Soumettre</button>&nbsp;
														<button type="submit" class="btn btn-primary btn-inverse">Réinitialiser</button>
													</div>
												</form>
											</div>
										</div>
										<div class="tab-pane fade" id="contact-block">
											<!-- Contact Block Form -->
											<div class="contact-block-form">
												<h4>Formulaire de contact</h4>
												<!-- Border -->
												<div class="bor bg-orange"></div>
												<!-- Form -->
												<form class="form" role="form">
													<!-- Form Group -->
													<div class="form-group">
														<label class="control-label">Nom</label>
														<input type="text" class="form-control" placeholder="Entrer Nom">
													</div>
													<div class="form-group">
														<label class="control-label">Email</label>
														<input type="text" class="form-control" placeholder="Entrer Email">
													</div>
													<div class="form-group">
														<label class="control-label">Sujet</label>
														<input type="text" class="form-control" placeholder="Entrer votre sujet">
													</div>
													<div class="form-group">
														<label for="comments" class="control-label">Commentaire</label>
														<textarea class="form-control" id="comments" rows="5" placeholder="Entrer Commentaire"></textarea>
													</div>
													<div class="form-group">
														<!-- Buton -->
														<button type="submit" class="btn btn-primary">Soumettre</button>&nbsp;
														<button type="submit" class="btn btn-primary btn-inverse">Réinitialiser</button>
													</div>
												</form>
											</div>
										</div>
									</div>
								</div>
							</div>
					</div>
				
				</div>
			
			</div>

			<!-- start footer -->
			<footer class="footer-wrapper-area">

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
										<li><a href="index.jsp">Accueil</a></li>
										<li><a href="vote.jsp">Vote</a></li>
										<li><a href="login.jsp">login</a></li>
										<li><a href="login.jsp">s'enregistrer</a></li>
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