<%@ page import="kr.co.js12.dto.AdminDto" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%
	AdminDto adminLoginedDto = (AdminDto)session.getAttribute("adminLoginedDto");
	if(adminLoginedDto != null){
		//로그인 이후 자바문법
		
	
%>
<ul>
		<li>
			<a href="<c:url value='/admin/logout'></c:url>">LOG OUT</a>
		</li>
		<li>
			<a href="<c:url value='/admin/modifyAccountForm'></c:url>">Modify Account </a>
		</li>
		
		<c:if test="${adminLoginedDto.a_id eq 'admin'}">
			<li>
				<a href="<c:url value='/admin/listupAdmin'></c:url>">관리자 목록 </a>
			</li>
		</c:if>
		
		
		<li>
			<a href="<c:url value='/admin/getAllBook'></c:url>">전체 도서 </a>
		</li>
		<li>
			<a href="<c:url value='/admin/registerBookForm'></c:url>">도서 등록 </a>
		</li>
	</ul>
<%} else {
	//로그인 안된상태
	%>
<ul>
		<li>
			<a href="<c:url value='/admin/createAccountForm'></c:url>">Create Account</a>
		</li>
		<li>
			<a href="<c:url value='/admin/loginForm'></c:url>">Login</a>
		</li>
	</ul>
<%}%>