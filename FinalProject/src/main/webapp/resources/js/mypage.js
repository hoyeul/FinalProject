$(function(){
	//이메일 select
	$("#emailSelect").on("change", function(){
		$("input[name='email2']").val($("#emailSelect").val());
	});
	//맞지 않는 입력값 거부
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
	
});
function checkPw(){
	let old_pw = $('#old_pw').val(); // input_id에 입력되는 값
	let id = $('#id').val(); // input_id에 입력되는 값
	$.ajax({
		url : "/FinalProject/mypage/pwCheck",
		type : "post",
		data : {old_pw: old_pw, id: id},
		dataType : 'json',
		success : function(result){
			//alert(result);
			if(result == 0){
				alert('기존비밀번호가 일치하지 않습니다.');
		        return false;
			}else if(result == 1){
				alert('기존비밀번호와 일치합니다 ');
			}else{}
		},
		error : function(){
			alert("서버요청실패");
		}
	});	 
}
function validate(form) {
	
    var pw = document.getElementById('pw').value;
    var pwc = document.getElementById('pwc').value;
    var phone1 = document.getElementById('phone1').value;
    var phone2 = document.getElementById('phone2').value;
    var phone3 = document.getElementById('phone3').value;
	var phoneCheck = phone1 + phone2 + phone3;
	var email1 = document.getElementById('email1').value;
    var email2 = document.getElementById('email2').value;
    var emailCheck = email1 + email2;
	var address = document.getElementById('address').value;

    if(old_pw == "") {
        alert('기본비밀번호를를 입력하세요');
        return false;
    }else if(old_pw != ""){
        checkPw();
    }else if(pw == ""){
        alert('비밀번호를 입력하세요');
        return false;
    }else if(pwc == ""){
        alert('비밀번호확인을 입력하세요');
        return false;
    }else if(pwc != pw){
        alert('비밀번호확인이 일치하지 않습니다 ');
        return false;
    }else if(phoneCheck == ""){
        alert('전화번호를 입력하세요');
        return false;
    }else if(emailCheck == ""){
        alert('이메일을 입력하세요');
        return false;
    }else if(address == ""){
        alert('주소를 입력하세요');
        return false;
    }else{
        return confirm('Do you really want to submit the form?');
    }
}
