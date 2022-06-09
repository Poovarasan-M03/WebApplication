package com.sella.webapp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import com.sella.webapp.bean.MyOrders;
import com.sella.webapp.bean.ProductDetails;
import com.sella.webapp.dao.DataBaseConnection;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Myorders
 */
public class Myorders extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Myorders() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
//	
		
		String emailid=(String) request.getSession(false).getAttribute("emailid");
		System.out.println(emailid);
		
		int pid=(Integer)(request.getSession(false).getAttribute("pid"));
		//int pid=Integer.parseInt(pid1);
		System.out.println("iiiiiiiiiiiiiiii"+pid);
		System.out.println("874365");
		String pname=(String) request.getSession(false).getAttribute("pname");
		System.out.println("yyyyyyyyyyyyyyy"+pname);
		String pdate=(String) request.getSession(false).getAttribute("date");
		System.out.println("ppppppppppppppppp"+pdate);
		String ptime=(String) request.getSession(false).getAttribute("time");
		System.out.println("lllllllllllllllllll"+ptime);
		double pprice=(double) request.getSession(false).getAttribute("pprice");
		System.out.println("jjjjjjjjjjjjjjjjjjj"+pprice);
		int pmodelyear=(int) request.getSession(false).getAttribute("pmodelyear");
		System.out.println("nnnnnnnnnnnnnnnnn"+pmodelyear);
		String pcolor=(String) request.getSession(false).getAttribute("pcolor");
		System.out.println(pcolor);
		int pqty=(int) request.getSession(false).getAttribute("pqty");
		System.out.println(pqty);
		int TotalAmount=(int) request.getSession(false).getAttribute("totalqty");
		System.out.println(TotalAmount);
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
