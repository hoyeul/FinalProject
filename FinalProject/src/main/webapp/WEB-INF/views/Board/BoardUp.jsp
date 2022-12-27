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
<script src="${path}/resources/js/Board/boardup.js"></script>
<script type="text/javascript" src="${path}/resources/ckeditor/ckeditor.js"></script>
</head>
<body>
	<section>
		<form name="upfrm" action="/boardUp" method="post">
			<table>
				<caption><a href="/board">게시판</a></caption>
				<tr class="board-order">
					<td>게시판</td>
					<td>종류</td>
					<td>제목</td>
					<td>작성자</td>
					<td>날짜</td>
				</tr>
				<tr class="board-order__item">
		            <td>
		            	<select name="continent">
	                		<option value="">선택하세요</option>
	                		<option value="아시아">아시아</option>
	                		<option value="아프리카">아프리카</option>
	                		<option value="유럽">유럽</option>
	                		<option value="오세아니아">오세아니아</option>
	                		<option value="북아메리카">북아메리카</option>
	                		<option value="남아메리카">남아메리카</option>
                		</select>
		            </td>
		            <td>
		            	<select name="select">
	                		<option value="">선택하세요</option>
	                		<option value="자유">자유</option>
	                		<option value="질문">질문</option>
	                		<option value="후기">후기</option>
	                		<option value="정보">정보</option>
	                	</select>
		            </td>
		            <td><input type=text value="${a.title}" name="title"></td>
					<td>${a.id}</td>
					<td>${a.date}</td>
				</tr>
				<tr>
					<td class="enter__btn" colspan="8">
						<div class="mb-3" style="width: 100%; margin: 0 auto;">
						<label for="exampleFormControlTextarea1" class="form-label"></label>
						 <textarea class="form-control " name="freeboard_content" id="ckeditor" rows="6" contenteditable="true">${a.text }</textarea>
						 </div>
					</td>
				</tr>
				<tr>
					<td class="enter__btn" colspan="8">
					<button type="button" onclick="boardup()">수정완료</button>
					</td>
				</tr>
			</table>
			<input type=number value="${a.num}" name="num" readonly="readonly" style="display:none">
		</form>
	</section>
</body>
</html>