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
		<div class="page-header">
			<h2>회원 등록</h2>
		</div>
		<form action="memberInsert.do" method="post">
			<div class="row">

			<table class="table table-striped">

					<tr>
						<th>ID</th>
						<td>
							<input type="text" name ="mem_id">
						</td>
					</tr>
					<tr>
						<th>PASSWORD</th>
						<td>
							<input type="text" name ="mem_pwd">
						</td>
					</tr>
					<tr>
						<th>이름</th>
						<td><input type="text" name="mem_name"></td>
					</tr>
					<tr>
						<th>전화번호</th>
						<td><input type="text" name="mem_phone"></td>
					</tr>
					<tr>
						<th>이메일</th>
						<td><input type="text" name="mem_email"></td>
					</tr>
			</table>
			</div>
			<div class="row">
					<a class="btn btn-default" href="memberList.do" role="button">취소</a>
					<button type="submit" class="btn btn-default pull-right" role="button">저장</button>
			</div>
		</form>	
	</div>
		
</body>
</html>