<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="path" value="${pageContext.request.contextPath }"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${path }/resources/css/findID.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="${path}/resources/js/findID.js"></script>
</head>
<body>
<section>
<table>
	<caption>아이디 찾기</caption>
	<tr>
		<td>이름</td>
		<td><input type="text" name="nm"></td>
	</tr>
	<tr>
		<td>주민등록번호</td>
		<td>
			<input type="text" name="jumin1" maxlength="6">-
			<input type="password" name="jumin2" maxlength="7">
		</td>
	</tr>
	<tr>
		<td>이메일</td>
		<td>
			<input type="text" name="email1"> @ <input type="text" name="email2">
			<select id="emailSelect">
				<option value="">선택</option>
				<option value="naver.com">naver.com</option>
				<option value="google.com">google.com</option>
				<option value="">직접입력</option>
			</select>
		</td>
	</tr>
	<tr>
		<td colspan="2">
			<button type="button" id="find">아이디 찾기</button>
			<button type="button" onclick="window.location.href='/Controller/login'">이전화면으로</button>
		</td>
	</tr>
</table>
</section>
</body>
</html>