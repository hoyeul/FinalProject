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
	$("input[name='email1']").on("keyup", function() {
	      $(this).val($(this).val().replace(/[^a-z|A-Z|0-9]/,""));
	});
	$("input[name='email2']").on("keyup", function() {
	      $(this).val($(this).val().replace(/[^a-z|.|]/,""));
	});
	
	//비밀번호 유효성 확인
	$("#pw").blur(function(){
		let pw = $('#pw').val();
		let reg =  /^(?=.*[A-Za-z])(?=.*\d)[A-Za-z\d]{8,}/;
		if( !reg.test(pw) ) {
			$("#checkpw").html("비밀번호가 최소 8자, 문자와 숫자를 사용해야 합니다.");
			$("#checkpw").css('color','red');
		}else{
			$("#checkpw").html("사용가능한 비밀번호 입니다.");
			$("#checkpw").css('color','green');
		}
	});
	//비밀번호확인(pwc) 일치여부
	$("#pwc").blur(function(){
		let pwc = $('#pwc').val();
		let pw = $('#pw').val();
		if( !(pwc == pw)) {
			$("#checkpwc").html("비밀번호 확인이 일치하지 않습니다.");
			$("#checkpwc").css('color','red');
		}else{
			$("#checkpwc").html("비밀번호 확인이 일치합니다.");
			$("#checkpwc").css('color','green');
		}
	});
	
	//이메일 select
	$("#emailSelect").on("change", function(){
		$("input[name='email2']").val($("#emailSelect").val());
	});
});

function validate(form) {
	alert("hi");
    // validation code here ...
    var old_pw = document.getElementById('old_pw').value;
    var pw = document.getElementById('pw').value;
    var pwc = document.getElementById('pwc').value;
    var phone1 = document.getElementById('phone1').value;
    var phone2 = document.getElementById('phone2').value;
    var phone3 = document.getElementById('phone3').value;
    var email1 = document.getElementById('email1').value;
    var email2 = document.getElementById('email2').value;
    var address = document.getElementById('address').value;
    let pwc = $('#pwc').val();
	let pw = $('#pw').val();
	let pw = $('#pw').val();
	let reg =  /^(?=.*[A-Za-z])(?=.*\d)[A-Za-z\d]{8,}/;
		
    
    if(old_pw == ""){
        alert('기존비밀번호를 입력하세요');
        return false;
    }else if(old_pwc != old_pw){
        alert('기존비밀번호가 일치하지 않습니다');
        return false;
    }else if(pw == ""){
        alert('비밀번호를 입력하세요');
        return false;
    }else if(pwc == ""){
        alert('비밀번호확인을 입력하세요');
        return false;
    }else if(pw != pwc){
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
    }else if(email1 == ""){
        alert('이메일을 입력하세요');
        return false;
    }else if(email2 == ""){
        alert('이메일의 도메인을 입력하세요');
        return false;
    }else if(address == ""){
        alert('주소를 입력하세요');
        return false;
    }else if( !(pwc == pw)) {
		$("#checkpwc").html("비밀번호 확인이 일치하지 않습니다.");
		$("#checkpwc").css('color','red');
	}else if( !reg.test(pw) ) {
		$("#checkpw").html("비밀번호가 최소 8자, 문자와 숫자를 사용해야 합니다.");
		$("#checkpw").css('color','red');
	}	
	else{
        return confirm('Do you really want to submit the form?');
    }
}

