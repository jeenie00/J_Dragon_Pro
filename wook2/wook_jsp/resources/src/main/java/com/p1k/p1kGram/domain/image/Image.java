package com.p1k.p1kGram.domain.image;

import java.sql.Timestamp;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OrderBy;
import jakarta.persistence.Transient;

import org.hibernate.annotations.CreationTimestamp;

import com.p1k.p1kGram.domain.comment.Comment;
import com.p1k.p1kGram.domain.likes.Likes;
import com.p1k.p1kGram.domain.tag.Tag;
import com.p1k.p1kGram.domain.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Image {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	// 내용 적음
	private String caption;
	
	// 기본 이미지(포스트)
	private String postImageUrl;
	
	@JsonIgnoreProperties({"images"})
	@ManyToOne // 당연히 기본은 EAGER
	@JoinColumn(name="userId") // userId = db 칼럼명
	private User user; // User가 주인임 여러개으 키를 만들 수 있음
	
	// 양방향 매핑 , 데베에 생기면 안됨
	// sql 에서 key의 변수명을 적음 (안적으면 기본값(lazy)으로 들어감)
	@JsonIgnoreProperties({"image"})
	@OneToMany(mappedBy = "image") 
	private List<Tag> tags; // * 컨틀롤러에서는 잭슨이 발동하지 않아서 갯터가 실행이안됨 무한반복이 안됨
	
	//라이크 정보도 가지고 있어야함, 그래야 버튼을 눌러서 빨간색이 뜨게 하고 유지할수있음
	// sql 에서 key의 변수명을 적음 (안적으면 기본값(lazy)으로 들어감)
	@JsonIgnoreProperties({"image"})
	@OneToMany(mappedBy = "image") 
	private List<Likes> likes; // A이미지에 홍길동, 장보고, 임꺽정 좋아요를 했고, 여기에 이름이 없으면 빨간색 하트가안뜨고
	
	// follow 정보
	// comment (댓글)
	// 정렬 jakarta
	@OrderBy("id DESC") 
	@JsonIgnoreProperties({"image"})
	@OneToMany(mappedBy = "image")
	private List<Comment> comments;
	
	// 쿼리 생성시 자동으로 현지 시간을 저장함
	@CreationTimestamp 
	private Timestamp createDate;
	
	// 카운트만해야함 컬럼에 넣으면 안됨
	@Transient 
	private int likeCount;
	
	@Transient
	private boolean likeState;
}