package com.p1k.p1kGram.domain.follow;

// java - timestamp
import java.sql.Timestamp;

// jakarta peristence
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

//hibernate insert/update 등의 쿼리가 발생 시, 자동으로 시간을 저장해줌
import org.hibernate.annotations.CreationTimestamp;

// p1kGram
import com.p1k.p1kGram.domain.user.User;
//json 파싱을 막기위함
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
@Table( // 중복 제어해야함
		name="follow",
		uniqueConstraints={
			@UniqueConstraint(
				name = "follow_uk",
				columnNames={"fromUserId","toUserId"}
			)
		}
	) 
public class Follow {
	// id
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	// from
	@JsonIgnoreProperties({"images"})
	@ManyToOne
	@JoinColumn(name = "fromUserId")
	private User fromUser; 
	
	// to
	@JsonIgnoreProperties({"images"})
	@ManyToOne
	@JoinColumn(name = "toUserId")
	private User toUser; 
	
	// 쿼리 발생 시 자동으로 현재 시간을 저정함
	@CreationTimestamp 
	private Timestamp createDate;
}