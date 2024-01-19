package com.p1k.p1kGram.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//↓ 기존 WebSecurityConfigurerAdapter에서 SecurityFilterChain로 변경
import org.springframework.security.web.SecurityFilterChain;
// BCryptPasswordEncoder  → 값을 암호화해줌 ex)$#$#KJ:Ffsdfdsfsd%$#fds@fdsfds456sdfds
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.p1k.p1kGram.config.oauth.OAuth2DetailsService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	private final OAuth2DetailsService oAuth2DetailsService;

	@Bean
	public BCryptPasswordEncoder encode() {
		return new BCryptPasswordEncoder();}
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
		http
			.csrf(csrf ->csrf.disable())
			
			//antMatchers →  requestMatchers 로 변경됨
			// has AnyRole
			.authorizeHttpRequests((authorizeRequests) ->
					authorizeRequests
								.requestMatchers("/", "/user/**", "/image/**", "/follow/**","/comment/**").hasAnyRole("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')") //막을것만 막고 나머진 허용 / authenticated:로그인만하면 허용 /
								.requestMatchers("/admin/**").hasAnyRole("hasRole('ROLE_ADMIN')")
								.anyRequest()
			)
								
								
			.formLogin(login ->login
			.loginPage("/auth/loginForm")
			.loginProcessingUrl("/login") 
			.defaultSuccessUrl("/"));
				

			
		return http.build();}}

