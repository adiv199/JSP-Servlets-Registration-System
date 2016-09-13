<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home Page</title>
<link rel="stylesheet" href="style.css">
</head>
<body>
	<jsp:useBean id="userBean" scope="session"
		class="com.uic.ids520.bean.UserBean">
	</jsp:useBean>
	<jsp:useBean id="errorMessageBean" scope="request"
		class="com.uic.ids520.bean.ErrorMessageBean">
	</jsp:useBean>
	<h1>Home Page</h1>
	<p>
		Welcome,
		<%=userBean.getFirstName()%></p>
	<form action="LogoutServlet" method="post">
		<input type="submit" name="Logout" value="Logout" />
	</form>
	<form id="retrieveCourses" method="get" action="RetrieveCourses">
		<input type="submit" value="Course Registration">
	</form>
	<br>
	<form action="ReportServlet" method="post">
	<input type="hidden" name="action" value="goToReportsMenu">
		<input type="submit" name="ServerReports" value="View Server Reports" />
	</form>
</body>
</html>