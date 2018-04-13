package com.study.board.web;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.study.board.service.BoardServiceImpl;
import com.study.board.vo.Board;
import com.study.board.vo.BoardSearch;
import com.study.servlet.IController;

public class BoardListController implements IController {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws ServletException {

		BoardSearch boardSearch = new BoardSearch();
		
		// BeanUtils로 유저빈, 셋프로퍼티처럼 사용가능함
		try {
			BeanUtils.populate(boardSearch, request.getParameterMap());
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	/*	String currentPage = request.getParameter("currentPage");
	 * system.out.println(currentpage);*/
	 
	/*	if(currentPage != null && !currentPage.trim().equals("")) {
			boardSearch.setCurrentPage(Integer.parseInt(currentPage));
		}*/
		
		BoardServiceImpl boardService = new BoardServiceImpl();
		boardSearch.setting(boardService.getBoardCount(boardSearch));
		
		List<Board> list = boardService.getBoardList(boardSearch);
		request.setAttribute("boards", list);
		request.setAttribute("search", boardSearch);
		
		String viewPage =  "/WEB-INF/view/board/boardList.jsp";
		System.out.println(viewPage);
		return viewPage;
	}
	
}
