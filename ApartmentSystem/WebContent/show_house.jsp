<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>搜索房屋信息</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/js/ShowImg.js"></script>
<script src="${pageContext.request.contextPath}/js/page.js"></script>
<script src="${pageContext.request.contextPath}/js/menu.js"></script>
<script src="${pageContext.request.contextPath}/js/house.js"></script>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/apartment.css">
</head>

<body>
	<%@ include file="common/head.jsp"%>
	<div class="holisticDiv">
		<%@ include file="common/menu.jsp"%>
		<div class="Info" id="house">
			<%@ include file="common/SearchAndPaging.jsp"%>
			<div class="show_info" id="showHouse">
				<h2>房屋信息</h2>
				房间ID： <input type="text" id="h_id" disabled="disabled" >
				<br><br> 
				<%@ include file="common/HouseInfo.jsp"%>
					<br>
					 创建时间：<input type="text" id="h_addtime" style="width:150px;" disabled="disabled">
                    &ensp;&ensp;修改时间：<input type="text" id="h_updatetime" style="width:150px;" disabled="disabled">
                    <br><br>
					<button id="house_update_button" >修改</button>
					<button id="house_save_button" style="display: none">保存</button>
					<button id="house_delete_button">删除</button>
					<button id="house_getBack">返回</button>
					
			</div>
		</div>
	</div>
</body>
</html>