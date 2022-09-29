package com.cos.blog.test;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

// 사용자가 요청 -> 응답(Data) : @RestController
// 사용자가 요청 -> 응답(HTML) : @Controller


//Body에 데이터를 실어 보내면 object로 mapping해서 받을수 있음 with @RequestBody annatation
//

@RestController
public class HttpControllerTest {
	

	private static final String TAG = "HttpControllerTest : " ;
	
	@GetMapping("/http/lombok")
	public String lombokTest() {
		Member m = Member.builder().username("taey").password("1234").email("ty.kim@tum.de").build();
		System.out.println(TAG+ "getter :" +m.getUsername());
		m.setUsername("taeyoung");
		System.out.println(TAG+ "setter :" +m.getUsername());
		return "lombok test complete";
		
	}
	
	
	//인터넷 브라우저 요청은 무조건 get만 사용 가능함! 
	//http://localhost:8080/http/get (Select)  @@yaml 변경으로인해 주소 바뀜 localhost:8000/blog/http/lombok
	@GetMapping("/http/get")
	public String getTest(Member m) { //id=1&username=taeyoung&password=1234&Email=ssar@nate.com
		return "get request:" +m.getId()+ "," +m.getUsername()+ ","+ m.getPassword()+ "," +m.getEmail();
	}
	
	//http://localhost:8080/http/put (insert) 
	@PostMapping("/http/post") // text/plain(평문으로 보냄) . //application/json(이썬타입 mime)
	public String postTest(@RequestBody Member m) { //MessageConverter(Springboot) works mapping each Infos.
		return "post request:" +m.getId()+ "," +m.getUsername()+ ","+ m.getPassword()+ "," +m.getEmail();
	}
	
	//http://localhost:8080/http/put (update) 
	@PutMapping("/http/put")
	public String putTest(@RequestBody Member m) {
		return "post request:" +m.getId()+ "," +m.getUsername()+ ","+ m.getPassword()+ "," +m.getEmail();
	}
	
	//http://localhost:8080/http/delete (delete) 
	@DeleteMapping("/http/delete")
	public String deleteTest() {
		return "delete request";
	}

	
}
