<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lobby Page</title>
<style>


body{
background-image:url("shopp.jpg");
background-repeat:no-repeat;
background-attachment:fixed;
background-size:cover;
background-size:100% 100%;

}
</style>
</head>
<body>
<style>


body {
	font-family: Arial, Helvetica, sans-serif;
	
}

* {
	box-sizing: border-box;
}

/* Full-width input fields */
input[type=email], input[type=password] {
	width: 50%;
	padding: 25px;
	margin: 10px 0 25px 0;
	display: inline-block;
	border: none;
	background: #f1f1f1;
}

hr {
	border: 1px solid #f1f1f1;
	margin-bottom: 15px;
}

/* Set a style for all buttons */
button {
	background-color: #13A42D;
	color: white;
	padding: 15px 20px;
	margin: 8px 0;
	border: none;
	cursor: pointer;
	width: 80%;
	opacity: 0.9;
}

button:hover {
	opacity: 1;
}

.signupbtn {
	float: center;
	width: 30%;
}

/* Add padding to container elements */
.container {
	padding: 10px;
}

/* Clear floats */
.clearfix::after {
	content: "";
	clear: both;
	display: table;
	text-align: center;
}

.clearfix {
	text-align: center;
	padding: 10x;
}
</style>
<body>



	<form action="AdminSignUp.jsp" method=post>
		<div class="container">
		<table class="lobby">
			<center>
				
				<b><h1 style=color:black;>WELCOME TO ONLINE-SHOPPING</h1></b>
				<p style=color:white;>Please Click to Admin / User</p>
			</center>
			
<%-- <%String message=(String) request.getAttribute("message");
if(message!=null){%>
<center> <%= (String) request.getAttribute("message") %> </center>
<%} %> --%>
<br>

			

			<div class="clearfix">

				<button type="submit" class="signupbtn">Admin Login</button><br>

				

			</div>

		</div>
	</form>
	<form action="Login.jsp" method=post>
	<center><button type="submit" class="signupbtn">User Login</button><br></center>
	
	</form>
	</table>
	
</style>

</body>
</html>