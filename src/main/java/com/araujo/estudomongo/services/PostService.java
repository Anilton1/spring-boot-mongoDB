package com.araujo.estudomongo.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.araujo.estudomongo.domain.Post;
import com.araujo.estudomongo.repository.PostRepository;
import com.araujo.estudomongo.services.exception.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired
	PostRepository rep;

	public Post findById(String id) {
		Optional<Post> obj = rep.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	public List<Post> findByTitle(String text){
		//return rep.findByTitleContainingIgnoreCase(text);
		return rep.findByTitle(text);
	}
	
	public List<Post> fullSearch(String text, Date minDate, Date maxDate){
		//Adiantando um dia para comparação efetiva na comparação de data 'final'
		maxDate = new Date(maxDate.getTime() + 24 * 60 * 60 * 1000);
		return rep.fullSearch(text, minDate, maxDate);
	}
}
