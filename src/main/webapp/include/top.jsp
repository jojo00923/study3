<!--include와 연동되는 파일  -->
<%@page import="com.study.member.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>아라사이트</h1>
	<a href="<%=request.getContextPath()%>/index.jsp">Home</a>
	<a href="<%=request.getContextPath()%>/member/memberList.do">회원관리</a>
	<a href="<%=request.getContextPath()%>/board/boardList.do">게시판</a>
	<%
		Member mem = (Member) session.getAttribute("LOGIN");
		if (mem != null) {
	%>
	<!-- 로그인 상태인 경우 -->
	<%=mem.getMem_name()%>님 방가~~
	<a href="<%=request.getContextPath()%>/12/logout.jsp">로그아웃</a>
	<!--top을 여기뿐 아니라 다른곳에서도 쓰니깐 절대경로로 쓰는게좋음  -->
	<%
		} else {
	%>
	<!-- 비로그인 상태인 경우 -->
	<a href="<%=request.getContextPath()%>/12/Login.jsp">로그인</a>
	<%
		}
	%>


</body>
</html>
<!-- request요청하는 사람에 대한 정보를 가져올수있음 사용자의 아이디아이피 등 -->
<!-- response내가 넘겨줄때 -->
<!-- application 영역으로 말했을때는 공동으로 사용하는 저장장소 단 30분정도만 사용가능  -->
<!-- 객체 영역 -->