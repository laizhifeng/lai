$(document).ready(function(){
	window.scrollTo(0,0); 
	$(".search_box").attr("placeholder","请输入地区名、小区名或详细地址");
  //返回按钮
    $("#house_getBack").click(function(){
    	$("#house_update_button").show();
    	$(".show_info").hide();
        $(".show_list").show();
        $(".del_div").hide();
        ShowAndHide();
    });
    
    //批量删除
    h_del_batch();
    //添加房屋
    addHouse(); 
    //房屋搜索
    selectHouse();
    
    //修改房屋
    updateHouse();
    //保存修改
    saveUpdateHouse();
    //删除房屋
    deleteHouse();
    
 });

//搜索
function selectHouse() {
	 $(".search_button").click(function(){
		 $(".search_button").unbind(showHouseInfo());
		 $(".show_info").hide();
	     $(".show_list").show();
	     $(".del_div").hide();
	     ShowAndHide();
	     $("li").detach();
				 $.ajax({
	        	 url : "House/HouseSelect",
	        	 dataType : "json",
	        	 type : "post",
	        	 data:{
	        		 filed:$(".search_box").val()
	        		 },
	        	 async : false,
	        	 success : function(data) {
	        		if(data == ""){
	        			$(".notfound").show();
	        			$(".pagediv").hide();
	        			$(".del_batch_button").hide();
	        		}else{
	        			$(".notfound").hide();
	        			$(".pagediv").show();
	        			$(".del_batch_button").show();
	        			var str = "";
	        			for(var i=0;i<data.length;i++){
	        				str =  data[i].h_address;
	            			var html = "<li><input type='checkbox' name='h_del' value='"+data[i].h_id+"' style='display:none'/><button class='goShowHouse' id='goShow"+i+"' value='"+data[i].h_id+"'>"+str+"</button></li>";
	            			$("#showUl").append(html);
	                		
	        			 }		 
	            	}
	        			//分页
	        		paging(data);	
	        		//显示房屋信息
	        		showHouseInfo();
	        	 }
			});
	    });
}



//显示房屋详细信息
function showHouseInfo() {
	$(".goShowHouse").each(function(){
		 $(this).click(function(){
			$('html,body').animate({ scrollTop: 0 }, 0);
			$(".show_info").show();
		    $(".show_list").hide();
		    $(".del_batch_button").hide();
		    ShowAndHide();
		    var thisId = $(this).attr("id");
		    var h_id = $("#"+thisId+"").val();
		    show(h_id);		    
		 });
	});
}
//显示
function show(h_id) {
	$.ajax({
        url : "House/ShowHouse",
        dataType : "json",
        type : "post",
        data:{
        	h_id:h_id,
    		 },
    	async : false,
    	success : function(showData) {
    	//显示
    		$(".pagediv").hide();
    		var length = showData.length;
    		for (let i = 0; i < length; i++){
    			$("#h_id").attr("value",showData[i].h_id);
    	    	$("#h_region").attr("value",showData[i].h_region);
    	    	$("#h_estate").attr("value",showData[i].h_estate);
    	    	$("#h_unitNumber").attr("value",showData[i].h_unitNumber);
    	    	$("#h_roomNo").attr("value",showData[i].h_roomNo);
    	    	$("#h_area").attr("value",showData[i].h_area);
    	    	$("#h_orientation").attr("value",showData[i].h_orientation);
    	    	$("input:radio[name='h_fitment'][value="+showData[i].h_fitment+"]").attr('checked','true');
    	    	$("input:radio[name='h_isDoubleAir'][value="+showData[i].h_isDoubleAir+"]").attr('checked','true');
    	    	$("#h_limit").attr("value",showData[i].h_limit);
    	    	$("#h_facility").val(""+showData[i].h_facility+"");
    	    	$("#h_price").attr("value",showData[i].h_price);
    	    	$("#h_status").attr("value",showData[i].h_status);
    	    	$("#h_address").val(""+showData[i].h_address+"");
    	    	var src = showData[i].h_img;
    	    	$("#h_img").attr("src",src);
    	    	
    	    	var h_addtime = (showData[i].h_addtime.year+1900)+"-"+(showData[i].h_addtime.month+1)+"-"
    			+showData[i].h_addtime.date+" "+showData[i].h_addtime.hours+":"+
    			showData[i].h_addtime.minutes+":"+showData[i].h_addtime.seconds;
    			$("#h_addtime").attr("value",h_addtime);
    			
    			var h_updatetime = (showData[i].h_updatetime.year+1900)+"-"+(showData[i].h_updatetime.month+1)+"-"
    			+showData[i].h_updatetime.date+" "+showData[i].h_updatetime.hours+":"+
    			showData[i].h_updatetime.minutes+":"+showData[i].h_updatetime.seconds;
    			$("#h_updatetime").attr("value",h_updatetime);
    		}
    	
    	}    		 
     });	
}


