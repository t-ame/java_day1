<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ page import="java.util.List, com.java.components.ScheduledFlight"%>
<!DOCTYPE html>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<meta charset="UTF-8">
<title>Flight Search</title>
</head>
<body>

	<form action="/flightsearch" name="flight_search_form">
	
		<label for="departure">From: </label>
		<select required name="departure">
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
		
		<label for="departure_date"></label>
		<input type="date" name="departure_date" placeholder="yyyy/mm/dd" required  value="${requestScope.departure_date}">
		
		<button type="submit">Search</button>
		<button type="reset">Clear</button>
	
	</form>

	<hr/>
	
	<h1>Available Flights</h1>
	
	<h4 style="color: 'Red'">${requestScope.errorMsg}</h4>

	<c:if test = "${sessionScope.flights != null}">
         <table>
	         <thead>
		         <tr>
		         	<td>Departure</td>
		         	<td>Destination</td>
		         	<td>Departure Time</td>
		         	<td>Arrival Time</td>
		         	<td>Cost</td>
		         	<td>            </td>
		         </tr>
	         </thead>
	         
	         <tbody>
				<c:forEach items="${sessionScope.flights}" var="flight">
			    <tr> 
		         	<td><c:out value="${flight.departure}"/></td>
		         	<td><c:out value="${flight.destination}"/></td>
		         	<td><c:out value="${flight.departureDateFormat}"/></td>
		         	<td><c:out value="${flight.arrivalDateFormat}"/></td>
		         	<td><c:out value="'$'${flight.cost}"/></td>
		         	<td><a href="/booking/${flight.id}">Select</a> </td>
			    </tr>
				</c:forEach>

			</tbody>
		</table>

    </c:if>



</body>
</html>