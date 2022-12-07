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
	<table>
		<caption>문의 게시판</caption>
            <tr class="board-order">
                <td>번호</td>
                <td>대륙</td>
                <td>종류</td>
                <td>제목</td>
                <td>작성자</td>
                <td>날짜</td>
                <td>조회수</td>
            </tr>
<c:forEach var="item" items="${list}">
        <tr class="board-order__item">
            <td><a href="">${item.num}</a></td>
            <td>${item.continent}</td>
            <td>${item.select}</td>
            <td>${item.title}</td>
            <td>${item.id}</td>
            <td>${item.date}</td>
            <td>${item.number}</td>
        </tr> 
</c:forEach>
        <tr >
            <td class="enter__btn" colspan="7">
               <a href="/Controller/boardreg"><button>등록</button></a>
            </td>
        </tr>
	</table>
	</section>
</body>
</html>