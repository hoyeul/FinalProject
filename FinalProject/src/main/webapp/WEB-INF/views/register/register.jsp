<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/register.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript">
$(function(){
	//alert("되나?");
	//맞지 않는 입력값 거부
	$("#user_nm").on("keyup", function(){
		$(this).val($(this).val().replace(/[^ㄱ-ㅎ|가-힣|ㅏ-ㅣ]/,""));
	});
	$("input[name='jumin1']").on("keyup", function() {
	    $(this).val($(this).val().replace(/[^0-9]/,""));
	});
	$("input[name='jumin2']").on("keyup", function() {
		$(this).val($(this).val().replace(/[^0-9]/,""));
	});
	$("input[name='user_id']").on("keyup", function() {
	      $(this).val($(this).val().replace(/[^a-z|A-Z|0-9]/,""));
	});
	$("input[name='user_phone1']").on("keyup", function() {
		$(this).val($(this).val().replace(/[^0-9]/,""));
	});
	$("input[name='user_phone2']").on("keyup", function() {
		$(this).val($(this).val().replace(/[^0-9]/,""));
	});
	$("input[name='user_phone3']").on("keyup", function() {
		$(this).val($(this).val().replace(/[^0-9]/,""));
	});
	$("input[name='user_email']").on("keyup", function() {
	      $(this).val($(this).val().replace(/[^a-z|A-Z|0-9]/,""));
	});
	$("input[name='user_domain']").on("keyup", function() {
	      $(this).val($(this).val().replace(/[^a-z|.|]/,""));
	});
	
	//비밀번호 유효성 확인
	$("#user_pw").blur(function(){
		let userPw = $('#user_pw').val();
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
	$("#user_pwc").blur(function(){
		let userPwc = $('#user_pwc').val();
		let userPw = $('#user_pw').val();
		if( !(userPwc == userPw)) {
			$("#checkpwc").html("비밀번호 확인이 일치하지 않습니다.");
			$("#checkpwc").css('color','red');
		}else{
			$("#checkpwc").html("비밀번호 확인이 일치합니다.");
			$("#checkpwc").css('color','green');
		}
	});

	//아이디 중복확인
	$('#user_id').blur(function(){
		//alert("여기")
		let userId = $('#user_id').val(); // input_id에 입력되는 값
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
    var user_nm = document.getElementById('user_nm').value;
    var user_id = document.getElementById('user_id').value;
    var user_pw = document.getElementById('user_pw').value;
    var user_pwc = document.getElementById('user_pwc').value;
    var user_phone = document.getElementById('user_phone').value;
    var user_email = document.getElementById('user_email').value;
    var user_address = document.getElementById('user_address').value;
    var user_regnum = document.getElementById('user_regnum').value;
    
    if(user_nm == "") {
        alert('이름을 입력하세요');
        return false;
    }else if(user_regnum == ""){
        alert('주민등록번호를 입력하세요');
        return false;
    }else if(user_id == ""){
        alert('아이디를 입력하세요');
        return false;
    }else if(!form.id.readOnly){
		alert("아이디 중복 검사를 진행해주세요.");
		return;
	}else if(user_pw == ""){
        alert('비밀번호를 입력하세요');
        return false;
    }else if(user_pwc == ""){
        alert('비밀번호확인을 입력하세요');
        return false;
    }else if(!(user_pw == user_pwc)){
        alert('입력한 비밀번호와 비밀번호확인이 일치하지 않습니다.');
        return false;
    }else if(user_phone == ""){
        alert('전화번호를 입력하세요');
        return false;
    }else if(user_email == ""){
        alert('이메일을 입력하세요');
        return false;
    }else if(user_address == ""){
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
			<input name="name" class="input" id="user_nm">
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
			<input name="id" class="input" id="user_id"><br>
			<span id="checkId" class="caution">아이디를 입력하세요</span>
		</div>
		<div class="info">
			<span class="key">비밀번호</span><br>
			<input name="pw" class="input" id="user_pw" type="password" ><br>
			<span id="checkpw" class="caution">비밀번호를 입력하세요</span>
		</div>
		<div class="info">
			<span class="key">비밀번호확인</span><br>
			<input name="pwc" class="input" id="user_pwc" type="password"><br>
			<span id="checkpwc" class="caution">비밀번호확인을 입력하세요</span>
		</div>
		<div class="info">
			<span class="key">전화번호</span><br>
			<div class="phone_wrap">
				<input name="phone1" class= phone id="user_phone1" maxlength="3">
				<div class="phone_dash">-</div>
				<input name="phone2" class= phone id="user_phone2" maxlength="4">
				<div class="phone_dash">-</div>
				<input name="phone3" class= phone id="user_phone3" maxlength="4">
			</div>
		</div>			
		<div class="info">
			<span class="key">이메일</span><br>
			<div class="email_wrap">
				<input name="email1"  class="email1" id="user_email">
				<div class="email_at">@</div>
				<input name="email2" class="email2" id="user_domain">
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
			<span class="key">주소</span><br>
			<input name="address" class="input"  id="user_address">
		</div>					
		<div class="btn_wrap">
			<button>등록</button>
			<button type="button" onclick="location.href=''">취소</button>
		</div>			
	</form>
	</div>
</section>
</body>
</html>