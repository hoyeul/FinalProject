$(function(){
	// console.log(" test = "+  $('.b_con'));
	let b_sels =  document.querySelectorAll(".b_sel");
	for(let i=0 ; i< b_sels.length; i++){
	    let b_sel = b_sels[i];
	    // alert( b_con.innerHTML);
	    let category = b_sel.innerHTML;
	    if(category.trim() == "[공지]"){	            
	        b_sel.style.color='red';
	        b_sel.style.fontWeight='900';
	    }
	}
});

window.addEventListener("load",function(){
	let frm = document.frm;
	let selecttypeName = frm.selecttypeH.value;
	let selectcontentName = frm.selectcontentH.value;
	let continentName = frm.continentH.value;
	
	let selecttype = frm.selecttype;
	for(let i=0; i<selecttype.options.length; i++){
		if(selecttype.options[i].value==selecttypeName){
			selecttype.options[i].selected=true;
		}
	}
	
	let selectcontent = frm.selectcontent;
	for(let i=0; i<selectcontent.options.length; i++){
		if(selectcontent.options[i].value==selectcontentName){
			selectcontent.options[i].selected=true;
		}
	}
	
	let continentRadio = frm.continent;
	for(let i=0;i<continentRadio.length; i++){
		if(continentRadio[i].value==continentName){
			continentRadio[i].checked=true;
		}
	}
});

function boardregbtn() {
	
	let loginId = document.querySelector('#user_id').value;
	// alert(loginId);
	if(loginId =="" ){
		alert("로그인 후 글쓰기가 가능합니다.");
		window.location.href='/login.alreadyLogin';
	}
	else{
		window.location.href='/boardreg';
	}
}
