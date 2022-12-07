<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<style>
* {
    padding: 0px;
    margin: 0px;
}

table, td {
    border: none;
    /*border: 1px solid black;*/
    text-align: center;
    border-collapse: collapse;
}
table{
width: 800px;
margin: 0px auto;
border-bottom: 3px solid  #ef3e61;
}

caption{
    padding: 15px;
    font-size: 24px;
    font-weight: 800;
}

a {
	text-decoration: none;
	color: black;
}
/*============================================================================*/
.board-order{
    font-size: 15px;
    font-weight: bold;
    

}
.board-order td{
    padding: 10px;
    border-top: 3px solid  #ef3e61;
    border-bottom: 2px solid  #ef3e61;
    border-left: 1px dashed #ef3e61;

}
.board-order__item td {
    border-top: 1px solid  #ef3e61;
    border-left: 1px dashed #ef3e61;
    padding: 5px 0px;
    margin: 5px 0px;
}
.board-order__item td:first-child,
.board-order td:first-child{
    border-left: none;
}

.enter__btn {
    height: 50px;
    padding: 10px;
    text-align: right;
    border-bottom: 3px solid  #ef3e61;
    border-top: 2px solid  #ef3e61;
  }

.enter__btn button {
    width: 100px;
    height: 40px;
    margin-right: 10px;
    font-size: 16px;
    font-weight: 700;
    border: none;
    border-radius: 15px;
    color: white;
    background-color: #ef3e61;
}
textarea{
width:800px;
resize:none;
padding:15px;
outline:none;
}
.button2{
color:red;
}
</style>
<script>
$(document).ready(function() {
	$(".button2").click(function(){
		let num =$(this).attr('value');
		$.ajax( {
			  type:"GET" ,
			  url :"CommentDE",
			 data : {num:num},  // 서버로 전송할 데이터. stringify()로 직렬화 필요.
			 success: function(data){ 
	        	  showList();
	        	  alert("삭제완료");
	        	  console.log( data);  },
	          error: function(){
	        	  alert("error");
	        	  console.log( data);
	        	  
	          }	
		});  
	});
});
$(document).ready(function() {
	$(".button3").click(function(){
		let num =$(this).attr('value');
		let text = document.querySelector('.text').value;
		let button1 =document.querySelector('.button1');
		let button2 =document.querySelector('.button2');
		let button3 =document.querySelector('.button3');
		let button4 =document.querySelector('.button4');
		let text2 = document.querySelector('.text');
		button1.style.display='inline-block';
		button2.style.display='inline-block';
		button3.style.display='none';
		button4.style.display='none';
		text2.readOnly=true;
		$.ajax( {
			  type:"POST" ,
			  url :"CommentUP",
			 data :  {num:num,text:text},
			 success: function(data){ 
	        	  alert("수정완료");
	        	  console.log( data);  },
	          error: function(){
	        	  alert("error");
	        	  console.log( data);
	        	  
	          }	
		});  
	});
});
$(document).ready(function() {
	$(".button5").click(function(){
		let text = document.querySelector('.CMreg').value;
		let Cnum =$(this).attr('value');
		$.ajax( {
			  type:"POST" ,
			  url :"CommentReg",
			 data : {Cnum:Cnum,text:text},  // 서버로 전송할 데이터. stringify()로 직렬화 필요.
			 success: function(data){ 
	        	  document.querySelector('.CMreg').value='';
	        	  showList();
	        	  alert("입력완료");
	        	  console.log( data); 
	        	  },
	          error: function(){
	        	  alert("error");
	        	  console.log( data);
	        	  
	          }	
		});  
	});
});
function showList(){
	let Cnum = document.querySelector('.button5').value;
	  $.ajax(
			    {
			    	type:"GET" ,
			    	url: "RegIn" ,
			    	data : {Cnum:Cnum},
			    	success:function(data){
			    		 let dataHtml  = toHtml(data);
			    		 $(".CMTable").html(dataHtml);
			    		console.log(data);			    		
			    	},
			    	error: function(){
			    		alert(" error");	    		
			    	}
			    	
			    }		
			
			);
}
function toHtml(data){
	let str="";
	for( let i=0 ; i< data.length; i++){
		let item = data[i];
		str+= '<tr class="comment"><td><textarea id="text" class="text" readonly="readonly">'+ item.text+'</textarea></td>'
		+'<td>'+item.name+'</td><td>'+item.date+'</td></tr> <tr class="comment2"><td><button id="button1" class-button1="'+item.num+'" type="button">수정'
		+'</button><button id="button2" class-button2="'+item.num+'" type="button" value="'+item.num+'">삭제</button>'
		+'<button id="button3" class=-button3="'+item.num+'" type="button" value="'+item.num+'" style="display:none">수정완료</button>'
		+'<button id="button4" class-button4="'+item.num+'" type="button" style="display:none" >취소</button></td></tr>'  	   
	}

  
	
	return  str;
}
$(document).ready(function(){
	$(".button1").click(function(){
		let button1 =document.querySelector('.button1');
		let button2 =document.querySelector('.button2');
		let button3 =document.querySelector('.button3');
		let button4 =document.querySelector('.button4');
		let text = document.querySelector('.text');
		button1.style.display='none';
		button2.style.display='none';
		button3.style.display='inline-block';
		button4.style.display='inline-block';
		text.readOnly=false;
	});
});
$(document).ready(function(){
	$(".button4").click(function(){
		let button1 =document.querySelector('.button1');
		let button2 =document.querySelector('.button2');
		let button3 =document.querySelector('.button3');
		let button4 =document.querySelector('.button4');
		let text = document.querySelector('.text');
		button1.style.display='inline-block';
		button2.style.display='inline-block';
		button3.style.display='none';
		button4.style.display='none';
		text.readOnly=true;
	});
});
</script>
<body>
 <table>
            <caption>게시판</caption>
            <tr class="board-order">
                <td>번호</td>
                <td>대륙</td>
                <td>종류</td>
                <td>제목</td>
                <td>작성자</td>
                <td>날짜</td>
                <td>조회</td>
            </tr>
           <tr class="board-order__item">
            <td>${a.num}</td>
            <td>${a.continent}</td>
            <td>${a.select}</td>
            <td>${a.title}</td>
            <td>${a.id}</td>
            <td>${a.date}</td>
            <td>${a.number}</td>
        </tr>
            <tr>
            <td  class="enter__btn" colspan="8">
               <textarea name="content" readonly="readonly"> ${a.text}</textarea>
            </td>
            </tr>
	

        <tr >
            <td  class="enter__btn" colspan="8">
                <button><a href="boardUp?num=${a.num}">수정</a></button>
                <button><a href="boardDE?num=${a.num}">삭제</a></button>
            </td>
        </tr>
        </table>
        <table class="CMTable">
        <c:forEach var="list" items="${list}">
        <tr class="comment">
         <td><textarea id="text" class="text" readonly="readonly">${list.text}</textarea></td>
         <td>${list.name}</td>
         <td>${list.date}</td>
        </tr>
          <tr class="comment2">
         <td> 
         <button id="button1" class="button1" type="button" >수정</button>
         <button id="button2" class="button2" type="button" value="${list.num}" onclick="click1()">삭제</button>
         <button id="button3" class="button3" type="button" value="${list.num}" style="display:none">수정완료</button>
         <button id="button4" class="button4" type="button" style="display:none">취소</button>
         </td>
        </tr> 
        </c:forEach>
        </table>
        <div  id="result"> 
		</div> 
        <table>
        <tr>
         <td><textarea class="CMreg"></textarea></td>
         <td><button class="button5" type="button" value="${a.num}">등록</button></td>
        </tr>
        </table>
</body>
</html>