package com.p1k.p1kGram.domain.user;

// JAVA TIMESTAMP
import java.sql.Timestamp;
import java.util.List;

// JAKARTA
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
//OneToMany 
// 상대 엔티티를 참조할 수 있는 매핑이 부모 엔티티 쪽에 존재하지만, FK는 자식 엔티티 테이블에 존재하는 연관관계
import jakarta.persistence.OneToMany;

// import another method
import com.p1k.p1kGram.domain.image.Image;

// Hibernate 설정
import org.hibernate.annotations.CreationTimestamp;

// Fasterxml Json ignore (제이슨 파싱을 막기 위함)
import com.fasterxml.jackson.annotation.JsonIgnore;

// LomBok 
import lombok.AllArgsConstructor; // parameter가 있는 생성자를 자동으로 생성
import lombok.Builder; // Builder
import lombok.Data; // lombok 기능의 집합체 (getter,setter,RequiredArgsC, Tostring EqualsAndH 의 집합)
import lombok.NoArgsConstructor; // parameter가 없는 생성자를 자동으로 생성

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class User {
	@Id // ID (기본 키 값) 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	// 영구속성 또눈 팔두애 매핑된 열을 지정함 (지정하지 않으면 기본값 제공)
	// 최대 길이가 30 이라는 소리임
	@Column(length = 30, unique = true) 
	private String username;
	
	@JsonIgnore // password 제이슨 파실 불가능 
	private String password;
	
	// 기본 구분 작성
	private String name; // name
	private String website; // 마이페이지
	private String bio; // 프로필
	private String email; // email
	private String phone; // 전화번호 
	private String gender; // 성별
	
	private String profileImage; // 프로필 이미지 경로로 설정 

	private String provider; // 제공자 
	
	private String role; // USER, ADMIN
	
	@OneToMany(mappedBy = "user")
	private List<Image> images;
	
	@CreationTimestamp
	private Timestamp createDate;
}