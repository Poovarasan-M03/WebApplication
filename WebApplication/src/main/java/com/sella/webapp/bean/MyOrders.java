package com.sella.webapp.bean;

public class MyOrders {
	private int Emailid;
    private int   ProductId;
    private String   productname  ;
    private double  productprice   ;
    private  String Date;
    private String Time;
    private int quantity;
    private int totalamt;
    
    
	public MyOrders(int emailid, int productId, String productname, double productprice, String date, String time,
			int quantity, int totalamt) {
		super();
		Emailid = emailid;
		ProductId = productId;
		this.productname = productname;
		this.productprice = productprice;
		Date = date;
		Time = time;
		this.quantity = quantity;
		this.totalamt = totalamt;
	}
	 
	
	@Override
	public String toString() {
		return "MyOrders [Emailid=" + Emailid + ", ProductId=" + ProductId + ", productname=" + productname
				+ ", productprice=" + productprice + ", Date=" + Date + ", Time=" + Time + ", quantity=" + quantity
				+ ", totalamt=" + totalamt + "]";
	}
	public int getEmailid() {
		return Emailid;
	}
	public void setEmailid(int emailid) {
		Emailid = emailid;
	}
	public int getProductId() {
		return ProductId;
	}
	public void setProductId(int productId) {
		ProductId = productId;
	}
	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	public double getProductprice() {
		return productprice;
	}
	public void setProductprice(double productprice) {
		this.productprice = productprice;
	}
	public String getDate() {
		return Date;
	}
	public void setDate(String date) {
		Date = date;
	}
	public String getTime() {
		return Time;
	}
	public void setTime(String time) {
		Time = time;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getTotalamt() {
		return totalamt;
	}
	public void setTotalamt(int totalamt) {
		this.totalamt = totalamt;
	}
    
}
