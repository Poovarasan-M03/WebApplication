<%@ page language="java" contentType="text/html; charset=ISO-8859-1"pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.ArrayList"%>
<%@page import="com.sella.webapp.bean.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Wishlist</title>
</head>
<body>
<center><h1>Product Details</h1>
	</center>
	<style>
	tr:nth-child(even) {
  background-color: #D6EEEE;
}



td:nth-child(even), th:nth-child(even) {
  background-color: #D6EEEE;
}
</style>
	<table border="1" width="600" align="center">
		<tr bgcolor="F0F8FF">
			<th><b>Product Id</b></th>
			<th><b>Product Name</b></th>
			<th><b>Product Price</b></th>
			<th><b>ModelYear</b></th>
			<th><b>Color</b></th>
			<th><b>Total_Quantity</b>
			<!-- <th><b>Add WishList</b> -->
		</tr>
		
		
		<%ArrayList<Products> list=(ArrayList)request.getAttribute("list");%>
		
       <% for( Products p:list){
      %>
		<%-- Arranging data in tabular form
        --%>
		<tr>
			<td><%=p.getProductId()%></td>
			
			<td><%=p.getProdcutName() %></td>
			<td><%=p.getProductPrice()%></td>
			<td><%=p.getModelYear() %></td>
			<td><%=p.getColor() %></td>
			<td><%=p.getTotal_Quantity() %><%} %>
			
</td></tr></table>
<center>
<a href=" DashBoard.jsp">Back</a></center>
</body>
</html>