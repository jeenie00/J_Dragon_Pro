package com.p1k.p1kGram.service;

// java - List
import java.util.List;

// 네이티브 쿼리 toEntity 타입이 아닌 결과값을 집합을 dto로 맵핑 해줌 
import org.qlrm.mapper.JpaResultMapper;

// jakarta - persistence
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

// sping streo/web
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

// import another class
import com.p1k.p1kGram.domain.follow.FollowRepository;
import com.p1k.p1kGram.web.dto.follow.FollowRespDto;

// lombok
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FollowService {
	private final FollowRepository followRepository;
	private final EntityManager em;
	
	// 팔로우 리스트
	@Transactional(readOnly = true)
	public List<FollowRespDto> 팔로우리스트(int principalId, int pageUserId){ // 로그인한사람, 페이지에 있는 사람
		
		// 쿼리문 맨뒤 한칸 띄어주기
		StringBuffer sb = new StringBuffer();
		sb.append("select u.id userId, u.username, u.profileImageUrl, ");
		sb.append("if((select True from follow where fromUserId = ? and toUserId = u.id),true,false) followState, "); 
		//  ↑ principalDetails.user.id
		sb.append("if(u.id = ?, true, false) equalState "); //principalDetails.user.id 
		sb.append("from follow f inner join user u on u.id = f.toUserId ");
		sb.append("where f.fromUserId = ?; "); // pageUserId
		
		Query query = em.createNativeQuery(sb.toString()) // Query jakarta persistance
				.setParameter(1, principalId)
				.setParameter(2,principalId)
				.setParameter(3, pageUserId);
		
		JpaResultMapper result = new JpaResultMapper(); 
		List<FollowRespDto> followRespDtos = result.list(query, FollowRespDto.class);		
		return followRespDtos;
	}
	
	// 팔로우하기
	@Transactional
	public int 팔로우(int fromUserId, int toUserId) {
		
		return followRepository.mFollow(fromUserId, toUserId);
	}
	
	// 언팔로우 하기
	@Transactional
	public int 언팔로우(int fromUserId, int toUserId) {
		
		return followRepository.mUnFollow(fromUserId, toUserId);
	}
}