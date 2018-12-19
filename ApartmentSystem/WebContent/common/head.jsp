<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

	<div class="infoDiv">
    	<div class="ShowUserName">欢迎：<%
    			String name=(String)session.getAttribute("username");
    			if(name	!=	null){
    				out.print(name);
    			}else{
    				response.sendRedirect("login.jsp");
    			}
    	%>
    	</div>
        <div class="personalDiv"><img src="${pageContext.request.contextPath}/img/0940053906.jpg"></div>
        <a href="quit.jsp" >退出</a>
    </div>
    <div class="titleDiv" style=" background-image: url(${pageContext.request.contextPath}/img/s.jpg);">
    <h1>智游公寓管理系统</h1>
    </div>
