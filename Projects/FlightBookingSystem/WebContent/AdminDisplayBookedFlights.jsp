<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.java.components.BookedFlight"%>

<html>
<head>
<meta charset="UTF-8">
<title>Booked Flights</title>
</head>
<body>


	<%-- 	<h4 style="color: 'Red'">${requestScope.errorMsg}</h4>

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

    </c:if> --%>


	<h6 style="color: Red">${requestScope.errorMsg}</h6>
	<%
		request.setAttribute("errorMsg", "");
	%>

	<c:if test="${sessionScope.flights !=null}">
		<div class="card mb-3">
			<div class="card-header" style="text-align: center">
				<h2>
					<i class="fas fa-table">Booked Flights</i>
				</h2>
			</div>
			<div class="card-body">
				<c:if test="${flightList.size()==0}">
					<div class="alert alert-warning" role="alert">No flights have
						been booked.</div>
				</c:if>
				<c:set var="count" value="${1}" />
				<c:if test="${flightList.size()>0}">
					<div class="table-responsive">
						<table class="table table-bordered" id="dataTable" width="100%"
							cellspacing="0">
							<thead>
								<tr>
									<th scope="col">#</th>
									<td scope="col">Airline</td>
									<td scope="col">Passenger</td>
									<td scope="col">Source</td>
									<td scope="col">Destination</td>
									<td scope="col">Departure Time</td>
									<td scope="col">Arrival Time</td>
									<td scope="col"></td>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${flightList}" var="flight">
									<tr>
										<th scope="row">${1}</th>
										<td><c:out value="${flight.getAirline()}" /></td>
										<td><c:out value="${flight.getPassengerName()}" /></td>
										<td><c:out value="${flight.getFrom()}" /></td>
										<td><c:out value="${flight.getTo()}" /></td>
										<td><c:out value="${flight.parseDate(0)}" /></td>
										<td><c:out value="${flight.parseDate(1)}" /></td>
										<c:if test="${flight.isFuture()}">
											<td><c:out value="${flight.parseDate(1)}" /></td>
										</c:if>
										<c:if test="${!flight.isFuture()}">
											<td></td>
										</c:if>
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