package com.sella.webapp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import com.sella.webapp.dao.DataBaseConnection;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AdminLoginServlet
 */
public class AdminLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email=request.getParameter("emailid");
		String pwd= request.getParameter("password");
		request.getSession();
		PrintWriter out =response.getWriter();
		

		try {
			String query="Select EmailId,Password from AdminSignUp where EmailId='"+email+"' AND Password='"+pwd+"'";
			ResultSet rs=DataBaseConnection.DBLogin(query);
			
			if(rs.next())
			{
				
				RequestDispatcher r=request.getRequestDispatcher("AdminLobby.jsp");
				r.forward(request, response);
			}
			else {
				String message="Invalid EmailId / Password";
				request.setAttribute("message", message);
				RequestDispatcher r=request.getRequestDispatcher("AdminLogin.jsp");
				r.forward(request, response);
				}
			
		
		} catch (Exception e) {



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
