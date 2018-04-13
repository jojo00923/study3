package com.study.member.service;
//비즈니스 영역, 여러개의 프로세스 (insert, update ....)를 처리할 수 있는 곳. 트랜잭션은 서비스객체에서 묶이는 것이다.
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.member.dao.IMemberDao;
import com.study.member.vo.Member;

@Service("memberService")
public class MemberServiceImpl implements IMemberService {
	
	@Autowired
	private IMemberDao memberDao ; //new MemberDaoJDBC();
	
	@Override
	public List<Member> getMemberList() {
			
			List<Member> list = memberDao.getMemberList();
			return list;
		
	}
	
	@Override
	public Member getMember(String mem_id) {
	
			Member member = memberDao.getMember(mem_id);
			return member;
		
		
	}

	@Override
	public int modifyMember(Member member) {
	
			int cnt = memberDao.updateMember(member);
			return cnt;
	
	}
	
	@Override
	public int registMember(Member member) {
		
			int cnt = memberDao.insertMember(member);
		
		return cnt;
	}
	
	@Override
	public int deleteMember(Member member) {
	
			int cnt = memberDao.deleteMember(member);
			return cnt;
	
	}
	
}








