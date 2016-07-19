<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="http://code.jquery.com/jquery-1.11.0.min.js"></script> 
	<script type="text/javascript" src="<c:url value="/resources/css/searchbar.css" />"></script>
    <link href="http://netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/css/bootstrap-combined.no-icons.min.css" rel="stylesheet">
    <link href="http://netdna.bootstrapcdn.com/font-awesome/3.1.1/css/font-awesome.min.css" rel="stylesheet">
	<script type="text/javascript" src="https://code.jquery.com/jquery-2.1.3.min.js"></script>
	<script type="text/javascript" src="<c:url value="/resources/js/search.js" />"></script>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">	
	<title>Player List</title>
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/playerlist.css" />" />
	</head>
	<body>
		<table border="1" cellpadding="2" width="70%" class="search-table">
		<thead>
		<tr>
		<th><form action="search?by=name&q=" method="get"><input type="search"  placeholder ="NAME"></form></th>
		<th><form action="search?by=role&q=" method="post"><input type="search" placeholder ="ROLE"></form></th>
		<th><form action="search?by=batting&q=" method="post"><input type="search" placeholder ="BATTING"></form></th>
		<th><form action="search?by=bowler&q=" method="post"><input type="search"  placeholder ="BOWLING"></form></th>
		<th><form action="search?by=nation&q=" method="post"><input type="search" placeholder ="NATION"></form></th>
		<th><form action="search?by=dob&q=" method="post"><input type="search" placeholder ="DATE OF BIRTH"></form></th>
		</tr>
			
			</thead>
			<c:forEach var="playerslist" items="${playerslist}">

				<tr>
					<td>${playerslist.name}</td>
					<td>${playerslist.role}</td>
					<td>${playerslist.batting}</td>
					<td>${playerslist.bowler}</td>
					<td>${playerslist.nation}</td>
					<td>${playerslist.dob}</td>

				</tr>
			</c:forEach>
		</table>
		<br/>
</body>
</html>