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
				<span>UserID</span> <br>
				<input type="text" name="id" placeholder=" 아이디를 입력하시오" value="${cookie.id.value }">
			</div>	
			<div class="pw">
				<span>Password</span> <br>
				<input type="password" name="pw" placeholder=" 비밀번호를 입력하시오">
			</div>
		</div>
		<div class="btn_wrap">
			<input type="button" id="loginBtn" value="로그인">
		</div>
			
		<div class="function_wrap">
				<a href="/FinalProject/register">회원가입</a>
			<br>
			<a class="find" href="/FinalProject/findID">아이디찾기</a> |
			<a class="find" href="/FinalProject/findPW">비밀번호찾기</a>
	
		</div>
		
	</div>
</section>
</body>
</html>