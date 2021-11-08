package tn.esprit.spring;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entities.User;
import tn.esprit.spring.services.IUserService;
import tn.esprit.spring.services.UserServiceImpl;


@RestController
public class HelloController {
	
	@Autowired
	private UserServiceImpl userservice;
	
	@GetMapping("/hello")
	public String hello() {
		return "Hello From SpringBoot v2 ";
	}
	
	@GetMapping("/retrieve-users")
	@ResponseBody
	public List<User> getUsers(){
		
	
		List<User> list= userservice.retrieveAllUsers();
		return list;
	}
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<User>  createUser(@RequestBody User user){
		return new ResponseEntity<>(userservice.addUser(user), HttpStatus.OK);
	}
	
/*	@DeleteMapping(value = "/{id}" , produces = MediaType.APPLICATION_JSON_VALUE )
 	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<String> deleteUser(@PathVariable(value = "id") int id ){
		return new ResponseEntity<>(userservice.deleteUser((long) id), HttpStatus.OK);
		
	}
	*/
}
