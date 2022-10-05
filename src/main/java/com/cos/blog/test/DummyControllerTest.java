package com.cos.blog.test;

import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cos.blog.model.RoleType;
import com.cos.blog.model.User;
import com.cos.blog.repository.UserRepository;


// html 파일이 아니라  data 를 리턴 해주는 controller = Restcontroller
@RestController
public class DummyControllerTest {
	@Autowired //의존성 주입(Dependency insert) 
	private UserRepository userRepository;
	
	//{id} 주소로 파라미터를 전달 받을수 있다.
	// http://localhost:8000/blog/dummy/user/3
	@GetMapping("/dummy/user/{id}")
	public User detail(@PathVariable int id) throws IllegalAccessException{
		// user/4를 찾으면 내가 DB에서 못찾아오게 되면 User = null
		// 그럼 return null이 리턴 된다.= 프로그램에 문제가 있다
		// optional로 user 객체를 감싸서 가져올테니 null인지 아닌지 판단해서 return해! 
		
//람다식 
//		User user = userRepository.findById(id).orElseThrow(()->{
//		return new IllegalArgumentException("해당 사용자는 없습니다.");
//	});
		
		User user = userRepository.findById(id).orElseThrow(new Supplier<IllegalAccessException>() {
			@Override
			public IllegalAccessException get() {
				// TODO Auto-generated method stub
				return new IllegalAccessException("There is no such user. id: "+id);
			}
		});
		// request from web-browser
		// user object = java object 
		// transport(웹브라우저가 이해할 수 있는 데이터로 변환해야함 json이 가장 적절)
		// 스프링부트 = MessageConverter 라는 애가 응답시에 자동 작동
		// 만약에 자바 오브젝트를 리턴하게 되면 MessageConverter가 jackson 라이브러리를 호출해서 
		// user 오브젝트를 json으로 변환해서 브라우저에게 던져준다.
		return user;
		
	}
	// http://localhost:8000/blog/dummy/join (Request)
	// http의 body에 username, password, email 데이터를 가지고 요청하게 되면 join 함수의 파라미터에 들어

	@PostMapping("/dummy/join")
	public String join(User user) { //key=value (promised rule)
		System.out.println("Id :"+user.getId());
		System.out.println("username :"+user.getUsername());
		System.out.println("password :"+user.getPassword());
		System.out.println("email :"+user.getEmail());
		System.out.println("role :"+user.getRole());
		System.out.println("createDate :"+user.getCreateDate());
		
		user.setRole(RoleType.USER);
		userRepository.save(user);
		return "Sign up is complete.";
		
		
	}

}
