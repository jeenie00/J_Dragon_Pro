package com.p1k.p1kGram.domain.comment;

// java
import java.sql.Timestamp;
import java.util.List;

// jakarta - persistence 
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

// hibernate insert/update 등의 쿼리가 발생 시, 자동으로 시간을 저장해줌
import org.hibernate.annotations.CreationTimestamp;

// p1kGram
import com.p1k.p1kGram.domain.image.Image;
import com.p1k.p1kGram.domain.likes.Likes;
import com.p1k.p1kGram.domain.tag.Tag;
import com.p1k.p1kGram.domain.user.User;

// json 파싱을 막기위함
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

// lombok
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Comment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	// 최대 글자 수 설정, null은 안됨
	@Column(length = 100, nullable = false) 
	private String content;
	
	// joincilumn : db에 column명을 적어놓음
	@ManyToOne
	@JoinColumn(name="imageId") 
	private Image image;
	
	// joincilumn : db에 column명을 적어놓음
	// json 파싱을 막음
	@JsonIgnoreProperties({"images"})
	@ManyToOne
	@JoinColumn(name="userId")
	private User user;
	
	// 쿼리 발생 시 자동으로 현재 시간을 저정함
	@CreationTimestamp 
	private Timestamp createDate;
}