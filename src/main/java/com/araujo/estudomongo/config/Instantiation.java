package com.araujo.estudomongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.araujo.estudomongo.domain.Post;
import com.araujo.estudomongo.domain.User;
import com.araujo.estudomongo.repository.PostRepository;
import com.araujo.estudomongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner{
	
	@Autowired
	private UserRepository repUser;
	
	@Autowired
	private PostRepository repPost;

	@Override
	public void run(String... args) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		
		Post post1 = new Post(null,sdf.parse("21/03/2021"), "Partiu viagem", "Viajando para Paraíba.", maria);
		Post post2 = new Post(null,sdf.parse("23/03/2021"), "Bom dia", "BD", maria);
		
		repPost.deleteAll();
		repUser.deleteAll();
		
		repUser.saveAll(Arrays.asList(maria, alex, bob));
		repPost.saveAll(Arrays.asList(post1, post2));
	}

}
