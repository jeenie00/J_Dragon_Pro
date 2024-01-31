package com.p1k.p1kGram.web;

// Controller
import org.springframework.stereotype.Controller;

// import web annotation
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

// import another function
import com.p1k.p1kGram.service.LoginService;
import com.p1k.p1kGram.service.UserService;
import com.p1k.p1kGram.utils.Script;
import com.p1k.p1kGram.web.dto.auth.UserJoinReqDto;

// LomBok 
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class LoginController {
	private final LoginService loginService;
	
	// 로그인 화면 p1k_login/Login
	@GetMapping("/p1k_login/Login")
	public String p1k_Login() {
		return "p1k_login/Login";
	}
	
	// 회원가입 화면 p1k_login/JoinForm
	@GetMapping("/pk1_login/JoinForm")
	public String p1k_JoinForm() {
		return "p1k_login/p1k_JoinForm";
	}
	
	// 비밀번호 HASH를 위한 postmapping
	@PostMapping("/p1k_login/join")
	public @ResponseBody String join(UserJoinReqDto userJoinReqDto) {
		loginService.회원가입(userJoinReqDto.toEntity());
		
	return Script.href("성공!", "/p1k_login/Login");
	}

}
