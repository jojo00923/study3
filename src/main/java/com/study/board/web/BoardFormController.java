package com.study.board.web;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.study.servlet.IController;

public class BoardFormController implements IController {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		System.out.println("폼");
		return "/WEB-INF/view/board/boardForm.jsp";
	}
	
}
