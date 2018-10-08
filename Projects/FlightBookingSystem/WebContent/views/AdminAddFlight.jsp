<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add New Flight</title>
</head>
<body>

	<form action="/addflight" method="post">
	
		
		<label for="airline">Airline: </label>
		<input type="text" name="airline" required>
		
		<label for="source">From: </label>
		<select required name="source">
			<option disabled selected>Select</option>
		  	<option value="AL">Alabama</option>
		  	<option value="GA">Georgia</option>
		  	<option value="IL">Illinois</option>
		  	<option value="CA">California</option>
		  	<option value="TX">Texas</option>
		</select>
		
		<label for="destination">To: </label>
		<select required name="destination">
			<option disabled selected>Select</option>
		  	<option value="AL">Alabama</option>
		  	<option value="GA">Georgia</option>
		  	<option value="IL">Illinois</option>
		  	<option value="CA">California</option>
		  	<option value="TX">Texas</option>
		</select>
		
		<br>
		
		<label for="depart_time">Time: </label>
		<input type="date" name="depart_time" required>
		
		<label for="arrive_time">Time: </label>
		<input type="date" name="arrive_time" required>
		<br>
		
		<label for="seats">Seat Number: </label>
		<input type="number" name="seats" required>
		
		<label for="price">Price: </label>
		<input type="text" name="price" required>
		<br>
		
		<button type="submit">Add</button>
		<button type="reset">Clear</button>
	
	
	</form>





</body>
</html>