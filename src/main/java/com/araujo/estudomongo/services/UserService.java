package com.araujo.estudomongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.araujo.estudomongo.domain.User;
import com.araujo.estudomongo.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository rep;
	
	public List<User> findAll(){
		return rep.findAll();
	}

}
