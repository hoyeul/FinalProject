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
	
	$(".nav_information").on("click", function(){
		if($(".nav_information_menu").css("display") == "none"){
			$(".nav_information_menu").css("display", "block");
			$(".nav_board_menu").css("display", "none");
		}else{
			$(".nav_information_menu").css("display", "none");
		}
	});
	
	$(".nav_board").on("click", function(){
		if($(".nav_board_menu").css("display") == "none"){
			$(".nav_board_menu").css("display", "block");
			$(".nav_information_menu").css("display", "none");
		}else{
			$(".nav_board_menu").css("display", "none");
		}
	});
	
});	