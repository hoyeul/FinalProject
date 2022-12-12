<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/register.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/AddressAPI.js"></script>
<script type="text/javascript">
$(function(){
	//alert("되나?");
	//맞지 않는 입력값 거부
	$("#name").on("keyup", function(){
		$(this).val($(this).val().replace(/[^ㄱ-ㅎ|가-힣|ㅏ-ㅣ]/,""));
	});
	$("input[name='jumin1']").on("keyup", function() {
	    $(this).val($(this).val().replace(/[^0-9]/,""));
	});
	$("input[name='jumin2']").on("keyup", function() {
		$(this).val($(this).val().replace(/[^0-9]/,""));
	});
	$("input[name='id']").on("keyup", function() {
	      $(this).val($(this).val().replace(/[^a-z|A-Z|0-9]/,""));
	});
	$("input[name='phone1']").on("keyup", function() {
		$(this).val($(this).val().replace(/[^0-9]/,""));
	});
	$("input[name='phone2']").on("keyup", function() {
		$(this).val($(this).val().replace(/[^0-9]/,""));
	});
	$("input[name='phone3']").on("keyup", function() {
		$(this).val($(this).val().replace(/[^0-9]/,""));
	});
	$("input[name='email']").on("keyup", function() {
	      $(this).val($(this).val().replace(/[^a-z|A-Z|0-9]/,""));
	});
	$("input[name='domain']").on("keyup", function() {
	      $(this).val($(this).val().replace(/[^a-z|.|]/,""));
	});
	
	//비밀번호 유효성 확인
	$("#pw").blur(function(){
		let userPw = $('#pw').val();
		let reg =  /^(?=.*[A-Za-z])(?=.*\d)[A-Za-z\d]{8,}/;
		if( !reg.test(userPw) ) {
			$("#checkpw").html("비밀번호가 최소 8자, 문자와 숫자를 사용해야 합니다.");
			$("#checkpw").css('color','red');
		}else{
			$("#checkpw").html("사용가능한 비밀번호 입니다.");
			$("#checkpw").css('color','green');
		}
	});
	//비밀번호확인(pwc) 일치여부
	$("#pwc").blur(function(){
		let userPwc = $('#pwc').val();
		let userPw = $('#pw').val();
		if( !(userPwc == userPw)) {
			$("#checkpwc").html("비밀번호 확인이 일치하지 않습니다.");
			$("#checkpwc").css('color','red');
		}else{
			$("#checkpwc").html("비밀번호 확인이 일치합니다.");
			$("#checkpwc").css('color','green');
		}
	});

	//아이디 중복확인
	$('#id').blur(function(){
		//alert("여기")
		let userId = $('#id').val(); // input_id에 입력되는 값
		//alert(userId);
		$.ajax({
			url : "/Controller/register/IdCheck",
			type : "post",
			data : {userId: userId},
			dataType : 'json',
			success : function(result){
				//alert(result);
				if(result == 0){
					//alert("사용할수없음");
					$("#checkId").html('사용할 수 없는 아이디입니다.');
					$("#checkId").css('color','red');
				}else if(result == 1){
					//alert("사용할수있음");
					$("#checkId").html('사용할 수 있는 아이디입니다.');
					$("#checkId").css('color','green');
				}else{}
			},
			error : function(){
				alert("서버요청실패");
			}
		});
		 
	});
	
	//이메일 select
	$("#emailSelect").on("change", function(){
		$("input[name='email2']").val($("#emailSelect").val());
	});
});

function validate(form) {
    // validation code here ...
    var name = document.getElementById('name').value;
    var jumin1 = document.getElementById('jumin1').value;
    var jumin2 = document.getElementById('jumin2').value;
    var id = document.getElementById('id').value;
    var pw = document.getElementById('pw').value;
    var pwc = document.getElementById('pwc').value;
    var user_phone = document.getElementById('user_phone').value;
    var email = document.getElementById('email').value;
    var address = document.getElementById('address').value;
    
    if(name == "") {
        alert('이름을 입력하세요');
        return false;
    }else if(jumin1 == ""){
        alert('주민등록번호를 입력하세요');
        return false;
    }else if(jumin2 == ""){
        alert('주민등록번호를 입력하세요');
        return false;
    }else if(id == ""){
        alert('아이디를 입력하세요');
        return false;
    }else if(pw == ""){
        alert('비밀번호를 입력하세요');
        return false;
    }else if(pwc == ""){
        alert('비밀번호확인을 입력하세요');
        return false;
    }else if(!(pw == pwc)){
        alert('입력한 비밀번호와 비밀번호확인이 일치하지 않습니다.');
        return false;
    }else if(phone1 == ""){
        alert('전화번호를 입력하세요');
        return false;
    }else if(phone2 == ""){
        alert('전화번호를 입력하세요');
        return false;
    }else if(phone3 == ""){
        alert('전화번호를 입력하세요');
        return false;
    }else if(email == ""){
        alert('이메일을 입력하세요');
        return false;
    }else if(address == ""){
        alert('주소를 입력하세요');
        return false;
    }else{
        return confirm('Do you really want to submit the form?');
    }
}
 </script>
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
				<input name="jumin1" class="jumin" id="jumin1" maxlength="6"> 
				<div class="jumin_dash">-</div>
				<input name="jumin2" class="jumin" id="jumin2" maxlength="7" type="password">
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
			</div>
		</div>			
		<div class="info">
			<span class="key">이메일</span><br>
			<div class="email_wrap">
				<input name="email1"  class="email1" id="email">
				<div class="email_at">@</div>
				<input name="email2" class="email2" id="domain">
				<div class="email_space"> </div>
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
				<input type="button" onclick="sample4_execDaumPostcode()" value="우편번호 찾기" class="d_btn">
			</div>
			<div class="postcode_road">
				<input type="text" id="sample4_postcode" class="input d_form mini" placeholder="우편번호">
				<div class="postcode_spacer"></div>
				<input type="text" id="sample4_roadAddress" class="input d_form std" placeholder="도로명주소">
			</div>
			<input type="text" id="sample4_jibunAddress" class="input d_form std dn" placeholder="지번주소">
			<span id="guide" style="color:#999;display:none"></span>
			<input type="text" id="sample4_detailAddress" class="input d_form" placeholder="상세주소">
			<input type="text" id="sample4_extraAddress" class="input d_form dn" placeholder="참고항목">
		</div>						
		<div class="btn_wrap">
			<button type="submit">등록</button>
			<button type="button" onclick="location.href=''">취소</button>
		</div>			
	</form>
	</div>
</section>
</body>
</html>