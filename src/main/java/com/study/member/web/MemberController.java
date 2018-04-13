package com.study.member.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.study.member.service.IMemberService;
import com.study.member.vo.Member;

@Controller
public class MemberController {

	@Autowired
	private IMemberService memberService;

	@RequestMapping("/member/memberList")
	public String list(HttpServletRequest request) { // 멤버에 멤버리스트라고 요청들어왔으면 요 매퍼에 매핑걸라는것

		List<Member> list = memberService.getMemberList();

		request.setAttribute("list", list);

		return "member/memberList"; // 사용자가 이렇게 인식하면 웹아이엠에프뷰 밑에 멤버 밑에 멤버리스트 밑에 포워딩 하겠다는거다
	}
	
	//요청 : /board/boardView?bo_no=10
	// restful : board/view/10
	
	@RequestMapping("/member/memberView")
	public String view(String mem_id, Model model) {
		//아이디가 널, 비어있으면 회원목록을 리다이렉트
		if(mem_id == null || mem_id.trim().equals("")) {
			return "redirect:/member/memberList";
		}
		Member member = memberService.getMember(mem_id);
		model.addAttribute("member", member);
		
		return "member/memberView";
	}
	
	@RequestMapping("/member/memberEdit")
	public String edit(@RequestParam("mem_id") String mem_id, Model model) {
		
/*		if(StringUtils.isEmpty(mem_id)) {
			
		}*/
		
		//아이디가 널, 비어있으면 회원목록을 리다이렉트
		if(mem_id == null || mem_id.trim().equals("")) {
			return "redirect:/member/memberList";
		}
		Member member = memberService.getMember(mem_id);
		model.addAttribute("member", member);
		
		return "member/memberEdit";
	}
	
	// JSON으로 처리 필요
	@RequestMapping(value="/member/memberUpdate", method=RequestMethod.POST, produces="application/json;charset=utf-8")//사용자가 (어떻게) 요청할때
	@ResponseBody
	public String update(Member member, Model model) throws Exception{ //알아서 패러미터의 세터? MemberUpdateController의 뉴멤버. 멤버세팅까지 다해줌
		int cnt = memberService.modifyMember(member);
		ObjectMapper mapper = new ObjectMapper();
		Map<String, Object> map = new HashMap();
		
		
		if(cnt > 0) {
			map.put("result", true);
			map.put("message", "수정성공");
		}else {
			map.put("result", false);
			map.put("message", "수정실패");
		}
		
		return mapper.writeValueAsString(map);
	}
	
/*	@RequestMapping("/member/memberForm")
	public String form() {
		return "member/memberForm";
	}*/
	
	
	@RequestMapping(value="/member/memberInsert", method=RequestMethod.POST)//사용자가 /member/memberInsert를 요청할때 메서드방식은 무조건 POST여야한다.
	public String insert(Member member, Model model){ //알아서 패러미터의 세터? MemberUpdateController의 뉴멤버. 멤버세팅까지 다해줌
		int cnt = memberService.modifyMember(member);
		if(cnt > 0) {
			model.addAttribute("message", "회원수정을 완료했습니다.");
		}else {
			model.addAttribute("message", "회원수정에 실패했습니다.을 완료했습니다.");
		}
		
		return "member/memberInsert";
	}
	
	
	
}















