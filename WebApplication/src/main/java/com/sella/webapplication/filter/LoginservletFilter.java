package com.sella.webapplication.filter;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import com.sella.webapp.dao.DataBaseConnection;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class LoginservletFilter
 */
public class LoginservletFilter extends HttpFilter {

	/**
	 * @see HttpFilter#HttpFilter()
	 */
	public LoginservletFilter() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		String email=request.getParameter("emailid");
		String pwd= request.getParameter("password");
		//HttpServletRequest rq=(HttpServletRequest) request;
		
			//HttpSession	session=null;
		HttpServletRequest rq=(HttpServletRequest) request;
//		rq.getSession().setAttribute("emailid", email);
		PrintWriter out =response.getWriter();
		
		
		if(email==null && pwd==null)
		{
			request.getRequestDispatcher("DashBoardServlet").forward(request, response);
		}
		//try {
			
		String query="Select Email,Password from SignUp where Email='"+email+"' AND Password='"+pwd+"'";
         

		try {
			ResultSet rs=DataBaseConnection.DBLogin(query);
			
			if(rs.next())
			{
				//rq.getSession().setAttribute("email", email);
				request.setAttribute("emailid", email);
				chain.doFilter(request, response);
			}
			else {
				String message="Invalid Email Id/Password";
				request.setAttribute("message", message);
				RequestDispatcher r=request.getRequestDispatcher("Login.jsp");
				r.forward(request, response);
				}
			
		
		} catch (Exception e) {



			out.println("Check Connection!!!1");
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
