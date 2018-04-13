package com.study.board.web;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.study.board.service.BoardServiceImpl;
import com.study.board.vo.Board;
import com.study.servlet.IController;

public class BoardInsertController implements IController {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws ServletException {

		//<jsp:useBean id="board" class="com.study.board.vo.Board"></jsp:useBean> <!-- 파라미터 이름과 세터가 같으면 자동입력되게하는것. request.getParameter 대신 사용. -->
		//<jsp:setProperty property="*" name="board"/>
		Board board = new Board();
		
		try {
			BeanUtils.populate(board, request.getParameterMap());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		board.setBo_ip(request.getRemoteAddr());/*작성자 제목 패스워드 이메일 내용 아이피 6개가 남겨서 레지스트 보드로간다.  */
		BoardServiceImpl boardService = new BoardServiceImpl();
		int cnt = boardService.registBoard(board);

		if(cnt > 0) {
			request.setAttribute("message", "성공");
		}else {
			request.setAttribute("message", "실패");
		}
		
		request.setAttribute("board", board); //글 번호 때문에 담은거얌~
		return "/WEB-INF/view/board/boardInsert.jsp";
	}
	
}
