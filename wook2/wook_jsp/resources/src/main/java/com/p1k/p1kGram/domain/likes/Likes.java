package com.p1k.p1kGram.domain.likes;

import java.sql.Timestamp;

// jakarta - persistence
// persistence(영속성)란? readme 추가내용 첨부  
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

// 쿼리 작성시, 자동으로 현재 시간을 저장해줌
import org.hibernate.annotations.CreationTimestamp;

// p1kGram
import com.p1k.p1kGram.domain.image.Image;
import com.p1k.p1kGram.domain.user.User;
// json 파싱을 막기 위힘 
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

// lombok
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

// Like는 mysql에 안되서 s를 붙여줌
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(
		name="likes",
		uniqueConstraints={
			@UniqueConstraint(	// unique - 한사람은 한번식만 좋아요를 가능하게 
				name = "likes_uk",
				columnNames={"imageId","userId"}
			)
		}
	) 
public class Likes {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	@JoinColumn(name="imageId")
	private Image image;
	
	// 누가 좋아요를 눌렀는지 알기 위함 
	// 추가적인 파싱을 막음(likes image가 필요없기 때문)
	@JsonIgnoreProperties({"images"})
	@ManyToOne
	@JoinColumn(name="userId")
	private User user;
	
	@CreationTimestamp
	private Timestamp createDate;
}