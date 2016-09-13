<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<jsp:useBean id="error" class="com.uic.ids520.bean.ErrorMessageBean" scope="request"></jsp:useBean>
<h4 align="center" style="position: relative;left:0px;font-size:20px;color:red;""><jsp:getProperty name="error" property="errorMessage"/></h4>

<body>
<form action="LoginServlet" method="post">
<table>
<tr>
<td>
User ID:
</td>
<td>
<input type="text" name="user_id" value=""/>
</td>
</tr>
<tr>
<td>
Password:
</td>
<td>
<input type="password" name="password" value="">
</td>
</tr>
</table>
<input type="submit" name="submit" value="Login"/>
</form>
<a align="center" href="register.jsp">New User? Register Here!</a>
</body>
</html>