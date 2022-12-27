var x;

$(function(){
	$('#mail-Check-Btn').on("click", function() {
		let email = $("#email").val();
		if($("input[name='name']").val() != "" && $("jumin1").val() != "" && $("jumin2").val() != "" && $("email1").val() != "" && $("email2").val() != ""){
			var time = 180;
			var min = "";
			var sec = "";
			
			
			
			
			let checkInput = $(".mail-check-input") // 인증번호 입력하는곳 
			$.ajax({
				type : 'get',
				url : '/FinalProject/mailCheck', 
				data: {email:email},
				success : function (data) {
					checkInput.attr('disabled',false);
					$('#hiddenInput').prop('value', data);
					
					clearInterval(x);
					x = setInterval(function(){
						min = parseInt(time/60);
						sec = time%60;
						
						if(min < 1)		min = "0";
						if(sec < 10)	sec = "0" + time%60;
						
						document.getElementById("demo").innerHTML = "0" + min + ":" + sec;
						time--;
						
						if(time < 0){
							clearInterval(x);
							document.getElementById("demo").innerHTML = "";
						}
					}, 1000);
					alert("인증번호가 발송되었습니다");
					clearTimeout(setTimeout(() => $('#hiddenInput').prop('value', ""), 180000));
					setTimeout(() => $('#hiddenInput').prop('value', ""), 180000);
				},
				error: function(){
					alert("error");
				}
			}); 
		}else	{alert("정보를 입력해주세요");}
	}); 
	
//입력값 유효성 확인
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
		let userId = $('#id').val(); // input_id에 입력되는 값
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
		$("#email2").val($("#emailSelect").val());
	});	
//주민번호 병합
	$("#jumin1, #jumin2").blur(function(){
		let jumin1 = $('#jumin1').val();
		let jumin2 = $('#jumin2').val();
		jumin = jumin1 + "-" + jumin2;
		$('#jumin').val(jumin);
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

//Submit 전 유효성 확인
function validate(form) {
    // validation code here ...
    var name = document.getElementById('name').value;
    var jumin1 = document.getElementById('jumin1').value;
    var jumin2 = document.getElementById('jumin2').value;
    var id = document.getElementById('id').value;
    var pw = document.getElementById('pw').value;
    var pwc = document.getElementById('pwc').value;
    var user_phone = document.getElementById('user_phone').value;
    var email1 = document.getElementById('email1').value;
    var email2 = document.getElementById('email2').value;
    var postcode = document.getElementById('postcode').value;
	var roadAddress = document.getElementById('roadAddress').value;
	var detailAddress = document.getElementById('detailAddress').value;
if(name == "") {
        alert('이름을 입력하세요');
        return false;
    }else if(jumin1 == ""||jumin2 == ""){
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
        return confirm('Do you really want to submit the form?');
    }

}