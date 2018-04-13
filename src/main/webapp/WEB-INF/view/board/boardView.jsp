<%@page import="com.study.board.vo.Board"%>
<%@page import="com.study.board.service.BoardServiceImpl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%
	request.setCharacterEncoding("UTF-8");
%>

<!DOCTYPE html>
<html lang="ko">
  <head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>타이틀을 입력하세요.</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script> 

</head>
<body>
	<div class="container">
		<div class="page-header">
			<h2>게시글 상세정보</h2>
		</div>
		<%
		String bo_no = request.getParameter("bo_no");
		//파라미터가 널이거나, 비어있거나, 숫자가 아니면 ??
		if(bo_no == null || bo_no.trim().equals("")){
			response.sendRedirect("boardList.jsp");
			return;
		}
		BoardServiceImpl boardService = new BoardServiceImpl();
		Board board = boardService.getBoard(Integer.parseInt(bo_no));
		
		request.setAttribute("board", board);
		%>
		<div class="row">
			<table class="table table-condensed">
				<colgroup>
					<col width="10%">
					<col width="auto">
					<col width="10%">
					<col width="20%">
					<col width="10%">
					<col width="10%">
				</colgroup>
				<tbody>
				<c:if test="${empty board}">
					<tr>
						<th colspan="6">해당 게시물이 없습니다</th>
					</tr>			
				</c:if>
				<c:if test="${! empty board}">
					<tr class="active">
						<td colspan="6" style="font-size: 3em; text-indent:30px ">${board.bo_title}</td>
					<tr>
					<tr class="active">
						<th>작성자</th>
						<th>${board.bo_writer}</th>
						<th>작성일</th>
						<th>${board.bo_reg_date}</th>
						<th>조회수</th>
						<th>${board.bo_read_cnt}</th>
					</tr>
					<tr>
						<th style="height:300px;" colspan="6">${board.bo_content}</th>
					</tr>
				
				</c:if>
				</tbody>
			</table>
		</div>
		
		<div class="row">
				<a class="btn btn-default" href="boardList.jsp" role="button">목록으로</a>
				<a class="btn btn-default pull-right" href="boardEdit.jsp?bo_no=${board.bo_no}" role="button">수정</a>
		</div>
	</div>
</body>
</html>