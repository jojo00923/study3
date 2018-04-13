package com.study.spring.test;

import java.util.List;

public class IPhone implements Phone {

	List<String> address;
	
	@Override
	public void calling() {
		System.out.println("아이폰 : 전화왔어요.");
		
	}

	@Override
	public List<String> getAddress() {
		return address;
	}

	@Override
	public void setAddress(List<String> address) {
		this.address = address;
	}

}
