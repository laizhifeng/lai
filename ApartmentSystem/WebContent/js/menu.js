$(document).ready(function(){
	//房屋信息管理按钮
    $("#menu_house").click(function(){
      $("#submenu_house").toggle();
    });
    //租客信息管理按钮
    $("#menu_lodger").click(function(){
        $("#submenu_lodger").toggle();
    });   
    //房屋搜索管理按钮
    $("#house_select_menu").click(function(){
    	window.location.href = "show_house.jsp";
    });  
    //房屋添加管理按钮
    $("#house_add_menu").click(function(){
    	window.location.href = "add_house.jsp";
    });
    //租客搜索管理按钮
    $("#tenant_select_menu").click(function() {
    	window.location.href = "show_tenant.jsp";
	});
    //租客添加管理按钮
    $("#tenant_add_menu").click(function(){
    	window.location.href = "add_tenant.jsp";
    });  
 });
