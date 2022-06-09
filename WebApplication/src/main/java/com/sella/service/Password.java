package com.sella.service;

public class Password {
	public boolean getPasswordCheck(String password,String confirmpassword)
	{
		if(password.equals(confirmpassword))
		{
			return true;
		}else
		{
			return false;
		}
	}

	public double amountCheck(int quantity,double productprice) {

		double 	totalamount=quantity*productprice; 

		return totalamount;




	}

}
