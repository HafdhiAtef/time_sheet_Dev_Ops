package tn.esprit.spring.services;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import tn.esprit.spring.entities.User;
import tn.esprit.spring.repository.UserRepository;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	UserRepository userRepository;

	private static final Logger l = LogManager.getLogger(UserServiceImpl.class);
	
	@Override
	public List<User> retrieveAllUsers() { 
		List<User> users = null; 
		try {
			
			l.info("In Method retrieveAllUseres");
			
			// TODO Log à ajouter en début de la méthode 
			users = (List<User>) userRepository.findAll();  
			for (User user : users) {
				l.info("-------");
				l.debug(user.getLastName());
				l.info("-------");
				// TODO Log à ajouter pour affiher chaque user dans les logs 
				
			}
			
			l.info("Out Metho retrieveAllUsers");
			// TODO Log à ajouter à la fin de la méthode 
		}catch (Exception e) {
			
			l.error("Error method retrieveAllUsers" + e);
			// TODO Log à ajouter pour gérer les erreurs 
		}

		return users;
	}


	@Override
	public User addUser(User u) {
		// TODO Log à ajouter en début de la méthode 
		l.info("In Method addUser");
		
		User u_saved = userRepository.save(u); 
		l.debug(u.getLastName());
		
		// TODO Log à ajouter à la fin de la méthode 
		l.info("Out Method addUser");
		
		return u_saved; 
	}

	@Override 
	public User updateUser(User u) { 
		// TODO Log à ajouter en début de la méthode 
		l.info("In Method Update");
		
		User u_saved = userRepository.save(u); 
		// TODO Log à ajouter à la fin de la méthode
		l.info(" Method addUser");
		
		return u_saved; 
	}

	@Override
	public void deleteUser(String id) {
		// TODO Log à ajouter en début de la méthode
		l.info("In Method Delete");
		userRepository.deleteById(Long.parseLong(id)); 
		// TODO Log à ajouter à la fin de la méthode 
		l.info("Out Method Update");
	}

	@Override
	public User retrieveUser(String id) {
		// TODO Log à ajouter en début de la méthode 
		l.info("In Method retrieveUser");
		
		//User u =  userRepository.findById(Long.parseLong(id)).orElse(null);
		User u =  userRepository.findById(Long.parseLong(id)).get(); 
		l.debug("User :" + u.getLastName());
		// TODO Log à ajouter à la fin de la méthode 
		l.info("Out Method retrieveUser");
		return u; 
	}

}