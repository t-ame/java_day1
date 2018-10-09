<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>

	<form action="/login" method="post">
		
		<h5 style="color: 'Red'">${requestScope.errorMsg}</h5>
		
		<label for="userName">Email: </label>
		<input type="email" name="userName" id="userName" required>
		
		<label for="password">Password: </label>
		<input type="password" name="password" id="password" required>
		
		<input type="hidden" name="isAdmin" id="isAdmin" value="true">
		
		<button type="submit" id="loginButton">Login</button>
		<button type='<jsp:forward page="index.jsp"></jsp:forward>' id="cancelButton">Cancel</button>
	
	</form>


</body>
</html>