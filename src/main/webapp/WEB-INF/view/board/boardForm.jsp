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

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<link
	href="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.9/summernote.css"
	rel="stylesheet">
<script
	src="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.9/summernote.js"></script>
</head>
<body>
	<div class="container">
		<div class="page-header">
			<h2>회원 등록</h2>
		</div>
		<form action="boardInsert.do" method="post">
			<div class="row">

				<table name="editor1" class="table table-striped">


					<tr>
						<th>제목</th>
						<td><input type="text" name="bo_title"></td>
					</tr>
					<tr>
						<th>작성자</th>
						<td><input type="text" name="bo_writer"></td>
					</tr>
					<tr>
						<th>비번</th>
						<td><input type="password" name="bo_passwd"></td>
					</tr>
					<tr>
						<th>E-MAIL</th>
						<td><input type="text" name="bo_email"></td>
					</tr>
					<tr>
						<th colspan="2">
							<div id="summernote" >
							</div> <script>
								$(document).ready(function() {
									$('#summernote').summernote({
										height: 300
									});
								});
							</script>
						</th>

					</tr>
				</table>

			</div>
			<div class="row">
				<a class="btn btn-default" href="boardList.do" role="button">목록으로</a>
				<button type="submit" class="btn btn-default pull-right"
					role="button">저장</button>
			</div>
		</form>
	</div>

</body>
</html>