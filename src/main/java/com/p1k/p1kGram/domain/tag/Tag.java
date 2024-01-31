package com.p1k.p1kGram.domain.tag;

import java.sql.Timestamp;

// jakarta persistence
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

// 쿼리생성시 자동으로 시간을 저장함
import org.hibernate.annotations.CreationTimestamp;

// p1kGram
import com.p1k.p1kGram.domain.image.Image;
import com.p1k.p1kGram.domain.user.User;

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
public class Tag {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	
	// manytoOne 단방향과 양방향의 관계 manytoOne / oneToMany
	@ManyToOne
	@JoinColumn(name="imageId")
	private Image image;
	
	// 쿼리생성시 자동으로 시간을 저장함
	@CreationTimestamp 
	private Timestamp createDate;
}