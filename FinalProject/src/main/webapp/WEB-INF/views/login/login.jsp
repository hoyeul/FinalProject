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
		<input type="text" name="id" placeholder="id" value="${cookie.id.value }">
		<input type="password" name="pw" placeholder="pw">
		<button type="button" id="loginBtn">로그인</button>
		<a href="/Controller/findID">아이디찾기</a>/
		<a href="/Controller/findPW">비밀번호찾기</a>/
		<a href="/Controller/reg">회원가입</a>
	</div>
</section>
</body>
</html>