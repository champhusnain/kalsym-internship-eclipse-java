package com.javatpoint.springbootRequestTimeout;

import java.awt.print.Book;
import java.util.concurrent.Callable;

import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;  


@RestController  
public class Controller   
{  
	//Transactional Timeout
	@GetMapping("/author/transactional")
	@Transactional(timeout = 1)
	public String getWithTransactionTimeout(@RequestParam String title) {
	    bookRepository.wasteTime();
	    return bookRepository.findById(title)
	      .map(Book::getAuthor)
	      .orElse("No book found for this title.");
	}
	
	
    //WebClient Timeout
	@Bean
	public WebClient webClient() {
	    return WebClient.builder()
	      .baseUrl("http://localhost:8080")
	      .clientConnector(new ReactorClientHttpConnector(
	        HttpClient.create().responseTimeout(Duration.ofMillis(250))
	      ))
	      .build();
	}
	@GetMapping("/author/webclient")
	public String getWithWebClient(@RequestParam String title) {
	    return webClient.get()
	      .uri(uriBuilder -> uriBuilder
	        .path("/author/transactional")
	        .queryParam("title", title)
	        .build())
	      .retrieve()
	      .bodyToMono(String.class)
	      .block();
	}
	
	///Spring-mvc
	@GetMapping("/author/mvc-request-timeout")
	public Callable<String> getWithMvcRequestTimeout(@RequestParam String title) {
	    return () -> {
	        bookRepository.wasteTime();
	        return bookRepository.findById(title)
	          .map(Book::getAuthor)
	          .orElse("No book found for this title.");
	    };
	}
	
	
	
	//Resilience
	private TimeLimiter ourTimeLimiter = TimeLimiter.of(TimeLimiterConfig.custom()
			  .timeoutDuration(Duration.ofMillis(500)).build());
	
	@GetMapping("/author/resilience4j")
	public Callable<String> getWithResilience4jTimeLimiter(@RequestParam String title) {
	    return TimeLimiter.decorateFutureSupplier(ourTimeLimiter, () ->
	      CompletableFuture.supplyAsync(() -> {
	        bookRepository.wasteTime();
	        return bookRepository.findById(title)
	          .map(Book::getAuthor)
	          .orElse("No book found for this title.");
	    }));
	}
	
	
	
	
	
}  
