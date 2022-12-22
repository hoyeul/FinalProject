$(document).ready(function() {
   showList1();
   
    $("#board-in-comment-box").on("click",".reply",function(){
		let p = this.parentElement.nextSibling;
		console.log(p);
		p.style.display="block";
	});
	
	$("#board-in-comment-box").on("click",".replyreg",function(){
		let Cnum =$(this).attr('value');
		let p = this.parentElement.previousSibling;
		let Recm =  p.querySelector(".reply").value;
		let q = this.parentElement;
		let text = q.querySelector(".text").value;
		let commentRegLoginId = document.querySelector('#user_id').value;
		if(commentRegLoginId == ""){
			alert("로그인 후 댓글작성이 가능합니다.");
			window.location.href='/FinalProject/login';
		}else if(text == ""){
			alert("댓글을 입력해주세요.");
		}else{
			$.ajax( {
				type:"POST" ,
				url :"ReplyCm",
				data :{
				Recm:Recm,
				Cnum:Cnum,
				text:text,
				name:commentRegLoginId
				},
				success: function(data){
                	showList1();
	                alert("입력완료");
	                console.log( data); 
		        },
		        error: function(){
		        	alert("error");
		        	console.log( data);
		        }
			})
		};  
	});

   $("#board-in-comment-box").on("click",".comment-box-delete",function(){
      let num = $(this).attr('value');
      $.ajax( {
          type:"GET" ,
          url :"CommentDE",
          data : {num:num},  // 서버로 전송할 데이터. stringify()로 직렬화 필요.
          success: function(data){ 
                showList1();
                alert("삭제완료");
                console.log( data);  },
             error: function(){
                alert("readyerror");
                console.log( data);             
             }   
      });  
   });
   
   $("#board-in-comment-box").on("click",".comment-box-update",function(){
      showList2();
   });
   
   $("#board-in-comment-box").on("click",".button4",function(){
      showList1();
   });
   
   $(".comment-edit-btn").click(function(){
      let text = document.querySelector('.comment-textarea').value;
      let Cnum = $(this).attr('value');
      let commentRegLoginId = document.querySelector('#user_id').value;
      if(commentRegLoginId == ""){
		alert("로그인 후 댓글작성이 가능합니다.");
		window.location.href='/FinalProject/login';
      }else if( text == "" ){
      	alert("댓글을 입력해주세요.");
      }else{
      	$.ajax( {
	          type:"POST" ,
	          url :"CommentReg",
	          data : {
	          	Cnum:Cnum, 
	          	text:text, 
	          	name:commentRegLoginId
	          	},  // 서버로 전송할 데이터. stringify()로 직렬화 필요.
	          success: function(data){ 
                	showList1();
	                alert("입력완료");
	                document.querySelector('.comment-textarea').value = "";
	                console.log(data); 
	                },
	         error: function(){
	            alert("comment-edit-btn error");
	            console.log(data);
	         }
		})
      };  
   });
   
   $("#board-in-comment-box").on("click",".button3",function(){
      let num =$(this).attr('value');
      let p = this.parentElement.parentElement.previousSibling;
          let text = p.querySelector(".text").value;
      $.ajax( {
          type:"POST" ,
          url : "CommentUP",
          data : {num:num,text:text},
          success: function(data){ 
                alert("수정완료");
                console.log(data);  },
             error: function(){
                alert("CommentUPerror");
                console.log(data);      
             }   
      }); 
      showList1();     
   });
   
});

function showList1(){
   let Cnum = document.querySelector('.comment-edit-btn').value;
   let loginId = document.querySelector('#user_id').value;
        $.ajax(
             {
                type:"GET" ,
                url : "/FinalProject/RegIn" ,
                data : {Cnum:Cnum},
                success:function(data){
                   let dataHtml  = toHtml1(data);
                   let loginNullView = loginNull(data);
					if( loginId == "" ){
						$("#board-in-comment-box").html(loginNullView);
					}else{
                    	$("#board-in-comment-box").html(dataHtml);
                    }
                   console.log(data);                   
                },
                error: function(){
                   alert("showList1error");             
                }   
             }      
      );
}

function toHtml1(data){
    let str="<div class='board-in-comment'>";
    for( let i=0 ; i< data.length; i++){
       let item = data[i];
       str+=
        '<div class="comment-info">'
       +'<span class="comment-user">'+item.name+'</span>'
       +'<span class="comment-date">'+'('+item.date+')'+'</span>'
       +'<div class="comment-area">'
       +'<span class="comment-text" readonly="readonly">'+ item.text+'</span>'
       +'<button class="reply" type="button" value="'+item.recm+'">답글</button>'
       +'<button class="comment-box-delete" type="button" value="'+item.num+'">삭제</button>'
       +'<button class="comment-box-update" type="button">수정</button>'
       +'</div>'
       +'<div class ="replySpace">'
       +'<textarea id="text" class="text"></textarea>'
       +'<button class="replyreg" type="button" value="'+item.cnum+'">등록</button>'
       +'<button class="button4" type="button">취소</button>'
       +'</div>'
       +'</div>'
    }
    str+= "</div>";
    return  str;
}

