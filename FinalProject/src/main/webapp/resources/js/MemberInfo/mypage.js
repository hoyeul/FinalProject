$(function(){
//기존 전화번호 이메일주소 병합
	let phone1 = $('#phone1').val();
	let phone2 = $('#phone2').val();
	let phone3 = $('#phone3').val();
	phone = phone1 + "-" + phone2 + "-" + phone3;
	$('#phone').val(phone);
	let email1 = $('#email1').val();
	let email2 = $('#email2').val();
	email = email1 + "@" + email2;
	$('#email').val(email);

//입력값 유효성 확인
	$("input[name='phone1']").on("keyup", function() {
		$(this).val($(this).val().replace(/[^0-9]/,""));
	});
	$("input[name='phone2']").on("keyup", function() {
		$(this).val($(this).val().replace(/[^0-9]/,""));
	});
	$("input[name='phone3']").on("keyup", function() {
		$(this).val($(this).val().replace(/[^0-9]/,""));
	});
	$("input[name='email1']").on("keyup", function() {
	      $(this).val($(this).val().replace(/[^a-z|A-Z|0-9]/,""));
	});
	$("input[name='email2']").on("keyup", function() {
	      $(this).val($(this).val().replace(/[^a-z|.|]/,""));
	});
//클릭시 border-bottom 색상 변경
	$("input[name='old_pw']").focus(function(){
		$("input[name='old_pw']").css("border-bottom", "1px solid #1089ff");
	});
	$("input[name='old_pw']").blur(function(){
		$("input[name='old_pw']").css("border-bottom", "1px solid rgba(0, 0, 0, 0.1)");
	});
	$("input[name='pw']").focus(function(){
		$("input[name='pw']").css("border-bottom", "1px solid #1089ff");
	});
	$("input[name='pw']").blur(function(){
		$("input[name='pw']").css("border-bottom", "1px solid rgba(0, 0, 0, 0.1)");
	});
	$("input[name='pwc']").focus(function(){
		$("input[name='pwc']").css("border-bottom", "1px solid #1089ff");
	});
	$("input[name='pwc']").blur(function(){
		$("input[name='pwc']").css("border-bottom", "1px solid rgba(0, 0, 0, 0.1)");
	});
	$("input[name='phone1']").focus(function(){
		$("input[name='phone1']").css("border-bottom", "1px solid #1089ff");
	});
	$("input[name='phone1']").blur(function(){
		$("input[name='phone1']").css("border-bottom", "1px solid rgba(0, 0, 0, 0.1)");
	});
	$("input[name='phone2']").focus(function(){
		$("input[name='phone2']").css("border-bottom", "1px solid #1089ff");
	});
	$("input[name='phone2']").blur(function(){
		$("input[name='phone2']").css("border-bottom", "1px solid rgba(0, 0, 0, 0.1)");
	});
	$("input[name='phone3']").focus(function(){
		$("input[name='phone3']").css("border-bottom", "1px solid #1089ff");
	});
	$("input[name='phone3']").blur(function(){
		$("input[name='phone3']").css("border-bottom", "1px solid rgba(0, 0, 0, 0.1)");
	});
	$("input[name='email1']").focus(function(){
		$("input[name='email1']").css("border-bottom", "1px solid #1089ff");
	});
	$("input[name='email1']").blur(function(){
		$("input[name='email1']").css("border-bottom", "1px solid rgba(0, 0, 0, 0.1)");
	});
	$("input[name='email2']").focus(function(){
		$("input[name='email2']").css("border-bottom", "1px solid #1089ff");
	});
	$("input[name='email2']").blur(function(){
		$("input[name='email2']").css("border-bottom", "1px solid rgba(0, 0, 0, 0.1)");
	});
	$("input[name='extraAddress']").focus(function(){
		$("input[name='extraAddress']").css("border-bottom", "1px solid #1089ff");
	});
	$("input[name='extraAddress']").blur(function(){
		$("input[name='extraAddress']").css("border-bottom", "1px solid rgba(0, 0, 0, 0.1)");
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
		if( userPwc != userPw) {
			$("#checkpwc").html("비밀번호 확인이 일치하지 않습니다.");
			$("#checkpwc").css('color','red');
		}else{
			$("#checkpwc").html("비밀번호 확인이 일치합니다.");
			$("#checkpwc").css('color','green');
		}
	});
//기존비밀번호 확인
	$("#old_pw").blur(function(){
	let old_pw2 = $('#old_pw').val();
	let id = $('#id').val();
	$.ajax({
		url : "/mypage/pwCheck",
		type : "post",
		data : {old_pw: old_pw2, id: id},
		dataType : 'json',
		success : function(result){
			//alert(result);
			if(result == 0){
    			$("#checkOldPw").html("기존비밀번호가 일치하지 않습니다.");
				$("#checkOldPw").css('color','red');
			}else if(result == 1){
				$("#checkOldPw").html("기존비밀번호와 일치합니다.");
				$("#checkOldPw").css('color','green');
			}else{}
		},
		error : function(){
			alert('서버요청실패');
		}
	});	 
//이메일 select
	$("#emailSelect").on("change", function(){
		$("input[name='email2']").val($("#emailSelect").val());
	});

//전화번호 병합
	$("#phone1, #phone2, #phone3").blur(function(){
		let phone1 = $('#phone1').val();
		let phone2 = $('#phone2').val();
		let phone3 = $('#phone3').val();
		phone = phone1 + "-" + phone2 + "-" + phone3;
		$('#phone').val(phone);

	});
//이메일주소,도메인 병합
	$("#email1, #email2, #emailSelect").blur(function(){
		let email1 = $('#email1').val();
		let email2 = $('#email2').val();
		email = email1 + "@" + email2;
		$('#email').val(email);
	});
});
});

function validate(form) {
	//alert("validation");
    var old_pw = document.getElementById('old_pw').value;	
    var pw = document.getElementById('pw').value;
    var pwc = document.getElementById('pwc').value;
    var phone1 = document.getElementById('phone1').value;
    var phone2 = document.getElementById('phone2').value;
    var phone3 = document.getElementById('phone3').value;
	var email1 = document.getElementById('email1').value;
    var email2 = document.getElementById('email2').value;
	var postcode = document.getElementById('postcode').value;
	var roadAddress = document.getElementById('roadAddress').value;
	var detailAddress = document.getElementById('detailAddress').value;

    if(old_pw == "") {
        alert('기존비밀번호를를 입력하세요');
        return false;
    }else if(pw == ""){
        alert('비밀번호를 입력하세요');
        return false;
    }else if(pwc == ""){
        alert('비밀번호확인을 입력하세요');
        return false;
    }else if(pwc != pw){
        alert('비밀번호확인이 일치하지 않습니다 ');
        return false;
    }else if(phone1 == ""||phone2 == ""||phone3 == ""){
        alert('전화번호를 입력하세요');
        return false;
    }else if(email1 == ""||email2 == ""){
        alert('이메일을 입력하세요');
        return false;
    }else if(postcode == "" || roadAddress == "" || detailAddress == ""){
        alert('주소를 입력하세요');
        return false;
    }else{
        return confirm('이 정보로 회원정보를 수정하시겠습니까?');
    }
}
