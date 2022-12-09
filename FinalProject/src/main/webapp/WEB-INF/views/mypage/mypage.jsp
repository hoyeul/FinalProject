<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/register.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="<c:url value="/resources/js/mypage.js" />"></script>


</head>
<body>
<section>
	<div class="reg_wrap">
	<form action="#" method="post" onsubmit="return validate(this);">
		<div class="info caption">회원정보 수정</div>
		<div class="info">
			<span class="key">이름</span><br>
			<input name="name" class="input" id="name" value="${registerDto.getName()}" readonly="readonly">
		</div>
		<div class="info">
			<span class="key">아이디</span><br>
			<input name="id" class="input" id="id" value="${registerDto.getId()}" readonly="readonly"><br>
		</div>
		<div class="info">
			<span class="key">기존비밀번호</span><br>
			<input name="pw" class="input" id="old_pw" type="password" ><br>
			<input type="hidden" id="old_pwc" value="${registerDto.getPw()}">
		</div>
		<div class="info">
			<span class="key">비밀번호</span><br>
			<input name="pw" class="input" id="pw" type="password" ><br>
			<span id="checkpw" class="caution">비밀번호를 입력하세요</span>
		</div>
		<div class="info">
			<span class="key">비밀번호확인</span><br>
			<input name="pwc" class="input" id="pwc" type="password"><br>
			<span id="checkpwc" class="caution">비밀번호확인을 입력하세요</span>
		</div>
		<div class="info">
			<span class="key">전화번호</span><br>
			<div class="phone_wrap">
				<input name="phone1" class= phone id="phone1" maxlength="3">
				<div class="phone_dash">-</div>
				<input name="phone2" class= phone id="phone2" maxlength="4">
				<div class="phone_dash">-</div>
				<input name="phone3" class= phone id="phone3" maxlength="4">
			</div>
		</div>			
		<div class="info">
			<span class="key">이메일</span><br>
			<div class="email_wrap">
				<input name="email1"  class="email1" id="email1">
				<div class="email_at">@</div>
				<input name="email2" class="email2" id="email2">
				<div class="email_space"> </div>
			<select id="emailSelect" class="email_select"> 
					<option value="">선택</option>
					<option value="naver.com">naver.com</option>
					<option value="google.com">google.com</option>
					<option value="">직접입력</option>
			</select>
			</div>
		</div>			
		<div class="info">
			<span class="key">주소</span><br>
			<input name="address" class="input"  id="address">
		</div>					
		<div class="btn_wrap">
			<button>등록</button>
			<button type="button" onclick="location.href=''">취소</button>
		</div>			
	</form>
	</div>
</section>
</body>
</html>