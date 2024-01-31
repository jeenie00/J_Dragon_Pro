package com.p1k.p1kGram.service;

// jakarta Transactional
import jakarta.transaction.Transactional;

// spring sec / streo
// 패스워드를 처리하기 위함
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.p1k.p1kGram.domain.user.RoleType;
import com.p1k.p1kGram.domain.user.User;
import com.p1k.p1kGram.domain.user.UserRepository;

// lombok
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LoginService {

	private final UserRepository userRepository;
	// 패스워드 인코딩
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