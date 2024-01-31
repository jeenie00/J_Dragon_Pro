package com.p1k.p1kGram.config.oauth;
//페이스북으로 로그인 하는 설정 → 현재는 사용 예정 없음 01/31

// java
import java.util.UUID;

// spring - security/streotype
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

// p1kGram
import com.p1k.p1kGram.config.auth.PrincipalDetails;
import com.p1k.p1kGram.domain.user.RoleType;
import com.p1k.p1kGram.domain.user.User;
import com.p1k.p1kGram.domain.user.UserRepository;

// lombok
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class OAuth2DetailsService extends DefaultOAuth2UserService {

	private final UserRepository userRepository;

	@Override
	public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
		System.out.println("OAuth 로그인 진행중");
		System.out.println("토큰 : " + userRequest.getAccessToken());

		// 1. AccessTocken으로 회원정보를 받았다는 의미 회원정보 요청 -> 토큰이 있음
		OAuth2User oauth2User = super.loadUser(userRequest);

		// 레트로핏
		System.out.println("oauth2User.getAttributes() : " + oauth2User.getAttributes());

		return processOAuth2User(userRequest, oauth2User); // null이면 로그인이 안됐다는 뜻.
	}

	private OAuth2User processOAuth2User(OAuth2UserRequest userRequest, OAuth2User oauth2User) {

		// userRequest : 뭐로 로그인 됐는지 정보를 가지고있음 (ex : google,naver,facebook)
		// oAuth2User : attribute 를 가지고있다.
		System.out.println("로그인된 클라이언트 정보?" + userRequest.getClientRegistration().getClientName());
		// 구글 페이스북 네이버 - 로그인된 클라이언트 정보를 보여줌
		
		OAuth2UserInfo oAuth2UserInfo = null;
		if (userRequest.getClientRegistration().getClientName().equals("Google")) {
			//oAuth2UserInfo = new GoogleInfo(oauth2User.getAttributes());

		} else if (userRequest.getClientRegistration().getClientName().equals("Facebook")) {
			oAuth2UserInfo = new FacebookInfo(oauth2User.getAttributes());
		}

		User userEntity = userRepository.findByUsername(oAuth2UserInfo.getUsername());

		UUID uuid = UUID.randomUUID();
		String encPassword = new BCryptPasswordEncoder().encode(uuid.toString());
		
		// 이미 회원가입이 되어있는 경우 → if else 사용
		if (userEntity == null) { 
			User user = User.builder()
					.username(oAuth2UserInfo.getUsername())
					.password(encPassword)
					.email(oAuth2UserInfo.getEmail())
					.role("USER")
					.build();
			userEntity = userRepository.save(user);
			return new PrincipalDetails(userEntity, oauth2User.getAttributes());

		} else { 
			// else : 이미 회원가입이 되어 있다면..
			return new PrincipalDetails(userEntity, oauth2User.getAttributes());
		}
	}
}