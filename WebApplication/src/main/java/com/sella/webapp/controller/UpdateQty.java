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
import oracle.net.aso.p;

/**
 * Servlet implementation class UpdateQty
 */
public class UpdateQty extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateQty() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		int quantity=Integer.parseInt(request.getParameter("quantity"));
		int pid=Integer.parseInt(request.getParameter("productid"));
		String emailid=(String) request.getSession(false).getAttribute("emailid");
		
		int availQ=0;
		int temp=0;
		//System.out.println("hiiii ");
		ArrayList<ProductDetails> std = 
	            (ArrayList<ProductDetails>)request.getSession(false).getAttribute("details");
		
		Iterator<ProductDetails> iterator=std.iterator();
		while(iterator.hasNext()) {
			ProductDetails pd=(ProductDetails) iterator.next();
			if(pid==pd.getProductId())
				availQ=pd.getTotal_Quantity();
		}
		
		temp=availQ-quantity;
		//System.out.println(availQ+"hiiii "+temp);
		//try {
				try {
				if((temp<0)||(quantity>availQ)) 
					throw new ProductException();
				request.getSession(false).setAttribute("temp",temp);
				request.getSession(false).setAttribute("quantity",quantity );
				request.getSession(false).setAttribute("pid",pid);
				request.getSession(false).setAttribute("emailid", emailid);
				RequestDispatcher rd=request.getRequestDispatcher("BillGenerate");
				rd.forward(request, response);
				}catch(ProductException e) {
					if(availQ>0) {
						String message="Available Quantity is lesser than requirement";
						request.setAttribute("message", message);
					}else {
						String message="OUT OF STOCK";
						request.setAttribute("message", message);
					}
					RequestDispatcher rd=request.getRequestDispatcher("DashBoardServlet");
					
					rd.forward(request, response);
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
