package com.p1k.p1kGram.service;

// import spring web/ transaction
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

// import another class
import com.p1k.p1kGram.domain.comment.Comment;
import com.p1k.p1kGram.domain.comment.CommentRepository;
import com.p1k.p1kGram.domain.image.Image;
import com.p1k.p1kGram.domain.user.User;

// lombok
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class CommentService {
	
	private final CommentRepository commentRepository;
	
	// 댓글쓰기
	@Transactional
	public Comment 댓글쓰기(User principal,String content, int imageId) {
		
		Image image = Image.builder()
				.id(imageId)
				.build();
		
		Comment comment = Comment.builder()
				.content(content)
				.image(image)
				.user(principal)
				.build();
		// 저장시 값을 넣어줌ㄴ
		return commentRepository.save(comment);
	}
	
	// 댓글 삭제
	@Transactional
	public void 댓글삭제(int id, int principalId) {
		
		Comment commentEntity = commentRepository.findById(id).get();
		
		if (commentEntity.getUser().getId() == principalId) {
			commentRepository.deleteById(id);
		} else {
	
		}
	}
}
