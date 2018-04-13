package com.study.spring.test2;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class UserTest {

	public static void main(String[] args) {
		

		System.out.println(">>>>>>>>>>>>>>DI활용<<<<<<<<<<<<<<<");
		String config = "classpath:com/study/spring/test2/userDI.xml";
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(config);
		
		//new를 쓰면 new개수만큼 해시코드가 나오는데, 
		//스프링은 변수명이 몇개든 결국은 해시코드가 하나야.. 같은 곳에서 활용하기 때문에
		UserDI userDI = ctx.getBean("userDI", UserDI.class);
		UserDI user2 = ctx.getBean("userDI", UserDI.class);
		
		
		//userDI.info();
		System.out.println("1번:  " + userDI.hashCode());
		System.out.println("2번:  " + userDI.hashCode());
		
		ctx.close();
	}
}
