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
 * Servlet implementation class AdDelete
 */
public class AdDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdDelete() {
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
			int ProductId=Integer.parseInt(request.getParameter("deleteid"));
			ArrayList<ProductDetails> al=new ArrayList<ProductDetails>();
			
			ProductDetails.add(new ProductDetails(ProductId));
			String query="delete from ProductDetails where ProductId=?" ;
			 System.out.println(query);
			 PreparedStatement pst=DataBaseConnection.getConnection().prepareStatement(query);
			    pst.setInt(1, ProductId);
				/*
				 * pst.setString(2, ProdcutName); pst.setDouble(3, ProductPrice);
				 * pst.setInt(4,modelYear ); pst.setString(5,color); pst.setInt(6,
				 * Total_Quantity);
				 */
				//pst.setInt(7,tq);
				pst.executeUpdate();
				
				
				
				String message3=" Sucessfully deleted";
				request.setAttribute("message3", message3);
				RequestDispatcher rd=request.getRequestDispatcher("AdminViewSetvlet");
				rd.forward(request, response);
				
				System.out.println("delete success");
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
