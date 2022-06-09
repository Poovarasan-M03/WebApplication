package com.sella.webapp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLIntegrityConstraintViolationException;

import com.sella.webapp.bean.ProductException;
import com.sella.webapp.dao.DataBaseConnection;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.Password;

/**
 * Servlet implementation class AdminSignUpServlet
 */
public class AdminSignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminSignUpServlet() {
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
		String AdminId=request.getParameter("Admin");
		//System.out.println(AdminId);
		try {
			String msg="";
			if(AdminId.equals("admin@123"))
			{


				Password password=new Password();
				boolean bool=password.getPasswordCheck(Password, ConfirmPassword);
			if(bool) {



			//String query="Insert into adminlogin values ('"+Email+"','"+pwd+"')";


				int inserted =DataBaseConnection.Admin(Email,Password);
			//out.println(update);
                 System.out.println(inserted);
			if(inserted>0)
			{
			msg="Sign in Successfull";
			request.setAttribute("msg",msg);

			RequestDispatcher d= request.getRequestDispatcher("AdminLogin.jsp");
			d.forward(request, response);


			}else
			{
			msg="Sign in UnSuccessfull";
			request.setAttribute("msg",msg);
			RequestDispatcher d= request.getRequestDispatcher("AdminSignUp.jsp");
			d.forward(request, response);

			}

			}else { msg=" Password does not match the confirm Password";
			request.setAttribute("msg",msg);
			RequestDispatcher d= request.getRequestDispatcher("AdminSignUp.jsp");
			d.forward(request, response);

			}





			}
			else {
			msg="Invalid Admin Id";
			request.setAttribute("msg",msg);
			RequestDispatcher d= request.getRequestDispatcher("AdminSignUp.jsp");
			d.forward(request, response);
			}}catch(Exception e) {
				String msg="Enter Unique Email id";
				request.setAttribute("msg",msg);
				RequestDispatcher d= request.getRequestDispatcher("AdminSignUp.jsp");
				d.forward(request, response);
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
