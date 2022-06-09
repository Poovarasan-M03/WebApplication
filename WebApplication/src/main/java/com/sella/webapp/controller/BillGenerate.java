package com.sella.webapp.controller;

import java.io.IOException;


import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.sella.webapp.bean.ProductDetails;
import com.sella.webapp.dao.DataBaseConnection;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.Password;

/**
 * Servlet implementation class BillGenerate
 */
public class BillGenerate extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//private static final Object TotalAmount = null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BillGenerate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @param TotalAmount 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out=response.getWriter();
	
		ArrayList productdetails1=new ArrayList();

		int s=(int) request.getSession(false).getAttribute("temp");
		int quantity=(int) request.getSession(false).getAttribute("quantity");
		int productid=(int) request.getSession(false).getAttribute("pid");
		String emailid=(String) request.getSession(false).getAttribute("emailid");
		
	    
		int TotalAmount=0;
		String query="select * from ProductDetails where ProductId='"+productid+"'";
		try {
			ResultSet rs=DataBaseConnection.getResultset(query);
			while(rs.next()) {
				int ProductId=rs.getInt("ProductId");
				String ProdcutName=rs.getString("ProdcutName");
				double ProductPrice=rs.getDouble("ProductPrice");
				int modelYear=rs.getInt("modelYear");
				String color=rs.getString("color");
				int Total_Quantity=rs.getInt("Total_Quantity");
				
				//junit
				Password password=new Password();
			double totalamount=password.amountCheck(quantity,ProductPrice);
				 TotalAmount=(int) (quantity*ProductPrice);
				//System.out.println(TotalAmount);
				productdetails1.add(new ProductDetails(ProductId,ProdcutName,ProductPrice,modelYear,color,Total_Quantity));
	}
    request.getSession().setAttribute("details1", productdetails1);
    request.getSession().setAttribute("quantity", quantity);
    request.getSession().setAttribute("TotalAmount", TotalAmount);
    request.getSession(false).getAttribute("emailid");
    request.getSession(false).setAttribute("emailid", emailid);
    
    request.getSession().setAttribute("pid",productid );
	
	 RequestDispatcher rd=request.getRequestDispatcher("Bill.jsp");
	rd.forward(request, response);
	
}
catch (Exception e) {
	System.out.println("Check");
	e.printStackTrace();
}}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
