<%@ page language="java" contentType="text/html; charset=ISO-8859-1"pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.ArrayList"%>
    <%@page import="com.sella.webapp.bean.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Delete</title>
</head>
<body>
<style>
table, td, th {
	border: 1px solid #ddd;
	text-align: left;
}

table {
	border-collapse: collapse;
	width: 100%;
}

th, td {
	padding: 15px;
}



</style>


	<style>
button {
	background-color: #ff0000;
	color: white;
	padding: 14px 20px;
	margin: 2px 0;
	border: none;
	cursor: pointer;
	width: 10%;
	opacity: 0.9;
}

button:hover {
	opacity: 1;
}
</style>
            <%ArrayList<ProductDetails> std = 
            (ArrayList<ProductDetails>)request.getSession(false).getAttribute("details");%>
            <%!int TotalQ=0; %>
	<center>
		<h1>Product Details</h1>
	</center>
	<table border="1" width="300" align="center">
		<tr bgcolor="F0F8FF">
			<th><b>Product Id</b></th>
			<th><b>Product Name</b></th>
			<th><b>Product Price</b></th>
			<th><b>ModelYear</b></th>
			<th><b>Color</b></th>
			<th><b>Total_Quantity</b>
			<!-- <th><b>Update Product</b> -->
		</tr>
		
       <% for(ProductDetails p:std){%>
       
		<%-- Arranging data in tabular form
        --%>
		<tr>
			<td><%=p.getProductId()%></td>
			
			 <td><%=p.getProdcutName()%></td>
			<td><%=p.getProductPrice()%></td>
			<td><%=p.getModelYear() %></td>
			<td><%=p.getColor() %></td>
			<td><%=p.getTotal_Quantity() %>
			</td> 
		<td>
<form action="">
<input type="hidden" name="productid" value="<%=p.getProductId() %>"/>
 <input type="hidden" name="productname" value="<%=p.getProdcutName() %>"/>
<input type="hidden" name="productprice" value="<%=p.getProductPrice() %>"/>
<input type="hidden" name="productmodel" value="<%=p.getModelYear() %>"/>
<input type="hidden" name="productcolor" value="<%=p.getColor() %>"/>
<input type="hidden" name="productqty" value="<%=p.getTotal_Quantity() %>"/> </td>

</form>
<%-- <form action="Delete" onsubmit="return user1()">
<input type="hidden" name="deleteid" value="<%=p.getProductId() %>"/>
<input type="submit" value="Delete"/>
</form> --%>

</tr>
		 <%TotalQ=p.getTotal_Quantity(); %>
		<%}%> </table><hr>
		
		<form action="AdDelete" method=post>
          <center><label for="products">Choose your ProductId:</label></center>
		
		<center><select name="deleteid">
			<%for(ProductDetails pd:std){%>
				
				<option values=<%=pd.getProductId()%>><%=pd.getProductId()%></option>
			<%} %><br>
			<br>
			<br><hr>
		</select></center>
		<center><button type="submit" value="Delete"/>Delete</button></center>
		
		


	<center><a href="AdminLobby.jsp"> Back</a></center>
		
	



</body>
</html>