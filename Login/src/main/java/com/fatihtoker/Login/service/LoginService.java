package com.fatihtoker.Login.service;

import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fatihtoker.Login.domain.Login;
import com.fatihtoker.Login.repository.LoginRepository;

@Service
public class LoginService {
	
	@Autowired
	private LoginRepository repo;
	
	public Login login(String username, String password) {
		Login user = repo.findByUsernameAndPassword(username, password);
		return user;
	}
	public void getInfo() {
		System.out.println("You Have "+repo.count()+" Record's in your Login Table in Sql");	
		for (int i = 0; i < repo.count(); i++) {
			int count = i +1;
			System.out.println(count+". record's username : "+repo.findAll().get(i).getUsername());

			System.out.println(count+". record's password : "+repo.findAll().get(i).getPassword());
		}
		
	}
	
}
