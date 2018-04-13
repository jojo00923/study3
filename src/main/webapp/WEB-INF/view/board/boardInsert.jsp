<%@page import="com.study.board.service.BoardServiceImpl"%>
<%@page import="com.study.member.service.MemberServiceImpl"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.SQLSyntaxErrorException"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
%>

<!DOCTYPE html>
<html lang="ko">
  <head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
  
	<title>title</title>
	
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

</head>
<body>
<div class="container">

	<div class="row text-center"></div>
		<div class="alert alert-info col-md-4 col-md-offset-4">
			${message }
		</div>
	</div>
	
	<div class="row">
		<div class="col-md-6 col-xs-4">
			<a href="boardList.do">목록으로</a>
			<a href="boardView.do?bo_no=${board.bo_no }">글 보기</a>
		</div>
	</div>
			
	</div><!--컨테이너 종료-->
</body>
</html>



















