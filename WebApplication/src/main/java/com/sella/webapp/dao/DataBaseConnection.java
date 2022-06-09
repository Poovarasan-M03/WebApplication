package com.sella.webapp.dao;

//Packages
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBaseConnection {
	private static String dburl="jdbc:mysql://localhost:3306/selladb";
	private static String userId="root";
	private static String password="1234";
	public static Connection getConnection() throws Exception
	{
		Connection connection=null;
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection=DriverManager.getConnection(dburl,userId,password);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return connection;
	}
	public static Statement getStatement() throws Exception{
		Statement statement = null;
		try {
			statement= getConnection().createStatement(); }
		catch (SQLException e) {
			e.printStackTrace();
		}
		return statement;
	}
	public static int getUpdate(String query) throws SQLException, Exception
	{
		int rowsinserted=0;
		rowsinserted=getStatement().executeUpdate(query);
		return rowsinserted;
	}
	//USER LOGIN
	public static ResultSet DBLogin(String query) throws Exception, SQLException{
		ResultSet resultset=null;
		Statement statement=getConnection().createStatement();
		 resultset=statement.executeQuery(query);
		return resultset;
		
	}
	
	//USER SIGNUP
	public static int getPreparedStatement(String Email,String Password)throws SQLException,Exception{
		
		
		int i=0;
		String query="insert into SignUp values(?,?)";
			try(Connection conn=DataBaseConnection.getConnection();
				PreparedStatement pst=getConnection().prepareStatement(query);){
		pst.setString(1,Email);
		pst.setString(2,Password);
		i=pst.executeUpdate();
		return i;
	
		}finally {
		}
		}
	//ADMIN SIGNUP
	public static int Admin(String Email,String Password)throws SQLException,Exception{
		int i=0;
		String query="insert into AdminSignUp values(?,?)";
		try (Connection conn=DataBaseConnection.getConnection();
			PreparedStatement pst=getConnection().prepareStatement(query);){
		
		
		
		pst.setString(1,Email);
		//pst.setString(2,AdminId);
		pst.setString(2, Password);
		i=pst.executeUpdate();
		return i;
	
	}
	finally {
	}
	}
	
	//MyOrders
	/*
	 * public static int Myorders(String Emailid,int ProductId,String
	 * productname,String Date,String Time,Double productprice,int modelYear,String
	 * color,int quantity,int totalamt ) throws Exception {
	 * 
	 * try (Connection conn=DataBaseConnection.getConnection()){ int i=0; String
	 * query="insert into myorders values(?,?,?,?,?,?,?,?,?,?)"; PreparedStatement
	 * pst=conn.prepareStatement(query); pst.setString(1, Emailid); pst.setInt(2,
	 * ProductId); pst.setString(3, productname); pst.setString(4, Date);
	 * pst.setString(5,Time); pst.setDouble(6, productprice); pst.setInt(7,
	 * modelYear); pst.setString(8, color); pst.setInt(9,quantity );
	 * pst.setInt(10,totalamt );
	 * 
	 * i=pst.executeUpdate(); return i; }finally {
	 * 
	 * }
	 * 
	 * }
	 */
	

	
	public static  boolean BillGenerate(String ProductId)throws Exception,SQLException
	{
		ResultSet resultset=null;
		Statement statement=DataBaseConnection.getConnection().createStatement();
		
		//ResultSet resultset=statement.executeQuery("select * from ProductDetails where ProductId='"+ProductId+"'");
		if(resultset.next())
		{
			return true;
		}
		else 
		{
			return false;
		}
		
	}
	

	public static ResultSet getResultset(String query) throws Exception
	{
		ResultSet resultset=getStatement().executeQuery(query);
		return resultset;
	}
	
	 
	
}


