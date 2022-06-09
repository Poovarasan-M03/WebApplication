
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SignUp Page</title>
<style>
body{
background-image:url("shop.jpg");
background-repeat:no-repeat;
background-attachment:fixed;
background-size:cover;
background-size: 102% 102%;



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
.signup{

width: 30%;
padding: 20px;
background-color: rgba(201, 76, 76, 0.3);
margin: 10px;
border-radius: 10px;
       }

button:hover {
	opacity: 1;
}

.signupbtn {
	float: center;
	width: 10%;
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
<body>



	<form action="SignUpServlet" method=post>
		<div class="container">
			<center>
				
				
			<hr>
<%String message=(String) request.getAttribute("message");
if(message!=null){%>
<center><h2 style=color:red;> <%= (String) request.getAttribute("message") %> </center></h2>
<%} %>
<br>    
                 
                <h1>Sign Up</h1>
				<p>Please fill in this form to create an account.</p>
			</center>

			<center><label for="email"><b>Email</b></label> <br>
			<input type="email"placeholder="Enter Email" name="email" required></center>
			<center><label for="psw"><b>Password</b></label> <br>
			<input type="password"placeholder="Enter Password" name="psw" required></center> 
			<center><label for="psw-confirm"><b>Confirm Password</b></label> <br>
			<input type="password" placeholder="Confirm Password" name="psw-confirm"pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" title="Must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters" required></center>

			<div class="clearfix">

				<button type="submit" class="signupbtn">Sign Up</button><br>
				<a href="Login.jsp">I have already account</a>

			</div>

		</div>
	</form>
	
	
</style>
</body>


</html>