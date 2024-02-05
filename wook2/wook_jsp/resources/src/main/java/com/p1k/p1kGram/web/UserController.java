package com.p1k.p1kGram.web;

// import java - List
import java.util.List;

// import Controller Security
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;

// impor web 
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseBody;
// MultipartFile 파일 업로드를 구현하기 위함
import org.springframework.web.multipart.MultipartFile;

// import another class
import com.p1k.p1kGram.config.auth.PrincipalDetails;
import com.p1k.p1kGram.domain.user.User;
import com.p1k.p1kGram.service.FollowService;
import com.p1k.p1kGram.service.UserService;
import com.p1k.p1kGram.web.dto.CmRespDto;
import com.p1k.p1kGram.web.dto.follow.FollowRespDto;
import com.p1k.p1kGram.web.dto.user.UserProfileRespDto;

// lombok
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class UserController {
	
	private final UserService userService;
	private final FollowService followService;
	
	// cors 정책을 막기 휘함 
	// cors = 교차 출저 리소스 공유 하나의 리소스에 두개의 출처가 들어간 경우를 말함
	// 팔로우 모음을 반환하기 위한 형식 (LIST)
	// CmRespDto == 기본값
	@GetMapping("/user/{pageUserId}/follow")
	public  @ResponseBody CmRespDto<?> followList(@AuthenticationPrincipal PrincipalDetails principalDetails, @PathVariable int pageUserId){
		
		List<FollowRespDto> followRespDto = followService.팔로우리스트(principalDetails.getUser().getId(),pageUserId);
		
		return new CmRespDto<>(1,followRespDto); 
	}
	
	// 회원 프로필 반환 
	@GetMapping("/user/{id}")
	public String profile(@PathVariable int id, Model model,@AuthenticationPrincipal PrincipalDetails principalDetails) throws IllegalAccessException {
		UserProfileRespDto userProfileRespDto = userService.회원프로필(id,principalDetails.getUser().getId());
		model.addAttribute("dto",userProfileRespDto);
		return "user/profile";
	}
	
	// 프로핑 .setting
	@GetMapping("/user/{id}/profileSetting")
	public String profileSetting(@PathVariable int id, @AuthenticationPrincipal PrincipalDetails principalDetails, Model model) {
		// 김자바 선생 주석
		// System.out.println("principalDetails은 뭐냐" + principalDetails.getUser());
		// model.addAttribute("principalDetails",principalDetails.getUser());
		return "user/profileSetting";
	}
	
	// 회원수정 .setUser
	@PutMapping("/user/{id}")
	public @ResponseBody CmRespDto<?> profileUpdate(@PathVariable int id, User user, @AuthenticationPrincipal PrincipalDetails principalDetails){
		System.out.println(user);
		User userEntity = userService.회원수정(id, user);
		principalDetails.setUser(userEntity);
		return new CmRespDto<>(1, null);
	}
	 
	// 회원사진변경 SetUser를 이미지로 받음
	@PutMapping("/user/{id}/profileImageUrl")
	public @ResponseBody CmRespDto<?> profileImageUrlUpdate(@PathVariable int id, MultipartFile profileImageFile, @AuthenticationPrincipal PrincipalDetails principalDetails){
		User userEntity = userService.회원사진변경(profileImageFile, principalDetails);
		principalDetails.setUser(userEntity);
		return new CmRespDto<>(1, null);
	}
}
