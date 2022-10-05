package com.phonumberchecker;

import static org.junit.Assert.assertEquals;

//import java.util.Scanner;

import org.junit.jupiter.api.Test;

class PakistanTest {
	
	//PakistanTest obj = new PakistanTest(); 
	
	Pakistan obj = new Pakistan();
	
	//Scanner sc= new Scanner(System.in); 
	
	//System.out.println("Enter Phone Number: "); 
	//String phonenumber = sc.next();
	
	//Boolean validPhoneNumber; 
	//System.out.println( str); 

	@Test
	public void tests() {
	    //Pakistan validPhoneNumber;
		assertEquals(true, Pakistan.validPhoneNumber("(123) 456-7890"));
	    assertEquals(false, Pakistan.validPhoneNumber("(1111)555 2345"));
	    assertEquals(false, Pakistan.validPhoneNumber("(098) 123 4567"));
	  }
	
	@Test
	public void basicTests() {
		    String msg = "Follow the formatting instructions carefully";
		    assertEquals(msg, true, Pakistan.validPhoneNumber("(123) 456-7890"));
		    assertEquals(msg, false, Pakistan.validPhoneNumber("(1111)555 2345"));
		    assertEquals(msg, false, Pakistan.validPhoneNumber("(098) 123 4567"));
		    assertEquals(msg, false, Pakistan.validPhoneNumber("(123)456-7890"));
		  }
		  
	@Test
	public void formCharTests() {
		    String msg = "Pay attention to the formatting of the string and surrounding characters";
		    assertEquals(msg, false, Pakistan.validPhoneNumber("abc(123)456-7890"));
		    assertEquals(msg, false, Pakistan.validPhoneNumber("(123)456-7890abc"));
		    assertEquals(msg, false, Pakistan.validPhoneNumber("abc(123)456-7890abc"));
		  }
		  
	@Test
	public void charTests() {
		    String msg = "Be careful with characters surrounding the phone number";
		    assertEquals(msg, false, Pakistan.validPhoneNumber("abc(123) 456-7890"));
		    assertEquals(msg, false, Pakistan.validPhoneNumber("(123) 456-7890abc"));
		    assertEquals(msg, false, Pakistan.validPhoneNumber("abc(123) 456-7890abc"));
		  }
		  
	@Test
	public void badCharTests() {
		    String msg = "Be careful with non-digit characters inside phone number";
		    assertEquals(msg, false, Pakistan.validPhoneNumber("(123) 456-78f0"));
		    assertEquals(msg, false, Pakistan.validPhoneNumber("(123) 4e6-7890"));
		    assertEquals(msg, false, Pakistan.validPhoneNumber("(*23) 456-7890"));
		  }
}


