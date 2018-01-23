<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>Masaccio - IoT Room Dashboard</title>
    
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
				<h1>IoT Room Dashboard</h1>
			</div>
		</div>
	</div>

	<div id="main" style="padding: 10%; padding-top:0">
	    <canvas id="bar-chart" width="800" height="400"></canvas>
	</div>
</body>
</html>

<script>
    window.onload = function() {

        Chart.defaults.global.defaultFontSize = 18;

        var dataPoints = [];
        var labels = [];
        var color = [];
        
        var backgroundColor = [
            'rgba(255, 99, 132, 0.6)',
            'rgba(54, 162, 235, 0.6)',
            'rgba(255, 206, 86, 0.6)',
            'rgba(75, 192, 192, 0.6)',
            'rgba(153, 102, 255, 0.6)',
            'rgba(255, 159, 64, 0.6)',
            'rgba(255, 99, 132, 0.6)',
            'rgba(54, 162, 235, 0.6)',
            'rgba(255, 206, 86, 0.6)',
        ];

        function addData(data) {
            for (var i = 0; i < data.length; i++) {
                dataPoints[i] = data[i].numberOfPeople;
                labels[i] = "Room" + " " + data[i].room;
                color[i] = backgroundColor[i];
            }
        }

        function doRedirect() {
            $.ajax({
                url: "http://localhost:8080/room",
                type: "GET",
                jsonpCallback: 'getRoomData',
                dataType: 'jsonp',
                contentType: 'application/json',
                success: function (data) {
                    addData(data);
                    new Chart(document.getElementById("bar-chart"), {
                        type: 'bar',
                        data: {
                            labels: labels,
                            datasets: [
                                {
                                    label: "People",
                                    backgroundColor: color,
                                    data: dataPoints
                                }
                            ]
                        },
                        options: {
                            legend: {display: true},
                            title: {
                                display: true,
                                text: 'Number of people in each room'
                            },
                            scales: {
                                yAxes: [{
                                    ticks: {
                                        beginAtZero: true
                                    }
                                }],
                                xAxes: [{
                                    // Change here
                                    barPercentage: 0.5
                                }]
                            }
                        }
                    });
                },
                error: function (x, m) {
                    console.log(x);
                    console.log(m);
                    alert('error!');
                }
            });
        }

        doRedirect();
        setInterval(doRedirect, 10000);
    };
</script>