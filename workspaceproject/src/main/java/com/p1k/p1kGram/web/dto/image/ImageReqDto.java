package com.p1k.p1kGram.web.dto.image;

import org.springframework.web.multipart.MultipartFile;

import com.p1k.p1kGram.domain.image.Image;
import com.p1k.p1kGram.domain.user.User;

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
				.build();}}