<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
String msg=(String)request.getAttribute("msg");
response.sendError(HttpServletResponse.SC_CONFLICT);
%>
<h2><%=msg %></h2>
<br>
<a href="Book.html">AddBookDetails</a>
<a href="view1">ViewBookDetails</a>
<a href="logout">Logout</a>
</body>
</html>