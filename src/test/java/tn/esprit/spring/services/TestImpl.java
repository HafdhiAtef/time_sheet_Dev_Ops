package tn.esprit.spring.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tn.esprit.spring.entities.Role;
import tn.esprit.spring.entities.User;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
class TestImpl {
	@Autowired
	IUserService us;
	
	@Test
	@Order(1)
	public void testAddUser() throws ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date d = dateFormat.parse("1995-11-08");
		User u = new User("zakaria" , "Faltani " , d , Role.CHEF_DEPARTEMENT);
		User userAdded = us.addUser(u);
		Assertions.assertEquals(u.getLastName(), userAdded.getLastName());
		
	}
	@Test
	@Order(2)
	public void testModifyUser() throws ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date d = dateFormat.parse("1995-11-08");
		User u = new User(5L,"zakaria" , "Faltani " , d , Role.CHEF_DEPARTEMENT);
		User userupdated = us.addUser(u);
		Assertions.assertEquals(u.getLastName(), userupdated.getLastName());
	}
	/*remove@test annotationTest
	//@
	public void testAll(){
		try{
		l.info('intestall()');
		testAddUser();
		testModifyUser();
	}catch 
		}
	*/

}