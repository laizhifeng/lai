<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加租客</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/js/menu.js"></script>
<script src="${pageContext.request.contextPath}/js/tenant.js"></script>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/apartment.css">
</head>


<body>
	<%@ include file="common/head.jsp"%>
	<div class="holisticDiv">
		<%@ include file="common/menu.jsp"%>
		<div class="Info" id="tenant" >
			<div class="add_info" >
				<h2>添加租客信息</h2>
				<%@ include file="common/TenantInfo.jsp"%>
				
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<button id="t_add_button">提交</button>
			</div>
		</div>
	</div>
</body>
</html>