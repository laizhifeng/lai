$(document).ready(function() {
	$("body").keydown(function() {
		  if (event.keyCode == "13") {//keyCode=13是回车键
		    $("#Loginbutton").click();
		    $("#SignInbutton").click();
		  }
		});  
	
	$("#LoginAck").click(function() {
		$("#SignInDiv").hide();
		$("#LoginDiv").show();
	});
	$("#SignInAck").click(function() {
		$("#LoginDiv").hide();
		$("#SignInDiv").show();
	});
	
	//登陆
	$("#Loginbutton").click(function() {
		$("#login_name_empty").css("display", "none");
		$("#login_pw_empty").css("display", "none");
		$("#login_name_error").css("display", "none");
		$("#login_pw_error").css("display", "none");
		if (document.getElementById("login_username").value == "") {
			$("#login_name_empty").css("display", "block");
		} else if (document.getElementById("login_password").value == "") {
			$("#login_pw_empty").css("display", "block");
		} else {
			$.ajax({
				cache : true,
				type : "POST",
				url : "login",
				data : {
					username : $("#login_username").val(),
					password : $("#login_password").val(),
				},
				async : false,
				success : function(data) {
					if (data == 0) {
						$("#login_name_error").css("display", "block");
					} else if (data == 1) {
						$("#login_pw_error").css("display", "block");
					} else {
						window.location.href = "show_house.jsp";
					}
				}
			});
		}
	});
	
	//注册
	$("#SignInbutton").click(function() {
		$("#signin_name_empty").css("display","none");
	    $("#signin_name_error").css("display","none");
	    $("#signin_pw_empyt").css("display","none");
	    $("#signin_pw_error").css("display","none");
	    if(document.getElementById("signin_username").value == ""){        
	        $("#signin_name_empty").css("display","block");
	    }else if(document.getElementById("signin_password").value == ""){       
	        $("#signin_pw_empyt").css("display","block");
	    }else if(document.getElementById("signin_pw_second").value == ""){       
	        $("#signin_pw_empyt").css("display","block");
	    }else{
	    	$.ajax({
				cache: true,
				type: "POST",
				url:"signIn",
				data:{
					username:$("#signin_username").val(),
					password:$("#signin_password").val(),
					pw_second:$("#signin_pw_second").val(),
				},
				
				async: false,
				success: function(data) {
					if(data == 0){
						$("#signin_name_error").css("display","block");
					}else if(data == 1){
						window.location.href = "NormalUser.jsp";
					}else if(data == 2){
						$("#signin_pw_error").css("display","block");
					}
				}
			});
	    }
	});
});




