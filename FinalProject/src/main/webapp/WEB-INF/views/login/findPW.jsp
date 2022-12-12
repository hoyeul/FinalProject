<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="path" value="${pageContext.request.contextPath }"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${path}/resources/css/findPW.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="${path}/resources/js/findPW.js"></script>
</head>
<body>
<section>
	<div class="findPwWrap">
	<div class="caption">비밀번호 찾기</div>
	<div class="infoWrap">
		<div class="userId">
			<span>아이디</span><br/>
			<input type="text" name="id">
		</div>
		<div class="name">
			<span>이름</span><br/>
			<input type="text" name="name">
		</div>
		<div class="jumin">
			<span>주민등록번호</span><br/>
			<input type="text" name="jumin1" maxlength="6">
			<div class="juminDash">-</div>
			<input type="password" name="jumin2" maxlength="7">
		</div>
		<div class="email">
			<span>이메일</span><br/>
			<input type="text" name="email1">
			<div class="emailAt">@</div>
			<input type="text" name="email2">
		</div>
	</div>
	<div class="btn_wrap">
		<button type="button" id="find">비밀번호 찾기</button>
		<div><a href="/FinalProject/home">홈으로</a></div>
	</div>
	</div>
</section>
</body>
</html>