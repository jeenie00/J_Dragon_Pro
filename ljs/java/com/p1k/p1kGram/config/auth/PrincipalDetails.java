package com.p1k.p1kGram.config.auth;

import com.p1k.p1kGram.domain.user.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.core.user.OAuth2User;


import lombok.Data;

@Data
public class PrincipalDetails implements UserDetails, OAuth2User{

	private User user;	
	private Map<String, Object> attributes;
	private boolean oAuth;
	
	public PrincipalDetails(User user) {
		this.user = user;
	}
	
	public PrincipalDetails(User user, Map<String, Object> attributes) {
		this.user = user;
		this.attributes = attributes;
		this.oAuth = true;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return user.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		Collection<GrantedAuthority> collectors = new ArrayList<>(); // 자바 유틸꺼임, collectors에 권한을 넣어줘야함
		collectors.add(()-> "ROLE_"+user.getRole().toString()); // collectors 에 리턴되서 들어간다.
		//컬렉터에 GrantedAuthority타입을 넣어줘야한다.
  
		// 위랑 같음
//		collectors.add(new GrantedAuthority() {
//			
//			@Override
//			public String getAuthority() {
//				
//				return user.getRole().toString(); //collectors 에 리턴되서 들어간다
//			}
//		});
		
		return collectors;
	}

	@Override
	public Map<String, Object> getAttributes() {
		// TODO Auto-generated method stub
		return attributes;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "알수없음";}}