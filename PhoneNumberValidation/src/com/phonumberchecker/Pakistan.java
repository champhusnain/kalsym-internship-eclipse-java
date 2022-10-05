package com.phonumberchecker;
import java.util.Scanner;

public class Pakistan {
	
	public static void main(String argvs[])  
	{  
	// creating an object of the class DiffSubseqGCD   
	//Painters obj = new Painters();  
		Pakistan obj = new Pakistan();
		
	System.out.println("Enter Phone Number: "); 
	Scanner sc= new Scanner(System.in); 
	String phonenumber = sc.next();
	
	Boolean str = obj.validPhoneNumber(phonenumber); 
	System.out.println( str); 
	
	}
	  
	  
	  public static boolean validPhoneNumber(String phoneNumber) {
		    //return phoneNumber.matches("\\d{12}");
		  return phoneNumber.matches("(0/92)?[0-9]{12}");
		  }
	}
