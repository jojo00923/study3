package com.study.spring.test;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class UserTest {

	public static void main(String[] args) {
		System.out.println(">>>>>>>>>>>기존객체생성방식<<<<<<<<<<<<<<");
		User user = new User();
		user.info();
		//------------------------------------------UsesrDI.xml에 따라서 출력되는것.
		System.out.println(">>>>>>>>>>>>>>DI활용<<<<<<<<<<<<<<<");
		String config = "classpath:com/study/spring/test/userDI.xml";
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(config);
		UserDI userDI = ctx.getBean("userDI", UserDI.class);
		userDI.info();
		ctx.close();
		
	}
}
