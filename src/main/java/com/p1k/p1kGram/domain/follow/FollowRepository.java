package com.p1k.p1kGram.domain.follow;

// java - List
import java.util.List;

// spring - data
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface FollowRepository extends JpaRepository<Follow, Integer>{
	
	 
	// write 
	//List<Follow> findByFromUserId(int userId);
	
	@Modifying // jakarta - Modifying 기본 쿼리 어노테이션 
	@Query(value = "INSERT INTO follow(fromUserId, toUserId, createDate) VALUES(:fromUserId, :toUserId,now())", nativeQuery = true)
	int mFollow(int fromUserId, int toUserId); // prepareStatement updateQuery() => -1, 0, 1 응답의 결과 그래서 int로 받기

	@Modifying 
	@Query(value = "DELETE FROM follow WHERE fromUserId = :fromUserId AND toUserId=:toUserId", nativeQuery = true)
	int mUnFollow(int fromUserId, int toUserId); // prepareStatement updateQuery() => -1, 0, 1 응답의 결과 그래서 int로 받기
	
	@Query(value = "select count(*) from follow where fromUserId = :principalId AND toUserId = :userId", nativeQuery = true)
	int mFollowState(int principalId, int userId);
	
	@Query(value = "select count(*) from follow where fromUserId = :userId", nativeQuery = true)
	int mFollowCount(int userId);
}