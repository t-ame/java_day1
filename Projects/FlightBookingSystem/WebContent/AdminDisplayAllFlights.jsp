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

    
    
	<h6 style="color: Red">${requestScope.errorMsg}</h6>
	<% request.setAttribute("errorMsg", ""); %>
	
	<c:if test="${sessionScope.flights !=null}">
		<div class="card mb-3">
			<div class="card-header" style="text-align: center">
				<h2 ><i class="fas fa-table"> Flight Information</i></h2>
			</div>
			<div class="card-body">
				<c:if test="${flightList.size()==0}">
					<div class="alert alert-warning" role="alert">Have not found
						matched records.</div>
				</c:if>
				<c:if test="${flightList.size()>0}">
					<div class="table-responsive">
						<table class="table table-bordered" id="dataTable" width="100%"
							cellspacing="0">
							<thead>
								<tr>
									<th scope="col">#</th>
									<td scope="col">Airline</td>
									<td scope="col">Departure</td>
									<td scope="col">Destination</td>
									<td scope="col">Departure Time</td>
									<td scope="col">Arrival Time</td>
									<td scope="col">Available Seats</td>
									<td scope="col">Cost</td>
									<td scope="col"></td>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${flightList}" var="flight">
									<tr>
										<th scope="row">1</th>
										<td><c:out value="${flight.getAirline()}" /></td>
										<td><c:out value="${flight.getFrom()}" /></td>
										<td><c:out value="${flight.getTo()}" /></td>
										<td><c:out value="${flight.getDepartureTime()}" /></td>
										<td><c:out value="${flight.getArrivalTime()}" /></td>
										<td><c:out value="${flight.getAvailableSeats()}" /></td>
										<td><c:out value="'$'${flight.getCost()}" /></td>
										<td><a href="/editflight/${flight.id}">Edit</a> <a href="./deleteflight/${flight.id}">Delete</a></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</c:if>
			</div>
		</div>
	</c:if> 





</body>
</html>