//修改
function updateHouse() {	
	$("#house_update_button").click(function(){
		$.ajax({
			type : "POST",
			url : "House/HouseUpdateButton",
			dataType: "json",
			async : false,
			data : {				
			},
			async : false,
			success : function(data) {

				if(data.message == "false"){
					alert("您没有权限");
				}		
			},
			error : function() {
				$("#house_update_button").hide();
				ShowAndHide();
			}
		})		
	 });
}
//提交修改
function saveUpdateHouse() {
	
      $("#house_save_button").click(function(){
      	if (document.getElementById("h_estate").value == "") {
      		$("#h_estate_error").text("小区名不能为空");
		}else if(document.getElementById("h_unitNumber").value == "") {
			$("#h_unitNumber_error").text("单元号不能为空");
		}else if(document.getElementById("h_roomNo").value == "") {
			$("#h_roomNo_error").text("房间号不能为空");
		}else if(document.getElementById("h_area").value == "") {
			a$("#ah_area_error").text("面积不能为空");
		}else if(document.getElementById("h_orientation").value == "") {
			$("#h_orientation_error").text("朝向不能为空");
		}else if(document.getElementById("h_limit").value == "") {
			$("#h_limit_error").text("限住人数不能为空");
		}else if(document.getElementById("h_price").value == "") {
			$("#h_price_error").text("租金不能为空");
		}else if(document.getElementById("h_address").value == "") {
			$("#h_address_error").text("地址不能为空");
		}else{$.ajax({
			type : "POST",
			url : "House/HouseUpdate",
			dataType: "json",
			async : false,
			data : {
				update_h_id:$("#h_id").val(),
				update_h_region:$("#h_region").val(),
				update_h_estate:$("#h_estate").val(),
				update_h_unitNumber:$("#h_unitNumber").val(),
				update_h_roomNo:$("#h_roomNo").val(),
				update_h_area:$("#h_area").val(),
				update_h_orientation:$("#h_orientation").val(),
				update_h_fitment:$("#h_fitment").val(),
				update_h_isDoubleAir:$("#h_isDoubleAir").val(),
				update_h_limit:$("#h_limit").val(),
				update_h_facility:$("#h_facility").val(),
				update_h_price:$("#h_price").val(),
				update_h_status:$("#h_status").val(),
				update_h_address:$("#h_address").val(),
				update_h_img:$("#h_img").attr("src"),	
			},
			async : false,
			success : function(data) {
				if(data.message == "false"){
					alert("您没有权限");
				} else {
					if (data == 0) {
						alert("修改失敗");
					} else if (data == 1) {
						alert("修改成功");
						show($("#h_id").val());
						$("#house_update_button").show();
						ShowAndHide();
					} 
				}
				
			}
		});
		}
      });  	
}
//删除
function deleteHouse() {
	 $("#house_delete_button").click(function(){
		 if(confirm('您确定要删除选中的记录吗？')){
			 $.ajax({
				 type : "POST",
				 url : "House/HouseDelete",
				 dataType: "json",
				 data : {
					 delete_h_id:$("#h_id").val(),
				 },
				 async : false,
				 success : function(data) {
					 console.log(data)
					 if(data.message == "false"){
						 alert("您没有权限");
					 }else {
					
						 if (data == 0) {
							 alert("删除失敗");
						 } else if (data == 1) {
							alert("删除成功");
							window.location.href = "show_house.jsp";
						 } 
					 }					
				 }			 
			 });	
		 }
  });	
}

