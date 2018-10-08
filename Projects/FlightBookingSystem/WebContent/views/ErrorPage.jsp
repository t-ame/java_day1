<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Error</title>
</head>
<body>

	<h1>Oops...</h1>
	<h3>Sorry, an Exception occurred.</h3>
	<h4>Here is the Exception message: </h4>
	<hr>
	<h2 style="color: 'Red'">${requestScope.exceptionMsg}</h2>
	

</body>
</html>