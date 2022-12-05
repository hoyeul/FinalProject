<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/register.css">
<script type="text/javascript">
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
<script src = "js/jquery-3.6.0.min.js"></script>
<script>
	$('.user_id').focusout(function(){
		let userId = $('.user_id').val(); // input_id에 입력되는 값
		
		$.ajax({
			url : "IdCheckService",
			type : "post",
			data : {user_id: user_id},
			dataType : 'json',
			success : function(result){
				if(result == 0){
					$("#checkId").html('사용할 수 없는 아이디입니다.');
					$("#checkId").attr('color','red');
				} else{
					$("#checkId").html('사용할 수 있는 아이디입니다.');
					$("#checkId").attr('color','green');
				} 
			},
			error : function(){
				alert("서버요청실패");
			}
		})
		 
	})
 </script>

</head>
<body>
<section>
	<form action="customer/reg" method="post" onsubmit="return validate(this);">
		<table>
			<caption>회원가입</caption>
				<tr>
					<td>이름</td>
					<td>
						<input name="user_nm" id="user_nm">
						
					</td>
				</tr>
				<tr>
					<td>주민번호</td>
					<td><input name="user_regnum" id="user_regnum"></td>
				</tr>
				<tr>
					<td>아이디</td>
					<td>
						<input name="user_id" id="user_id">
						<input name="checkId"type="button">
					</td>
					
				</tr>
				<tr>
					<td>비밀번호</td>
					<td><input name="user_pw" id="user_pw"></td>
				</tr>
				<tr>
					<td>비밀번호확인</td>
					<td><input name="user_pwc" id="user_pwc"></td>
				</tr>
				<tr>
					<td>전화번호</td>
					<td><input name="user_phone" id="user_phone"></td>
				</tr>
				<tr>
					<td>이메일</td>
					<td><input name="user_email"  id="user_email"></td>
				</tr>
				<tr>
					<td>주소</td>
					<td><input name="user_address"  id="user_address"></td>
				</tr>
				<tr>
					<td>
						<button>등록</button>
						<button type="button" onclick="location.href=''">취소</button>
					</td>
				</tr>
		</table>
	</form>
</section>
</body>
</html>