<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.ArrayList"%>
    <%@page import="com.sella.webapp.bean.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert Page</title>
</head>
<body><style>
button {
	background-color: #04AA6D;
	color: white;
	padding: 14px 20px;
	margin: 8px 0;
	border: none;
	cursor: pointer;
	width: 80%;
	opacity: 0.9;
}

button:hover {
	opacity: 1;
}
.signupbtn{
      float: center;
	width: 10%;
}</style>
<center><h1 style=color:blue;>INSERT PRODUCT</h1>
<form action="InsertServlet">
<label for="text" ><b>Enter ProductId&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;:&nbsp;</label>

 <input type="number"  name="Productid"  min="1"required>
 <br>
 <br>
 <tr><td><label for="text" ><b>Enter ProductName:&nbsp;</label></td></tr>

 <input type="text"  name="Productname" required>
 <br><br>
 <br>
 <label for="text"  ><b>Enter ProductPrice:&nbsp;</label>
 
 <input type="numeric" min="1"  name="Productprice" required>
 <br><br>
 <br>
 <label for="text" ><b>Model Year&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;:&nbsp;</label>

 <input type="number" min="1" name="Productmodel" required>
 <br><br>
 <br>
 <label for="text" ><b>Color&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;:&nbsp;</label>

 <input type="text"  name="Productcolor" required>
 <br><br>
 <br>
 <label for="text" ><b>Total_Quantity&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;:</label>

 <input type="number" min="1"  name="Productqty" required>
 <br><br>
 <br>
 <%String message=(String) request.getAttribute("message");
                 if(message!=null){%>
        <center> <h4 style=color:red;><%= (String) request.getAttribute("message") %> </h4></center><%} %>
 
<button type="submit" class="signupbtn">Submit</button><br>

</form>
</center>

</body>
</html>
    