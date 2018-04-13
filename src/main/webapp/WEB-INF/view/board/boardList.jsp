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
<div class="container" id="board"> <!-- 전체 감싸는 div  -->
<div class="page-header">
	<h1>게시판 목록</h1>
</div>

<script type="text/javascript">

$(function(){

	$(".pagination li a", $("#board")).click(function(){ /* 전체감싸는 div 이용해서 어쩌구~ */
		//페이지 값 구하고
		//form에 설정하고
		//form submit
		/* alert($(this).data("page")); */ //132째줄 데이터페이지의 값을 알럿으로 보여준다
		var frm = document.forms.frm_search; //폼을 frm에 객체로 넣어준다
		frm.currentPage.value = $(this).data("page"); //현재클릭한 것의 값을 찾아서 폼태그안에있는 currentPage의 값으로 넣어준다확인 누르면 값 바뀌게
		frm.submit(); // pagination 파랗게 활성화 됨(액티브)
	});
	
	$('select[name="listSize"]', $("#board")).change(function() {
		//jquery select box 제어하는 법
		//구하고, form에 설정하고 , form submit
		console.log(this.value, $(this).val());
		var frm = document.forms.frm_search;
		frm.listSize.value = $(this).val();
		frm.submit();
	});
	
	
	//삼항연산자 쓰기 싫다??
/* 	var init=function(){
		alert("페이지가 로드하고나서 스크립트로 처리~");
		#('[name="currentPage"]').val(${search.currentPage});
		#('[name="listSize"]').val(${search.listSize});
	}		
	init(); */
});

</script>

<div class="row">
<!-- 검색폼. //BoardSearch.java에 searchType,searchWord라고 정의했었음. -->
<form name="frm_search" action="boardList.do" method="post" class="form-inline">
	<input type="hidden" name="currentPage" value="${search.currentPage}" />
	<input type="hidden" name="listSize" value="${search.listSize}" />
	

	<div class="form-group">
	검색구분 : <select name="searchType"  class="form-control"> <!-- name은 vo에서 만든 이름과 같아야함 -->
							<option value="all" ${search.searchType eq 'all' ? 'selected = "selected"' : '' }  >전체</option>
							<option value="bo_title" ${search.searchType eq 'bo_title' ? 'selected = "selected"' : '' }>제목</option>
							<option value="bo_writer" ${search.searchType eq 'bo_writer' ? 'selected = "selected"' : '' }>작성자</option>
							<option value="bo_content" ${search.searchType eq 'bo_content' ? 'selected = "selected"' : '' }>내용</option>
						</select>
	</div>
	<div class="form-group">
	<input type="text"	name="searchWord" value="${search.searchWord}"  class="form-control">
	</div>
	<button type="submit"  class="form-control">검색</button>					
	<!-- submit 누르면 서비스 갈거고, 컨트롤러타서 다오로 갈거임 -->
</form>
</div>


<div class="row">
	<div class="col-md-6 col-md-offset-8 text-right">
		<a href="boardForm.do" class="btn btn-sm btn-primary">글등록</a>
	</div>
</div>
	
<%-- <c:set var="list" value="<%=list %>" scope="request" /> --%>
<div class="row form-inline" >
<!-- pasing부여에 total rowcount도 있죠 -->
전체 게시물 : ${search.totalRowCount} / 페이지 수 :${search.totalPageCount}
<select name="listSize" class="form-control listSize" >
	<option value="5" ${search.listSize eq '5' ? 'selected = "selected"' : '' } >5</option>
	<option value="10" ${search.listSize eq '10' ? 'selected = "selected"' : '' }>10</option>
	<option value="20" ${search.listSize eq '20' ? 'selected = "selected"' : '' }>20</option>
	<option value="30" ${search.listSize eq '30' ? 'selected = "selected"' : '' }>30</option>
</select>

<table class="table table-striped">
	<colgroup>
		<col style="width: 8%;" />
		<col  />	
		<col style="width: 15%" />	
		<col style="width: 10%" />	
		<col style="width: 15%" />	
	</colgroup>	
		<thead>

			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>조회수</th>
				<th>등록일</th>
			</tr>
		</thead>
		<tbody>
		
		
		<c:if test="${empty boards}">
			<tr>
				<td colspan="5">목록이 조회되지 않았습니다.</td>
			</tr>	
		</c:if>
		<c:if test="${not empty boards}">
			<c:forEach var="boards" items="${boards}" varStatus="st">
			
				<tr>
					<td>${boards.bo_no}</td> <!-- 현재 몇번 반복하고 있는지 알고싶을 때 ${st.count}쓰면됨.-->
					<td><a href="boardView.do?bo_no=${boards.bo_no}">
						${boards.bo_title}
					</a></td>
					<td>${boards.bo_writer}</td>
					<td>${boards.bo_read_cnt}</td>
					<td>${boards.bo_reg_date}</td>
				</tr>		
			</c:forEach>
		</c:if>
	</tbody>
</table>
</div>
<div class="row text-center">
	<div>
		<ul style="list-style: none" class="pagination">
		    <c:if test="${search.startPage > 1}">
		    <li><a href="#" data-page="${search.startPage - 1 }">
		        <span aria-hidden="true">&laquo;</span>
		      </a>
		    </li>
		    </c:if>
			<c:forEach var="i" begin="${search.startPage}" end="${search.endPage}">
				<c:if test="${i eq search.currentPage}">
					<li class="active"><a href="#">${i}</a></li>
				</c:if>	
				<c:if test="${i ne search.currentPage}">
		      		<li><a  href="#" data-page="${i}">${i}</a></li>
				</c:if>	
			</c:forEach>
			<c:if test="${search.endPage < search.totalPageCount }">
			    <li><a href="#" data-page="${search.endPage + 1 }">
			        <span aria-hidden="true">&raquo;</span>
			      </a>
			    </li>			
		    </c:if>		
		</ul>
	</div>
</div>



</div>  
  </body>
</html>