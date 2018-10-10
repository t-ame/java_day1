<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ page import="java.util.List"%>
<!DOCTYPE html>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta charset="UTF-8">
<title>Flight Search</title>
<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">



</head>


<body>
	<main role="main" class="container">
	<form class="needs-validation" action="./flightsearch" method="post">
		<div
			style="padding: 2rem 1rem; margin-bottom: 2rem; background-color: #e9ecef; border-radius: .3rem;">
			<h1>Flight Query</h1>
			<div class="row mt-4">
				<div class="col-md-3">
					<label for="departure">From: </label> <select required
						name="departure" class="form-control" >
						<option disabled selected>Select</option>
						<option value="AL">Alabama</option>
						<option value="GA">Georgia</option>
						<option value="IL">Illinois</option>
						<option value="CA">California</option>
						<option value="TX">Texas</option>
					</select> 
				</div>
				<div class="col-md-3">


					<label for="destination">To: </label> <select required
						name="destination" class="form-control" >
						<option disabled>Select</option>
						<option value="AL">Alabama</option>
						<option value="GA">Georgia</option>
						<option value="IL">Illinois</option>
						<option value="CA">California</option>
						<option value="TX">Texas</option>
					</select> 
				</div>
				<div class="col-md-3">
					<label for="departure_date">Date</label> <input type="date"
						class="form-control" id="departure_date" name="departure_date" placeholder=""yyyy-MM-dd""
						value="" required>
				</div>
				<div class="col-md-3 mt-2">
					<label></label>
					<button class="btn btn-primary btn-lg btn-block"
						style="padding: 1px 7px 2px;" type="submit">Search</button>
				</div>
			</div>
		</div>
	</form>
	
	
	
	
	<h6 style="color: Red">${requestScope.errorMsg}</h6>
	<% request.setAttribute("errorMsg", ""); %>
	
	<c:if test="${sessionScope.flights !=null}">
		<div class="card mb-3">
			<div class="card-header">
				<i class="fas fa-table"></i> Flight Information
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
										<td><a href="/booking/${flight.getId()}">Select</a></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</c:if>
			</div>
		</div>
	</c:if> 
	
	</main>

</body>


</html>