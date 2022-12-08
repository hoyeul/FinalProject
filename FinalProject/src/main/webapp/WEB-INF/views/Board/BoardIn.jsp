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
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="${path}/resources/js/boardin.js"></script>
<link rel="stylesheet" href="${path}/resources/css/boardin.css">
</head>
<body>
	<section>
	 	<table>
			<caption>${a.continent}</caption>
				 <tr class="board-order">
				    <td>번호</td>
				    <td>대륙</td>
				    <td>종류</td>
				    <td>제목</td>
				    <td>작성자</td>
				    <td>날짜</td>
				    <td>조회</td>
				</tr>
				<tr class="board-order__item">
					<td>${a.num}</td>
					<td>${a.continent}</td>
					<td>${a.select}</td>
					<td>${a.title}</td>
					<td>${a.id}</td>
					<td>${a.date}</td>
					<td>${a.number}</td>
				</tr>
			    <tr>
				    <td  class="enter__btn" colspan="8">
				       <textarea name="content" readonly="readonly"> ${a.text}</textarea>
				    </td>
			    </tr>
				<tr>
				    <td class="enter__btn" colspan="8">
				        <a href="boardUp?num=${a.num}"><button>수정</button></a>
						<a href="boardDE?num=${a.num}"><button>삭제</button></a>
				    </td>
				</tr>
		</table>
		<table class="CMTable">
			<c:forEach var="list" items="${list}">
				<tr class="comment">
					<td><textarea id="text" class="text" readonly="readonly">${list.text}</textarea></td>
					<td>${list.name}</td>
					<td>${list.date}</td>
				</tr>
				<tr class="comment2">
					<td> 
						<button id="button1" class="button1" type="button" >수정</button>
						<button id="button2" class="button2" type="button" value="${list.num}" onclick="click1()">삭제</button>
						<button id="button3" class="button3" type="button" value="${list.num}" style="display:none">수정완료</button>
						<button id="button4" class="button4" type="button" style="display:none">취소</button>
					</td>
				</tr> 
			</c:forEach>
	      </table>
<div id="result"> 
</div>
		<table>
			<tr>
				<td><textarea class="CMreg"></textarea></td>
				<td><button class="button5" type="button" value="${a.num}">등록</button></td>
			</tr>
			<tr>
				<td>
					<button type="button" onclick="window.location.href='/Controller/board'">목록으로</button>
				</td>
			</tr>
		</table>
	</section>
</body>
</html>