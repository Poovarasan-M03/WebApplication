package com.sella.webapp.controller;

import java.io.IOException;
import java.sql.PreparedStatement;

import com.sella.webapp.dao.DataBaseConnection;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class ForgotValidateServlet
 */
public class ForgotValidateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ForgotValidateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int checkotp=Integer.parseInt(request.getParameter("checkotp"));
		String password=request.getParameter("password");
		int otp=Integer.parseInt( (String) request.getSession(false).getAttribute("checkotp"));
		
		String emailid=(String) request.getSession(false).getAttribute("email");
		if(checkotp==otp) {
				try {
					String query="update SignUp set Password=? where Email='"+emailid+"'";
					System.out.println(query);
					PreparedStatement pst=DataBaseConnection.getConnection().prepareStatement(query);
					pst.setString(1, password);
					pst.executeUpdate();
					
					String message="Password Changed Successfully";
					System.out.println(message);
					  request.setAttribute("message", message); 
					RequestDispatcher rd=request.getRequestDispatcher("Login.jsp");
					rd.forward(request, response);
					}  catch(Exception e) {
				e.printStackTrace();
			      }
		}else {
				String message="Invalid otp";
				request.setAttribute("message", message);
				request.setAttribute("otp", otp);
				RequestDispatcher rd=request.getRequestDispatcher("ForgotVerify.jsp");
				rd.forward(request, response);
	}}

	private String getAttribute(String string) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
