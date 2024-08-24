<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% out.println("sucesss data"); 
String productName=	request.getParameter("productName");
double productPrice=Double.parseDouble(request.getParameter("productPrice"));
%>
<p> ur product name is :<%=productName %> </p>
<p> ur product price is :<%=productPrice %> </p>
	
	<a href="/ProductManagementSystem/register?action=read">Show Products</a>
</body>
</html>