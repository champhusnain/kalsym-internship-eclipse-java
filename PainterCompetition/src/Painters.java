import java.io.*;
import java.util.Scanner;



public class Painters {

	public static String findMinWindow(String S1, String S2)   
	{  
	  
	// In the beginning, the window is empty  
	String win = "";  
	int ptr2 = 0;  
	int minimum = S1.length() + 1;  
	  
	for (int ptr1 = 0; ptr1 < S1.length(); ptr1++)   
	{  
	  
	// If the characters of both the strings are the same, then increment the ptr2 pointer  
	// ptr1 will get incremented itself, as ptr1 is the loop variable.  
	if (S1.charAt(ptr1) == S2.charAt(ptr2))   
	{  
	ptr2 = ptr2 + 1;  
	  
	// the string S2 has been traversed completely. Therefore,  
	// the time has come to shrink the window.  
	if (ptr2 == S2.length())   
	{  
	int e = ptr1 + 1;  
	ptr2 = ptr2 - 1;  
	  
	// Reducing the window size  
	while (ptr2 >= 0)   
	{  
	if (S1.charAt(ptr1) == S2.charAt(ptr2))   
	{  
	ptr2 = ptr2 - 1;  
	}  
	ptr1 = ptr1 - 1;  
	}  
	  
	ptr2 = ptr2 + 1;  
	ptr1 = ptr1 + 1;  
	  
	// we have found the window of lesser length  
	// hence, we have to update the window  
	if (e - ptr1 < minimum)   
	{  
	  
	// Updating the var minimum  
	minimum = e - ptr1;  
	  
	// Updating the window  
	win = S1.substring(ptr1, e);  
	}  
	}  
	}  
	}  
	      
	//returning our final answer, which is stored in the window  
	return win;  
	}  
	  
	  
	// main method  
	public static void main(String argvs[])  
	{  
	// creating an object of the class DiffSubseqGCD   
	Painters obj = new Painters();  
	Scanner sc= new Scanner(System.in); 
	
	
	//System.out.println("Please enter number of painters in the competetion: ");
	//int i = sc.nextInt();
	for(int j=0; j<5; j++){   

	// input 1  
	String s1 = "ORBGWSPOGWPO";  
	System.out.println("Enter needed color:\n");  
	System.out.println("ORBGWSPOGWPO, "); 
	
	String s2 = sc.nextLine();       ;  
	System.out.println("For the colors \"" + s2 + "\" in \"" + s1 + "\"");  
	  
	String str = obj.findMinWindow(s1, s2);  
	System.out.println("Painter must pick : " + str);  
	System.out.println();  
	  
	}
	  
	}  
	  
	}  


