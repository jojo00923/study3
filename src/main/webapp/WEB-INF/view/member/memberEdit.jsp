<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>13/ memberList.jsp</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

</head>
<body>
<div class="container">
<div class="page-header">
	<h2>회원 상세정보</h2>
</div>

<form action="memberUpdate.do" method="post">
<div class="row">

<table class="table ">
	<tbody>
		<c:if test="${! empty member}">	
		<tr>
			<th>ID</th>
			<td>
				${member.mem_id}
				<input type="hidden" name="mem_id" value="${member.mem_id}">
			</td>
		</tr>	
		<tr>
			<th>이름</th>
			<td>
				<input type="text" name="mem_name" value="${member.mem_name}">
			</td>
		</tr>	
		<tr>
			<th>연락처</th>
			<td>
				<input type="text" name="mem_phone" value="${member.mem_phone}">
			</td>
		</tr>	
		<tr>
			<th>이메일</th>
			<td>
				<input type="text" name="mem_email" value="${member.mem_email}">
			</td>
		</tr>	
		<tr>
			<th>가입일</th>
			<td>${member.reg_date}</td>
		</tr>									

		</c:if >
		<c:if test="${empty member}">
		<tr>
			<td>해당 회원이 존재하지 않습니다.</td>
		</tr>
		</c:if>
	</tbody>
</table>
</div>

<div class="row">
	<div class="col-md-6 col-xs-4">
		<a href="memberList.do" class="btn btn-sm btn-warning">목록으로</a>
	</div>
	<div class="col-md-6" text-right>
		<button type="submit" class="btn btn-sm btn-primary">저장</button>
	</div>

</div>
</form>


</div>
</body>
</html>













