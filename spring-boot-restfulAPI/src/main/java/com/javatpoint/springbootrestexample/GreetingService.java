package com.javatpoint.springbootrestexample;

import java.util.ArrayList;  
import java.util.List;  
import org.springframework.stereotype.Service;  

@Service  
public class GreetingService implements IGreetingService {
	
	@Override  
	public List<Greeting> findAll()  
	{  
	//creating an object of ArrayList  
	ArrayList<Greeting> greetings = new ArrayList<Greeting>();  
	//adding greetings to the List  
	greetings.add(new Greeting(100, "Husnain"));  
	greetings.add(new Greeting(101, "Abdul Haseeb"));  
	greetings.add(new Greeting(102, "Hassan Sajjad"));  
	greetings.add(new Greeting(103, "Shoaib"));  
	greetings.add(new Greeting(104, "Faisal"));  
	greetings.add(new Greeting(105, "Ali"));  
	//returns a list of product  
	return greetings;  
	}  

}
