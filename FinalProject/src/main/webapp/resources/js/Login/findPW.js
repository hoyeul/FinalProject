var x;

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
		let email = $("input[name='email1']").val() + "@" + $("input[name='email2']").val();
		if($("input[name='id']").val() != "" && $("input[name='name']").val() != "" && $("input[name='jumin1']").val() != "" && $("input[name='jumin2']").val() != "" && $("input[name='email1']").val() != "" && $("input[name='email2']").val() != ""){
			var time = 180;
			var min = "";
			var sec = "";
			
			let checkInput = $(".mail-check-input") // 인증번호 입력하는곳 
			$.ajax({
				type : 'post',
				url : '/mailCheck', 
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
   
   
   
	$("#find").on("click",function(){
		let jumin = $("input[name='jumin1']").val() + "-" + $("input[name='jumin2']").val();
		let email = $("input[name='email1']").val() + "@" + $("input[name='email2']").val();
		
		$.ajax({
		    url:'/findPW', //request 보낼 서버의 경로
		    type:'post', // 메소드(get, post, put 등)
		    data:{
		    	id: $("input[name='id']").val(),
		    	name: $("input[name='name']").val(),
				jumin: jumin,
				email: email,
		    }, //보낼 데이터
		    dataType: 'text',	//받을 데이터
		    success: function(data) {
		        if($("input[name='id']").val() == ""){
		       		alert("아이디를 입력해주세요");
		       		$("input[name='id']").focus();
		       }else if($("input[name='name']").val() == ""){
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
		       }else{
		       		if(document.getElementById("demo").innerHTML == ""){
		       			alert("인증번호 유효시간이 만료되었습니다");
		       		}
		       		else if($('#hiddenInput').prop('value') != $('.mail-check-input').val()){
			       		alert("인증번호가 맞지 않습니다");
			        }else{
				       if(data == ""){
				       		alert("정보를 잘못 입력하셨거나 존재하는 아이디가 없습니다");
				       }else{
				       		alert("고객님의 아이디는 " + data + " 입니다");
				       		location.href="/login.alreadyLogin"
				       }
				    }
				}
		    },
		    error: function(err) {
		        alert("error");
		    }
		});
	});
});
