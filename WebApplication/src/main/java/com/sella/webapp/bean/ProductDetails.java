package com.sella.webapp.bean;

public class ProductDetails {
	
	
	int ProductId;
	String ProdcutName;
	double ProductPrice;
	int modelYear;
	String color;
	int Total_Quantity;
	public int getProductId() {
		return ProductId;
	}
	public void setProductId(int productId) {
		ProductId = productId;
	}
	public String getProdcutName() {
		return ProdcutName;
	}
	public void setProdcutName(String prodcutName) {
		ProdcutName = prodcutName;
	}
	public double getProductPrice() {
		return ProductPrice;
	}
	public void setProductPrice(double productPrice) {
		ProductPrice = productPrice;
	}
	public int getModelYear() {
		return modelYear;
	}
	public void setModelYear(int modelYear) {
		this.modelYear = modelYear;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public int getTotal_Quantity() {
		return Total_Quantity;
	}
	public void setTotal_Quantity(int total_Quantity) {
		Total_Quantity = total_Quantity;
	}
	public ProductDetails(int productId, String prodcutName, double productPrice, int modelYear, String color,
			int total_Quantity) {
		super();
		ProductId = productId;
		ProdcutName = prodcutName;
		ProductPrice = productPrice;
		this.modelYear = modelYear;
		this.color = color;
		Total_Quantity = total_Quantity;
	}
	public ProductDetails(int productId2) {
		productId2=productId2;
	}
	@Override
	public String toString() {
		return "ProductDetails [ProductId=" + ProductId + ", ProdcutName=" + ProdcutName + ", ProductPrice="
				+ ProductPrice + ", modelYear=" + modelYear + ", color=" + color + ", Total_Quantity=" + Total_Quantity
				+ ", getProductId()=" + getProductId() + ", getProdcutName()=" + getProdcutName()
				+ ", getProductPrice()=" + getProductPrice() + ", getModelYear()=" + getModelYear() + ", getColor()="
				+ getColor() + ", getTotal_Quantity()=" + getTotal_Quantity() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	
}