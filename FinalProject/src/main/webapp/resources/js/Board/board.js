$(function(){
	// console.log(" test = "+  $('.b_con'));
	let b_sels =  document.querySelectorAll(".b_sel");
	for(let i=0 ; i< b_sels.length; i++){
	    let b_sel = b_sels[i];
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
	let recommendName = frm.recommendH.value;
	
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
	
		let recommendRadio = frm.recommend;
	for(let i=0;i<recommendRadio.length; i++){
		if(recommendRadio[i].value==recommendName){
			recommendRadio[i].checked=true;
		}
	}
	
});

function boardregbtn() {
	
	let loginId = document.querySelector('#user_id').value;
	if(loginId =="" ){
		window.location.href='/login.alreadyLogin';
	}
	else{
		window.location.href='/boardreg';
	}
}
