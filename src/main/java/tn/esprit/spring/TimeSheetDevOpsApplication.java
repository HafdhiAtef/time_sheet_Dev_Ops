package tn.esprit.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
public class TimeSheetDevOpsApplication {
	
	
    
	public static void main(String[] args) {
		SpringApplication.run(TimeSheetDevOpsApplication.class, args);
	
	
	}
 
	@GetMapping("/hello")
	public String hello() {
		return "Hello From SpringBoot";
	}

}
