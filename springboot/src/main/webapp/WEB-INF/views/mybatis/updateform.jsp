<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="resources/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	
});
</script>
</head>
<body>
<form action="membermybatisupdate" method="post">
아이디 : <input type=text name=id value="${param.id }" readonly="readonly"><br>
이름 : <input type=text name=name><br>
주소 : <input type=text name=address><br>
<input type= submit value="회원 정보 수정">
</form>
</body>
</html>