function boardreg(){
	let regfrm = document.regfrm;
	let continent = regfrm.continent;
	let select = regfrm.select;
	let title = regfrm.title;
	let text = regfrm.text;
	
	if(continent.value == ""){
		alert("게시판을 선택해주세요.");
		continent.focus();
	}else if(select.value == ""){
		alert("말머리를 선택해주세요");
		select.focus();
	}else if(title.value == ""){
		alert("제목을 입력해주세요");
		title.focus();
	}else if(text.value == ""){
		alert("내용을 입력해주세요");
		text.focus();
	}else{
		regfrm.submit();
	}
}


function boardup() {
	let upfrm = document.upfrm;
	let continent = upfrm.continent;
	let select = upfrm.select;
	let title = upfrm.title;
	let text = upfrm.text;
	
	if(continent.value == ""){
		alert("게시판을 선택해주세요.");
		continent.focus();
	}else if(select.value == ""){
		alert("말머리를 선택해주세요");
		select.focus();
	}else if(title.value == ""){
		alert("제목을 입력해주세요");
		title.focus();
	}else if(text.value == ""){
		alert("내용을 입력해주세요");
		text.focus();
	}else{
		upfrm.submit();
	}
}


$(document).ready(function() {
	showList1();
	
	$("#result").on("click",".button2",function(){
		let num =$(this).attr('value');
		$.ajax( {
			  type:"GET" ,
			  url :"CommentDE",
			 data : {num:num},  // 서버로 전송할 데이터. stringify()로 직렬화 필요.
			 success: function(data){ 
	        	  showList1();
	        	  alert("삭제완료");
	        	  console.log( data);  },
	          error: function(){
	        	  alert("error");
	        	  console.log( data);        	  
	          }	
		});  
	});
	
	$("#result").on("click",".button1",function(){
		showList2();
	});
	
	$("#result").on("click",".button4",function(){
		showList1();
	});
	
	$(".button5").click(function(){
		let text = document.querySelector('.CMreg').value;
		let Cnum =$(this).attr('value');
		$.ajax( {
			  type:"POST" ,
			  url :"CommentReg",
			 data : {Cnum:Cnum,text:text},  // 서버로 전송할 데이터. stringify()로 직렬화 필요.
			 success: function(data){ 
	        	  document.querySelector('.CMreg').value='';
	        	  showList1();
	        	  alert("입력완료");
	        	  console.log( data); 
	        	  },
	          error: function(){
	        	  alert("error");
	        	  console.log( data);
	        	  
	          }	
		});  
	});
	
	$("#result").on("click",".button3",function(){
		let num =$(this).attr('value');
		let p = this.parentElement.parentElement.previousSibling;
  	  	let text =  p.querySelector(".text").value;
		$.ajax( {
			  type:"POST" ,
			  url :"CommentUP",
			 data :  {num:num,text:text},
			 success: function(data){ 
	        	  alert("수정완료");
	        	  console.log( data);  },
	          error: function(){
	        	  alert("CommentUPerror");
	        	  console.log( data); 	  
	          }	
		}); 
		showList1();     
	});
	
});

function showList1(){
	let Cnum = document.querySelector('.button5').value;
	  $.ajax(
			    {
			    	type:"GET" ,
			    	url: "RegIn" ,
			    	data : {Cnum:Cnum},
			    	success:function(data){
			    		 let dataHtml  = toHtml1(data);
			    		 $("#result").html(dataHtml);
			    		console.log(data);			    		
			    	},
			    	error: function(){
			    		alert(" showList1error");	    		
			    	}	
			    }		
			);
}

function toHtml1(data){
	let str="<table>";
	for( let i=0 ; i< data.length; i++){
		let item = data[i];
		str+= '<tr class="comment"><td><textarea class="text" readonly="readonly">'+ item.text+'</textarea></td>'
		+'<td>'+item.name+'</td><td>'+item.date+'</td></tr><tr class="comment2" colspan="3"><td><button class="button1" type="button">수정</button>'
		+'<button class="button2" type="button" value="'+item.num+'">삭제</button></td></tr>'
	}
	str+= "</table>";
	return  str;
}

function showList2(){
	let Cnum = document.querySelector('.button5').value;
	  $.ajax(
			    {
			    	type:"GET" ,
			    	url: "RegIn" ,
			    	data : {Cnum:Cnum},
			    	success:function(data){
			    		 let dataHtml  = toHtml2(data);
			    		 $("#result").html(dataHtml);
			    		console.log(data);			    		
			    	},
			    	error: function(){
			    		alert(" showList2error");	    		
			    	}	
			    }		
			);
}

function toHtml2(data){
	let str="<table>";
	for( let i=0 ; i< data.length; i++){
		let item = data[i];
		str+= '<tr class="comment"><td><textarea data-id='+item.text+' id="text" class="text">'+ item.text+'</textarea></td>'
		+'<td>'+item.name+'</td><td>'+item.date+'</td></tr><tr class="comment2" colspan="3"><td>'
		+'<button class="button3" type="button" value="'+item.num+'">수정완료</button>'
		+'<button class="button4" type="button"  >취소</button></td></tr>'  	   
	}
	str+= "</table>";
	return  str;
}