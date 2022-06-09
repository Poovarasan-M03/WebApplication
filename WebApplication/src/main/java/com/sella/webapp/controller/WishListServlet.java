package com.sella.webapp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.sella.webapp.bean.ProductDetails;
import com.sella.webapp.bean.Products;
import com.sella.webapp.dao.DataBaseConnection;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class WishListServlet
 */
public class WishListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WishListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		
		
		ArrayList<Products>list=new ArrayList<Products>();

		try {
			if(request.getParameterValues("products") != null) {
				 String[] product = request.getParameterValues("products");

			for(int i=0;i<product.length;i++) {
				
				String query="select * from ProductDetails where ProductId='"+product[i]+"'";
				
				ResultSet rs=DataBaseConnection.getResultset(query);
				while(rs.next()) {
					String ProductName=rs.getString("ProdcutName");
					int ProductId=rs.getInt("ProductId");
					double ProductPrice=rs.getDouble("ProductPrice");
					int modelyear=rs.getInt("modelYear");
					String color=rs.getString("color");
					int totalQty=rs.getInt("Total_Quantity");
					list.add(new Products(ProductId,ProductName,ProductPrice,modelyear,color,totalQty));
				}
			}
			request.setAttribute("list", list);
			//System.out.println(list);
			RequestDispatcher rd=request.getRequestDispatcher("wishlist.jsp");
			rd.forward(request, response);
		}else {
			String message="Choose products to wishlist ";
			request.setAttribute("message", message);
			RequestDispatcher rd=request.getRequestDispatcher("DashBoard.jsp");
			rd.forward(request, response);
		}
			
		
	}catch(Exception e) {
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
