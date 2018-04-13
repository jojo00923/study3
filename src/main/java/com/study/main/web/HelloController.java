package com.study.main.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

	
	
	@RequestMapping("/hello") //->사용자요청
	public String hello(Model model) { //어트리뷰트에 담을 객체를 위한 객체.......
		
		model.addAttribute("message", "언니 주무세요 엄마가 섬그늘에~~굴따러어가면~~ ");
		return "hello"; //->뷰이름 //MemberListController와 비교해보삼 /WEB-INF/view/hello.jsp 
				                       //이거는 mvc-config.xml에 기본으로 prefix (/WEB-INF/view/) suffix(.jsp)가 있기때문에 안쓰는거임. 
	}
	
	
	
}
