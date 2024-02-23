<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="test.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
AdminBean ab=(AdminBean)session.getAttribute("abean");
BookBean bb=(BookBean)request.getAttribute("bbean");
out.println("page belongs to :"+ab.getfName()+"<br>");
%>
<form action="update" method="post">
<input type="hidden" name="bcode" value=<%=bb.getCode()   %>>
BookPrice:<input type="text" name="price" value=<%=bb.getPrice() %>><br>
BookQty:<input type="text" name="qty" value=<%=bb.getQty() %>><br>
<input type="submit" value="UpdateBookDetails">
</form>
</body>
</html>