<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>
<%@page import="com.uic.ids520.bean.CourseBean"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Course Registration</title>
<link rel="stylesheet" href="style.css">
</head>
<body>
	<jsp:useBean id="userBean" scope="session"
		class="com.uic.ids520.bean.UserBean">
	</jsp:useBean>
	<jsp:useBean id="errorMessageBean" scope="session"
		class="com.uic.ids520.bean.ErrorMessageBean">
	</jsp:useBean>
	<p><jsp:getProperty name="errorMessageBean" property="errorMessage"/></p>
	<h1>Course Registration</h1>
	<form action="LogoutServlet" method="post">
		<input type="submit" name="Logout" value="Logout" />
	</form>
	<form id="registerCourse" method="post" action="courseRegisterServlet">
		<select name="courseValue">
			<c:forEach items="${courseList}" var="courseValue">
				<option value="${courseValue.courseName}">
					${courseValue.courseName}</option>
			</c:forEach>
		</select>
		<input type="submit" value="Register Course">
	</form>
	
	<br/>
	<br/>
	<a href="./homePage.jsp">Go Back to Home</a>
	
</body>
</html>