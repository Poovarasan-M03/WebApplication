<%@ page language="java" contentType="text/html; charset=ISO-8859-1"pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.ArrayList"%>
<%@page import="com.sella.webapp.bean.*"%>
<%@page import="java.time.*"%>
<%@ page import ="java.time.format.DateTimeFormatter" %>
<%-- <%@page import="java.Date"%> --%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Bill</title>


</head>
<% DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");//yyyy/MM/dd HH:mm:ss
DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern("HH:mm:ss");
LocalDateTime date = LocalDateTime.now();
LocalDateTime time = LocalDateTime.now(); %>
<body>
<br>
<%ArrayList<ProductDetails> std = 
            (ArrayList<ProductDetails>)request.getSession(false).getAttribute("details1");%>
            <center><h1>Bill Details</h1></center>
            <% for(ProductDetails p:std){%> 
<table border="1" width="200" align="center">

            <tr><td><b>EmailId</b></td>
            <td><%=request.getSession(false).getAttribute("emailid") %></td></tr>
            <%String emailid=(String) request.getSession(false).getAttribute("emailid") ;%>    
             <%request.getSession(false).setAttribute("emailid",emailid); %> 

            <tr><td><b>Product Id</b></td>
            <td><%=p.getProductId()%></td></tr>
            <%-- <%=p.getProductId() %> --%>
            <% request.getSession(false).setAttribute("pid", p.getProductId());%>
            
            
			<tr><td><b>Product Name</b></td>
			<td><%=p.getProdcutName()%></td></tr>
			<% request.getSession(false).setAttribute("pname", p.getProdcutName());%>
			
			
			<tr><td><b>Date</b>
			<td><%=(dtf.format(date)) %></td></tr>
			
			<%request.getSession(false).setAttribute("date", (dtf.format(date)));%>
			
			<tr><td><b>Time</b>
			<td><%=(dtf1.format(time)) %></td></tr>
			<% request.getSession(false).setAttribute("time", (dtf1.format(time)));%>
			
			<tr><td><b>Product Price</b></td>
			<td><%=p.getProductPrice()%></td></tr>
			<%request.getSession(false).setAttribute("pprice", p.getProductPrice()); %>
			
			<tr><td><b>ModelYear</b></td>
			<td><%=p.getModelYear() %></td></tr>
			<%request.getSession(false).setAttribute("pmodelyear", p.getModelYear()); %>
			
			<tr><td><b>Color</b></td>
			<td><%=p.getColor() %></td></tr>
			
			<% request.getSession(false).setAttribute("pcolor", p.getColor());%>
			
			
			
			<tr><td><b>Quantity</b></td>
			<td><%=request.getSession().getAttribute("quantity")%></td></tr>
			
			<%request.getSession(false).setAttribute("pqty", request.getSession(false).getAttribute("quantity")); %>
			
			<tr><td><b>Total Amount</b></td>
			<td><%=request.getSession(false).getAttribute("TotalAmount")%></td></tr>
			
			<%request.getSession(false).setAttribute("totalqty",request.getSession(false).getAttribute("TotalAmount") ); %>
			<%}%> 
			

</table><br><center>
<style>
.button5{
background-color: #ff0000;
	color: white;
	padding: 10px 10px;
	margin: 4px 0;
	border: none;
	cursor: pointer;
	width: 10%;
	opacity: 0.9;
       }
button {
	background-color: #13A42D;
	color: white;
	padding: 10px 10px;
	margin: 4px 0;
	border: none;
	cursor: pointer;
	width: 20%;
	opacity: 0.9;
}
button:hover {
	opacity: 1;
}

.bill {
	float: center;
	width: 10%;
}


</style>


<form action="Qty"> 

                          
<button type="submit"  class="bill" >Confirm</button>

</center><br>

</form>

<!-- <form action="DashBoard.jsp"> -->
<form action="DashBoardServlet"> 

<center>
<button type="submit"  class="bill">Back</button></center>
</form>
<br><hr><br>
<%String message=(String) request.getAttribute("message");
if(message!=null){%>
<center><h4 style=color:blue;> <%= (String) request.getAttribute("message") %></h4> </center>
<%} %><hr>
<form action="Lobby.jsp">
<center><button type="submit" style=button-color:red; class="button5">Exit</button>
<br>
<br>


</form>

</body>
</html>