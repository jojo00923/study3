package com.study.spring.test.aop;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class AopTest1 {

	public static void main(String[] args) {
		
		String config = "classpath:com/study/spring/test/aop/aop2.xml";
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(config);
		
		// 대상 빈(TargetObject)
		TargetObject target = ctx.getBean("target", TargetObject.class);
		String result = target.total(100);
		System.out.println(result);
		
		ctx.close();
		
		
		
		
		
		
		
	}
}
