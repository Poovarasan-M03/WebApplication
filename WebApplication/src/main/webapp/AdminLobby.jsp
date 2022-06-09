<%@ page language="java" contentType="text/html; charset=ISO-8859-1"pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Lobby</title>
<style>
body{
background-image:url("shopping.jpg");
background-repeat:no-repeat;
background-attachment:fixed;
background-size:cover;
background-size:100% 100%;

}</style>
</head>
<center><h1 style=color:blue;>ADMIN DASHBOARD</h1></center><br>
<body>
<style>
button1 {
	background-color: #04AA6D;
	color: white;
	padding: 14px 20px;
	margin: 8px 0;
	border: none;
	cursor: pointer;
	width: 20%;
	opacity: 0.9;
}

button:hover {
	opacity: 1;
}
button {
	background-color: #13A42D;
	color: white;
	padding: 14px 20px;
	margin: 8px 0;
	border: none;
	cursor: pointer;
	width: 30%;
	opacity: 0.9;
}

button:hover {
	opacity: 1;
}

.bill {
	float: center;
	width: 10%;
}
.button5{
background-color: #f44336; /* Red */
}
.exit{
float: center;
	width: 10%;
}
</style>
	
  
  <form action="AdminViewSetvlet" method=post>
  
  
  <center><button type="submit"  class="button1">View Product</button>
          <br>
          <br>
          <br>
</form>
<form action="Insert.jsp" method=post>
<center><button type="submit"  class="button2">Insert Product</button>
<br><br><br>
</form>
<form action="AdminUpdate" method=post>
<center><button type="submit"  class="button3">Update Product</button>
<br><br><br>
</form>
<form action="AdminDelete" method=post>
<center><button type="submit"  class="button4">Delete Product</button>
<br><br><br>
</form>
<form action="Lobby.jsp" method=post>
<center><button type="submit" style=button-color:red; class="button5">Exit</button>
</form>
</body>
</html>