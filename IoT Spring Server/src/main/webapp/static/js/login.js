$(document).ready(function () {

	$('#horizontalTab').easyResponsiveTabs({
            type: 'default', //Types: default, vertical, accordion
            width: 'auto', //auto or any width like 600px
            fit: true   // 100% fit in a container
	});

    localStorage.removeItem('token');

    $("#login").click(function() {
        var message = "";
        var username = $("#username").val();
        var password = $("#password").val();
        if (username == "") message += "Inserire Username!\n";
        if (password == "") message += "Inserire Password!";
        if (message != "") {
            alert(message);
            return false;
        }
        var data1 = {"username": username, "password": password};
        var data = JSON.stringify(data1);
        $.ajax({
            type: "POST",
            url: "http://localhost:8080/masaccio/login",
            data: data,
            crossDomain: true,
            contentType: "application/json; charset=utf-8",
            jsonpCallback: 'login',
            dataType: 'json',
            success:function(data){
                console.log(data);
                localStorage['token'] = JSON.parse(JSON.stringify(data['data']['token']));
                console.log(localStorage['token']);
                window.location.href = "IoTRoomData.jsp";
            },
            error: function(x, m){
                console.log(x);
                console.log(m);
                alert('error!');
            }
        });
    });
 });

