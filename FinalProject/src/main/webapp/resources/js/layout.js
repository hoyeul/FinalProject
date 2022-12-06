$(function(){
	$(".navIcon").on("click", function(){
		if($("#nav").css("display") == "block"){
			$("#nav").css("display", "none");
			$(".navPart").css("width","0");
			$(".sectionAndFooterPart").css("width", "100%");
		}else{
			$("#nav").css("display", "block");
			$(".navPart").css("width","15%");
			$(".sectionAndFooterPart").css("width", "85%");
		}
	});
});	