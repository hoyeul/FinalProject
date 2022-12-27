<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<header>
	<div class="header_left">
		<div class="material-symbols-outlined navIcon">menu</div>
		<div class="header_lefthomeBtn"><a href="/FinalProject/home">header</a></div>
	</div>
	<div class="header_right">
		<div class="header_right_login">
		<c:choose>
			<c:when test="${sessionID ne null }">
				<div><a href="/FinalProject/logout">로그아웃</a></div>
				<div><a class="header_myPage" href="/FinalProject/mypage.do">마이페이지</a></div>
			</c:when>
			<c:otherwise>
				<div><a href="/FinalProject/login.alreadyLogin">로그인</a></div>
				<div><a href="/FinalProject/register.alreadyLogin">회원가입</a></div>
			</c:otherwise>
		</c:choose>
		</div>
	</div>
</header>



