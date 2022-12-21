$(function(){
	// console.log(" test = "+  $('.b_con'));
	let b_cons =  document.querySelectorAll(".b_con");
	for(let i=0 ; i< b_cons.length; i++){
	    let b_con = b_cons[i];
	    // alert( b_con.innerHTML);
	    let country = b_con.innerHTML;
	    if(country.trim() == "[아시아]"){	            
	        b_con.style.color='red';
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
		window.location.href='/FinalProject/login';
	}
	else{
		window.location.href='/FinalProject/boardreg';
	}
}
