<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.ArrayList" %>
<c:set var="path" value="${pageContext.request.contextPath }"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" href="${path}/resources/css/boardreg.css">
<script src="${path}/resources/js/boardreg.js"></script>

<body>
	<section>
	<div class="boardreg-wrap">
	<form name="regfrm" action="/FinalProject/boardreg" method="post">
		<div class="boardreg-inner-wrap">
			<div class="boardreg-titlereg-area">게시글 등록</div>
				<div class="boardreg-selectConSel-area">
					<span class="con-sel">게시판</span>
                	<select id="continent" name="continent">
                		<option value="">선택하세요</option>
                		<option value="아시아">아시아</option>
                		<option value="아프리카">아프리카</option>
                		<option value="유럽">유럽</option>
                		<option value="오세아니아">오세아니아</option>
                		<option value="북아메리카">북아메리카</option>
                		<option value="남아메리카">남아메리카</option>
                	</select>
	               	<span class="sel-sel">말머리</span>
					<select id="select" name="select">
                		<option value="">선택하세요</option>
                		<option value="자유">자유</option>
                		<option value="질문">질문</option>
                		<option value="후기">후기</option>
                		<option value="정보">정보</option>
                	</select>
				</div>
				<div class="boardreg-titlearea">
					<input type="text" class="reg_title" name="title" placeholder="제목을 입력해 주세요.">
				</div>
				<div class="boardreg-textarea">
					<textarea name="text" class="reg_textarea" contenteditable="true" placeholder="내용을 입력해 주세요."></textarea>
				</div>
				<div class="boardreg-btn">
					<button type="button" onclick="window.location.href='/FinalProject/board'">목록으로</button>
					<button type="button" onclick="boardreg()">등록</button>
				</div>
			</div>
		</form>
	</div>
	</section>
</body>
</html>