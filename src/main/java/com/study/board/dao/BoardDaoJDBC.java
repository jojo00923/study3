package com.study.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.study.board.vo.Board;
import com.study.board.vo.BoardSearch;

public class BoardDaoJDBC implements IBoardDao {

	@Override
	public int getBoardCount(Connection conn, BoardSearch boardSearch) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		StringBuffer query = new StringBuffer();
		query.append("SELECT count(*) FROM tb_board");
		
		
		
		try {
			pstmt = conn.prepareStatement(query.toString());
			rs = pstmt.executeQuery();
			rs.next();//***
			return rs.getInt(1);//****	
		}finally {
			if(rs != null) try {rs.close();}catch(Exception e){};
			if(pstmt != null) try {pstmt.close();}catch(Exception e){};
		}
	}
	
	
	
	
	
	@Override
	public List<Board> getBoardList(Connection conn, BoardSearch boardSearch) throws SQLException {  //Map썼다가 boardSearch로 바꿈
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		List<Board> list = new ArrayList<>();
		StringBuffer query = new StringBuffer();
		
		query.append("SELECT *            ");
		query.append("FROM  (SELECT rownum rn, a.*    ");
		query.append("			 FROM (                 ");
		
		query.append(" SELECT   ");
		query.append("   		 bo_no ");
		query.append("  		,bo_title ");
		query.append("  		,bo_writer  ");
		query.append("  		,bo_passwd ");
		query.append("  		,bo_email  ");
		/*query.append("  ,bo_content  ");*/ /*clob 타입이라 크기 커서 빼는게 좋음 나머지는 varchar*/
		query.append(" 		 	,bo_ip ");
		query.append("  		,bo_read_cnt ");
		query.append("  		,TO_CHAR(bo_reg_date, 'YYYY/MM/DD') AS bo_reg_date ");
		query.append("  		,TO_CHAR(bo_mod_date, 'YYYY/MM/DD') AS bo_mod_date ");
		query.append("  FROM TB_BOARD ");
		query.append("  ORDER BY bo_no DESC ");
		
		query.append("                 )a ");
		query.append("       )b             ");
		query.append(" WHERE rn between ? and ?    ");
		
		try {
			pstmt = conn.prepareStatement(query.toString());
			pstmt.setInt(1, boardSearch.getStartRow());; //맵으로 값가져왔다가 검색할수있는 boardSearch연결로 바꿈
			pstmt.setInt(2, boardSearch.getEndRow());; //맵으로 값가져왔다가 검색할수있는 boardSearch연결로 바꿈
			//JSP에서 MAP을 만들어서 서비스 통과해서 가져오도록 할거임.
			rs = pstmt.executeQuery();
			Board board = null;
			while (rs.next()) {
				board = new Board();
				board.setBo_no(rs.getInt("bo_no"));
				board.setBo_title(rs.getString("bo_title"));
				board.setBo_writer(rs.getString("bo_writer"));
				board.setBo_passwd(rs.getString("bo_passwd"));
				board.setBo_email(rs.getString("bo_email"));
				/*board.setBo_content(rs.getString("bo_content"));*/
				board.setBo_ip(rs.getString("bo_ip"));
				board.setBo_read_cnt(rs.getInt("bo_read_cnt"));
				board.setBo_reg_date(rs.getString("bo_reg_date"));
				board.setBo_mod_date(rs.getString("bo_mod_date"));
				list.add(board);//리스트에 저장
			}
		return list;	
		}finally {
			if(rs != null) try {rs.close();}catch(Exception e){};
			if(pstmt != null) try {pstmt.close();}catch(Exception e){};
		}
	}
	
	//회원상세 (클릭했을때 뷰랑 연결됨)
	@Override
	public Board getBoard(Connection conn, int bo_no) throws SQLException { 
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		StringBuffer query = new StringBuffer();
		
		query.append(" SELECT            	  ");
		query.append(" 		 bo_no            ");
		query.append(" 		,bo_title         ");
		query.append(" 		,bo_writer        ");
		query.append(" 		,bo_passwd        ");
		query.append(" 		,bo_email         ");
		query.append(" 		,bo_content       ");
		query.append(" 		,bo_ip            ");
		query.append(" 		,bo_read_cnt      ");
		query.append(" 		,TO_CHAR(bo_reg_date) AS bo_reg_date      ");
		query.append(" 		,TO_CHAR(bo_mod_date) AS bo_mod_date      ");
		query.append(" FROM TB_BOARD    	  ");
		query.append(" WHERE bo_no = ?  	  ");
		
		System.out.println(query);
		
		try {
			pstmt = conn.prepareStatement(query.toString());
			pstmt.setInt(1, bo_no);
			
			rs = pstmt.executeQuery();
			
			Board board = null;
			while (rs.next()) {
				board = new Board();
				board.setBo_no(rs.getInt("bo_no"));
				board.setBo_title(rs.getString("bo_title"));
				board.setBo_writer(rs.getString("bo_writer"));
				board.setBo_passwd(rs.getString("bo_passwd"));
				board.setBo_email(rs.getString("bo_email"));
				board.setBo_content(rs.getString("bo_content"));
				board.setBo_ip(rs.getString("bo_ip"));
				board.setBo_read_cnt(rs.getInt("bo_read_cnt"));
				board.setBo_reg_date(rs.getString("bo_reg_date"));
				board.setBo_mod_date(rs.getString("bo_mod_date"));
			}
			
			return board;
		} finally {
			if(rs != null) try {rs.close();}catch(Exception e){};
			if(pstmt != null) try {pstmt.close();}catch(Exception e){};
		}
	}
	//회원등록
	@Override
	public int insertBoard(Connection conn, Board board) throws SQLException {
		
		PreparedStatement pstmt = null;
		StringBuffer query = new StringBuffer(); 
		
		query.append(" INSERT INTO TB_BOARD ( ");
		query.append("        bo_no      ");
		query.append("      , bo_title      ");
		query.append("      , bo_writer    ");
		query.append("      , bo_passwd     ");
		query.append("      , bo_email     ");
		query.append("      , bo_content   ");
		query.append("      , bo_ip   ");
		query.append("      , bo_read_cnt   ");
		query.append("      , bo_reg_date   ");
		query.append("      , bo_mod_date   ");
		query.append(" 			)         ");
		query.append(" values 	(         ");
		query.append(" 		seq_board.nextval		  ");
		query.append(" 			,?		  ");
		query.append(" 			,?		  ");
		query.append(" 			,?		  ");
		query.append(" 			,?		  ");
		query.append(" 			,?		  ");
		query.append(" 			,?		  ");
		query.append(" 			,0		  ");
		query.append(" 			,sysdate		  ");
		query.append(" 			,sysdate		  ");
		query.append(" 			)		  ");
		
		System.out.println(query);
		
		int id = 1;
		
		try {
			pstmt = conn.prepareStatement(query.toString());
			pstmt.setString(id++, board.getBo_title());
			pstmt.setString(id++, board.getBo_writer());
			pstmt.setString(id++, board.getBo_passwd());
			pstmt.setString(id++, board.getBo_email());
			pstmt.setString(id++, board.getBo_content());
			pstmt.setString(id++, board.getBo_ip());

			int cnt = pstmt.executeUpdate();
			return cnt;
		} finally {
			if(pstmt != null) try {pstmt.close();}catch(Exception e){};
		}
	}	
	
	//회원수정
	@Override
	public int updateBoard(Connection conn, Board board) throws SQLException {
		
		PreparedStatement pstmt = null;
		StringBuffer query = new StringBuffer();
		
		query.append(" update tb_board         ");
		query.append("    set                  ");
		query.append("        bo_title = ?        ");
		query.append("       ,bo_writer = ?         ");
		query.append("       ,bo_content = ?         ");
		query.append("       ,bo_mod_date = sysdate  ");
		query.append("  where bo_no = ?  ");
		
		System.out.println(query);
		
		int id=1;
		
		try {
			
			pstmt=conn.prepareStatement(query.toString());
			pstmt.setString(id++, board.getBo_title());
			pstmt.setString(id++, board.getBo_writer());
			pstmt.setString(id++, board.getBo_content());
			pstmt.setInt(id++, board.getBo_no());
			
			int cnt = pstmt.executeUpdate();
			return cnt;
			
		} finally {
			if(pstmt != null) try {pstmt.close();}catch(Exception e){};			
		}
	}
	
	//
}
