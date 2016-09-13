<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import ="java.util.*" %>
    <%@ page import ="java.io.*" %>
    <%@ page import ="com.uic.ids520.bean.*" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>All registered students</title>
</head>
<body>

<h2> All Registered Students: </h2>
<br/>
<table border="1">
	<tr>
		<th>Student ID</th>
		<th>First Name</th>
		<th>Last Name</th>
		<th>Course ID</th>
		<th>Course Name</th>
	</tr>
	
	<c:forEach items="${list}" var="i">	
	<tr>
	<c:forEach begin="0" end="${fn:length(i) - 1}" var="index">
	<td><c:out value="${i[index]}"></c:out></td>
	</c:forEach>
	</tr>
	</c:forEach>
</table>
<br/>
<br/>
<form action="ReportServlet" method="post">
<input type="hidden" name="action" value="goBack">
<input type="submit" name="Back" value="Back to Menu" />
</form>
</body>
</html>