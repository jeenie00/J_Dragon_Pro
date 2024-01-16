package com.p1k.p1kGram.domain.user;

import java.sql.Timestamp;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import org.hibernate.annotations.CreationTimestamp;

import com.p1k.p1kGram.domain.image.Image;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(length = 30, unique = true)
	private String username;
	
	@JsonIgnore // json block
	private String password;
	
	private String name; // 이름
	private String website; //자기 홈페이지
	private String bio; //자기소개
	private String email;
	private String phone;
	private String gender;
	
	private String profileImageUrl; // 프로필 이미지 경로로 설정
	
	private String provider; // 제공자 null → 기본 로그인
	
	private String role; // USER,ADMIN
	
	@OneToMany(mappedBy = "user") // 기본 LAZY로딩 
	private List<Image> images;
	
	@CreationTimestamp // 자동으로 만든시간이 들어감
	private Timestamp createDate;}