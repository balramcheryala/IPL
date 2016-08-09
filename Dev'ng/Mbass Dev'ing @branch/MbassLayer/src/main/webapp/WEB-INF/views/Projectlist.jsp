<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page import="java.util.logging.Logger"%>
<%-- <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>

<body bgcolor="Coral">
 <h3 align=center><font color=yellow>WELCOME TO MBASS LAYER !!!</font></h3>
<form:form method="GET" action="projectcreation.html"  commandName="projectcreation"> 
<table>
<tr>
			<td><input type="submit" value="CREATE NEW PROJECT" /></td>
</tr>
</table>
</form:form> 
	
</body>

</html>
 --%>
<html>
<head>
<title>Popup contact form</title>
<!-- <link href="css/elements.css" rel="stylesheet"> -->
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/elements.css" />" />
<script type="text/javascript"
	src="<c:url value="/resources/js/my_js.js" />"></script>
</head>
<!-- Body Starts Here -->
<body id="body" style="overflow: hidden;" bgcolor="Gold">
	<style>
body {
	background-color: FloralWhite;
	margin: 48px 0px 0px 64px;
}

div#topdiv {
	position: fixed;
	top: 0px;
	left: 0px;
	width: 100%;
	color: white;
	background: DarkMagenta;
	padding: 10px;
}
</style>
<div class="scrollD">
	<div id="xyz">
		<div id="topdiv">
			<img src="<c:url value="resources/images/bridgelabz.png" />" alt=" "
				style="width: 100px; height: 24px;"><strong>BridgeLabz</strong>
		</div>
		<div id="container">
			<header></header>
			<main>
			<section class="half"></section>
			<section class="half"></section>
			</main>
		</div>

		<br>
		<center>
			<h1 class="main">
				<font color=coral>WELCOME TO MBAAS LAYER !!!</font>
			</h1>
		</center>
		<!-- <div class="col-sm-6"> -->
		<br>
		<center>
			<button id="popup" onclick="div_show()">
				<h2 class="new_project">CREATE NEW PROJECT</h2>
			</button>
		</center>
		<!-- </div> -->
	</div>
	<!-- Display Popup Button -->
	<div id="abc">
		<!-- Popup Div Starts Here -->
		<div id="popupContact">
			<!-- Contact Us Form -->
			<!-- id="form"  name="form" -->
			<%
				Logger logger = Logger.getLogger(this.getClass().getName());
			%>

			<%-- <form method="POST" action="project" modelAttribute="projectcreate" commandName="projectcreate">  --%>
			<form action="#" id="form" method="post" name="form">
				<img id="close"
					src="<c:url value="/resources/images/close-button-icon.png" />"
					alt="" onclick="div_hide()" />
				<%-- <img src="<c:url value="/resources/images/left_arrow.png" />" alt="" /> --%>
				<%
					logger.info("Evaluating date ");
				%>
				<h2>Create a project</h2>
				<hr>
				<input id="name" name="name" placeholder="My Project"
					type="text">
				<%-- <form:input path="projectName"/> --%>
				<!-- <input id="email" name="email" placeholder="Email" type="text">
        		<textarea id="msg" name="message" placeholder="Message"></textarea> -->
				<!-- <button id="submit" onclick="check_empty()" >Create Project</button>  -->
				<!-- <button id="close" onclick="div_hide()" >Cancel</button>  -->
				<a href="javascript:%20check_empty()" id="submit">Create Project</a>
				<!-- <href="javascript:%20div_hide()" input type="close"  value="Cancel" />  -->
			</form>
		</div>
		<!-- Popup Div Ends</div> Here -->
	</div>
	<%-- <c:out value="${projectname.projectName}"/> --%>
	<!-- </div> -->
	<!-- <div class> -->
	<!-- <a href="/home/bridgelabz/Desktop/sport.txt">download</a>
 -->	
 <%-- <a href="<c:url value="/resources/txt/sport.txt" />" download>Download</a --%>>
 <!-- <a href="/home/bridgelabz/Desktop/sport.txt" download>
  download
</a> -->
<!-- <button type="submit">Download!</button> -->
</form>
	<c:if test="${!empty Projectlist}">
		<div class="wrapper">
			<c:forEach items="${Projectlist}" var="projectname" varStatus="stat">
				<%
					logger.info("Entering into loop");
				%>

				<!-- <div class="wrapper"> -->
				<a class="ripplelink cyan" href="overview?projectname=${projectname.projectName}">${projectname.projectName}</a>
				<!-- </div> -->

			</c:forEach>
		</div>
	</c:if>
	<!-- </div> --><footer></footer>
	</div>
	
</body>
</html>