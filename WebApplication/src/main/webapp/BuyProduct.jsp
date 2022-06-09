<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.sella.webapp.bean.*"%>
<%@page import="java.util.Iterator"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Buy Product</title>
</head>
<body>

	<%ArrayList<ProductDetails> std = 
            (ArrayList<ProductDetails> )request.getSession(false).getAttribute("details");
            %>
	
	<label for="products">Choose your Mobile:</label>
	<form action="">

		<select name="productdetails">
			<%for(ProductDetails pd:std){%>
				<option value=<%=pd.getProdcutName()%>><%=pd.getProdcutName()%></option>
			<%} %>
		</select>
	</form>
	<label for="points">Choose  Quantity:</label>
	<form>
	
  <input type="number" id="points" name="points" step="1" style=width:65px min="1" max="50">
  
</form>
<label for="products">Choose color:</label>
<form>
<input type="radio" id="product" name="color" value="Blue">
<label for="Blue">Blue</label>
<input type="radio" id="product" name="color" value="orange">
<label for="orange">orange</label>
<input type="radio" id="product" name="color" value="Red">
<label for="Red">Red</label>
<input type="radio" id="product" name="color" value="Black">
<label for="Red">Red</label>
<input type="radio" id="product" name="color" value="Black">
<label for="Black">Black</label>
</form>
</body>
</html>