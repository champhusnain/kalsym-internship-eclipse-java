package com.javatpoint.springbootrestexample;

import java.util.List;  
import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.web.bind.annotation.GetMapping;  
import org.springframework.web.bind.annotation.RestController;  


@RestController 
public class GreetingController {
	

	@Autowired  
	private IGreetingService greetingService;  
	//mapping the getProduct() method to /product  
	@GetMapping(value = "/greeting")  
	public List<Greeting> getGreeting()   
	{  
	//finds all the products  
	List<Greeting> greetings = greetingService.findAll();  
	//returns the product list  
	return greetings;  
	}   
}
