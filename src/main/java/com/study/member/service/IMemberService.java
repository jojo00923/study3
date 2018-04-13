package com.study.member.service;

import java.util.List;

import com.study.member.vo.Member;

public interface IMemberService {

	List<Member> getMemberList();

	Member getMember(String mem_id);

	int modifyMember(Member member);

	int registMember(Member member);

	int deleteMember(Member member);

}