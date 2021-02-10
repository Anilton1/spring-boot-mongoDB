package com.araujo.estudomongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.araujo.estudomongo.domain.User;
import com.araujo.estudomongo.repository.UserRepository;
import com.araujo.estudomongo.services.exception.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired
	UserRepository rep;

	public List<User> findAll() {
		return rep.findAll();
	}

	public User findById(String id) {
		Optional<User> obj = rep.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}

}
