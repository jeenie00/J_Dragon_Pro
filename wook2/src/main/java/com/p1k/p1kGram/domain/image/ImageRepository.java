package com.p1k.p1kGram.domain.image;

// java
import java.util.List;

// spring data / jpa
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ImageRepository extends JpaRepository<Image, Integer>{
	
	// 일반 사진
	// nativeQuery = true : 네이티브 쿼리 에서 페이징 가능
	//네이티브 쿼리 (native sql) 란 뭔가요?
	// 기본적으로 jpa 에서 지원하는 sql의 문법 → DB에 종속적인 기능을 제공하지 않음 
	// nativesql을 통해 직접 사용가능하게함
	
	@Query(value = "select * from image where userId in (select toUserId from follow where fromUserId = :principalId) order by id desc", nativeQuery = true)
	Page<Image> mFollowFeed(int principalId,Pageable pageable); 

	// 인기사진
	@Query(value = "select * from image where id in (select imageId from (select imageId, count(imageId) likeCount from likes where userId = :principalId group by imageId order by 2 desc) t)", nativeQuery = true)
	List<Image> mExplore(int principalId);
}