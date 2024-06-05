<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>

</head>
<body>
	<h2>Sign In</h2>
	<form action="<c:url value='/admin/loginConfirm'></c:url>" method="post" id="login_form">
		<input type="text" name="a_id" id="a_id" placeholder="Input Admin ID"/><br>
		<input type="password" name="a_pw" id="a_pw" placeholder="Input Admin PW"/><br>
		<input type="button" id="btn_login" value="login"/><br>
		<input type="reset" value="reset"/><br>
	</form>
	<script>
		$("#btn_login").on("click", function(){
			if($("#a_id").val().trim() == ""){
				alert("INPUT ADMIN ID");
				$("#a_id").focus();
			} else if($("#a_pw").val().trim() == ""){
				alert("INPUT ADMIN PW");
				$("#a_pw").focus();
			} else {
				$("#login_form").submit();
			}
		});
	</script>
</body>
</html>