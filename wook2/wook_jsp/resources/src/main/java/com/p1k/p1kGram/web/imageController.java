package com.p1k.p1kGram.web;

// import Controller
import org.springframework.stereotype.Controller;

// import data / security
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.annotation.AuthenticationPrincipal;

// import web
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

// import lombok
import lombok.RequiredArgsConstructor;

// import another class
import com.p1k.p1kGram.config.auth.PrincipalDetails;
import com.p1k.p1kGram.domain.comment.Comment;
import com.p1k.p1kGram.domain.image.Image;
import com.p1k.p1kGram.service.CommentService;
import com.p1k.p1kGram.service.ImageService;
import com.p1k.p1kGram.service.LikesService;
import com.p1k.p1kGram.web.dto.CmRespDto;
import com.p1k.p1kGram.web.dto.image.ImageReqDto;

@RequiredArgsConstructor
@Controller
public class imageController {
	private final ImageService imageService;
	private final LikesService likesService;
	private final CommentService commentService;
	
	// 피드 이미지 확인
	@GetMapping({"/","/image/feed"})
	public String feed() {
		return "image/feed";
	}
	
	// 주소확인 - 누가 팔로우를 했는지 확인하기 
	@GetMapping("/image")
	public @ResponseBody CmRespDto<?> image(Model model, @AuthenticationPrincipal PrincipalDetails principalDetails, 
			@PageableDefault(size = 3, sort="id", direction= Sort.Direction.DESC) Pageable pageable) { // 스프링프레임워크 데이터 도멘이꺼임

		Page<Image> pages = imageService.피드이미지(principalDetails.getUser().getId(),pageable);
		return new CmRespDto<>(1,pages); // MessageConverter 발동= Jackson 무한잠초가 발생할수있음
	}

	@GetMapping("/image/explore")
	public String explore(Model model, @AuthenticationPrincipal PrincipalDetails principalDetails) {

		model.addAttribute("images", imageService.인기사진(principalDetails.getUser().getId()));

		return "image/explore";
	}
	
	@GetMapping("image/upload")
	public String upload() {
		return "image/upload";
	}
	
	// PostMapping 
	// 사진 업로드 설정
	@PostMapping("/image")
	public String image(ImageReqDto imageReqDto, @AuthenticationPrincipal PrincipalDetails principalDetails) {
		imageService.사진업로드(imageReqDto,principalDetails);
		return "redirect:user/"+principalDetails.getUser().getId();
	}
	
	// 좋아요 설정
	@PostMapping("/image/{imageId}/likes")
	public @ResponseBody CmRespDto<?> like(@AuthenticationPrincipal PrincipalDetails principalDetails, @PathVariable int imageId){
		likesService.좋아요(imageId, principalDetails.getUser().getId());
		return new CmRespDto<>(1, null);
	}
	
	// 싫어요 설정
	@DeleteMapping("/image/{imageId}/likes")
	public @ResponseBody CmRespDto<?> unLike(@AuthenticationPrincipal PrincipalDetails principalDetails, @PathVariable int imageId){
		likesService.싫어요(imageId, principalDetails.getUser().getId());
		return new CmRespDto<>(1, null);
	}
	
	// 댓글로 받을 값 : imageId, content
	@PostMapping("/image/{imageId}/comment")
	public @ResponseBody CmRespDto<?> save(@PathVariable int imageId, @RequestBody String content, @AuthenticationPrincipal PrincipalDetails principalDetails){   // content, imageId, userId(세션)
		System.out.println("ㄱㄱ");
		System.out.println("content: " + content);
		Comment commentEntity = commentService.댓글쓰기(principalDetails.getUser(), content, imageId);
		
		return new CmRespDto<>(1, commentEntity);
	}
}
