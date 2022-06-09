<%@ page language="java" contentType="text/html; charset=ISO-8859-1"pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Login</title>
<style>



body{
background-image:url('online.jpg');
background-repeat:no-repeat;
background-attachment:fixed;
background-size:center;
background-size:55% 55%;

}

</style>

</head>
<body>
	<style>

 */
* {
	box-sizing: border-box;
}  /* Full-width input fields */
input[type=email], input[type=password] {
	width: 20%;
	 padding: 15px; 
	 margin: 5px 0 22px 0; 
	display: inline-block;
	border: none;
	background: #f1f1f1;
}

hr {
 	border: 1px solid #f1f1f1; 
	margin-bottom: 25px; 
} /* Set a style for all buttons */
button {
	background-color: #13A42D;
	color: white;
	padding: 14px 20px;
	margin: 4px 0; 
	border: none;
	cursor: pointer;
	width: 50%;
	opacity: 0.9;
}

button:hover {
	opacity: 1;
}

.loginbtn {
	float: center;
	width: 20%;
}

.container {
	padding: 16px;
	float:center;
}

.clearfix {
	text-align: center;
	padding: 16px;
} /* Clear floats */
.clearfix::after {
	clear: both;
	 display: table; 
	text-align: center;
}
</style>
<body>

	<form action="AdminLoginServlet"  method=post style="border: 1px solid #ccc">
		<div class="container">
			<center>
				<h1>Admin Login</h1>
				<p>Please login to access the page</p>
			
				<%String message=(String) request.getAttribute("message");
                 if(message!=null){%>
        <center> <h4 style=color:red;><%= (String) request.getAttribute("message") %> </h4></center><%} %>
				<div class="credentials">
					<label for="email"><b>Email</b></label><br> <input
						type="email" placeholder="Enter Email" name="emailid" required><br>
					<label for="psw"><b>Password</b></label><br> <input
						type="password" placeholder="Enter Password" name="password"
						pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" title="Must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters" required><br>
					<div class="clearfix">
						<button type="submit" class="loginbtn">Login</button><br>
						<!-- <a href="SignUp.jsp"  style="text-decoration:none">create Account</a> -->
					</div>
					
				</div>
		</div>
		
		
</body>

</body>
</html>