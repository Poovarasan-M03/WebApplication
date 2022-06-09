<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin SignUp</title>

</head>
<body>
<style>

body {
	 font-family: Arial, Helvetica, sans-serif; 
	/* font-family:Times New Roman", Times, serif; */
}

* {
	box-sizing: border-box;
}

/* Full-width input fields */
input[type=email], input[type=password],input[type=password] {
	width: 20%;
	padding: 20px;
	margin: 5px 0 22px 0;
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

.signupbtn {
	float: center;
	width: 10%;
}
.back{
float:center;
width:10%;
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
	padding: 16x;
}
</style>
<!-- <body> -->



	<form action="AdminSignUpServlet" method=post>
		<div class="container">
			<center>
				
				<h1>Admin Sign Up</h1>
				<p>Please fill in this form to create an account.</p>
			</center>
			<hr>
<%String message=(String) request.getAttribute("msg");
if(message!=null){%>
<center> <h4 style=color:red;><%= (String) request.getAttribute("msg") %></h4> </center>
<%} %>
<br>

			<center><label for="email"><b>Email</b></label> <br>
			<input type="email"placeholder="Enter Email" name="email" required></center>
			<center><label for="password" placeholder="Enter Admin Id" name="Admin"><b>AdminId</b></label> <br>
			<input type="password"placeholder="Enter Admin Id" name="Admin" required></center>
			<center><label for="psw"><b>Password</b></label> <br>
			<input type="password"placeholder="Enter Password" name="psw" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" title="Must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters" required><br></center> 
			<center><label for="psw-confirm"><b>Confirm Password</b></label> <br>
			<input type="password" placeholder="Confirm Password" name="psw-confirm" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" title="Must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters" required><br></center>

			<div class="clearfix">

				<button type="submit" class="signupbtn">Sign Up</button><br>

				

			</div>

		</div>
	</form>
	<form action="Lobby.jsp">
<center><button type= "submit"class="back">back</button></center>
</form>
	<center><a href="AdminLogin.jsp"  style=text-decoration:none;  style=color:darkblue; >I have already account</a></center>
</style>

</body>




</body>
</html>