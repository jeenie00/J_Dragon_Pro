package com.p1k.p1kGram.web.dto.follow;

import java.math.BigInteger;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class FollowRespDto {

	private int userId;
	private String username;
	private String profileImageUrl;
	private BigInteger followState; // boolean → BigInter
	private BigInteger equalState;
	
}