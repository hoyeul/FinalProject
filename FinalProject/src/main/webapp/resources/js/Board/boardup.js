$(document).ready(function(){
CKEDITOR.replace( 'ckeditor', {
    width:'100%',
    height:'400px',
    filebrowserUploadUrl:  "fileupload.do"
});
});
function boardup() {
	let upfrm = document.upfrm;
	let continent = upfrm.continent;
	let select = upfrm.select;
	let title = upfrm.title;
	let text= CKEDITOR.instances["ckeditor"].getData();
	
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
