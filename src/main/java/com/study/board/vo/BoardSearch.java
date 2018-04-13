package com.study.board.vo;

import com.study.common.vo.PagingVO;

public class BoardSearch extends PagingVO {
	
	// 업무화면(검색)의 검색어와 관련된 것 처리...
	private String searchWord = "";
	private String searchType = "";
	
	
	public String getSearchWord() {
		return searchWord;
	}
	public void setSearchWord(String searchWord) {
		this.searchWord = searchWord;
	}
	public String getSearchType() {
		return searchType;
	}
	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}
	
	

}
