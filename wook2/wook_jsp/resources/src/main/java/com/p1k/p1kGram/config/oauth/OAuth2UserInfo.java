package com.p1k.p1kGram.config.oauth;

// java Map
import java.util.Map;

public abstract class OAuth2UserInfo {

	protected Map<String, Object> attributes;

	public OAuth2UserInfo(Map<String, Object> attributes) {
		this.attributes = attributes;
	}
		
	public Map<String, Object> getAttributes(){
		return attributes;
	}
	// 정의를 내린곳 
	// Service로 가져가서 overring 한다
	public abstract String getUsername();
	public abstract String getId();
	public abstract String getName();
	public abstract String getEmail();
	public abstract String getImageUrl();
}