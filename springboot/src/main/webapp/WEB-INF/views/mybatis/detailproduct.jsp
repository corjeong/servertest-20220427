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
<h1>상품 상세 페이지</h1>
코드 : ${dto.productCode }<br>
이름 : ${dto.productName }<br>
가격 : ${dto.price }<br>
제조회사 : ${dto.company }<br>
재고량 : ${dto.balance }<br>
입고일 : ${dto.regdate }<br>

</body>
</html>