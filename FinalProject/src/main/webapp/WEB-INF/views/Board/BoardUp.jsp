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
<link rel="stylesheet" href="${path}/resources/css/boardup.css">
</head>
<body>
	<section>
		<form action="/Controller/boardUp" method="post">
			<table>
				<caption>게시판</caption>
					<tr class="board-order">
						<td>번호</td>
						<td>대륙</td>
						<td>종류</td>
						<td>제목</td>
						<td>작성자</td>
						<td>날짜</td>
					</tr>
					<tr class="board-order__item">
						<td>${a.num}</td>
						<td>${a.continent}</td>
						<td>${a.select}</td>
						<td><input type=text value="${a.title}" name="title"></td>
						<td>${a.id}</td>
						<td>${a.date}</td>
					</tr>
					<tr>
						<td  class="enter__btn" colspan="8">
						<textarea name="text"> ${a.text}</textarea>
						</td>
					</tr>
					<tr>
						<td  class="enter__btn" colspan="8">
						<button>수정완료</button>            
						</td>
					</tr>
			</table>
		</form>
	</section>
</body>
</html>