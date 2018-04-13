package com.study.member.web;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.study.member.service.IMemberService;
import com.study.member.service.MemberServiceImpl;
import com.study.member.vo.Member;
import com.study.servlet.IController;

public class MemberDeleteController implements IController {
//
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws ServletException {

		String viewPage = "/WEB-INF/view/member/memberDelete.jsp";
		
		String mem_id = request.getParameter("mem_id");//사용자 브라우저에서 포스트나 겟방식으로.... 
		
		System.out.println("mem_id :"+mem_id);
		
		IMemberService memberService = new MemberServiceImpl();//인스턴스 생성해줌.
		
		Member member = new Member();
		member.setMem_id(mem_id);
		
		try {
			memberService.deleteMember(member);
			request.setAttribute("message", "정상 삭제 ok");
		} catch (Exception e) {
			request.setAttribute("message", e.getMessage());
			e.printStackTrace();
		
		}
		
		
		//아이디가 널, 비어있으면 회원목록을 리다이렉트
		/*if(mem_id == null || mem_id.trim().equals("")) {
			
			return "redirect:/member/memberList.do";
		}
		
		Member member = memberService.getMember(mem_id);
		request.setAttribute("member", member);*/
		
		return viewPage;
	}

}
