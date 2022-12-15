$(function(){
	$("#loginBtn").on("click",function(){
		$.ajax({
		    url:'/FinalProject/login', //request 보낼 서버의 경로
		    type:'post', // 메소드(get, post, put 등)
		    data:{
		    	id: $("input[name='id']").val(),
				pw: $("input[name='pw']").val()
		    }, //보낼 데이터
		    dataType: 'text',	//받을 데이터
		    success: function(data) {
		        if($("input[name='id']").val() == ""){
		        	alert("아이디를 입력하세요");
		        }
		        else if($("input[name='pw']").val() == ""){
		        	alert("비밀번호를 입력하세요");
		        }
		        else{
			        if(data == 0)	alert("비밀번호가 잘못되었습니다");
			        else if(data == -1)	alert("존재하지 않는 아이디입니다.");
			        else	location.href="/FinalProject/home"
		        }
		    },
		    error: function(err) {
		        alert("error");
		    }
		});
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
	
});