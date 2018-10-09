<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Flight</title>
</head>
<body>

	<form action="/update" method="post">
	
		
				
		<label for="airline">Airline: </label>
		<input type="text" name="airline" required value="${requestScope.flight.airline}">
		
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
		
		<label for="airline">Airline: </label>
		<input type="date" name="airline" required value="${requestScope.flight.airline}">
		
		<label for="source">Source: </label>
		<input type="date" name="source" required value="${requestScope.flight.from}">
		
		<label for="destination">Destination: </label>
		<input type="date" name="destination" required value="${requestScope.to}">
		<br>
		
		<label for="depart_time">Departure Time: </label>
		<input type="date" name="depart_time" required value="${requestScope.flight.parseDate(0)}">
		
		<label for="arrive_time">Arrival Time: </label>
		<input type="date" name="arrive_time" required value="${requestScope.flight.parseDate(1)}">
		<br>
		
		<label for="seats">Seat Number: </label>
		<input type="number" name="seats" required value="${requestScope.flight.seats}">
		
		<label for="price">Price: </label>
		<input type="text" name="price" required value="${requestScope.flight.price}">
		<br>
		
		<input type="hidden" name="foward_jsp" id="foward_jsp" value="AdminDisplayAllFlights.jsp">
		
		<button type="button" onclick="backButton()">Back</button>
		<button type="submit">Save</button>
		<button type="reset">Clear</button>
	
	
	</form>




    <script type="text/javascript">
        function backButton()
        {
            document.getElementById('foward_jsp').value = "CustomerFlightSearch.jsp";
            flight_booking_form.submit();
        } 
    </script>

</body>
</html>