package com.p1k.p1kGram.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;

// findByusername → SELECT * FROM user WHERE username = 
public interface UserRepository extends JpaRepository<User, Integer>{
	User findByUsername(String username);
}