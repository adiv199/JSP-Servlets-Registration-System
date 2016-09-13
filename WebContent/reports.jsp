<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<br/>
<br/>
<br/>
<form method="post" action="ReportServlet">
<input type="hidden" name="action" value="courseByStudent">
<input type="submit" value="Courses by Students"><br/>
</form>
<br/>
<br/>
<form method="post" action="ReportServlet">
<input type="hidden" name="action" value="studentByCourse">
<input type="submit" value="Students By Courses"><br/>
</form>
<br/>
<br/>
<form method="post" action="ReportServlet">
<input type="hidden" name="action" value="studentAndCourse">
<input type="submit" value="Display all students and courses"><br/>
</form>
<br/>
<br/>
<form action="ReportServlet" method="post">
<input type="hidden" name="action" value="goBackToHome">
<input type="submit" name="Back" value="Back to Home Page" />
</form>
<br/>
<br/>
<form action="LogoutServlet" method="post">
<input type="submit" name="Logout" value="Logout" />
</form>
 
</body>
</html>