<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

    <meta charset='utf-8' />
    <meta http-equiv="X-UA-Compatible" content="chrome=1" />
    <link href="http://netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/css/bootstrap-combined.no-icons.min.css" rel="stylesheet">
    <link href="http://netdna.bootstrapcdn.com/font-awesome/3.1.1/css/font-awesome.min.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/bootstrap-filterable.css" />" />
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/bootstrap-editable.css" />" />
    <link href="http://lightswitch05.github.io/filterable/stylesheets/main.css" rel="stylesheet">
    <link href="http://netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/css/bootstrap-combined.no-icons.min.css" rel="stylesheet">
    <link href="http://netdna.bootstrapcdn.com/font-awesome/3.1.1/css/font-awesome.min.css" rel="stylesheet">

	<script type="text/javascript" src="http://code.jquery.com/jquery-1.11.0.min.js"></script> 
	<script type="text/javascript" src="<c:url value="/resources/css/searchbar.css" />"></script>
    <link href="http://netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/css/bootstrap-combined.no-icons.min.css" rel="stylesheet">
    <link href="http://netdna.bootstrapcdn.com/font-awesome/3.1.1/css/font-awesome.min.css" rel="stylesheet">
	<script type="text/javascript" src="https://code.jquery.com/jquery-2.1.3.min.js"></script>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">	
	<script type="text/javascript" src="https://code.jquery.com/jquery-2.1.3.min.js"></script>

	<title>Player List</title>
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/playerlist.css" />" />
	</head>
	<body>
		<div class="container">
      	<div class="row center span10">
        <table id="example-table" class="table table-striped table-hover table-condensed">
		<table border="1" cellpadding="2" width="70%" class="table table-striped table-hover table-condensed">
		<!--
 		<thead>
		<tr>
		<table border="1" cellpadding="2" width="70%" class="search-table">
		<thead>
		<tr>
		</form></th>
		<th><form action="search?by=role&q=" method=""><input type="search"  placeholder ="Search by Role">Name</form></th>
		<th><form action="search?by=role&q=" method=""><input type="search"  placeholder ="Search by Role">ROLE</form></th>
		<th><form action="search?by=batting&q=" method="get"><input type="search" placeholder ="Search by Batting">BATTING STYLE</form></th>
		<th><form action="search?by=bowler&q=" method="get"><input type="search"  placeholder ="Search by Bowling">BOWLING STYLE</form></th>
		<th><form action="search?by=nation&q=" method="get"><input type="search" placeholder ="Search by Nation">NATION</form></th>
		<th><form action="search?by=dob&q=" method="get"><input type="search" placeholder ="Search by Date Of birth">DATE OF BIRTH</form></th>-->
			
 		<thead>
			<tr>
				<th><h4 style="color:#00cccc;"><I><!-- <a href="search?by=name&q="> -->NAME</I></h4></th>
				<th><h4 style="color:#00cccc;"><I><!-- <a href="search?by=role&q="> -->ROLE</I></h4></th>
				<th><h4 style="color:#00cccc;"><I><!-- <a href="search?by=batting&q="> -->BATTING</I></h4></th>
				<th><h4 style="color:#00cccc;"><I><!-- <a href="search?by=bowler&q="> -->BOWLING</I></h4></th>
				<th><h4 style="color:#00cccc;"><I><!-- <a href="search?by=nation&q="> -->NATION</I></h4></th>
				<th><h4 style="color:#00cccc;"><I><!-- <a href="search?by=dob&q="> -->DATE OF BIRTH</I></h4></th>
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
			</form>
			</table>
			</div>
			</div>
		<br/>		
		
		
  <script src="http://ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
  <script src="http://netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/js/bootstrap.min.js"></script>
  <script type="text/javascript" src="<c:url value="/resources/js/bootstrap-editable.min.js" />"></script>
  <script type="text/javascript" src="<c:url value="/resources/js/filterable-utils.js" />"></script>
  <script type="text/javascript" src="<c:url value="/resources/js/filterable-cell.js" />"></script>
  <script type="text/javascript" src="<c:url value="/resources/js/filterable-row.js" />"></script>
  <script type="text/javascript" src="<c:url value="/resources/js/filterable.js" />"></script>
  <script type="text/javascript" src="<c:url value="/resources/js/bootstrap-editable.min.js" />"></script>
  <script type="text/javascript" src="<c:url value="/resources/js/search.js" />"></script>
  <script type="text/javascript">
  $('table').filterable();
  </script>

		
		
		
		
		
</body>
</html>