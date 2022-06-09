package com.sella.webapp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.Iterator;

import com.sella.webapp.bean.ProductDetails;
import com.sella.webapp.dao.DataBaseConnection;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class InsertServlet
 */
public class InsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertServlet() {
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
		int ProductId=Integer.parseInt(request.getParameter("Productid"));
		String ProdcutName=request.getParameter("Productname");
		double ProductPrice=Double.parseDouble(request.getParameter("Productprice"));
		int modelYear=Integer.parseInt(request.getParameter("Productmodel"));
		String color=request.getParameter("Productcolor");
		int Total_Quantity=Integer.parseInt(request.getParameter("Productqty"));
		
		
		
		 ArrayList<ProductDetails> al=new ArrayList<ProductDetails>();
			
		 
		ProductDetails.add(new ProductDetails(ProductId,ProdcutName,ProductPrice,modelYear,color,Total_Quantity));
		String query="insert into ProductDetails values(?,?,?,?,?,?)";
		PreparedStatement pst=DataBaseConnection.getConnection().prepareStatement(query);
		pst.setInt(1, ProductId);
		pst.setString(2, ProdcutName);
		pst.setDouble(3, ProductPrice);
		pst.setInt(4,modelYear );
		pst.setString(5,color);
		pst.setInt(6, Total_Quantity);
		pst.executeUpdate();
		
		
		//System.out.println("hii");
		
		String message5="Inserted Successfully";
		request.setAttribute("message5", message5);
		
		RequestDispatcher rd=request.getRequestDispatcher("AdminViewSetvlet");
		rd.forward(request, response);
		}catch(NumberFormatException e) {
			String message="Please Enter valid input";
			  request.setAttribute("message", message); 
			  RequestDispatcher rd=request.getRequestDispatcher("Insert.jsp"); 
			  rd.forward(request, response);
		
		}catch(SQLIntegrityConstraintViolationException e) {
			String message="Please Enter a Unique ID";
			  request.setAttribute("message4", message); 
			  RequestDispatcher rd=request.getRequestDispatcher("Insert.jsp"); 
			  rd.forward(request, response);
		}catch(Exception e) {
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
