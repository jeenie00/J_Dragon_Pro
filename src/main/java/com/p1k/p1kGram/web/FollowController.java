package com.p1k.p1kGram.web;

//import Security
import org.springframework.security.core.annotation.AuthenticationPrincipal;

//import web annotation
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//import another function
import com.p1k.p1kGram.config.auth.PrincipalDetails;
import com.p1k.p1kGram.domain.follow.Follow;
import com.p1k.p1kGram.service.FollowService;
import com.p1k.p1kGram.web.dto.CmRespDto;

//LomBok 
import lombok.RequiredArgsConstructor;

//RequiredArgsConstructor == this 생성자 주입을 자동으로 해줌
@RequiredArgsConstructor
@RestController
public class FollowController {
	private final FollowService followService;
	
	@PostMapping("/follow/{toUserId}") // 팔로우
	public CmRespDto<?> follow(@AuthenticationPrincipal PrincipalDetails principalDetails, @PathVariable int toUserId){
		int result = followService.팔로우(principalDetails.getUser().getId(), toUserId);
		return new CmRespDto<>(1,result);
	}
	
	@DeleteMapping("/follow/{toUserId}") // 언팔로우
	public CmRespDto<?> unFollow(@AuthenticationPrincipal PrincipalDetails principalDetails, @PathVariable int toUserId) {
		int result = followService.언팔로우(principalDetails.getUser().getId(), toUserId);
		return new CmRespDto<>(1,result);
	}
}