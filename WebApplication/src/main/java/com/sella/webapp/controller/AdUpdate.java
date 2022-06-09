package com.sella.webapp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.util.ArrayList;

import com.sella.webapp.bean.ProductDetails;
import com.sella.webapp.dao.DataBaseConnection;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AdUpdate
 */
public class AdUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdUpdate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		ArrayList ProductDetails=new ArrayList();
		try {
		//int ProductId=(int) request.getSession(false).getAttribute("ProductId");
		int ProductId=Integer.parseInt((String)request.getSession(false).getAttribute("pid"));
		System.out.println( ProductId);
		//int pid=Integer.parseInt(request.getParameter("pid"));
		String ProdcutName=request.getParameter("productName");
		double ProductPrice=Double.parseDouble(request.getParameter("price"));
		int modelYear=Integer.parseInt(request.getParameter("model"));
		String color=request.getParameter("color");
		int Total_Quantity=Integer.parseInt((String)request.getParameter("quantity"));
		
		
		ArrayList<ProductDetails> al=new ArrayList<ProductDetails>();
		
		ProductDetails.add(new ProductDetails(ProductId,ProdcutName,ProductPrice,modelYear,color,Total_Quantity));
		 String query="update ProductDetails set ProdcutName=?, ProductPrice=?, modelYear=?, color=? , Total_Quantity=? where ProductId='"+ProductId+"'" ;
		 //System.out.println(query);
		 PreparedStatement pst=DataBaseConnection.getConnection().prepareStatement(query);
		    
			pst.setString(1, ProdcutName);
			pst.setDouble(2, ProductPrice);
			pst.setInt(3,modelYear );
			pst.setString(4,color);
			pst.setInt(5, Total_Quantity);
			//pst.setInt(7,tq);
			pst.executeUpdate();
			String message1="Update Success";
			  request.setAttribute("message1", message1); 
			
			RequestDispatcher rd=request.getRequestDispatcher("AdminViewSetvlet");
			rd.forward(request, response);
			System.out.println("update success");
			}catch(NumberFormatException e) {
				String message="Please Enter valid Amount";
				  request.setAttribute("message", message); 
					
					  RequestDispatcher rd=request.getRequestDispatcher("AdminViewSetvlet");
					  rd.forward(request, response);
					 
			}
		
		catch(Exception e) {
				e.printStackTrace();
			}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
