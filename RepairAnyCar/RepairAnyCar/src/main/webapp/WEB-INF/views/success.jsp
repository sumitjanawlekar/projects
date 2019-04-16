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
	<h1></h1>

	<div align="right">
		<a href="logout"><b> Logout</b></a>
	</div>
	
		<div align="right">
		<a href="${pageContext.request.contextPath}/car/register"><b> Add Cars</b></a>
	</div>

	<div align="left">
		Welcome <b style="color: red"> ${customer.getFirstName()} </b>
		<c:out value="${customer.firstName}" />

	</div>

	<div>
		<table>
			<tr>
				<td>Customer name:</td>
				<td>${customer.firstName}</td>
			</tr>
		</table>
	</div>
	Success view
</body>
</html>