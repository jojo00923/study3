package com.study.member.web;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.study.member.service.IMemberService;
import com.study.member.service.MemberServiceImpl;
import com.study.member.vo.Member;
import com.study.servlet.IController;

public class MemberInsertController implements IController {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		
		IMemberService memberService = new MemberServiceImpl();
		String viewPage = "/WEB-INF/view/member/memberInsert.jsp";
		
		String mem_id = request.getParameter("mem_id");
		//아이디가 널, 비어있으면 회원목록을 리다이렉트
				if(mem_id == null || mem_id.trim().equals("")) {
					return "redirect:/member/memberList.do";
				}
		
		Member member = new Member();
		/*member.setMem_id(request.getParameter("mem_id"));이렇게해도됨.*/
		String mem_pwd = request.getParameter("mem_pwd");
		String mem_name = request.getParameter("mem_name");
		String mem_phone = request.getParameter("mem_phone");
		String mem_email = request.getParameter("mem_email");
		
		
		member.setMem_id(mem_id);
		member.setMem_pwd(mem_pwd);
		member.setMem_name(mem_name);
		member.setMem_phone(mem_phone);
		member.setMem_email(mem_email);
		 System.out.println(member.getMem_id());
		
		int cnt = memberService.registMember(member);
		System.out.println("cnt : "+cnt);
		if(cnt > 0) {
			request.setAttribute("message", "회원등록을 완료했습니다.");
		}else {
			request.setAttribute("message", "회원등록에 실패했습니다.");
		}
		

		
		return viewPage;
	}

}
