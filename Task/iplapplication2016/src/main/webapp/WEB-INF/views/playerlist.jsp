<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <link href="http://netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/css/bootstrap-combined.no-icons.min.css" rel="stylesheet">
    <link href="http://netdna.bootstrapcdn.com/font-awesome/3.1.1/css/font-awesome.min.css" rel="stylesheet">
	<script type="text/javascript" src="https://code.jquery.com/jquery-2.1.3.min.js"></script>
	<script type="text/javascript" src="<c:url value="/resources/js/search.js" />"></script>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>DD Player List</title>
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/playerlist.css" />" />
	</head>
	<body>
	<form action="playerlist" method="post">
		<table border="1" cellpadding="2" width="70%" class="search-table">
		<thead>
			<tr>
				<!-- <th><h4 style="color:#00cccc;"><I><a href="search?by=name&q=">TEAM</I></h4></th> -->
				<th><h4 style="color:#00cccc;"><I><!-- <a href="search?by=name&q="> -->NAME</I></h4></th>
				<th><h4 style="color:#00cccc;"><I><!-- <a href="search?by=role&q="> -->ROLE</I></h4></th>
				<th><h4 style="color:#00cccc;"><I><!-- <a href="search?by=batting&q="> -->BATTING</I></h4></th>
				<th><h4 style="color:#00cccc;"><I><!-- <a href="search?by=bowler&q="> -->BOWLING</I></h4></th>
				<th><h4 style="color:#00cccc;"><I><!-- <a href="search?by=nation&q="> -->NATION</I></h4></th>
				<th><h4 style="color:#00cccc;"><I><!-- <a href="search?by=dob&q="> -->DATE OF BIRTH</I></h4></th>
			</tr>
			</thead>
			<c:forEach var="playerlist" items="${playerlist}">

				<tr>
					<%-- <td>${playerlist.team}</td> --%>
					<td>${playerlist.name}</td>
					<td>${playerlist.role}</td>
					<td>${playerlist.batting}</td>
					<td>${playerlist.bowler}</td>
					<td>${playerlist.nation}</td>
					<td>${playerlist.dob}</td>

				</tr>

			</c:forEach>
		</table>
		<br />
		</form>
</body>
</html>