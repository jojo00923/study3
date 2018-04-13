package com.study.member.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.study.member.vo.Member;

// @Repository 또는 @Mapper를 등록하면 됨
@Mapper
public interface IMemberDao {

	// 회원목록
	List<Member> getMemberList();

	// 회원상세
	Member getMember(String mem_id);

	// 회원등록
	int insertMember(Member member);

	// 회원수정
	int updateMember(Member member);

	// 회원삭제
	int deleteMember(Member member);

}