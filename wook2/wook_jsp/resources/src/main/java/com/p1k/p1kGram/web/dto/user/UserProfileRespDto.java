package com.p1k.p1kGram.web.dto.user;

// p1kGram
import com.p1k.p1kGram.domain.user.User;

// import lombok
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor
public class UserProfileRespDto {
	
	// 팔로우 정보 조회
	// 저장을 하지 않음 
	private boolean followState;
	private int followCount;
	private int imageCount;
	private User user;
}