// 로그인 아이디가 댓글 아이디랑 일치하면 보이기.
function commentIdCheckOk(data){
	let loginId = document.querySelector('#user_id').value;
    let str="<div class='board-in-comment'>";
    for( let i=0 ; i< data.length; i++){
       let item = data[i];
       str+=
        '<div class="comment-info">'
       +'<span class="comment-user">'+item.name+'</span>'
       +'<span class="comment-date">'+'('+item.date+')'+'</span>'
       +'<div class="comment-area">'
       +'<span class="comment-text" readonly="readonly">'+ item.text+'</span>'
       +'<button class="reply" type="button" value="'+item.recm+'">답글</button>'
       +'<button class="comment-box-delete" type="button" value="'+item.num+'">삭제</button>'
       +'<button class="comment-box-update" type="button">수정</button>'
       +'</div>'
       +'<div class ="replySpace">'
       +'<textarea id="text" class="text"></textarea>'
       +'<button class="replyreg" type="button" value="'+item.cnum+'">등록</button>'
       +'<button class="button4" type="button">취소</button>'
       +'</div>'
       +'</div>'
    }
    str+= "</div>";
    return  str;
}

function loginNull(data){
   let str="<div class='board-in-comment'>";
   for( let i=0 ; i< data.length; i++){
      let item = data[i];
      str+=
       '<div class="comment-info">'
      +'<span class="comment-user">'+item.name+'</span>'
      +'<span class="comment-date">'+'('+item.date+')'+'</span>'
      +'<div class="comment-area">'
      +'<span class="comment-text" readonly="readonly">'+ item.text+'</span>'
      +'<button class="reply" type="button" value="'+item.recm+'">답글</	button>'
      +'</div>'
      +'<div class ="replySpace">'
      +'<textarea id="text" class="text"></textarea>'
      +'<button class="replyreg" type="button" value="'+item.cnum+'">등록</button>'
      +'<button class="button4" type="button">취소</button>'
      +'</div>'
      +'</div>'
   }
   str+= "</div>";
   return  str;
}

function showList2(){
   let Cnum = document.querySelector('.comment-edit-btn').value;
     $.ajax(
             {
                type:"GET" ,
                url: "RegIn" ,
                data : {Cnum:Cnum},
                success:function(data){
                   let dataHtml = toHtml2(data);
                   $("#board-in-comment-box").html(dataHtml);
                   console.log(data);                   
                },
                error: function(){
                   alert("showList2error");             
                }   
             }      
         );
}

function toHtml2(data){
   let str="<table>";
   for( let i=0 ; i< data.length; i++){
      let item = data[i];
      str+= '<tr class="comment"><td><textarea data-id='+item.text+' id="text" class="text">'+item.text+'</textarea></td>'
      +'<td>'+item.name+'</td><td>'+item.date+'</td></tr><tr class="comment2" colspan="3"><td>'
      +'<button class="button3" type="button" value="'+item.num+'">수정완료</button>'
      +'<button class="button4" type="button">취소</button></td></tr>'        
   }
   str+= "</table>";
   return  str;
}

$(function(){
		$("#recUp").click(function(){
			let id = $("#user_id").val();
			let b_num = $("#board_num").val();
			$.ajax({
				url: "RecommendReg",
                type: "POST",
                data: {
                   id : id ,
                   b_num : b_num
                },
                datatype:"text",
                success : function (upcntResult) {
                	if( upcntResult == 0){
                		alert("이미 추천하셨습니다.");  
                	} 
                	else{
                		alert("추천되었습니다.");
                		$("#recUpHtml").html(upcntResult);
                	}
                },
                error : function () {
                	alert("추천기능에러");
			   	}
			})
		})
})

$(function(){
		$("#recDown").click(function(){
			let id = $("#user_id").val();
			let b_num = $("#board_num").val();
			$.ajax({
				url: "RecommendDown",
                type: "POST",
                data: {
                   id : id ,
                   b_num : b_num
                },
                datatype:"text",
                success : function (downcntResult) {
                	if( downcntResult == 0){
                		alert("이미 비추천하셨습니다.");
                	}
                	else{
                	 alert("비추천되었습니다.");
                	 $("#recDownHtml").html(downcntResult);
                	}
                },
                error : function () {
			    	alert("추천기능에러");
			   	}
			})
		})
})

function boardregbtn() {
	
	let loginId = document.querySelector('#user_id').value;
	// alert(loginId);
	if(loginId =="" ){
		alert("로그인 후 글쓰기가 가능합니다.");
		window.location.href='/FinalProject/login';
	}
	else{
		window.location.href='/FinalProject/boardreg';
	}
}
