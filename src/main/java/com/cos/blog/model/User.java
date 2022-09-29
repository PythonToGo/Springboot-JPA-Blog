package com.cos.blog.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;


// ORM -> Java +모든 언어 포함 object를 table로 mapping(jpa가 테이블로 만들어)
@Entity //User class가 자동으로 MySQL에테이블 생성됨.
public class User {
	
	@Id //Primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY) //프로젝트에서 연결된 DB의 넘버링 전략을 따라감identity, sequence, table 등등 여러개 많
	private int id; //for oracle: sequence,for MySQL: auto_increment
	
	@Column(nullable= false, length = 30)
	private String username; //ID
	  
	@Column(nullable= false, length = 100) //passord -> Hash(비밀번호 암호화)
	private String password; //PW
	
	@Column(nullable= false, length = 50)
	private String email;
	
	@ColumnDefault("'user'")
	private String role; //Enum사용하는게 낫다.(데이터의 도메인만들수 있음.) //admin, user, manager 중 하나만 들어갈수 있도록 도메인 설정 가능 = 범위를 설정할 수 있다.
	
	@CreationTimestamp //회원가입할때 시간이 자동입력됨.
	private Timestamp createDate; //updateDate도 나중에 사하기도 함
	

}
