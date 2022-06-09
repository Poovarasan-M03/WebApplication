package com.sella.Junit;

import static org.junit.Assert.*;

import org.junit.Test;

import service.Password;

public class PasswordCheck {
	Password password=new Password();
	@Test
	public void test() {
		boolean expected=password.getPasswordCheck("anandh", "anandh");
				boolean actual=true;
				assertEquals(expected,actual);
	}
	
	Password password1=new Password();
	
    @Test
    public void testing() {
    	double expected=password.amountCheck(2, 100);
    	double actual=200.0;
    	double delta=0.0;
    	assertEquals(actual,expected,delta);
    }
}
