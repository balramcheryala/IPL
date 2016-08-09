<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>${title}</title>

<link rel="stylesheet"
	href="https://storage.googleapis.com/code.getmdl.io/1.0.0/material.indigo-pink.min.css">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link rel="apple-touch-icon" href="apple-touch-icon.png">
<!-- Place favicon.ico in the root directory -->
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/vendor.css" />" />
<!-- Theme initialization -->
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/app-orange.css" />" />
</head>
<body>
	<div class="main-wrapper">
		<div class="app" id="app">
			<header class="header">
			<div class="header-block header-block-collapse hidden-lg-up">
				<button class="collapse-btn" id="sidebar-collapse-btn">
					<i class="fa fa-bars"></i>
				</button>
			</div>
			<div class="header-block header-block-search hidden-sm-down">
				<form role="search">
					<div class="input-container">
						<i class="fa fa-search"></i> <input type="search"
							placeholder="Search">
						<div class="underline"></div>
					</div>
				</form>
			</div>
		
			<div class="header-block header-block-nav">
				<ul class="nav-profile">	
					<li class="notifications new"><a href=""
						data-toggle="dropdown"> <i class="fa fa-bell-o"></i> <sup>
								<span class="counter">8</span>
						</sup>
					</a>
						<div class="dropdown-menu notifications-dropdown-menu">
							<ul class="notifications-container">
								<li><a href="" class="notification-item">
										<div class="img-col">
											<div class="img"
												style="background-image: url('assets/faces/3.jpg')"></div>
										</div>
										<div class="body-col">
											<p>
												<span class="accent">Zack Alien</span> pushed new commit: <span
													class="accent">Fix page load performance issue</span>.
											</p>
										</div>
								</a></li>
								<li><a href="" class="notification-item">
										<div class="img-col">
											<div class="img"
												style="background-image: url('assets/faces/5.jpg')"></div>
										</div>
										<div class="body-col">
											<p>
												<span class="accent">Amaya Hatsumi</span> started new task:
												<span class="accent">Dashboard UI design.</span>.
											</p>
										</div>
								</a></li>
								<li><a href="" class="notification-item">
										<div class="img-col">
											<div class="img"
												style="background-image: url('assets/faces/8.jpg')"></div>
										</div>
										<div class="body-col">
											<p>
												<span class="accent">Andy Nouman</span> deployed new version
												of <span class="accent">NodeJS REST Api V3</span>
											</p>
										</div>
								</a></li>
							</ul>
							<footer>
							<ul>
								<li><a href=""> View All </a></li>
							</ul>
							</footer>
						</div></li>
					<li class="profile dropdown"><a
						class="nav-link dropdown-toggle" data-toggle="dropdown" href="#"
						role="button" aria-haspopup="true" aria-expanded="false">
							<div class="img"
								style="background-image: url('http://tinyurl.com/h9uonzq')">
							</div> <span class="name"> ${user} </span>
					</a>
						<div class="dropdown-menu profile-dropdown-menu"
							aria-labelledby="dropdownMenu1">
							<a class="dropdown-item" href="#"> <i class="fa fa-user icon"></i>
								Profile
							</a> <a class="dropdown-item" href="#"> <i
								class="fa fa-bell icon"></i> Notifications
							</a> <a class="dropdown-item" href="#"> <i
								class="fa fa-gear icon"></i> Settings
							</a>
							<div class="dropdown-divider"></div>
							<a class="dropdown-item" href="login.html"> <i
								class="fa fa-power-off icon"></i> Logout
							</a>
						</div></li>
				</ul>
			</div>
			</header>
			<aside class="sidebar">
			<div class="sidebar-container">
				<div class="sidebar-header">
					<div class="brand">
						<div class="logo">
							<span class="l l1"></span> <span class="l l2"></span> <span
								class="l l3"></span> <span class="l l4"></span> <span
								class="l l5"></span>
						</div>
						${title}
					</div>
				</div>
				<nav class="menu">
				<ul class="nav metismenu" id="sidebar-menu">
					<li><a href="index.html"> <i class="fa fa-home"></i>
							Dashboard
					</a></li>
					<li class="active open"><a href=""> <i
							class="fa fa-th-large"></i> Auth <i class="fa arrow"></i>
					</a>
						<ul>
							<li class="active"><a href="items-list.html"> Users </a></li>
							<li><a href="item-editor.html"> Sign-in Method </a></li>
						</ul></li>
					<li><a href=""> <i class="fa fa-bar-chart"></i> Charts <i
							class="fa arrow"></i>
					</a>
						<ul>
							<li><a href="charts-flot.html"> Flot Charts </a></li>
							<li><a href="charts-morris.html"> Morris Charts </a></li>
						</ul></li>
					<li><a href=""> <i class="fa fa-table"></i> Tables <i
							class="fa arrow"></i>
					</a>
						<ul>
							<li><a href="static-tables.html"> Static Tables </a></li>
							<li><a href="responsive-tables.html"> Responsive Tables
							</a></li>
						</ul></li>
					<li><a href="forms.html"> <i class="fa fa-pencil-square-o"></i>
							Forms
					</a></li>
					<li><a href=""> <i class="fa fa-desktop"></i> UI Elements
							<i class="fa arrow"></i>
					</a>
						<ul>
							<li><a href="buttons.html"> Buttons </a></li>
							<li><a href="cards.html"> Cards </a></li>
							<li><a href="typography.html"> Typography </a></li>
							<li><a href="icons.html"> Icons </a></li>
							<li><a href="grid.html"> Grid </a></li>
						</ul></li>
					<li><a href=""> <i class="fa fa-file-text-o"></i> Pages <i
							class="fa arrow"></i>
					</a>
						<ul>
							<li><a href="login.html"> Login </a></li>
							<li><a href="signup.html"> Sign Up </a></li>
							<li><a href="reset.html"> Reset </a></li>
							<li><a href="error-404.html"> Error 404 App </a></li>
							<li><a href="error-404-alt.html"> Error 404 Global </a></li>
							<li><a href="error-500.html"> Error 500 App </a></li>
							<li><a href="error-500-alt.html"> Error 500 Global </a></li>
						</ul></li>
					<li><a
						href="https://github.com/modularcode/modular-admin-html"> <i
							class="fa fa-github-alt"></i> Theme Docs
					</a></li>
				</ul>
				</nav>
			</div>
			<footer class="sidebar-footer">
			<ul class="nav metismenu" id="customize-menu">
				<li>
					<ul>
						<li class="customize">
							<div class="customize-item">
								<div class="row customize-header">
									<div class="col-xs-4"></div>
									<div class="col-xs-4">
										<label class="title">fixed</label>
									</div>
									<div class="col-xs-4">
										<label class="title">static</label>
									</div>
								</div>
								<div class="row hidden-md-down">
									<div class="col-xs-4">
										<label class="title">Sidebar:</label>
									</div>
									<div class="col-xs-4">
										<label> <input class="radio" type="radio"
											name="sidebarPosition" value="sidebar-fixed"> <span></span>
										</label>
									</div>
									<div class="col-xs-4">
										<label> <input class="radio" type="radio"
											name="sidebarPosition" value=""> <span></span>
										</label>
									</div>
								</div>
								<div class="row">
									<div class="col-xs-4">
										<label class="title">Header:</label>
									</div>
									<div class="col-xs-4">
										<label> <input class="radio" type="radio"
											name="headerPosition" value="header-fixed"> <span></span>
										</label>
									</div>
									<div class="col-xs-4">
										<label> <input class="radio" type="radio"
											name="headerPosition" value=""> <span></span>
										</label>
									</div>
								</div>
								<div class="row">
									<div class="col-xs-4">
										<label class="title">Footer:</label>
									</div>
									<div class="col-xs-4">
										<label> <input class="radio" type="radio"
											name="footerPosition" value="footer-fixed"> <span></span>
										</label>
									</div>
									<div class="col-xs-4">
										<label> <input class="radio" type="radio"
											name="footerPosition" value=""> <span></span>
										</label>
									</div>
								</div>
							</div>
							<div class="customize-item">
								<ul class="customize-colors">
									<li><span class="color-item color-red" data-theme="red"></span>
									</li>
									<li><span class="color-item color-orange"
										data-theme="orange"></span></li>
									<li><span class="color-item color-green"
										data-theme="green"></span></li>
									<li><span class="color-item color-seagreen"
										data-theme="seagreen"></span></li>
									<li><span class="color-item color-blue active"
										data-theme=""></span></li>
									<li><span class="color-item color-purple"
										data-theme="purple"></span></li>
								</ul>
							</div>
						</li>
					</ul>
				</li>
			</ul>
			</footer> </aside>
			<div class="sidebar-overlay" id="sidebar-overlay"></div>
			<article class="content items-list-page">
			<div class="title-search-block">
				<div class="title-block">
					<div class="row">
						<div class="col-md-6">
							<h3 class="title">

								</form>
						</div>
					</div>
					<div class="auth-content">
						<p class="text-xs-center">Add an Email/Password user</p>
						<form id="signup-form" action="/user" method="GET"
							novalidate="">

							<div class="form-group">
								<label for="email">Email</label> <input type="email"
									class="form-control underlined" name="email" id="email"
									placeholder="Enter email address" required="">
							</div>
							<div class="form-group">
								<label for="password">Password</label>
								<div class="row">
									<div class="col-sm-6">
										<input type="password" class="form-control underlined"
											name="password" id="password" placeholder="Enter password"
											required="">
									</div>
								
								</div>
							</div>
							
							<div class="form-group">
								<button type="submit" class="btn btn-block btn-primary">Add
									User</button>
							</div>

						</form>
					</div>
				</div>
				<div class="text-xs-center">
					<a href="/userpage" class="btn btn-secondary rounded btn-sm">
						<i class="fa fa-arrow-left"></i> Back to dashboard
					</a>
				</div>
			</div>
		</div>
		</li>
		<li class="item">
			<div class="item-row">
				<div class="item-col fixed item-col-check">
					<label class="item-check" id="select-all-items"> <span></span>
					</label>
				</div>
				<div class="item-col fixed item-col-img md">
					</a>
				</div>

				<div class="item-col fixed item-col-actions-dropdown">
					<div class="item-actions-dropdown">
						<a class="item-actions-toggle-btn"> <span class="inactive">

								
								</div>
					</div>
				</div>
			</div>
		</li>
		</ul>
	</div>
	</article>
	<!-- /.modal -->
	<div class="modal fade" id="confirm-modal">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title">
						<i class="fa fa-warning"></i> Alert
					</h4>
				</div>
				<div class="modal-body">
					<p>Are you sure want to do this?</p>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-primary" data-dismiss="modal">Yes</button>
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal">No</button>
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal-dialog -->
	</div>
	<!-- /.modal -->
	<!-- Reference block for JS -->
	<div class="ref" id="ref">
		<div class="color-primary"></div>
		<div class="chart">
			<div class="color-primary"></div>
			<div class="color-secondary"></div>
		</div>
	</div>
	<script type="text/javascript"
		src="<c:url value="/resources/js/vendor.js" />"></script>
	<script type="text/javascript"
		src="<c:url value="/resources/js/app.js" />"></script>
	</div>

</body>

</html>
</ul>
