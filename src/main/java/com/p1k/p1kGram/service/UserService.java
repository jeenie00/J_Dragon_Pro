package com.p1k.p1kGram.service;

// import java
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.util.UUID;

// import value(application에 접근하기 위함) / security / streo / transaction /web(이미지파일)
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

// p1kGram
import com.p1k.p1kGram.config.auth.PrincipalDetails;
import com.p1k.p1kGram.domain.follow.FollowRepository;
import com.p1k.p1kGram.domain.user.User;
import com.p1k.p1kGram.domain.user.UserRepository;
import com.p1k.p1kGram.web.dto.user.UserProfileRespDto;

// lombok
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserService {

	private final UserRepository userRepository;
	private final FollowRepository followRepository;
	private final BCryptPasswordEncoder bCryptPasswordEncoder;
	
	// application 설정에 접근
	@Value("${file.path}")
	private String uploadFolder;
	
	// 더티체킹 //함수종료일때 -> 트랙잭션 종료 -> 영속화 되어있는 데이터를 db로 갱신(flush) -> 디비에 commit 
	
	// 회원사진 변경
	@Transactional
	public User 회원사진변경(MultipartFile profileImageFile, PrincipalDetails principalDetails) {
		
		UUID uuid = UUID.randomUUID();
		String imageFileName = uuid+"_"+profileImageFile.getOriginalFilename();
		//System.out.println("파일명 : "+imageFileName);
		
		Path imageFilePath = Paths.get(uploadFolder+imageFileName);
		//System.out.println("파일패스 : "+imageFilePath);
		try {
			Files.write(imageFilePath, profileImageFile.getBytes());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		User userEntity = userRepository.findById(principalDetails.getUser().getId()).get();
		userEntity.setProfileImage(imageFileName);
		// ↑ 해당 원문 setProfileImageUrl : 오류로 수정 01.31 minamwook
		return userEntity;
	}

	// 회원 프로필 확인
	@Transactional(readOnly = true)
	public UserProfileRespDto 회원프로필(int userId, int principalId) throws IllegalAccessException {
		UserProfileRespDto userProfileRespDto = new UserProfileRespDto();

		User userEntity = userRepository.findById(userId).orElseThrow(() -> {
			return new IllegalArgumentException();
		});

		int followState = followRepository.mFollowState(principalId, userId);
		int followCount = followRepository.mFollowCount(userId);
		System.out.println(followState == 1);

		userProfileRespDto.setFollowState(followState == 1);
		userProfileRespDto.setFollowCount(followCount); // 내가 팔로우 하고 있는 카운트
		userProfileRespDto.setImageCount(userEntity.getImages().size());

		userEntity.getImages().forEach((image) -> {
			image.setLikeCount(image.getLikes().size());
		});

		userProfileRespDto.setUser(userEntity);

		return userProfileRespDto;
	}
	// 회원수정
	@Transactional
	public User 회원수정(int id, User user) {
		// username, email 수정 불가
		User userEntity = userRepository.findById(id).get();
		userEntity.setName(user.getName());
		userEntity.setBio(user.getBio());
		userEntity.setWebsite(user.getWebsite());
		userEntity.setGender(user.getGender());

		String rawPassword = user.getPassword();
		String encPassword = bCryptPasswordEncoder.encode(rawPassword);
		userEntity.setPassword(encPassword);
		return userEntity;
	}
}