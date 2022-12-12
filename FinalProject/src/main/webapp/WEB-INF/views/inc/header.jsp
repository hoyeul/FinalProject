<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<header>
	<div class="header_left">
		<div class="navIcon"></div>
		<div class="header_lefthomeBtn"><a href="/FinalProject/home">header</a></div>
	</div>
	<div class="header_right">
		<div class="header_right_login">
		<c:choose>
			<c:when test="${sessionID ne null }">
				<div><a href="/FinalProject/logout">로그아웃</a></div>
			</c:when>
			<c:otherwise>
				<div><a href="/FinalProject/login">로그인</a></div>
				<div><a href="/FinalProject/register">회원가입</a></div>
			</c:otherwise>
		</c:choose>
		</div>
		<div><div class="myPageIcon"></div></div>
	</div>
</header>



