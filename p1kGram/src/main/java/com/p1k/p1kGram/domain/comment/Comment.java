package com.p1k.p1kGram.domain.comment;

import java.sql.Timestamp;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import org.hibernate.annotations.CreationTimestamp;

import com.p1k.p1kGram.domain.image.Image;
import com.p1k.p1kGram.domain.likes.Likes;
import com.p1k.p1kGram.domain.tag.Tag;
import com.p1k.p1kGram.domain.user.User;
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
public class Comment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(length = 100, nullable = false) // 100
	private String content;
	
	@ManyToOne
	@JoinColumn(name="imageId") // On Database
	private Image image;
	
	@JsonIgnoreProperties({"images"})
	@ManyToOne
	@JoinColumn(name="userId")
	private User user;
	
	@CreationTimestamp 
	private Timestamp createDate;}