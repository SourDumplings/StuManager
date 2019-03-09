<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首页</title>
</head>
<body>
	<c:if test="${not empty userBean }">
		<h2>欢迎您，${userBean.getUsername() }</h2>
		<h3><a href="StudentListServlet">显示所有学生列表</a></h3><br>
		<h3><a href="StudentListPageServlet?currentPage=1">分页显示所有学生</a></h3>
	</c:if>
	<c:if test="${empty userBean }">
		您好，请先<a href="login.jsp">登录</a>！
	</c:if>	
	
</body>
</html>