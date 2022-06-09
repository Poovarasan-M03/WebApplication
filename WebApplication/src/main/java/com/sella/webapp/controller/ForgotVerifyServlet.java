package com.sella.webapp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;

import com.sella.webapp.dao.DataBaseConnection;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ForgotVerifyServlet
 */
public class ForgotVerifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ForgotVerifyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String password=request.getParameter("password");
		String Confirm_Password = request.getParameter("confirmpassword");
        String email=(String) request.getAttribute("emailid"); 
		PrintWriter out =response.getWriter();
		
		System.out.println(password.equals(Confirm_Password));
		/* if(password.equals(Confirm_Password)) { */
		try {
			String query="update SignUp set Password=? where Email='"+email+"'";
			System.out.println(query);
			PreparedStatement pst=DataBaseConnection.getConnection().prepareStatement(query);
			pst.setString(1, Confirm_Password);
			pst.executeUpdate();
			
			String message="Password Changed Successfully";
			System.out.println(message);
			  request.setAttribute("message", message); 
			RequestDispatcher rd=request.getRequestDispatcher("Login.jsp");
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
