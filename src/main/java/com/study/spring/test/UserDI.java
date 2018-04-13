package com.study.spring.test;

public class UserDI {
	// DI를 통해서 객체 받기(new -source -setter만 받아오기)

	Phone phone;
	String name;
	
	//빈으로 등록할 때  초기화관련 호출
	public void init() {
		System.out.println("초기화 관련 메서드");
	}
	
	//빈에서 해제될 때 호출
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

	public void setPhone(Phone phone) {
		this.phone = phone;
	}

	public void setName(String name) {
		this.name = name;
	}

}
