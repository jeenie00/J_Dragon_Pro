package com.p1k.p1kGram.service;

// import java
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

// spring - value : 설정파일(application)에 설정한 내용을 불러 올 수 있읍
import org.springframework.beans.factory.annotation.Value;

// spring data/streo/trans
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

// import p1kGram

import com.p1k.p1kGram.config.auth.PrincipalDetails;
import com.p1k.p1kGram.domain.image.Image;
import com.p1k.p1kGram.domain.image.ImageRepository;
import com.p1k.p1kGram.domain.tag.Tag;
import com.p1k.p1kGram.domain.tag.TagRepository;
import com.p1k.p1kGram.utils.TagUtils;
import com.p1k.p1kGram.web.dto.image.ImageReqDto;

// lombok
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ImageService {

	private final ImageRepository imageRepository;
	private final TagRepository tagRepository;
	
	// 이제부터 application 파일에 접근 가능 
	// 저장된 이미지를 업로드 or 보기 위해서
	@Value("${file.path}")
	private String uploadFolder;
	
	@Transactional(readOnly = true)
	// 인기사진
	public List<Image> 인기사진(int principalId){
		return imageRepository.mExplore(principalId);
	}
	// 이미지 확인
	public Page<Image> 피드이미지(int principalId,Pageable pageable){
		
		// SELECT toUserId FROM follow where toUser=principalId
		// principalId로 사용자를 찾음, 그리고 찾은 사용자의 사진을 배포함 
	
		Page<Image> images = imageRepository.mFollowFeed(principalId,pageable);
		
		// 좋아요 하트 색깔 로직 + 좋아요 카운트 로직
		images.forEach((image)->{
			
			int likeCount = image.getLikes().size();
			image.setLikeCount(likeCount);
			
			image.getLikes().forEach((like)->{
				if(like.getUser().getId() == principalId) { // 좋아요한사람이랑 이미지 유저의 아이디랑
					image.setLikeState(true);
				}
			});
		});
		return images;
	}
	
	// 사진 업로드하기
	@Transactional
	public void 사진업로드(ImageReqDto imageReqDto, PrincipalDetails principalDetails) {
		
		UUID uuid = UUID.randomUUID();
		String imageFileName = uuid+"_"+imageReqDto.getFile().getOriginalFilename();
		System.out.println("파일명" + imageFileName);
		
		Path imageFilePath = Paths.get(uploadFolder+imageFileName); // 파일 경로
		System.out.println("파일path"+imageFilePath);
		
		try {
			// write 통신을 진행함 실패가능성을 위해 try catch 를 사용 
			Files.write(imageFilePath, imageReqDto.getFile().getBytes());
		} catch (Exception e) {
			e.printStackTrace();
		}
				
		// 1.image 저장
		Image image = imageReqDto.toEntity(imageFileName, principalDetails.getUser());
		Image imageEntity = imageRepository.save(image);
		
		// 2 Tag 저장
		List<Tag> tags = TagUtils.parsingToTagObject(imageReqDto.getTags(),imageEntity);
		tagRepository.saveAll(tags); // 컬렉션 한방에 저장
				
	}
}