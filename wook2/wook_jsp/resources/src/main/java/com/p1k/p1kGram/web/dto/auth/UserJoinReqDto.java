package com.p1k.p1kGram.web.dto.auth;

// import domain
import com.p1k.p1kGram.domain.user.User;

// lombok
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor; 

@AllArgsConstructor
@Builder
@NoArgsConstructor
@Data
public class UserJoinReqDto {
	
	private String username;
	private String password;
	private String email;
	private String name;
	
	public User toEntity() {
		return User.builder()
				.username(username)
				.password(password)
				.email(email)
				.name(name)
				.build();
	}
}