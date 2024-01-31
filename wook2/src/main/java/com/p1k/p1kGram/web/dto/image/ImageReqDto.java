package com.p1k.p1kGram.web.dto.image;

// 이미지 파일 받기 위한 import
import org.springframework.web.multipart.MultipartFile;

// import another class
import com.p1k.p1kGram.domain.user.User;
import com.p1k.p1kGram.domain.image.Image;

// import lombok
import lombok.Data;

@Data
public class ImageReqDto {
	private MultipartFile file;
	private String caption;
	private String tags;
	
	public Image toEntity(String postImageUrl, User userEntity) {
		return Image.builder()
				.caption(caption)
				.postImageUrl(postImageUrl)
				.user(userEntity)
				.build();
	}
}
