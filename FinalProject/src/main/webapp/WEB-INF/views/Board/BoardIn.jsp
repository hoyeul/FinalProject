<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.ArrayList" %>
<c:set var="path" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="${path}/resources/js/Board/boardin.js"></script>
<link rel="stylesheet" href="${path}/resources/css/Board/boardin.css">
</head>
<body>
	<section>
		<div class="board-in-all-wrap">
			<div class="board-in-continent-title">
				<a href="/FinalProject/board?continent=아시아">${b.continent} 게시판</a>
			</div>
			<hr class="under-continent-title">
			<div class="board-in-title">
				<span>[${b.select}] ${b.title}</span>
				<span>${b.id}</span>
				<span> | </span>
				<span>${b.date}</span>
				<span>조회수 ${b.number}</span>
			</div>
			<div class="board-in-textarea">
			    <textarea name="content" readonly="readonly">${b.text}</textarea>
			</div>
			<div class="recommend-btn-area">
				<div class="rec-btn-inner-area">
					<button class="recommend-btn">
						<img class="recommend-img" alt="" src="<c:url value="resources/image/rec-up.png"/>">
						<span class="rec-text">추천</span>
					</button>
					<button class="recommend-btn">
						<img class="recommend-img" alt="" src="<c:url value="resources/image/rec-down.png"/>">
						<span class="rec-text">비추천</span>
					</button>
				</div>
			</div>
			<div class="update-nav">
				<div class="update-nav-goList">
			    	<a href="/FinalProject/board"><button>목록으로</button></a>
			    </div>
			    <div class="update-nav-update-btn">
			    	<a href="boardDE?num=${b.num}"><button>삭제</button></a>
				    <a href="boardUp?num=${b.num}"><button>수정</button></a>
				</div>
			</div>
			<div id="board-in-comment-box"></div>
			<div class="comment-edit-area">
				<textarea class="comment-textarea"></textarea>
				<button class="comment-edit-btn" type="button" value="${b.num}">등록</button>
			</div>
			<div class="comment-edit-nav">
				<button type="button" onclick="window.location.href='/FinalProject/board'">목록으로</button>
				<a href="/FinalProject/boardreg.do"><button>글쓰기</button></a>		
			</div>
		</div>
	</section>
</head>
</body>
</html>