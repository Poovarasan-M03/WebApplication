package com.sella.webapp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;

import com.sella.webapp.bean.ProductDetails;
import com.sella.webapp.bean.ProductException;
import com.sella.webapp.dao.DataBaseConnection;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Qty
 */
public class Qty extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Qty() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		int quantity=(int) request.getSession(false).getAttribute("quantity");
		int pid=(int) request.getSession(false).getAttribute("pid");
		String emailid=(String) request.getSession(false).getAttribute("emailid");
		//System.out.println(quantity);
		//System.out.println(pid);
		int availQ=0;
		ArrayList<ProductDetails> std = 
	            (ArrayList<ProductDetails>)request.getSession(false).getAttribute("details");
		//ArrayList<ProductDetails> al=(ArrayList<ProductDetails>) request.getSession(false).getAttribute("movies");
		Iterator<ProductDetails> iterator=std.iterator();
		while(iterator.hasNext()) {
			ProductDetails pd=(ProductDetails) iterator.next();
			if(pid==pd.getProductId())
				availQ=pd.getTotal_Quantity();
		}
		
		int temp=(int)request.getSession(false).getAttribute("temp");
		try {
			
		String query="update ProductDetails set Total_Quantity="+temp+" where ProductId='"+pid+"'";
		int inserted=DataBaseConnection.getUpdate(query);
		 if(inserted>0) {
			 //System.out.println("Inserted Sucessfully");
			 String message="Billing Genrate Success";
			 //System.out.println(message);
			 request.setAttribute("message", message);
			 request.getSession(false).setAttribute("emailid", emailid);
				 //RequestDispatcher rd=request.getRequestDispatcher("DashBoardServlet"); 
			 RequestDispatcher rd=request.getRequestDispatcher("BillGenerate");
		rd.forward(request, response);
		 }else 
		 response.sendRedirect("Bill.jsp");
			
		 
		 }catch(Exception e) {
		 e.printStackTrace();
		 out.println("OUT OF STOCK");
	}
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
