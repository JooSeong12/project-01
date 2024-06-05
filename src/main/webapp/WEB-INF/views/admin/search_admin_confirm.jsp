<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="./nav.jsp"></jsp:include>
	<h2>Search Result</h2>
	<br>
		<form action="<c:url value='/admin/searchAdminConfirm'></c:url>"
		name="search_admin_confirm" method="get">
			<select name="category">
				<option value="none">== Select Category ==</option>
				<option value="Account">Account</option>
				<option value="Name">Name</option>
				<option value="Phone">Phone</option>
			</select>
			<input type="text" name="keyword" placeholder="Enter Keyword" value="search">
			<input type="submit" value="search">
	</form>
	<br>
	<table border="1">
		<tr>
			<th>ID</th>
			<th>NAME</th>
			<th>PHONE</th>
		</tr>
		<c:forEach var="dto" items="${list}">
			<tr>
				<td>${dto.a_id}</td>
				<td>${dto.a_name}</td>
				<td>${dto.a_phone}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>