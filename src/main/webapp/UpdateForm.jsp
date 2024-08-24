<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="com.product.Product" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Edit Product</title>
</head>
<body>
<h2>Edit Product Details</h2>

<%
    // Assuming the "product" object is set in the request scope by the servlet
    Product product = (Product) request.getAttribute("product");
    if (product != null) {
%>

<form action="/ProductManagementSystem/register?action=update" method="post">
    <!-- Hidden input to store the product ID -->
    <input type="hidden" id="productId" name="productId" value="<%= product.getId() %>">

    <label>Product Name:</label>
    <input type="text" id="productName" name="productName" value="<%= product.getProductName() %>"><br><br>

    <label>Product Price:</label>
    <input type="number" id="productPrice" name="productPrice" value="<%= product.getProductPrice() %>"><br><br>

    <input type="submit" value="Update">
</form>

<%
    } else {
%>
    <p>Product not found.</p>
<%
    }
%>

</body>
</html>