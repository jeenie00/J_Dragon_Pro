package com.p1k.p1kGram.domain.follow;

import com.p1k.p1kGram.domain.user.User;





import java.sql.Timestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

import org.hibernate.annotations.CreationTimestamp;

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
@Table(
		name="follow",
		uniqueConstraints={
			@UniqueConstraint(
				name = "follow_uk",
				columnNames={"fromUserId","toUserId"}
			)
		}
	) //중복으로 될수있는걸 막기
public class Follow {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@JsonIgnoreProperties({"images"})
	@ManyToOne
	@JoinColumn(name = "fromUserId")
	private User fromUser; // ~~로 부터, 팔로우를 하는 애
	
	@JsonIgnoreProperties({"images"})
	@ManyToOne
	@JoinColumn(name = "toUserId")
	private User toUser; // ~~를, 팔로우를 당하는 애
	
	@CreationTimestamp // 자동으로 현재시간 담김
	private Timestamp createDate;
}
