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
	
	//클릭시 border-bottom 색상 변경
	$("input[name='name']").focus(function(){
		$("input[name='name']").css("border-bottom", "1px solid #1089ff");
	});
	$("input[name='name']").blur(function(){
		$("input[name='name']").css("border-bottom", "1px solid rgba(0, 0, 0, 0.1)");
	});
	$("input[name='jumin1']").focus(function(){
		$("input[name='jumin1']").css("border-bottom", "1px solid #1089ff");
	});
	$("input[name='jumin1']").blur(function(){
		$("input[name='jumin1']").css("border-bottom", "1px solid rgba(0, 0, 0, 0.1)");
	});
	$("input[name='jumin2']").focus(function(){
		$("input[name='jumin2']").css("border-bottom", "1px solid #1089ff");
	});
	$("input[name='jumin2']").blur(function(){
		$("input[name='jumin2']").css("border-bottom", "1px solid rgba(0, 0, 0, 0.1)");
	});
	$("input[name='id']").focus(function(){
		$("input[name='id']").css("border-bottom", "1px solid #1089ff");
	});
	$("input[name='id']").blur(function(){
		$("input[name='id']").css("border-bottom", "1px solid rgba(0, 0, 0, 0.1)");
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
			url : "/FinalProject/register/IdCheck",
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