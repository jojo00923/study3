package com.study.spring.test2;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//얘를 쓰면 빈으로 등록해주자나 이 클래스를 그러면 이 클래스를 빈으로 등록할때 아이디를 낙타식으로 해서 써준다(memberID처럼 앞에를 소문자 연결되는단어 대문자~~)
@Component("userDI")  //spring이 관리할 수 있게 등록하고싶을때, xml에 bean을 정의한것과 같은 역할. = controller, service, repositiry mvc사용땜에 만들어진 애들 이 네가지 중 골라서 쓰면 됨.
	                    //userTest.java에 정의한 아이디와 같은걸로 이름정해주어야함.
@Scope("prototype") //기본이 singleton인데(안쓰면 기본적용됨) prototype으로 바꾸고 싶으면 ()안에 적어주면됨.
public class UserDI {
	// DI를 통해서 객체 받기(new -source -setter만 받아오기)
	
	@Autowired(required=true) //자동주입, 기본은 필수로 주입//setter에 @Autowired 붙여도 됨. 근데 여기 쓰면 setter자체를 안만들어도 됨~~ (required=false)없으면 안줘도 된다는 뜻. 원래 phone에 어노테이션이나 빈이 연결되어있어야됨 
	@Qualifier("IPhone") //동일타입의 빈이 여러개인경우 //지금은 androidPhone이랑 iPhone있어서 쓴거임.
	
	@Resource(name="IPhone") //위랑 똑같은것, 3개중 1개만 쓰면 됨. 근데 3개써도 오륜 안남
	private Phone phone;
	@Value("길동이래요")
	String name;
	
	//빈으로 등록할 때  초기화관련 호출
	@PostConstruct
	public void init() {
		System.out.println("초기화 관련 메서드");
	}
	
	//빈에서 해제될 때 호출
	@PreDestroy
	public void close() {
		//사용했던 자원 해제
		System.out.println("close 호출");
	}

	public void info() {
		System.out.println("내이름은 " + name);
		phone.calling();
		System.out.println("주소록명단");
		for (String str : phone.getAddress()) {
			System.out.println(str);
		}
	}

/*	property에 직접 @Autowired를 하면 setter 메서드를 생성 안하셔도 됩니다.
 * @Autowired 
	public void setPhone(Phone phone) {
		this.phone = phone;
	}
*/
	public void setName(String name) {
		this.name = name;
	}

}
