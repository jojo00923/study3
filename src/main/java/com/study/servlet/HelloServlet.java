package com.study.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
//@WebServlet(urlPatterns= {"/admin/*", "*.nhn"}) //경로매핑, 확장자매핑
public class HelloServlet extends HttpServlet {

	@Override
	public void init() throws ServletException {
		// 최초에 메모리에 올라올때 (인스턴트 될때 1번 호출)
		super.init();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 사용자의 요청이 Get 방식인 경우 호출
		resp.setContentType("text/html; charset=utf-8"); //out 객체 생성하기 전에 콘텐츠 타입 먼저 지정해야 한글 나온다.
		PrintWriter out = resp.getWriter();
		out.println("<html lang=\"ko\">");
		out.println("<head>");
		out.println("<title>Hello</title>");
		out.println("</head>");
		out.println("<body>");
		String msg = "Hello 아라사이트에 오신걸 환영합니다.";
		out.println("<h3>" + msg + "</h3>");
		out.println("</body>");
		out.println("</html>");
	}
	
	@Override
	public void destroy() {
		// 메모리에서 해제될때
		super.destroy();
	}
	
	
}
