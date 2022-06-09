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

/**
 * Servlet implementation class AdminDelete
 */
public class AdminDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminDelete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out=response.getWriter();
		String query="select ProductId,ProdcutName,ProductPrice,modelYear,color,Total_Quantity from ProductDetails";
		ArrayList<ProductDetails>  productdetails=new ArrayList();
		try {
			ResultSet rs=DataBaseConnection.getResultset(query);
			while(rs.next()) {
				int ProductId=rs.getInt("ProductId");
				String ProdcutName=rs.getString("ProdcutName");
				double ProductPrice=rs.getDouble("ProductPrice");
				int modelYear=rs.getInt("modelYear");
				String color=rs.getString("color");
			
				int Total_Quantity=rs.getInt("Total_Quantity");
				productdetails.add(new ProductDetails(ProductId,ProdcutName,ProductPrice,modelYear,color,Total_Quantity));
				
			}
			//request.getSession(false).setAttribute("details", productdetails);
			request.getSession(false).setAttribute("details",productdetails);
			request.setAttribute("details", productdetails);
			RequestDispatcher rd=request.getRequestDispatcher("Delete.jsp");
			rd.forward(request, response);
		
		} catch (Exception e) {
			System.out.println("Check connection");
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
