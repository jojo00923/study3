package com.study.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface IController {

	//뷰페이지 반환할거라 String
	public String process(HttpServletRequest request, HttpServletResponse response) throws ServletException;
	//무조건 오버라이딩해줘야하는애

}