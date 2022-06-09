package com.sella.webapp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.sella.webapp.dao.DataBaseConnection;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class ForgotServlet
 */
public class ForgotServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ForgotServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session =request.getSession();
		String email= request.getParameter("emailid");
		System.out.println(request.getParameter("emailid"));
		request.getSession(false).setAttribute("email", email);

		session.setAttribute("email", email);
		//System.out.println(email);
	      
		PrintWriter out =response.getWriter();
		String otp="";
		try {
			String query="Select Email from SignUp where Email=?";
			System.out.println(query);
			PreparedStatement pst=DataBaseConnection.getConnection().prepareStatement(query);
			pst.setString(1,email);
			ResultSet rs=pst.executeQuery();
			if(rs.next())
			{
				
				int randompin=(int)(Math.random()*2300000)+5000;
				 otp = String.valueOf(randompin);
				System.out.println(otp);
			try {
				Thread.sleep(4000);
			}catch(InterruptedException e) {
				Thread.currentThread().interrupt();
			}
			String message="Enter below the otp";
			//String otp1=otp;
			request.setAttribute("otp", otp);
			request.setAttribute("message", message);
			request.getSession(false).setAttribute("checkotp", otp);
			//session.setAttribute("checkotp", otp);
			
			request.getRequestDispatcher("ForgotVerify.jsp").forward(request, response);
		}else {
			String message="Invalid user";
			request.setAttribute("message", message);
			request.getRequestDispatcher("Forgot.jsp").forward(request, response);
			
		}}catch (Exception e) {
					out.println("Check Connection!!!1");
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
