package com.p1k.p1kGram.web.dto.follow;

// import java = BigInteger
// 아주 큰 정수를 활용하기 위함
import java.math.BigInteger;

// import lombok
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class FollowRespDto {
	private int userId;
	private String username;
	private String profileImageUrl;
	// boolean 논리형의 값을 받아서 매개변수로 저장 불가능
	// 따라서 biginteger 형으로 받아옴 
	private BigInteger followState;
	private BigInteger equalState;
	
}