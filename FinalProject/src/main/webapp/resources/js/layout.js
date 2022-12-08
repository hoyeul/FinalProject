$(function(){
	$(".navIcon").on("click", function(){
		if($("#nav").css("display") == "block"){
			$("#nav").css("display", "none");
			$("#nav").css("width","0");
			$(".section_nav").css("width","0");
			$(".section_nav").css("min-width", "0");
			$(".section").css("width","100%");
		}else{
			$("#nav").css("display", "block");
			$("#nav").css("width","15%");
			$(".section_nav").css("width","15%");
			$(".section_nav").css("min-width", "180px");
			$(".section").css("width","85%");
		}
	});
});	