package com.p1k.p1kGram.config.oauth;
// 페이스북으로 로그인 하는 설정 → 현재는 사용 예정 없음 01/31

// java
import java.util.Map;

public class FacebookInfo extends OAuth2UserInfo{
	// facebookinfo 페이스북 정의를 내린곳의 객체를 overriding
	public FacebookInfo(Map<String, Object> attributes) {
		super(attributes);
		
	}
	@Override
	public String getId() {
		
		return (String)attributes.get("id");
	}
	@Override
	public String getName() {
		
		return (String)attributes.get("name");
	}
	@Override
	public String getEmail() {
		
		return (String)attributes.get("email");
	}
	@Override
	public String getImageUrl() {
		
		return null;
	}
	@Override
	public String getUsername() {
		// sub는 중복될 수 있는데 여기 앞에 어디서 로그인했는지 적어놓으면 중복될수 없음 프라이머리키가 될수있다.
		return "Facebook_"+(String)attributes.get("id"); 
	}
}