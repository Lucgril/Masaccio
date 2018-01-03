<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<html lang="en">
	<head>
	    <meta charset="UTF-8">
	    <title>Masaccio - Home</title>
	    
	    <script src="../../static/js/jquery.min.js" type="text/javascript"></script>
	    
	    <!-- Latest compiled and minified CSS -->
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
		<!-- Optional theme -->
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
		<!-- Latest compiled and minified JavaScript -->
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
	
		<link href="<c:url value='../../static/css/style.css' />" rel="stylesheet" type="text/css" media="all" />	    
	</head>
	<body>
		<jsp:include page="../includes/menu.jsp" />
		
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<h1>Home</h1>
					</br>
					<h4>Welcome to the Masaccio application ${user}</h4>	
				</div>
			</div>
		</div>
	</body>
</html>