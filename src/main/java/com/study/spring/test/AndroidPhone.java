package com.study.spring.test;

import java.util.List;

public class AndroidPhone implements Phone {
	List<String> address;
	
	@Override
	public void calling() {
		System.out.println("안드로이드: 전화왔어요~");
		
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
