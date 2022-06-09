<%@ page language="java" contentType="text/html; charset=ISO-8859-1"pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body><style>
.update{
   float:center;
   width:20%
}
.hello{
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
}</style>
<center></center>
 <form action ="AdUpdate" > 
 <% String pid = request.getParameter("productid");%> 
 
<% String  pname= request.getParameter("productname");%>
  
<% String  pprice= request.getParameter("productprice");%>
 
<% String  pmodel= request.getParameter("productmodel");%>
 
<% String  pcolor= request.getParameter("productcolor");%>
 
<% String  pqty= request.getParameter("productqty");%>
 


<!-- <form action="AdUpdate"> -->
<!-- Change quantity <input type="number" name="changequantity"><br>
 --> <!-- <center><h1 style=color:blue;>UPDATE PRODUCT</h1></center> -->  
 <%-- <center><input type="hidden" name="updateid" value=<%=pid %>> --%><center>
 <%-- ProductId :<%=request.getSession(false).getAttribute("ProductId") %><br><br> --%>
 
 <%-- ProductId:<%request.getSession().get%> --%>
 
 
 
 ProductId:<%request.getSession(false).setAttribute("pid", pid);%><%=request.getSession(false).getAttribute("pid") %>
  <br>
  <br>
 <%-- <input type="number" placeholder=<%=pid %> value="pid " name="pid" min="1" ><br><br>  --%>
Product Name&nbsp; :&nbsp;&nbsp; <input type="text" name="productName" placeholder= <%=pname %> value="productName" required  ><br><br>
Product Price&nbsp;&nbsp;&nbsp;: &nbsp;&nbsp;
<input type="text" placeholder=<%=pprice %> value="price" min="1" name="price" required ><br><br>
Model year &nbsp;&nbsp;&nbsp;&nbsp;:&nbsp;&nbsp;<input type="number" placeholder="Model Year" name="model" min="1" required><br><br>
Color &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;:&nbsp;&nbsp;<input type="text" placeholder="Color " name="color" required><br><br>
Quantity &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;:&nbsp;&nbsp;<input type="number"  placeholder=" quantity" name="quantity" min="1" required><br><br>
    
     </center>


<center><button type="submit"class="update" name="hello">Update</button></form></center>
</body>
</html>