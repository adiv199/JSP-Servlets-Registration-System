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
<title>Report By Student</title>
</head>
<body>
<% 
//out.println(request.getContextPath());
//out.println(request.getServletContext());

//Enumeration e = request.getAttributeNames();
//while (e.hasMoreElements()) {
 // String name = (String) e.nextElement();
  //out.println(name + ": " + request.getAttribute(name));
//}
//System.out.println(request.getAttributeNames());
//out.println((ArrayList<TestBean>)request.getAttribute("list"));%>


<table>
<tr>
	<th>SELECT A STUDENT</th>
	<th>COURSES</th>
</tr>
<tr>
	<td>
	<BR/>
	<form method="post" action = "ReportServlet">
	<input type="hidden" name="action" value="courseByStudent">
	<SELECT id="students" NAME="students" SIZE="4" >
	<c:forEach items="${list}" var="i">
		<OPTION value = "${i.userId}"> <c:out value="${i.userId}" ></c:out>
	</c:forEach>
	</SELECT>
	<br/>
	<br/>
	<input type="submit" value="Display courses for this students" />
	</form>	
	</td>

	<td> 
 
	<b><font color="blue"><c:out value="${answer}" /></font> </b>
	<br/>
	<ul style="list-style: none;">
	<c:forEach items="${courselist}" var="j">
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