package com.example.northwind.Core.DataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.northwind.Core.Entities.User;

public interface UserDao extends JpaRepository<User,Integer>{
	User findByEmail(String email);
		
	
}
