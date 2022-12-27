<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.ArrayList" %>
<c:set var="path" value="${pageContext.request.contextPath }"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${path}/resources/css/Board/boardup.css">
<script type="text/javascript" src="${path}/resources/ckeditor/ckeditor.js"></script>
<script src="${path}/resources/js/Board/boardup.js"></script>
</head>
<body>
<section>
<div class="boardup-wrap">
<c:set var="loginGrade" value="${sessionGrade}"></c:set>
	<form name="upfrm" action="/boardUp" method="post">
	<div class="boardup-inner-wrap">
		<div class="boardup-title-area">게시글 수정</div>
			<div class="boardup-selectConSel-area">
				<span class="con-sel">게시판</span>
               	<select id="continent" name="continent">
               		<option value="">선택하세요</option>
               		<option value="전체">전체</option>
               		<option value="아시아">아시아</option>
               		<option value="아프리카">아프리카</option>
               		<option value="유럽">유럽</option>
               		<option value="오세아니아">오세아니아</option>
               		<option value="북아메리카">북아메리카</option>
               		<option value="남아메리카">남아메리카</option>
               	</select>
               	<span class="sel-sel">말머리</span>
				<c:choose>
               	<c:when test="${loginGrade eq 'admin'}">
					<select id="select" name="select">
	               		<option value="">선택하세요</option>
	               		<option value="공지">공지</option>
	               		<option value="자유">자유</option>
	               		<option value="질문">질문</option>
	               		<option value="후기">후기</option>
	               		<option value="정보">정보</option>
	               	</select>
	            </c:when>
	            <c:otherwise>
	            	<select id="select" name="select">
	               		<option value="">선택하세요</option>
	               		<option value="자유">자유</option>
	               		<option value="질문">질문</option>
	               		<option value="후기">후기</option>
	               		<option value="정보">정보</option>
	               	</select>
	            </c:otherwise>
              	</c:choose>
			</div>
			<div class="boardup-titlearea">
	            <input type=text value="${a.title}" name="title" class="up-title">
			</div>
			<div class="boardup-textarea">
				<div class="mb-3" style="width: 100%; margin: 0 auto;">
                  <label for="exampleFormControlTextarea1" class="form-label"></label>
                 <textarea class="form-control " name="freeboard_content" id="ckeditor" rows="6" contenteditable="true">${a.text}</textarea>
                </div>
			</div>
			<div class="boardup-btn">
				<button type="button" onclick="window.location.href='/board'">목록으로</button>
				<button type="button" onclick="boardup()">수정완료</button>
			</div>
		<input type=number value="${a.num}" name="num" readonly="readonly" style="display:none">
		</div>
	</form>
<input type="hidden" value="${sessionGrade}" id="user_grade"/>
</div>
</section>
</body>
</html>