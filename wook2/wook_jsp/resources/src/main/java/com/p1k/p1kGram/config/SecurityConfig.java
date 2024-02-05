package com.p1k.p1kGram.config;

// spring
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//↓ 기존 WebSecurityConfigurerAdapter에서 SecurityFilterChain로 변경
import org.springframework.security.web.SecurityFilterChain;
// BCryptPasswordEncoder  → 값을 암호화해줌 ex)$#$#KJ:Ffsdfdsfsd%$#fds@fdsfds456sdfds
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

// lombok
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Configuration
@EnableWebSecurity
public class SecurityConfig {
	

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
					authorizeRequests //막을것만 막고 나머진 허용 / authenticated:로그인만하면 허용 /
								.requestMatchers("/", "/user/**", "/image/**", "/follow/**","/comment/**").hasAnyRole("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')") 
								.requestMatchers("/admin/**").hasAnyRole("hasRole('ROLE_ADMIN')")
								.anyRequest()
			)
								
								
			.formLogin(login ->
					login
								.loginPage("/auth/loginForm")
								.loginProcessingUrl("/login") 
								.defaultSuccessUrl("/"))
			.oauth2Login((oauth2) -> // 일단 설정만 바꿔놨음
					oauth2 // OAuth2 로그인 설정시작
								.userInfoEndpoint(userInfoEndpoint -> userInfoEndpoint
	                            .userService(null)) //OAuth 로그인 시 사용자 정보를 가져오는 엔드포인트와 사용자 서비스를 설명줌
					);
		return http.build();}}