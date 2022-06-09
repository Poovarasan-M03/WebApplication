<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Forgot Password</title>
</head>
<body>
<style>

input[type=email] {
	width: 20%;
	padding: 15px;
	margin: 5px 0 22px 0;
	display: inline-block;
	border: none;
	background: #f1f1f1;
}
button {
	background-color: #04AA6D;
	color: white;
	padding: 14px 20px;
	margin: 4px 0;
	border: none;
	cursor: pointer;
	width: 10%;
	opacity: 0.9;
}

button:hover {
	opacity: 1;
}


</style>
<center>



<form action="ForgotServlet" method=post>

<label for="email" style=color:blue;><b>Email ID</b></label><br> 
<input type="email" placeholder="Enter Email" class="email" name="emailid" required><br>
<button type="submit" class="confirm" required>Confirm</button></center>
<%String message=(String) request.getAttribute("message");
         if(message!=null){%>
        <center><h3 style=color:red;> <%= (String) request.getAttribute("message") %> </h3></center><%} %>
</form>

</body>
</html>