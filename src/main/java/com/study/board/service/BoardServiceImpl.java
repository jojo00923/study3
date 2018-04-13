package com.study.board.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.study.board.dao.BoardDaoJDBC;
import com.study.board.dao.BoardDaoMyBatis;
import com.study.board.dao.IBoardDao;
import com.study.board.vo.Board;
import com.study.board.vo.BoardSearch;

public class BoardServiceImpl {
/*new하면 객체의 인스턴스가 돌겠져*/
	private IBoardDao boardDao = new BoardDaoMyBatis(); 
	
	public int getBoardCount(BoardSearch boardSearch) {
		Connection conn = null;
		
		try {
			//conn = DriverManager.getConnection("jdbc:apache:commons:dbcp:Study");
			int cnt = boardDao.getBoardCount(conn, boardSearch); 
			return cnt;
		} catch (SQLException e) {
			throw new RuntimeException("게시판조회 오류", e);
		}finally {
			if(conn != null) try {conn.close();}catch(Exception e){};
		}
	}

	public List<Board> getBoardList(BoardSearch boardSearch) { //맵 받아옴? boardSearch로 바꿈
		Connection conn = null;
		
		try {
			//conn = DriverManager.getConnection("jdbc:apache:commons:dbcp:Study");
			List<Board> list = boardDao.getBoardList(conn, boardSearch); //dao는 커넥션에 맵 줘야되는데 왜 안줘? 오류나서 맵 던져줌.? boardSearch로 바꿈
			return list;
		} catch (SQLException e) {
			throw new RuntimeException("게시판조회 오류", e);
		}finally {
			if(conn != null) try {conn.close();}catch(Exception e){};
		}
	}
	
	

	public Board getBoard(int bo_no) {
		Connection conn = null;
		try {
			/*conn = DriverManager.getConnection("jdbc:apache:commons:dbcp:Study");*/
			Board board = boardDao.getBoard(conn, bo_no);
			return board;
		} catch (SQLException e) {
			throw new RuntimeException("게시판 상세조회 오류", e);
		} finally {
			if(conn != null) try {conn.close();}catch(Exception e){};	
		}
	}

	public int registBoard(Board board) {
		Connection conn = null;
		int cnt=0;
		try {
/*			conn = DriverManager.getConnection("jdbc:apache:commons:dbcp:Study");*/
			cnt = boardDao.insertBoard(conn, board);
			return cnt;
		} catch (SQLException e) {
			throw new RuntimeException("글등록 오류", e);
		}finally {
			if(conn != null) try {conn.close();}catch(Exception e){};			
		}
	
	}
	


	public int modifyBoard(Board board) {
		Connection conn = null;
		int cnt = 0;
		
		try {
			/*conn = DriverManager.getConnection("jdbc:apache:commons:dbcp:Study");*/
			cnt = boardDao.updateBoard(conn, board);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(conn != null) try {conn.close();}catch(Exception e){};			
		}
		return cnt;
	}

}
