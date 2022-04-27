<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="jquery-3.6.0.min.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
	//jquery code
		
	});
</script>
</head>
<body> 
<h1>상품 조회</h1>
<c:forEach items="${list }" var="dto">
<h3>${dto.productCode } <a href="product?code=${dto.productCode }">${dto.productName }</a> ${dto.price }</h3>
</c:forEach>
<div id=detail></div>
</body>
</html>