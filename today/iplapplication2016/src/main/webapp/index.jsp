<%@page import="com.bridgelabz.social.FBConnection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	FBConnection fbConnection = new FBConnection();
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<style>

</style>
<head>
<title>${title}</title>
<style>
.button {
	background-color: #4CAF50;
	border: none;
	color: white;
	padding: 15px 32px;
	text-align: center;
	text-decoration: none;
	display: inline-block;
	font-size: 16px;
	margin: 4px 2px;
	cursor: pointer;
}

.h1 {
	color: blue;
}

.p {
	color: green;
}
}
</style>
</head>
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.2/css/bootstrap.min.css">

<!-- Optional theme -->
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.2/css/bootstrap-theme.min.css">

<!-- Latest compiled and minified JavaScript -->
<script
	src="//netdna.bootstrapcdn.com/bootstrap/3.0.2/js/bootstrap.min.js"></script>

<!-- font awesome css -->
<link
	href="//netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css"
	rel="stylesheet">
</head>
<body style="text-align: center; padding: 1em">

	<center>
		<h1 style="color: #800000;">WELCOME TO IPL APPLICATION</h1>
	</center>
	<form class="login_form" name='loginForm'
				action="<c:url value='../j_spring_security_check' />" method='POST'>
		<center>
			<div class="btn-group">
				<a class='btn btn-warning disabled'><i class="fa fa-sign-in"
					style="width: 16px; height: 20px"></i></a> <a class='btn btn-warning '
					href='loginform.html' style="width: 12em"> IPL Login</a>
			</div>
		</center>
	</form>
	<br>
	<div class="btn-group">
		<a class='btn btn-info disabled'><i class="fa fa-user"
			style="width: 16px; height: 20px"></i></a> <a class='btn btn-info '
			href='registrationform.html' style="width: 12em"> IPL
			Registration</a>
	</div>
	<center>
		<h2 style="color: black;">Sign in With Social Networks</h2>
	</center>
	<div class="btn-group">
		<a class='btn btn-info disabled'><i class="fa fa-twitter"
			style="width: 16px; height: 20px"></i></a> <a class='btn btn-info '
			href='#'
			style="width: 12em"> Sign in with Twitter</a>
	</div>
	<div class="btn-group">
		<a class='btn btn-danger disabled'><i class="fa fa-google-plus"
			style="width: 16px; height: 20px"></i></a> <a class='btn btn-danger'
			href='#' style="width: 12em;"> Sign in with Google</a>
	</div>
	<br />
	<br />
	<div class="btn-group">
		<a class='btn btn-primary disabled'><i class="fa fa-facebook"
			style="width: 16px; height: 20px"></i></a> <a class='btn btn-primary '
			href='<%=fbConnection.getFBAuthUrl()%>'
			style="width: 12em"> Sign in with Facebook</a>
	</div>

	<div class="btn-group">
		<a class='btn btn-primary disabled'><i class="fa fa-linkedin"
			style="width: 16px; height: 20px"></i></a> <a class='btn btn-primary '
			href='#' style="width: 12em"> Sign in with
			LinkedIn</a>
	</div>
	<c:url value="../services/signup" var="signupurl" />
	<form class="login_form" name='loginForm'
				action="<c:url value='../j_spring_security_check' />" method='POST'>
				<ul>
					<li><input type="text" class="textbox1" id="username"
						name="j_username" placeholder="Username" required="">
						<p>
							<img src="../images/contact.png" alt="">
						</p></li>
					<li><input type="password" id="password" name="j_password"
						class="textbox2" placeholder="Password">
						<p>
							<img src="../images/lock.png" alt="">
						</p></li>
				</ul>
				<input type="submit" name="Sign In" value="Sign In">
				<div class="clear"></div>
				<label class="checkbox"><input type="checkbox"
					name="checkbox" checked=""><i></i>Remember me</label>
				<div class="forgot">
					<a href="#">forgot password?</a>
				</div>
				<div class="clear"></div>
			</form>
			<c:url value="../services/signup" var="signupurl" />
	<h5>
		<a href="${signupurl}">Don't have an account? Sign Up!</a>
	</h5>
</body>
</html>
