package com.p1k.p1kGram.web.dto.comment;

// lombok Data == lombok 매서드의 집합체 
import lombok.Data;

@Data
public class CommentReqDto {
	private String content;
	private int imageId;
}