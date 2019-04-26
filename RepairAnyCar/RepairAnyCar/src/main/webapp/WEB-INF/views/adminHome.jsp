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
<h1> Welcome  Admin</h1>
	<div align="right">
		<a href="logout"><b> Logout</b></a>
	</div>
	

	<div align="center">
		<a href="${pageContext.request.contextPath}/admin/register"><b> Add Service center</b></a>
	</div>
	
	
<table>
<tr>
<td> 	<div align="center">
	<c:forEach  var="serviceCenters" items="${serviceCenterList}"> 
<%-- 	<a href="${pageContext.request.contextPath}/serviceCenter/dashboard?serviceCenterId=${serviceCenters.serviceCenterId}">${serviceCenters.serviceCenterName}</a>  <br> --%>
	<h4><i>${serviceCenters.serviceCenterName}</i></h4> <a href="${pageContext.request.contextPath}/admin/delete?serviceCenterId=${serviceCenters.serviceCenterId}"> delete</a><br>
	
	</c:forEach>
	
	</div>
	</td>
	</tr>
</table>

</body>
</html>