//添加房屋
function addHouse() {
    $("#houseAdd_Button").click(function(){
    	if (document.getElementById("h_estate").value == "") {
    		$("#h_estate_error").text("小区名不能为空");
		}else if(document.getElementById("h_unitNumber").value == "") {
			$("#h_unitNumber_error").text("单元号不能为空");
		}else if(document.getElementById("h_roomNo").value == "") {
			$("#h_roomNo_error").text("房间号不能为空");
		}else if(document.getElementById("h_area").value == "") {
			$("#h_area_error").text("面积不能为空");
		}else if(document.getElementById("h_orientation").value == "") {
			$("#h_orientation_error").text("朝向不能为空");
		}else if(document.getElementById("h_limit").value == "") {
			$("#h_limit_error").text("限住人数不能为空");
		}else if(document.getElementById("h_price").value == "") {
			$("#h_price_error").text("租金不能为空");
		}else if(document.getElementById("h_address").value == "") {
			$("#h_address_error").text("地址不能为空");
		}else{$.ajax({
			cache : true,
			type : "POST",
			url : "House/HouseAdd",
			dataType: "json",
			data : {
				h_region_add:$("#h_region").val(),
				h_estate_add:$("#h_estate").val(),
				h_unitNumber_add:$("#h_unitNumber").val(),
				h_roomNo_add:$("#h_roomNo").val(),
				h_area_add:$("#h_area").val(),
				h_orientation_add:$("#h_orientation").val(),
				h_fitment_add:$("#h_fitment").val(),
				h_isDoubleAir_add:$("#h_isDoubleAir").val(),
				h_limit_add:$("#h_limit").val(),
				h_facility_add:$("#h_facility").val(),
				h_price_add:$("#h_price").val(),
				h_status_add:$("#h_status").val(),
				h_address_add:$("#h_address").val(),
				h_img_add:$("#h_img").attr("src"),	
			},
			async : false,
			success : function(data) {
				
				if(data.message == "false"){
					alert("您没有权限");
				} else {
					if (data == 0) {
						alert("添加失敗，已有相同房屋存在");
					} else if (data == 1) {
						alert("添加成功");
						$(".h_add").val('');
						document.documentElement.scrollTop = document.body.scrollTop = 0;
					} 
				}
				
			}
		});
	}
    });  	
}

//批量删除
function h_del_batch() {
	var box=document.getElementsByName('h_del');
	$(".del_batch_button").click(function(){
		$.ajax({
			type : "POST",
			url : "House/HouseDelBatchButton",
			dataType: "json",
			async : false,
			data : {				
			},
			async : false,
			success : function(data) {	
				if(data.message == "false"){
					alert("您没有权限");
				} 		
			},
			error : function() {
				$(".del_div").show();
				$("input:checkbox[name='h_del']").show();
				$(".goShowHouse").attr("disabled","disabled");
			}
		})		
	});
	//取消批量删除
	$("#del_cancel").click(function(){
		$(".del_div").hide();
		$("input:checkbox[name='h_del']").hide();
		$(".goShowHouse").removeAttr("disabled");    
        for(var i=0;i<box.length;i++){
        	box[i].checked="";
        }
	});
	//全选
	$("#del_all").click(function(){    
        for(var i=0;i<box.length;i++){
            box[i].checked="checked";
        }
	});
	//全不选
	$("#del_none").click(function(){    
        for(var i=0;i<box.length;i++){
            box[i].checked="";
        }
	});
	//确认删除
	$("#del_affirm").click(function(){
		var checkedbox=$("input:checkbox[name='h_del']:checked");
		if(checkedbox.length == 0){
			alert("请至少选择一个");
		}else{
			if(confirm('您确定要删除选中的记录吗？')){
				var arr = new Array();
				checkedbox.each(function() {
					arr.push(this.value);
				});
				$.ajax({
					type : "POST",
					url : "House/HouseDeleteBatch",
					data : {
						h_delete_batch:arr,
					},
					traditional :true,
					async : false,
					success : function(data) {
						
						if(data.message == "false"){
							alert("您没有权限");
						}else {
							var err = arr.length - data;
							alert("成功删除"+data+"条记录，失败了"+err+"条");
							window.location.href = "show_house.jsp";
						}
						
					}
				});
			}
		}
	});
}

function ShowAndHide() {
	if($("#house_update_button").css("display")=="inline-block"){
		$(":text").attr("onfocus","this.blur()");
		$(":radio").attr("disabled","disabled");
		$("#h_status").attr("disabled","disabled");
		$("#h_region").attr("disabled","disabled");
		$("#h_address").attr("onfocus","this.blur()");
		$("#h_facility").attr("onfocus","this.blur()");	
		$("#house_save_button").hide();
		$("#pic").hide();
		$(".search_box").removeAttr("onfocus");
		$("#changePage").removeAttr("onfocus");
		$('html,body').animate({ scrollTop: 0 }, 500);
	}else if($("#house_update_button").css("display")=="none"){
		$(":text").removeAttr("onfocus");
		$(":radio").removeAttr("disabled");
		$("#h_status").removeAttr("disabled");
		$("#h_region").removeAttr("disabled");
		$("#h_address").removeAttr("onfocus");
		$("#h_facility").removeAttr("onfocus");
		$("#house_save_button").show();
		$("#pic").show();
		$('html,body').animate({ scrollTop: 0 }, 500);
	}
	if($(".show_list").css("display")=="block"){
		$(".del_batch_button").show();
	}else if($(".show_list").css("display")=="none"){
		$(".del_batch_button").hide();
	}
	
}