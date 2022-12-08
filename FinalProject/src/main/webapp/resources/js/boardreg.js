function boardreg(){
	let frm = document.frm;
	let continent = frm.continent;
	let select = frm.select;
	let title = frm.title;
	let text = frm.text;
	
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
		frm.submit();
	}
}