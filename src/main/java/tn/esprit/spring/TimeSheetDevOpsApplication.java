package tn.esprit.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TimeSheetDevOpsApplication {
	
	@RequestMapping("/")
    	String home() {
        	return "Hello World - v3!";
    }
	public static void main(String[] args) {
		SpringApplication.run(TimeSheetDevOpsApplication.class, args);
	}

}
