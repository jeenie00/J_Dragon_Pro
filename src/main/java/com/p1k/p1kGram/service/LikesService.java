package com.p1k.p1kGram.service;

// spring streo/transaction
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

// p1kGram
import com.p1k.p1kGram.domain.likes.LikesRepository;

// lombok
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class LikesService {
	private final LikesRepository likesRepository;
	
	// 좋아요 설정
	@Transactional	
	public void 좋아요(int imageId, int principalId) {
		likesRepository.mLike(imageId, principalId);
	}
	// 싫어요 설정
	@Transactional
	public void 싫어요(int imageId, int principalId) {
		likesRepository.mUnLike(imageId, principalId);
	}
}