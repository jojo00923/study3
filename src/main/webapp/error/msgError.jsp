<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isErrorPage="true" %>     
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
메시지 오류가 발생했습니다.<br>
<hr>
에러타입 : <%=exception.getClass().getName() %> <%-- <%@ page isErrorPage="true" %>일때 이걸 쓸 수있다. read를 사용자가 쓰는데 에러나면 익셉션개체를 여기로 보내는거임. --%>   
에러정보 : <%=exception.getMessage() %>
</body>
</html>