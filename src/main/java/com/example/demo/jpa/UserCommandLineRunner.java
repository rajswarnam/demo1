package com.example.demo.jpa;

import org.apache.commons.logging.LogFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class UserCommandLineRunner implements CommandLineRunner {

	private static Logger log = LoggerFactory.getLogger(UserCommandLineRunner.class);
	@Autowired
	private UserRepository UserRepository;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		UserRepository.save(new User("Rosa","Admin"));
		UserRepository.save(new User("Ross","User"));
		UserRepository.save(new User("Rajini","Admin"));
		UserRepository.save(new User("kamal","User"));
		
		for(User user:UserRepository.findAll())
		log.info(user.toString());
		
		for (User user1:UserRepository.findByRole("Admin")) {
			log.info(user1.toString());
		}
		

	}

}
