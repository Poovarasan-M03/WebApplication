<%@ page language="java" contentType="text/html; charset=ISO-8859-1"pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.ArrayList"%>
<%@page import="com.sella.webapp.bean.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View</title>
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
	background-color: #FFD700;
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
	
	<%String message=(String) request.getAttribute("message");
                 if(message!=null){%>
        <center> <h4 style=color:red;><%= (String) request.getAttribute("message") %> </h4></center><%} %>
        
        
        <%String message3=(String) request.getAttribute("message3");
                 if(message3!=null){%>
        <center> <h4 style=color:red;><%= (String) request.getAttribute("message3") %> </h4></center><%} %>
        
        
        
        <%String message5=(String) request.getAttribute("message5");
                 if(message5!=null){%>
        <center> <h4 style=color:#07f70f;><%= (String) request.getAttribute("message5") %> </h4></center><%} %>
        
        
        
        
        <%String message1=(String) request.getAttribute("message1");
                 if(message1!=null){%>
        <center> <h2 style=color:#07f70f;><%= (String) request.getAttribute("message1") %> </h2></center><%} %>
        
	<table border="1" width="300" align="center">
		<tr bgcolor="F0F8FF">
			<th><b>Product Id</b></th>
			<th><b>Product Name</b></th>
			<th><b>Product Price</b></th>
			<th><b>ModelYear</b></th>
			<th><b>Color</b></th>
			<th><b>Total_Quantity</b>
		</tr>
		
       <% for(ProductDetails p:std){%>
       
		<%-- Arranging data in tabular form
        --%>
		<tr>
			<td><%=p.getProductId()%></td>
			
			<td><%=  p.getProdcutName() %></td>
			<td><%=p.getProductPrice()%></td>
			<td><%=p.getModelYear() %></td>
			<td><%=p.getColor() %></td>
			<td><%=p.getTotal_Quantity() %>
		</tr>
		<%TotalQ=p.getTotal_Quantity(); %>
		<%}%></table><hr>
		<center>
		
		

	<center><a href="AdminLobby.jsp"> Back</a></center>
		
	
	        
</body>
</html>