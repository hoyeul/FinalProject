<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="path" value="${pageContext.request.contextPath }"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${path }/resources/css/Login/findID.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="${path}/resources/js/Login/findID.js"></script>
</head>
<body>
<section>
	<div class="findIDWrap">
	<div class="caption">아이디 찾기</div>
	<div class="infoWrap">
		<div class="name">
			<span>이름</span><br/>
			<input type="text" name="name">
		</div>
		<div class="jumin">
			<span>주민등록번호</span><br>
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
		<div class="checkNum">
			<span>인증번호</span><br/>
			<div class="certificationNum">
				<input type="text" name="mail-check-input" class="mail-check-input" disabled="disabled">
				<div id="demo"></div>
			</div>
			<button type="button" id="mail-Check-Btn">인증번호발송</button>
			<input type="hidden" id="hiddenInput" value="">
		</div>
	</div>
	<div class="btn_wrap">
		<button type="button" id="find">아이디 찾기</button>
	</div>
	</div>
</section>
</body>
</html>