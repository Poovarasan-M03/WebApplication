<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Forgot Verify</title>

</head>
<body>


<style>

input[type=numeric], input[type=text] {
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
<form  action="ForgotValidateServlet" method=post>
<%-- <%request.getSession(false).getAttribute("email"); %> --%>
<center><p><b>Email Id</p>
<%=session.getAttribute("email") %></b>
</center>



<center><label for="text"><b>Enter otp</b></label> <br>
			<input type="numeric" placeholder="Enter  otp" name="checkotp" required></center>


<center><label for="text"><b>Reset Password</b></label> <br>
			<input type="text"placeholder="Reset Password" name="password" 
			pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" title="Must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters" required></center>	
<center><button type="submit" class="forgot"> Confirm</button>	</center>	
    
    <%String message=(String) request.getAttribute("message");
         if(message!=null){%>
        <center><h3 style=color:red;> <%= (String)request.getAttribute("message") %> </h3></center><%} %>
        
      <center>  <% String otp=String.valueOf(request.getAttribute("otp"));
        if(otp!=null){%>
        <%=otp %>
        <%} %></center>
        
        
        
        <!-- <form action="forgot.jsp">
        <button type="submit">back</button> -->
        </form>
</body>
</html>