<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import ="java.util.*" %>
    <%@ page import ="java.io.*" %>
    <%@ page import ="com.uic.ids520.bean.*" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Students by course</title>
</head>
<body>
<table>
<tr>
	<th>SELECT A COURSE</th>
	<th>STUDENTS</th>
</tr>
<tr>
	<td>
	<BR/>
	<form method="post" action = "ReportServlet">
	<SELECT id="courses" NAME="courses" SIZE="4" >
	<c:forEach items="${list}" var="i">
	<OPTION value = "${i.courseNumber}"> <c:out value="${i.courseName}" ></c:out>
	</c:forEach>
	</SELECT>
	<br/>
	<br/>
	<input type="hidden" name="action" value="studentByCourse">
	<input type="submit" value="Display Students for this course" />
	</form>	
	</td>

	<td>   
	<b><font color="blue"><c:out value="${answer}" /></font></b>
	<br/>
	<ul style="list-style: none;">
	<c:forEach items="${studentlist}" var="j">
  	<li><c:out value="${j}" /></li>
 	</c:forEach> 
	</ul>
	</td>
</tr>
</table>
<br/>
<br/>
<form action="ReportServlet" method="post">
<input type="hidden" name="action" value="goBack">
<input type="submit" name="Back" value="Back to Menu" />
</form>   
</body>
</html>