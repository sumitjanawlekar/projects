<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1> Welcome  ${customer.firstName}</h1>

	<div align="right">
		<a href="${pageContext.request.contextPath}/customer/logout"><b> Logout</b></a>
	</div>
	
	<div align="right">
		<a href="${pageContext.request.contextPath}/car/register"><b> Add Cars</b></a>
	</div>
	
	<div align="center">
	<form action="${pageContext.request.contextPath}/serviceCenter/list" method="get">
	<h1> <i> <a >Search Service Centers </a></i></h1>
	<input type="submit" value="Search">
	</form>
	</div>
	<br>
	<br>
		<div align="center"> <h3><i>Your Bookings</i></h3>
	<c:forEach  var="booking" items="${customer.booking}"> 
	${booking.serviceCenter.serviceCenterName}  <br>
	${booking.appointmentTime}  <br>
	<font color="green"> ${booking.status} </font> <br>
	${booking.vechileNumber}  <br>
	<br>
	<br>
	</c:forEach>
	</div>
	
	<div align="right"> <h3><i>Your Vehicles</i></h3>
	<c:forEach  var="vehicles" items="${customer.vehicles}"> 
	${vehicles.model}  (${vehicles.numberPlate})<br>
	</c:forEach>
	
	</div>

<%-- 	<div align="left">
		Welcome <b style="color: red"> ${customer.getFirstName()} </b>
		<c:out value="${customer.firstName}" />

	</div> --%>

	<div>
		<table>
			<tr>
				<td>Customer name:</td>
				<td>${customer.firstName} ${customer.lastName} </td>
			</tr>
		</table>
	</div>

</body>
</html>