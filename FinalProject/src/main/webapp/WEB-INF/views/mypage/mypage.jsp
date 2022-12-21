<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/mypage.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/AddressAPI.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/mypage.js"></script>
</head>
<body>
<section>
	<div class="reg_wrap">
	<form action="mypage" method="post" onsubmit="return validate(this);">
		<div class="info caption">회원정보 수정</div>
		<div class="info">
			<span class="key">이름</span><br>
			<input name="name" class="input" id="name" value="${registerDto.name}" readonly="readonly">
		</div>
		<div class="info">
			<span class="key">아이디</span><br>
			<input name="id" class="input" id="id" value="${registerDto.id}" readonly="readonly"><br>
		</div>
		<div class="info">
			<span class="key">기존비밀번호</span><br>
			<input name="old_pw" class="input" id="old_pw" type="password" ><br>
			<span id="checkOldPw" class="caution">기존비밀번호를 입력하세요</span>
		</div>
		<div class="info">
			<span class="key">비밀번호</span><br>
			<input name="pw" class="input" id="pw" type="password" ><br>
			<span id="checkpw" class="caution">비밀번호를 입력하세요</span>
		</div>
		<div class="info">
			<span class="key">비밀번호확인</span><br>
			<input name="pwc" class="input" id="pwc" type="password"><br>
			<span id="checkpwc" class="caution">비밀번호확인을 입력하세요</span>
		</div>
		<div class="info">
			<span class="key">전화번호</span><br>
			
			<div class="phone_wrap">
				<input name="phone1" class= phone id="phone1" maxlength="3" value="${fn:split(registerDto.phone,'-')[0]}">
				<div class="phone_dash">-</div>
				<input name="phone2" class= phone id="phone2" maxlength="4" value="${fn:split(registerDto.phone,'-')[1]}">
				<div class="phone_dash">-</div>
				<input name="phone3" class= phone id="phone3" maxlength="4" value="${fn:split(registerDto.phone,'-')[2]}">
				<input name="phone" id="phone" type="hidden">
			</div>
		</div>		
		<div class="info">
			<span class="key">이메일</span><br>
			<div class="email_wrap">
				<input class="email1" id="email1" value="${fn:split(registerDto.email,'@')[0]}">
				<div class="email_at">@</div>
				<input class="email2" id="email2" value="${fn:split(registerDto.email,'@')[1]}">
				<div class="email_space"> </div>
				<input name="email" id="email" type="hidden">
				
			<select id="emailSelect" class="email_select"> 
					<option value="">선택</option>
					<option value="naver.com">naver.com</option>
					<option value="google.com">google.com</option>
					<option value="">직접입력</option>
			</select>
			</div>
		</div>	
		<div class="info">
			<input name="address" class="input"  id="address" type="hidden">
			<div class="add_key_wrap">
				<span class="key add_key">주소</span>
				<div class="add_spacer"></div>
				<input type="button" onclick="execDaumPostcode()" value="우편번호 찾기" class="d_btn" >
			</div>
			<div class="postcode_road">
				<input name="postcode" type="text" id="postcode" class="input d_form mini" placeholder="우편번호" value="${registerDto.postcode}" readonly="readonly">
				<div class="postcode_spacer"></div>
				<input name="roadAddress" type="text" id="roadAddress" class="input d_form std" placeholder="도로명주소" value="${registerDto.roadAddress}" readonly="readonly">
			</div>
			<input type="text" id="jibunAddress" class="input d_form std dn" placeholder="지번주소">
			<span id="guide" style="color:#999;display:none"></span>
			<input name="detailAddress" type="text" id="detailAddress" class="input d_form" placeholder="상세주소" value="${registerDto.detailAddress}">
			<input type="text" id="extraAddress" class="input d_form dn" placeholder="참고항목">
		</div>																
		<div class="btn_wrap">
			<button>수정</button>
			<button type="button" onclick="location.href=''">취소</button>
		</div>			
	</form>
	<form action="mypage/withdraw" method="post">
		<button>회원탈퇴</button>
	</form>
	
	</div>
</section>
</body>
</html>