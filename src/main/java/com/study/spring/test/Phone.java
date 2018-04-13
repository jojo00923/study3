package com.study.spring.test;

import java.util.List;

public interface Phone {
	
	void calling();
	
	List<String> getAddress();
	
	void setAddress(List<String> address);
}
