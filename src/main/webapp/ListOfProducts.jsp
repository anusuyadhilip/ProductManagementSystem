<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List, com.product.Product" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>List of Products</title>
</head>
<body>

<h2>List of Products</h2>

<%
    List<Product> list = (List<Product>) request.getAttribute("list");
    if (list != null && !list.isEmpty()) {
%>
    <table border="1" cellpadding="5" cellspacing="0">
        <thead>
            <tr>
                <th>Product Id</th>
                <th>Product Name</th>
                <th>Product Price</th>
                <th colspan="2">Action</th> <!-- Added colspan to accommodate two action links -->
            </tr>
        </thead>
        <tbody>
<%
        for (Product product : list) {
%>
            <tr>
                <td><%= product.getId() %></td>
                <td><%= product.getProductName() %></td>
                <td><%= product.getProductPrice() %></td>
                <td><a href="/ProductManagementSystem/register?action=update&id=<%= product.getId() %>">Update</a></td> <!-- Added link with product ID -->
                <td><a href="/ProductManagementSystem/register?action=delete&id=<%= product.getId() %>">Delete</a></td> <!-- Added link with product ID -->
            </tr>
<%
        }

%>
        </tbody>
    </table>
    <a href="/ProductManagementSystem/register?action=create">Add the product</a>
<%
    } else {
%>
    <p>No products available.</p>
<%
    }
%>

</body>
</html>