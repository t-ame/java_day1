<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="/flightbook" id="payment_form" method="post">
	
	
	<h4>Billing Information:</h4>
	
	<label for="full_name">Full Name: </label>
		<input type="text" name="full_name" required>
		
		<label for="card_number">Card Number: </label>
		<input type="number" name="card_number">
		
		<label for="zip_code">Zip Code: </label>
		<input type="number" name="zip_code">
	
		<input type="hidden" name="foward_jsp" id="foward_jsp" value="CustomerFlightBooking.jsp">
		
		<button type="button" onclick="backButton()">Back</button>
		<button type="submit">Pay</button>
		<button type="reset">Clear</button>
	</form>





    <script type="text/javascript">
        function backButton()
        {
            document.getElementById('payment_form').action = "/jsptojsp";
            payment_form.submit();
        } 
    </script>


</body>
</html>