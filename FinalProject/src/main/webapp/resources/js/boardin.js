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