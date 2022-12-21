<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
$(function(){
	
	$.ajax({
	    url:'https://www.koreaexim.go.kr/site/program/financial/exchangeJSON?authkey=1SbTZQ1Vrt4KIeKvlx5ULicZAHB7tI1U&data=AP01', //request 보낼 서버의 경로
	  
	    dataType: 'json',	//받을 데이터
	    success: function(data) {
	        console.log(data);
	    },
	    error: function(err) {
	        alert("error");
	    }
	});
	
})
</script>
</head>
<body>

</body>
</html>