package com.study.spring.test2;

public class User {
	//전형적인 객체 생성 방식의 사용
	Phone phone = new AndroidPhone();
	String  name = "혜진";
	
	public void info() {
		System.out.println("내이름은 " + name);
		phone.calling();
	}

}
