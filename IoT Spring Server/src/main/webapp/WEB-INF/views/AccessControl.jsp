<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>Masaccio - Access Control</title>
    
    <script src="https://canvasjs.com/assets/script/jquery-1.11.1.min.js"></script>
     <!-- Latest compiled and minified CSS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
	<!-- Optional theme -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
	<!-- Latest compiled and minified JavaScript -->
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
    
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <link href="<c:url value='../../static/css/style.css' />" rel="stylesheet" type="text/css" media="all" />
    
    <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.5.0/Chart.min.js"></script>
</head>
<body>
	<jsp:include page="../includes/menu.jsp" />

	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<h1>Access Control</h1>
			</div>
		</div>
	</div>

	<div class="container">
		<div class="row">
			<div class="col-md-8">
				<table class="table table-striped">
					<thead>
						<tr>
							<th>User name</th>
							<th>Item name</th>
							<th>Time</th>
							<th>Allowed</th>
						</tr>
					</thead>
					<tbody id="accessOverviewTable">
					
					</tbody>
				</table>
			</div>
		</div>
	</div>
</body>
</html>

<script>
    window.onload = function() {
        function getData() {
        	console.log('ja');
            $.ajax({
                url: "http://localhost:8080/accessControl",
                type: "GET",
                dataType: 'json',
                contentType: 'application/json',
                success: function (data) {
                    var table = $("#accessOverviewTable");
                    $("#accessOverviewTable > tr").remove();
                    $.each(data, function(key, value) {
                    	var htmlString = '<tr>';
                    	htmlString += '<td>' + value.user + '</td>';
                    	htmlString += '<td>' + value.item + '</td>';
                    	htmlString += '<td>' + value.timestamp + '</td>';
                    	
                    	if(value.allowed) {
                    		htmlString += '<td><span class="glyphicon glyphicon-ok"></span></td>';
                    	} else {
                    		htmlString += '<td><span class="glyphicon glyphicon-remove"></span></td>';
                    	}
                    	
                    	htmlString += '</tr>';
                    	table.append(htmlString);
                    });
                },
                error: function (x, m) {
                    console.log(x);
                    console.log(m);
                    alert('error!');
                }
            });
        }
	
        getData();
        setInterval(getData, 10000);
    };
</script>