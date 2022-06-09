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

/**
 * Servlet Filter implementation class AdminLoginFilter
 */
public class AdminLoginFilter extends HttpFilter {
       
    /**
     * @see HttpFilter#HttpFilter()
     */
    public AdminLoginFilter() {
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
		// TODO Auto-generated method stub
		// place your code here
		String email=request.getParameter("emailid");
		String pwd= request.getParameter("password");
		
		PrintWriter out =response.getWriter();
		// pass the request along the filter chain
		//chain.doFilter(request, response);
		//String query="Select EmailId,Password from AdminSignUp where Email='"+email+"' AND Password='"+pwd+"'";
        

		try {
			String query="Select EmailId,Password from AdminSignUp where Email='"+email+"' AND Password='"+pwd+"'";
			ResultSet rs=DataBaseConnection.DBLogin(query);
			
			if(rs.next())
			{
				//rq.getSession().setAttribute("email", email);
				chain.doFilter(request, response);
			}
			else {
				String message="Email Id/Password Incorrect Please enter correct Email Id/Password";
				request.setAttribute("message", message);
				RequestDispatcher r=request.getRequestDispatcher("AdminLogin.jsp");
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
