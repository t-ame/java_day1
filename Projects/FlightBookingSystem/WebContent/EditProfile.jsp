<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Profile</title>
</head>
<body>



	<form action="/saveprofile" method="post">
		
		<%-- <h5 style="color: 'Red'">${requestScope.errorMsg}</h5> --%>
		
		<label for="first_name">First Name: </label>
		<input type="text" name="first_name" id="first_name" required value="${sessionScope.account.firstName}">
		
		<label for="last_name">Last Name: </label>
		<input type="text" name="last_name" id="last_name" required value="${sessionScope.account.lastName}">
		
		<label for="userName">User Name: </label>
		<input type="text" name="userName" id="userName" readonly value="${sessionScope.account.userName}">
		
		<label for="password">Password: </label>
		<input type="password" name="password" id="password" required value="${sessionScope.account.password}">
		
		<label for="date_of_birth">Date of Birth: </label>
		<input type="date" name="date_of_birth" id="date_of_birth" required placeholder="yyyy-MM-dd" value="${sessionScope.account.dob}">
		
		<label for="gender">Gender: </label>
		<input type="radio" name="gender" value="female">Female
		<input type="radio" name="gender" value="male">Male
		
		<label for="street_address">Street Address: </label>
		<input type="text" name="street_address"required value="${sessionScope.account.address}">
		<br>
		<input type="text" name="address_line_2">
		<br>
		<input type="text" name="address_line_3">
		<br>
		
		<label for="city">City: </label>
		<input type="text" name="city" id="city" required>
		
		<label for="state">State: </label>
		<select name="state" required form="reg_form">
  			<option disabled selected>Select</option>
  			<option value="AL">Alabama</option>
  			<option value="GA">Georgia</option>
  			<option value="IL">Illinois</option>
  			<option value="CA">California</option>
  			<option value="TX">Texas</option>
		</select>
		
		<label for="zip_code">Zip Code: </label>
		<input type="number" name="zip_code" id="zip_code" required>
		
		<input type="hidden" name="isAdmin" id="isAdmin" value="${sessionScope.user.isAdmin}">
		
		<button type="submit" id="loginButton">Save</button>
		<button type='<jsp:forward page="index.jsp"></jsp:forward>' id="cancelButton">Cancel</button>
	
	</form>



</body>
</html>