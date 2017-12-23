$(document).ready(function () {
	$('#horizontalTab').easyResponsiveTabs({
            type: 'default', //Types: default, vertical, accordion           
            width: 'auto', //auto or any width like 600px
            fit: true   // 100% fit in a container
	});
        $("#eventi").hide();
        $("#popup").hide();
        localStorage.removeItem('token');
        
        $("#submit").click(function() {
            var message = $("#message").val();
            var data1 = {"text": message, "topic": "firstResponderCommunication"};
            var data = JSON.stringify(data1);

            $.ajax({
                type: "POST",
                url: "http://localhost:8080/masaccio/message/" +localStorage.getItem('token'),
                data: data,
                contentType: "application/json; charset=utf-8",
                jsonpCallback: 'message',
                dataType: 'json',
                success:function() {
                    console.log("OK");
                },
                error: function(x, m){
                    console.log(x);
                    console.log(m);
                    alert('error!');
                }
            });
        });
    

    window.onclick = function(event) {
        var modal = document.getElementById('id01');
        if (event.target == modal) {
            $(".modal").css('display', 'block');
        }
    }
    

    
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
            contentType: "application/json; charset=utf-8",
            jsonpCallback: 'login',
            dataType: 'json',
            success:function(data){
                console.log(data);
                localStorage['token'] = JSON.parse(JSON.stringify(data['data']['token']));
                console.log(localStorage['token']);
                $("#blocco1").hide();
                $("#eventi").show();
                //homepage();
            },
            error: function(x, m){
                console.log(x);
                console.log(m);
                alert('error!');
            }
        });
    });
    
    $("#registrazione").click(function() {
        var email_reg_exp = /^([A-Za-z0-9_\-\.])+\@([A-Za-z0-9_\-\.])+\.([A-Za-z]{2,4})$/;
        var message = "";
        var nome = $("#nome").val();
        var cognome = $("#cognome").val();
        var email = $("#email2").val();
        var password = $("#password2").val();
        var telefono = $("#telefono").val();
        if (nome == "") message += "Inserire Nome!\n";
        if (cognome == "") message += "Inserire Cognome!\n";
        if (email == "") message += "Inserire Email!\n";
        if (!email_reg_exp.test(email)) message += "Email non valida!\n";
        if (password == "") message += "Inserire Password!\n";
        if (message != "") {
            alert(message);
            return false;
        }
        var data1 = {"nome": nome, "cognome": cognome, "email": email, "password": password, "telefono": telefono};
        var data = JSON.stringify(data1);
        $.ajax({
            type: "POST",
            url: "http://localhost:8080/ShareChef_REST_Server_JAXRS/rest/auth/utenti",
            data: data,
            contentType: "application/json; charset=utf-8",
            dataType: "json",
            success:function(data){
                localStorage['token'] = JSON.parse(JSON.stringify(data));         
                console.log(localStorage['token']);
                $("#blocco1").hide();
                $("#eventi").show();
                homepage();
            },
            error: function(x, m){
                console.log(x);
                console.log(m);
                alert('error!');
            }
        });
    });
    
    $("#logout").click(function() {
        $.ajax({
            type: "POST",
            url: "http://localhost:8080/masaccio/logout/"+localStorage.getItem('token'),
            success:function(data){
                $("#eventi").hide();
                $("#blocco1").show();
            },
            error: function(x, m){
                console.log(x);
                console.log(m);
                alert('error!');
            }
        });
    });
 });

