<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<nav id="nav">
	<div class="nav_menu_wrap">
		<div class="nav_home">
			<a href="/FinalProject/home" class="nav_a">
				<i class="material-symbols-outlined">home</i>
				<span>메인화면</span>
			</a>
		</div>
		
		<div class="nav_information">
			<a class="nav_information_a">
				<i class="material-symbols-outlined">info</i>
				<span>여행정보</span>
				<i class="material-symbols-outlined chevron_right">chevron_right</i>
			</a>
		</div>
		<div class="nav_information_menu">
			<div class="nav_information_menu_div">
				<a href="/FinalProject/navy" class="nav_information_menu_a">단계별 여행경보</a>
				<a href="/FinalProject/currencyrate" class="nav_information_menu_a">환율정보</a>
				<a class="nav_information_menu_a">선택3</a>
			</div>
		</div>
		
		<div class="nav_board">
			<a class="nav_board_a">
				<i class="material-symbols-outlined">chat</i>
				<span>게시판</span>
				<i class="material-symbols-outlined chevron_right">chevron_right</i>
			</a>
		</div>
		<div class="nav_board_menu">
			<div class="nav_board_menu_div">
				<a class="nav_board_menu_a" href="/FinalProject/board">전체 게시판</a>
				<a class="nav_board_menu_a" href="/FinalProject/chatting_main">채팅방</a>
			</div>
		</div>
		
		<div class="nav_cusInfo">
			<a class="nav_cusInfo_a">
				<i class="material-symbols-outlined">person_search</i>
				<span>회원정보</span>
				<i class="material-symbols-outlined chevron_right">chevron_right</i>
			</a>
		</div>
		<div class="nav_cusInfo_menu">
			<div class="nav_cusInfo_menu_div">
				<c:choose>
					<c:when test="${sessionID ne null }">
						<a href="/FinalProject/mypage" class="nav_cusInfo_menu_a">회원정보수정</a>
					</c:when>
					<c:otherwise>
						<a href="/FinalProject/findID" class="nav_cusInfo_menu_a">아이디찾기</a>
						<a href="/FinalProject/findPW" class="nav_cusInfo_menu_a">비밀번호찾기</a>
					</c:otherwise>
				</c:choose>
			</div>
		</div>
	</div>
	
	<div class="nav_footer">
		<div class="footer_userInfo">
			<c:choose>
				<c:when test="${sessionID ne null }">
				<i class="material-symbols-outlined">face</i>
				<span>${sessionID }</span>
			</c:when>
			<c:otherwise>
				<span style="font-size: 14px">로그인이 필요합니다.</span>
			</c:otherwise>
			</c:choose>
		</div>
	</div>
</nav>