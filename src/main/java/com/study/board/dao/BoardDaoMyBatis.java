package com.study.board.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.study.board.vo.Board;
import com.study.board.vo.BoardSearch;
import com.study.util.MyBatisFactory;

public class BoardDaoMyBatis implements IBoardDao {

	private String namespace = "com.study.board.dao.IBoardDao.";
	
	//페이징 쿼리 select count로 쓴 거 가져옴. dao에서 query.append("select count " );
	@Override
	public int getBoardCount(Connection conn, BoardSearch boardSearch) throws SQLException {
		SqlSession session = MyBatisFactory.getSqlSession().openSession();
		
		try {
			int cnt = session.selectOne(namespace + "getBoardCount", boardSearch);
			return cnt;
		} finally {
			session.close();
		}
	}

	//목록보기
	@Override
	public List<Board> getBoardList(Connection conn, BoardSearch boardSearch) throws SQLException {
		SqlSession session = MyBatisFactory.getSqlSession().openSession();
		
		try {
			List<Board> list = session.selectList(namespace + "getBoardList", boardSearch);
			return list;
		} finally {
			session.close();
		}
	}

	//상세보기
	@Override
	public Board getBoard(Connection conn, int bo_no) throws SQLException {
		SqlSession session = MyBatisFactory.getSqlSession().openSession(); /*커넥션 실행 맵핑 마무리..*/
		
		try {
			Board board = session.selectOne( namespace + "getBoard", bo_no );
			return board;
			/*return session.selectOne("com.study.member.dao.IMemberDao.getMember",mem_id ); 이렇게 한줄로 해도 됨.*/
		} finally {
			session.close();
		}
		
	}

	@Override
	public int insertBoard(Connection conn, Board board) throws SQLException {
		SqlSession session = MyBatisFactory.getSqlSession().openSession();
			
			try {
				int cnt = session.insert( namespace + "insertBoard", board ); //update든 insert든 select만 아니면 상관 없음.
				session.commit();
				return cnt;
		
			} finally {
				session.close();
			}
		}

	@Override
	public int updateBoard(Connection conn, Board board) throws SQLException {
		SqlSession session = MyBatisFactory.getSqlSession().openSession(); 
			//int cnt = session.update에 update를 쓰든 delete를 쓰든 같음. executeUpdate로 감 다들 select빼고~
			try {
				int cnt = session.update( namespace + "updateBoard", board );
				session.commit();
				return cnt;
		
			} finally {
				session.close();
			}
	}
	
}
