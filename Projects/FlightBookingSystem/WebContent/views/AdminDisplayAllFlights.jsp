<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.java.components.FlightTemplate"%>

<%-- <%! FlightTemplate flight; %> --%>

<html>
<head>
<meta charset="UTF-8">
<title>All Scheduled flights</title>
</head>
<body>


	<h3>Scheduled Flights</h3>
	
	<h4 style="color: 'Red'">${requestScope.errorMsg}</h4>

	<c:if test = "${sessionScope.flights != null}">
         <table>
	         <thead>
		         <tr>
		         	<td>Airline</td>
		         	<td>Source</td>
		         	<td>Destination</td>
		         	<td>Departure Time</td>
		         	<td>Arrival Time</td>
		         	<td>Seats</td>
		         	<td>Price</td>
		         	<td>         </td>
		         </tr>
	         </thead>
	         
	         <tbody>
				<c:forEach items="${sessionScope.flights}" var="flight">
			    <tr> 
		         	<td><c:out value="${flight.airline}"/></td>
		         	<td><c:out value="${flight.from}"/></td>
		         	<td><c:out value="${flight.to}"/></td>
		         	<td><c:out value="${flight.parseDate(0)}"/></td>
		         	<td><c:out value="${flight.parseDate(1)}"/></td>
		         	<td><c:out value="${flight.seats}"/></td>
		         	<td><c:out value="'$'${flight.price}"/></td>
		         	<td><a href="/editflight/${flight.id}">Edit</a> <a href="/deleteflight/${flight.id}">Delete</a></td>
			    </tr>
				</c:forEach>

			</tbody>
		</table>

    </c:if>





</body>
</html>