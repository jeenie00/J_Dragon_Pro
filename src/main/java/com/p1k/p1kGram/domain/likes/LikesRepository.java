package com.p1k.p1kGram.domain.likes;

// spring jpa
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface LikesRepository extends JpaRepository<Likes, Integer>{
	
	// 네이티브 쿼리 사용
	// modifying → 자동적으로 삭제를 붙잡음 → likes 유지 시키기 위함
	@Modifying 
	@Query(value = "INSERT INTO likes(imageId, userId) VALUES(:imageId, :principalId)", nativeQuery = true)
	int mLike(int imageId, int principalId);
	
	@Modifying
	@Query(value = "DELETE FROM likes WHERE imageId = :imageId AND userId = :principalId", nativeQuery = true)
	int mUnLike(int imageId, int principalId);
}