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

<link rel="stylesheet" href="${path}/resources/css/board.css">

<body>
<section>
	<div class="boardwrap">
		<table class="mainboard">
			<caption><a href="/Controller/board" class="board_title">전체 게시판</a></caption>
	            <tr>
	                <td>번호</td>
	                <td>대륙</td>
	                <td>종류</td>
	                <td>제목</td>
	                <td>작성자</td>
	                <td>날짜</td>
	                <td>조회수</td>
	            </tr>
					<c:forEach var="item" items="${list}">
			        <tr>
			            <td>${item.num}</td>
			            <td>${item.continent}</td>
			            <td>${item.select}</td>
			            <td><a href="boardIn?num=${item.num}&number=${item.number}">${item.title}</a></td>
			            <td>${item.id}</td>
			            <td>${item.date}</td>
			            <td>${item.number}</td>
			        </tr> 
					</c:forEach>
	        	<tr>
		            <td class="" colspan="7">
		               <a href="/FinalProject/boardreg"><button>등록</button></a>
		            </td>
	        	</tr>
			</table>
		</div>
	</section>
</body>
</html>