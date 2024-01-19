package com.p1k.p1kGram.service;

import jakarta.transaction.Transactional;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.p1k.p1kGram.domain.user.RoleType;
import com.p1k.p1kGram.domain.user.User;
import com.p1k.p1kGram.domain.user.UserRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class AuthService {

	private final UserRepository userRepository;
	private final BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Transactional
	public void 회원가입(User user) {
		String rawPassword = user.getPassword();
		String encPassword = bCryptPasswordEncoder.encode(rawPassword);

		user.setPassword(encPassword);
		user.setRole("USER");
		userRepository.save(user);		
	}
}
