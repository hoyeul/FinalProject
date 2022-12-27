$(function(){	
	$("input[name='name']").on("keyup", function() {
      $(this).val($(this).val().replace(/[^ㄱ-ㅎ|가-힣|ㅏ-ㅣ]/g,""));
   });
	
	$("input[name='jumin1']").on("keyup", function() {
      $(this).val($(this).val().replace(/[^0-9]/g,""));
   });
   
   $("input[name='jumin2']").on("keyup", function() {
      $(this).val($(this).val().replace(/[^0-9]/g,""));
   });
	
	$('#mail-Check-Btn').on("click", function() {
		let email = $("input[name='email1']").val() + "@" + $("input[name='email2']").val()
		let checkInput = $(".mail-check-input") // 인증번호 입력하는곳 
		$.ajax({
			type : 'get',
			url : '/FinalProject/mailCheck', 
			data: {email:email},
			success : function (data) {
				alert("인증번호가 발송되었습니다");
				checkInput.attr('disabled',false);
				$('#hiddenInput').prop('value', data);
			},
			error: function(){
				alert("error");
			}
		}); 
	}); 
	
	
	$("#find").on("click",function(){
		let jumin = $("input[name='jumin1']").val() + "-" + $("input[name='jumin2']").val()
		let email = $("input[name='email1']").val() + "@" + $("input[name='email2']").val()
		
		$.ajax({
		    url:'/FinalProject/findID', //request 보낼 서버의 경로
		    type:'post', // 메소드(get, post, put 등)
		    data:{
		    	name: $("input[name='name']").val(),
				jumin: jumin,
				email: email,
		    }, //보낼 데이터
		    dataType: 'text',	//받을 데이터
		    success: function(data) {
		       if($("input[name='name']").val() == ""){
		       		alert("이름을 입력해주세요");
		       		$("input[name='name']").focus();
		       }else if($("input[name='jumin1']").val() == ""){
		       		alert("주민번호를 입력해주세요");
		       		$("input[name='jumin1']").focus();
		       }else if($("input[name='jumin2']").val() == ""){
		       		alert("주민번호를 입력해주세요");
		       		$("input[name='jumin2']").focus();
		       }else if($("input[name='email1']").val() == ""){
		       		alert("이메일을 입력해주세요");
		       		$("input[name='email1']").focus();
		       }else if($("input[name='email2']").val() == ""){
		       		alert("이메일을 입력해주세요");
		       		$("input[name='email2']").focus();
		       }else if($("input[name='mail-check-input']").val() == ""){
		       		alert("인증번호를 입력해주세요");
		       }else if($('#hiddenInput').prop('value') != $('.mail-check-input').val()){
		       		alert("인증번호가 맞지 않습니다");
		       }else{
			       if(data == ""){
			       		alert("정보를 잘못 입력하셨거나 존재하는 아이디가 없습니다");
			       }else{
			       		alert("고객님의 아이디는 " + data + " 입니다");
			       		location.href="/FinalProject/login"
			       }
			   }
		    },
		    error: function(err) {
		        alert("error");
		    }
		});
	});
});