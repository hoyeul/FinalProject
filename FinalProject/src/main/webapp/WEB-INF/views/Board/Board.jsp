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
<script src="${path}/resources/js/board.js"></script>
<link rel="stylesheet" href="${path}/resources/css/board.css">

<body>
<section>
	<div class="boardwrap">
		<div class="board_head">
			<a href="/Controller/board">전체 게시판</a>	
		</div>
			<div class="board_nav">
				<div class="board_all"><a href="" class="first_a">인기</a></div>
				<div class="tb_nav">
					<a href="" style="color: red">전체</a>
					<a href="" style="color: orange">아시아</a>
					<a href="" style="color: #ffdb2a">아프리카</a>
					<a href="" style="color: green">유럽</a>
					<a href="" style="color: blue">오세아니아</a>
					<a href="" style="color: darkblue">북아메리카</a>
					<a href="" style="color: purple">남아메리카</a>
				</div>
			</div>
				<table class="mainboard">
			            <tr>
			                <td style="width:10%;"></td>
			                <td style="width:60%;">제목</td>
			                <td>작성자</td>
			                <td>날짜</td>
			                <td>조회수</td>
			            </tr>
							<c:forEach var="item" items="${list}">
					        <tr>
					            <td>${item.num}</td>
					            <td style=" text-align: left;">
						            <span class="b_con">[${item.continent}] </span>
						            <span class="b_sel">[${item.select}] </span>
						            <a href="boardIn?num=${item.num}&number=${item.number}">${item.title}</a>
					            </td>
					            <td>${item.id}</td>
					            <td style="">${item.date}</td>
					            <td>${item.number}</td>
					        </tr> 
							</c:forEach>
					</table>
				<div class="reg_btn">
					<a href="/Controller/boardreg"><button>글쓰기</button></a>
				</div>
			</div>
	</section>
</body>
</html>