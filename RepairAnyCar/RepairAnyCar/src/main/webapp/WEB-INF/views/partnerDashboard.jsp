<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1 align="center"> DashBoard of ${sessionScope.serviceCenter.serviceCenterName} </h1>
<a href="${pageContext.request.contextPath}/partner/request"> View Customer requests</a>

<div align="right">
		<a href="${pageContext.request.contextPath}/customer/logout"><b> Logout</b></a>
	</div>
</body>
</html>