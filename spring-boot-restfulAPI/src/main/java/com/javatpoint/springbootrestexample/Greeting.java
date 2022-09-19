package com.javatpoint.springbootrestexample;

import java.util.List;

public class Greeting {
	 
	private int id;  
	private String pname;  

	
	//default constructor  	
		public Greeting()  
			{  
			      
			}
		
	//constructor using fields 
		public Greeting(int id, String pname)   
		{  
		super();  
		this.id = id;  
		this.pname = pname;  
		 
		}  
		//getters and setters  
		public int getId()   
		{  
		return id;  
		}  
		public void setId(int id)   
		{  
		this.id = id;  
		}  
		public String getPname()   
		{  
		return pname;  
		}  
		public void setPname(String pname)   
		{  
		this.pname = pname;  
		}

}
