package com.cos.blog.test;


import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//객체지향에서는 변수 private (값을 함수void를 통해서 변수private 접근함)

@Data
@NoArgsConstructor
public class Member {
	private int id;
	private String username;
	private String password;
	private String email;
	
	@Builder
	public Member(int id, String username, String password, String email) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
	}
	
	
}
	

//Builder: Dev can order things free USING LOMBOK
//		Dev can aviod to make some ordering USING LOMBOK