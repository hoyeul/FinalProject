$(document).ready(function() {
CKEDITOR.replace( 'ckeditor', {
    width:'100%',
    height:'400px',
});
   showList1();

    $("#board-in-comment-box").on("click",".reply",function(){
		let p = this.parentElement.nextSibling;
		console.log(p);
		p.style.display="block";
	});
	
	$("#board-in-comment-box").on("click",".replyreg",function(){
		let Cnum =$(this).attr('value');
		let Recm = this.parentElement.parentElement.parentElement.querySelector(".reply").value;
		let text = this.parentElement.parentElement.querySelector(".text").value;
		let commentRegLoginId = document.querySelector('#user_id').value;
		if(commentRegLoginId == ""){
			alert("로그인 후 댓글작성이 가능합니다.");
			window.location.href='/FinalProject/login.alreadyLogin';
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
      let p = this.parentElement.parentElement;
      p.querySelector('.comment-update-btn-box').style.display="block"
      p.querySelector('.comment-update-textarea').style.display="block"
      p.querySelector('.comment-text').style.display="none"
      p.querySelector('.reply').style.display="none"
      p.querySelector('.comment-box-delete').style.display="none"
      p.querySelector('.comment-box-update').style.display="none"

	  console.log(p);
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
		window.location.href='/FinalProject/login.alreadyLogin';
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
      let text = this.parentElement.parentElement.querySelector('.comment-update-textarea').value;
	$.ajax( {
          type:"POST" ,
          url : "CommentUP",
          data : {num:num,text:text},
          success: function(data){ 
                alert("수정완료");
                console.log(data); 
                showList1();
                 },
             error: function(){
                alert("CommentUPerror");
                console.log(data);      
             }   
      }); 
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
	let loginId = document.querySelector('#user_id').value;
    let str="<div class='board-in-comment'>";
    for( let i=0 ; i< data.length; i++){
        let item = data[i];
        let names = item.name
        str+=
         '<div class="comment-info">'
        +'<span class="comment-user">'+item.name+'</span>'
        +'<span class="comment-date">'+'('+item.date+')'+'</span>'
        +'<div class="comment-area">'
        +'<span class="comment-text" readonly="readonly">'+ item.text+'</span>'
        +'<textarea data-id='+item.text+' id="text" class="comment-update-textarea" style=display:none>'+item.text+'</textarea>'
        +'<button class="reply" type="button" value="'+item.recm+'">답글</button>'
        if( loginId == names || ("ㅤ┖"+loginId) == names){
        str+=
        '<button class="comment-box-delete" type="button" value="'+item.num+'">삭제</button>'
        +'<button class="comment-box-update" type="button">수정</button>'
        }
         str+=
        '</div>'
        +'<div class ="replySpace">'
        +'<textarea id="text" class="text"></textarea>'
        +'<div class="replyreg-btn-box">'
        +'<button class="replyreg" type="button" value="'+item.cnum+'">등록</button>'
        +'<button class="button4" type="button">취소</button>'
        +'</div>'
        +'</div>'
        +'<div class="comment-update-btn-box">'
     	+'<button class="button3" type="button" value="'+item.num+'">수정완료</button>'
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


function toHtml2(data){
   let str="<div class='comment-update-box'>";
   for( let i=0 ; i< data.length; i++){
      let item = data[i];
      str+=
       '<div class="comment">'
      +'<span class="comment-update-name">'+item.name+'</span><span class="comment-update-date">'+item.date+'</span>'
      +'<textarea data-id='+item.text+' id="text" class="text">'+item.text+'</textarea>'
      +'</div>'
      +'<div class="comment-update-btn-box">'
      +'<button class="button3" type="button" value="'+item.num+'">수정완료</button>'
      +'<button class="button4" type="button">취소</button>'
      +'</div>'
      +'</div>'
   }
   str+= "</div>";
   return  str;
}

$(function(){
		$("#recUp").click(function(){
			let id = $("#user_id").val();
			let b_num = $("#board_num").val();
			let loginId = document.querySelector('#user_id').value;
			if(loginId == ""){
				alert("로그인 후 추천이 가능합니다.");
				window.location.href='/FinalProject/login.alreadyLogin';
			}else{
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
			}
		})
})

$(function(){
		$("#recDown").click(function(){
			let id = $("#user_id").val();
			let b_num = $("#board_num").val();
			let loginId = document.querySelector('#user_id').value;
			if(loginId == ""){
				alert("로그인 후 비추천이 가능합니다.");
				window.location.href='/FinalProject/login.alreadyLogin';
			}else{
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
			}
		})
})


function boardregbtn() {
	
	let loginId = document.querySelector('#user_id').value;
	if(loginId =="" ){
		alert("로그인 후 글쓰기가 가능합니다.");
		window.location.href='/FinalProject/login.alreadyLogin';
	}
	else{
		window.location.href='/FinalProject/boardreg';
	}
}
