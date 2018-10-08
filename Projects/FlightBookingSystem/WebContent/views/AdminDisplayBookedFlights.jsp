<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.java.components.BookedFlight"%>

<html>
<head>
<meta charset="UTF-8">
<title>Booked Flights</title>
</head>
<body>


	<h3>Booked Flights</h3>
	
	<h4 style="color: 'Red'">${requestScope.errorMsg}</h4>

	<c:if test = "${sessionScope.flights != null}">
         <table>
	         <thead>
		         <tr>
		         	<td>Airline</td>
		         	<td>Passenger</td>
		         	<td>Source</td>
		         	<td>Destination</td>
		         	<td>Departure Time</td>
		         	<td>Arrival Time</td>
		         </tr>
	         </thead>
	         
	         <tbody>
				<c:forEach items="${sessionScope.flights}" var="flight">
			    <tr> 
		         	<td><c:out value="${flight.airline}"/></td>
		         	<td><c:out value="${flight.passengerName}"/></td>
		         	<td><c:out value="${flight.from}"/></td>
		         	<td><c:out value="${flight.to}"/></td>
		         	<td><c:out value="${flight.parseDate(0)}"/></td>
		         	<td><c:out value="${flight.parseDate(1)}"/></td>
			    </tr>
				</c:forEach>

			</tbody>
		</table>

    </c:if>





</body>
</html>