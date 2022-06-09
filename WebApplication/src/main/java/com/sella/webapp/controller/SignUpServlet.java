package com.sella.webapp.controller;

import java.io.IOException;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;

import com.sella.webapp.bean.ProductException;
import com.sella.webapp.dao.DataBaseConnection;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SignUpServlet
 */
public class SignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignUpServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String Email=request.getParameter("email");
		String Password=request.getParameter("psw");
		String ConfirmPassword=request.getParameter("psw-confirm");
		
		
		  try { 
			  if(!ConfirmPassword.equals(Password)) 
				  throw new ProductException();
			  
		  }catch(ProductException e) { 
			  String message="CHECK RE-ENTERED PASSWORD!";
		  request.setAttribute("message", message); 
		  RequestDispatcher rd=request.getRequestDispatcher("SignUp.jsp"); 
		  rd.forward(request, response);
		  }
	
		try {
		String message="ENTER UNIQUE EMAIL ID";
		request.setAttribute("message", message);
           if(Password.equals(ConfirmPassword)) {
			int inserted =DataBaseConnection.getPreparedStatement(Email,Password);
			if(inserted>0) {
				
				response.sendRedirect("Login.jsp");
			}}else {
				
				request.setAttribute("message", message);
				/* response.sendRedirect("SignUp.jsp"); */
				request.getRequestDispatcher("SignUp.jsp").forward(request, response);;
				
				
			}
		}catch(Exception e) {
			e.printStackTrace();
			
			String message="Already registered please login ";
			request.setAttribute("message", message);
			
			request.getRequestDispatcher("SignUp.jsp").forward(request, response);

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
