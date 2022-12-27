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
		let p = this.parentElement.previousSibling;
		let Recm =  p.querySelector(".reply").value;
		let q = this.parentElement;
		let text=q.querySelector(".text").value;
		$.ajax( {
			  type:"POST" ,
			  url :"ReplyCm",
			 data : {Recm:Recm,Cnum:Cnum,text:text},  
			 success: function(data){ 
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
   
   $("#board-in-comment-box").on("click",".comment-box-delete",function(){
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
      let Cnum =$(this).attr('value');
      $.ajax( {
          type:"POST" ,
          url :"CommentReg",
          data : {Cnum:Cnum,text:text},  // 서버로 전송할 데이터. stringify()로 직렬화 필요.
          success: function(data){ 
                document.querySelector('.comment-textarea').value='';
                showList1();
                alert("입력완료");
                console.log(data); 
                },
             error: function(){
                alert("comment-edit-btn error");
                console.log(data);
             }   
      });  
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
        $.ajax(
             {
                type:"GET" ,
                url : "/RegIn" ,
                data : {Cnum:Cnum},
                success:function(data){
                   let dataHtml  = toHtml1(data);
                   $("#board-in-comment-box").html(dataHtml);
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
      +'<div class ="replySpace"><textarea id="text" class="text"></textarea>'
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
      str+= '<tr class="comment"><td><textarea data-id='+item.text+' id="text" class="text">'+ item.text+'</textarea></td>'
      +'<td>'+item.name+'</td><td>'+item.date+'</td></tr><tr class="comment2" colspan="3"><td>'
      +'<button class="button3" type="button" value="'+item.num+'">수정완료</button>'
      +'<button class="button4" type="button">취소</button></td></tr>'        
   }
   str+= "</table>";
   return  str;
}




