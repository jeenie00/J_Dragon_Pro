package com.p1k.p1kGram.utils;

// java list
import java.util.ArrayList;
import java.util.List;

import com.p1k.p1kGram.domain.image.Image;
import com.p1k.p1kGram.domain.tag.Tag;

public class TagUtils {
	
	public static List<Tag> parsingToTagObject(String tags, Image imageEntity) {
		String temp[] = tags.split("#"); // 나눔, 나눈 크기로 배열
		List<Tag> list = new ArrayList<>();

		// json 파싱 → 0번에 공백이 들어감 → 1부터 시작
		for (int i=1; i<temp.length; i++) {
			Tag tag = Tag.builder()
					.name(temp[i].trim())
					.image(imageEntity)
					.build();

			list.add(tag);
		}
		return list;
	}
}
