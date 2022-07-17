package com.fatihtoker.Login.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.fatihtoker.Login.domain.Login;

public interface LoginRepository extends JpaRepository<Login, Long>{
	
	Login findByUsernameAndPassword(String username, String password);

}
