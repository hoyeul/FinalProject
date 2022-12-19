<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="path" value="${pageContext.request.contextPath }"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="${path}/resources/js/login.js"></script>
<link rel="stylesheet" href="${path}/resources/css/login.css">
</head>
<body>
<section>
	<div class="loginForm">
		<div class="caption_wrap">로그인</div>
		<div class="pwid_wrap">
			<div class="id">
				<span>아이디</span> <br>
				<input type="text" name="id" value="${cookie.id.value }">
			</div>	
			<div class="pw">
				<span>비밀번호</span> <br>
				<input type="password" name="pw">
			</div>
		</div>
		
		<div class="cookie_id">
			<input name="ckbox" type="checkbox"> <span style="font-size: 12px;">아이디 기억하기</span>
		</div>
		
		<div class="btn_wrap">
			<input type="button" id="loginBtn" value="로그인">
		</div>
			
		<div class="function_wrap">
			<a href="/FinalProject/register">회원가입</a> <span>|</span>
			<a href="/FinalProject/findID">아이디찾기</a> <span>|</span>
			<a href="/FinalProject/findPW">비밀번호찾기</a>
		</div>
	</div>
</section>
</body>
</html>