package com.p1k.p1kGram.service;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import org.qlrm.mapper.JpaResultMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.p1k.p1kGram.domain.follow.Follow;
import com.p1k.p1kGram.domain.follow.FollowRepository;
import com.p1k.p1kGram.web.dto.follow.FollowRespDto;

import lombok.RequiredArgsConstructor;

// 팔로잉 기능
@RequiredArgsConstructor
@Service
public class FollowService {

	private final FollowRepository followRepository;
	private final EntityManager em;
	
	@Transactional(readOnly = true)
	public List<FollowRespDto> 팔로우리스트(int principalId, int pageUserId){ // 로그인한사람, 페이지에 있는 사람
		
		// 쿼리문 맨뒤 한칸 띄어주기
		StringBuffer sb = new StringBuffer();
		sb.append("select u.id userId, u.username, u.profileImageUrl, ");
		sb.append("if((select True from follow where fromUserId = ? and toUserId = u.id),true,false) followState, "); //principalDetails.user.id
		sb.append("if(u.id = ?, true, false) equalState "); //principalDetails.user.id 
		sb.append("from follow f inner join user u on u.id = f.toUserId ");
		sb.append("where f.fromUserId = ?; "); // pageUserId
		
		Query query = em.createNativeQuery(sb.toString()) //
				.setParameter(1, principalId)
				.setParameter(2, principalId)
				.setParameter(3, pageUserId);
		
		JpaResultMapper result = new JpaResultMapper(); 
		List<FollowRespDto> followRespDtos = result.list(query, FollowReposDto.class)); // 팔로워를 불러주는 기능 → 정상적인 맵핑이 지금 안됨 	
		
		return followRespDtos;
	}
	
	@Transactional // On FrameWork
	public int 팔로우(int fromUserId, int toUserId) {
		
		return followRepository.mFollow(fromUserId, toUserId);
	}
	
	@Transactional // On FrameWork
	public int 언팔로우(int fromUserId, int toUserId) {
		
		return followRepository.mUnFollow(fromUserId, toUserId);
	}
}