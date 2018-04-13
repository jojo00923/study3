package com.study.spring.test.aop;

import org.springframework.stereotype.Component;

@Component("target")
public class TargetObject {
	
	public String total(int maxValue) {
		System.out.println("=== total 실행 ===");
		if(maxValue < 1 ){
		throw new RuntimeException( maxValue + "는 범위를 벗어났습니다.");
		}
		int sum = 0;
		for(int i = 1; i <= maxValue; i++){
		sum += i;
		}
		return "결과값은 = [" + sum + "]";
		} // total

}
