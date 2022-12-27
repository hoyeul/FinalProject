<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/MemberInfo/register.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/MemberInfo/AddressAPI.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/MemberInfo/register.js"></script>
</head>
<body>
<section>
	<div class="reg_wrap">
	<form action="register" method="post" onsubmit="return validate(this);">
		<div class="info caption">회원가입</div>
		<div class="info">
			<span class="key">이름</span><br>
			<input name="name" class="input" id="name">
		</div>
		<div class="info">
			<span class="key">주민번호</span><br>
			<div class="jumin_wrap">
				<input class="jumin" id="jumin1" maxlength="6"> 
				<div class="jumin_dash">-</div>
				<input class="jumin" id="jumin2" maxlength="7" type="password">
				<input name="jumin" id="jumin" type="hidden">
				
			</div>
		</div>
		<div class="info">
			<span class="key">아이디</span><br>
			<input name="id" class="input" id="id"><br>
			<span id="checkId" class="caution">아이디를 입력하세요</span>
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
				<input name="phone1" class= phone id="phone1" maxlength="3">
				<div class="phone_dash">-</div>
				<input name="phone2" class= phone id="phone2" maxlength="4">
				<div class="phone_dash">-</div>
				<input name="phone3" class= phone id="phone3" maxlength="4">
				<input name="phone" id="phone" type="hidden">
			</div>
		</div>			
		<div class="info">
			<span class="key">이메일</span><br>
			<div class="email_wrap">
				<input class="email1" id="email1">
				<div class="email_at">@</div>
				<input class="email2" id="email2">
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
			<span class="key">인증번호</span><br>
			<div class="certification_wrap">
				<div class="certificationNum">
				<input type="text" name="mail-check-input" class="mail-check-input" disabled="disabled">
				<div id="demo"></div>
				</div>
				<button type="button" id="mail-Check-Btn">인증번호발송</button>
				<input type="hidden" id="hiddenInput" value="">
			</div>
		</div>
		<div class="info">
			<input name="address" class="input"  id="address" type="hidden">
			<div class="add_key_wrap">
				<span class="key add_key">주소</span>
				<div class="add_spacer"></div>
				<input type="button" onclick="execDaumPostcode()" value="우편번호 찾기" class="d_btn">
			</div>
			<div class="postcode_road">
				<input type="text" name="postcode" id="postcode" class="input d_form mini" placeholder="우편번호" readonly="readonly">
				<div class="postcode_spacer"></div>
				<input type="text" name="roadAddress" id="roadAddress" class="input d_form std" placeholder="도로명주소" readonly="readonly">
			</div>
			<input type="text" id="jibunAddress" class="input d_form std dn" placeholder="지번주소">
			<span id="guide" style="color:#999;display:none"></span>
			<input type="text" name="detailAddress" id="detailAddress" class="input d_form" placeholder="상세주소">
			<input type="text" id="extraAddress" class="input d_form dn" placeholder="참고항목">
		</div>						
		<div class="btn_wrap">
			<button type="submit">등록</button>
			<button type="button" onclick="location.href='/home'">취소</button>
		</div>	
		<input name="grade" value="member" type="hidden">		
	</form>
	</div>
</section>
</body>
</html>