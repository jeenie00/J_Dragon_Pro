package com.p1k.p1kGram.domain.follow;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
// modifying → select 제외 쿼리 annotation 사용
import org.springframework.data.jpa.repository.Modifying;
// query 정의로 벌크연산된건 영속성x 	→ DB에 즉각적으로 질의함 
import org.springframework.data.jpa.repository.Query;

public interface FollowRepository extends JpaRepository<Follow, Integer>{
	
	
	@Modifying // javax 의 트랜잭션(서비스에서는 프레임 워크임 프레임 워크)
	@Query(value = "INSERT INTO follow(fromUserId, toUserId, createDate) VALUES(:fromUserId, :toUserId,now())", nativeQuery = true)
	int mFollow(int fromUserId, int toUserId); 

	@Modifying // javax 의 트랜잭션
	@Query(value = "DELETE FROM follow WHERE fromUserId = :fromUserId AND toUserId=:toUserId", nativeQuery = true)
	int mUnFollow(int fromUserId, int toUserId); 
	
	@Query(value = "select count(*) from follow where fromUserId = :principalId AND toUserId = :userId", nativeQuery = true)
	int mFollowState(int principalId, int userId);
	
	@Query(value = "select count(*) from follow where fromUserId = :userId", nativeQuery = true)
	int mFollowCount(int userId);}