package com.cos.blog.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.ColumnDefault;
// import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
// import org.hibernate.annotations.DynamicInsert;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
//ORM -> Java Object -> can mapping to Table
@Entity //User Class can make some Table in MySQL
// @DynamicInsert // insert시 null 인 필드를 제외시켜준다.
public class User {
	
	@Id // primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY) //프로젝트에서 연결된 데이터베이스의 넘버링 전략을 따라간다. 
	private int id; //sequence: auto_increment
	
	@Column(nullable = false, length= 30)
	private String username; //ID
	
	@Column(nullable = false, length= 100)
	private String password; // PASSWORD -> change it later as Hash
	
	@Column(nullable = false, length= 50)
	private String email;
	
	// @ColumnDefault("user")
	// DB는 RoleType 이 없다.
	@Enumerated(EnumType.STRING)
	private RoleType role; //use Emun (Emun can make domain) ADMIN, USER etc
	
	@CreationTimestamp // can upload time automatically
	private Timestamp createDate;
	
	
		

}
