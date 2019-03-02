<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>更新学生的页面</title>
</head>
<body>
	<h3>更新学生的页面</h3>
	<form action="UpdateServlet" method="post">
		<!-- 在页面上不出现，但是会把该数据传入request中 -->		
		<input type="hidden" name="sid" value="${stu.sid }">
		
		<table border="1" width="600">
			<tr>
				<td>姓名</td>
				<td><input type="text" name="sname" value="${stu.sname }"></td>
			</tr>
			<tr>
				<td>性别</td>
				<!-- 如果性别是男，就在男的input标签里面出现checked，女的同理 -->
				<td><input type="radio" name="gender" value="男"<c:if test="${stu.gender == '男' }">checked</c:if>>男
					<input type="radio" name="gender" value="女"<c:if test="${stu.gender == '女' }">checked</c:if>>女</td>
			</tr>
			<tr>
				<td>电话</td>
				<td><input type="text" name="phone" value="${stu.phone }"></td>
			</tr>
			<tr>
				<td>生日</td>
				<td><input type="text" name="birthday" value="${stu.birthday }"></td>
			</tr>
			<tr>
				<td>爱好</td>
				<!-- 判断包含关系 -->
				<td><input type="checkbox" name="hobby" value="游泳"<c:if test="${fn:contains(stu.hobby, '游泳') }">checked</c:if>>游泳
					<input type="checkbox" name="hobby" value="足球"<c:if test="${fn:contains(stu.hobby, '足球') }">checked</c:if>>足球 
					<input type="checkbox" name="hobby" value="看书"<c:if test="${fn:contains(stu.hobby, '看书') }">checked</c:if>>看书
					<input type="checkbox" name="hobby" value="写字"<c:if test="${fn:contains(stu.hobby, '写字') }">checked</c:if>>写字
					<input type="checkbox" name="hobby" value="篮球"<c:if test="${fn:contains(stu.hobby, '篮球') }">checked</c:if>>篮球
				</td>
			</tr>
			<tr>
				<td>简介</td>
				<td><textarea rows="3" cols="20" name="info">${stu.info }</textarea></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="更新"></td>
			</tr>

		</table>
	</form>
</body>
</html>