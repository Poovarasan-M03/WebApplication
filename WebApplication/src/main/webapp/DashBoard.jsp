<%@ page language="java" contentType="text/html; charset=ISO-8859-1"pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.sella.webapp.bean.*"%>

<!DOCTYPE html> 
<html>
<head>
<meta charset="ISO-8859-1">
<title>DashBoard Page</title>
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
.wishlist{
float:center;
width:50%;
}



</style>


	<style>
	
	button2{
	background-color: #13A42D;
	color: white;
	padding: 14px 20px;
	margin: 2px 0;
	border: none;
	cursor: pointer;
	width: 10%;
	opacity: 0.9;
	
	
	       }
button {
	background-color: #13A42D;
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
<form action="WishListServlet"><center><button type="submit" class="wish" name="wishlist" >Submit WishList</button></center> 

<%String message=(String) request.getAttribute("message");
if(message!=null){%>
<center> <h4 style=color:red;><%=(String) request.getAttribute("message") %></h4> </center>
<%} %>
	<table border="1" width="200" align="center">
		<tr bgcolor="F0F8FF">
		    <!-- <th><b>Email Id</b> -->
			<th><b>Product Id</b></th>
			<th><b>Product Name</b></th>
			<th><b>Product Price</b></th>
			<th><b>ModelYear</b></th>
			<th><b>Color</b></th>
			<th><b>Total_Quantity</b>
			<th><b>Add WishList</b>
		</tr>
		<%-- <%ArrayList<Products>list=new ArrayList<Products>();%> --%>
       <% for(ProductDetails p:std){%>
       
		<%-- Arranging data in tabular form
        --%>
		<tr>
		    
		    <%-- <%request.getSession(false).setAttribute("emailid",(String)request.getParameter("emailid"));%>
		    <%=request.getSession(false).setAttribute("emailid",(String)request.getParameter("emailid"))%> --%>
		    
			<td><%=p.getProductId()%></td>
			
			<td><%=p.getProdcutName() %></td>
			<td><%=p.getProductPrice()%></td>
			<td><%=p.getModelYear() %></td>
			<td><%=p.getColor() %></td>
			<td><%=p.getTotal_Quantity() %>
			
			<td>
              <input type="checkbox" name="products" value=<%=p.getProductId()%> ></td>
              
		</tr>
		<%TotalQ=p.getTotal_Quantity(); %>
		<%}%></table><hr><br>
		<br>
		
		
		<br>
		<br>
		</form>
		<center></center>
		
		<!-- <form action="BillGenerate"> -->
		<center><form action="UpdateQty" method=post>
          <label for="product"><b>Choose your ProductId:</b></label> 
          
		<select name="productid">
			<%for(ProductDetails pd:std){%>
				
				<option values=<%=pd.getProductId()%>><%=pd.getProductId()%></option>
			<%} %></center>
		</select><br><br>
		<br><hr style=color:#ffebc4;>
		
	<center><label for="number" ><b>Enter Quantity:</b></label>

  <input type="number" id="points" name="quantity" step="1" style=width:65px min="1" max="1000" required></center><br>
  <br><hr>
 
  
  <center><button type="submit"  class="Bill"><b>Bill</b></button></center><hr>
</form>
  
    <center><form action="Login.jsp">
    <button type="submit" class="Back"><b>Back<b></b></button></center></form>
	<!-- <center><a href="Login.jsp"> Back</a></center> -->
	        
	<center>
	
<%-- <form action="Myorders">	
<%String email=request.getParameter("emailid"); %>
	<%request.setAttribute("emailid",email); %> 
	<button type="submit" class="myoreders">Myorders</button>
	
	</form> --%>
	
	
	
	</body> 
</html>
