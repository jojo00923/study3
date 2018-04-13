package com.study.spring.test.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

public class LoggingAdvice {

	// 공통기능을 처리하는 클래스 작성

	public void logging(JoinPoint joinPoint) {
		String methodName = joinPoint.getSignature().getName();
		String className = joinPoint.getTarget().getClass().getSimpleName();
		Object[] args = joinPoint.getArgs();
		System.out.println("beforMethod 실행 " + className + "." + methodName);

		if (args != null && args.length > 0) {
			System.out.println("첫번째 인자 = " + args[0]);
		}
	}

	// 실행전 처리, 타겟 메서드 직접호출, 예외처리 가능
	public Object aroundMethod(ProceedingJoinPoint joinPoint) throws Throwable {
		String methodName = joinPoint.getSignature().getName();
		String className = joinPoint.getTarget().getClass().getSimpleName();
		long startTime = System.currentTimeMillis();//시작시간구함
		
		//대상 객체 콜(TargetObject의 total메서드를 호출하겠다는 것)
		Object retVal = joinPoint.proceed();
		
		System.out.println("aroundMethod 실행 - 2 " + className + "." + methodName + ", lead time ="
		    + (System.currentTimeMillis() - startTime));
		
		return retVal;
	}
}
