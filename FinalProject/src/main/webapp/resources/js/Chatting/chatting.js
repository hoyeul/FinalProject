$(document).ready(function () {
	let eu_black = document.querySelector('.eu_black');
	let asia_black = document.querySelector('.asia_black');
	let northAmerica_black = document.querySelector('.northAmerica_black');
	let africa_black = document.querySelector('.africa_black');
	let oceania_black = document.querySelector('.oceania_black');
	let southAmerica_black = document.querySelector('.southAmerica_black');
	let eu_color = document.querySelector('.eu_color');
	let asia_color = document.querySelector('.asia_color');
	let northAmerica_color = document.querySelector('.northAmerica_color');
	let africa_color = document.querySelector('.africa_color');
	let oceania_color = document.querySelector('.oceania_color');
	let southAmerica_color = document.querySelector('.southAmerica_color');
	  $("#chatting").on("click", ".eu_black", function () {
			alert("유럽방에 입장했습니다");
			window.open("http://192.168.0.95:8090/FinalProject/chat-ws-Eu.jsp", "eu", "width=450, height=700, left=100, top=50");
			eu_black.style.display ='none';
			asia_black.style.display ='block';
			northAmerica_black.style.display ='block';
			africa_black.style.display ='block';
			oceania_black.style.display ='block';
			southAmerica_black.style.display ='block';
			eu_color.style.display ='block';
			asia_color.style.display ='none';
			northAmerica_color.style.display ='none';
			africa_color.style.display ='none';
			oceania_color.style.display ='none';
			southAmerica_color.style.display ='none';
	  });
	  $("#chatting").on("click", ".asia_black", function () {
		    alert("아시아방에 입장했습니다");
			window.open("http://192.168.0.95:8090/FinalProject/chat-ws-Asia.jsp", "asia", "width=450, height=700, left=100, top=50");
			eu_black.style.display ='block';
			asia_black.style.display ='none';
			northAmerica_black.style.display ='block';
			africa_black.style.display ='block';
			oceania_black.style.display ='block';
			southAmerica_black.style.display ='block';
			eu_color.style.display ='none';
			asia_color.style.display ='block';
			northAmerica_color.style.display ='none';
			africa_color.style.display ='none';
			oceania_color.style.display ='none';
			southAmerica_color.style.display ='none';
	  });
	  $("#chatting").on("click", ".northAmerica_black", function () {
		 	alert("북아메리카방에 입장했습니다");
			window.open("http://192.168.0.95:8090/FinalProject/chat-ws-NorthAmerica.jsp", "northAmerica", "width=450, height=700, left=100, top=50");
			eu_black.style.display ='block';
			asia_black.style.display ='block';
			northAmerica_black.style.display ='none';
			africa_black.style.display ='block';
			oceania_black.style.display ='block';
			southAmerica_black.style.display ='block';
			eu_color.style.display ='none';
			asia_color.style.display ='none';
			northAmerica_color.style.display ='block';
			africa_color.style.display ='none';
			oceania_color.style.display ='none';
			southAmerica_color.style.display ='none';
	  });
	  $("#chatting").on("click", ".africa_black", function () {
		  	alert("아프리카방에 입장했습니다");
			window.open("http://192.168.0.95:8090/FinalProject/chat-ws-Africa.jsp", "africa", "width=450, height=700, left=100, top=50");
			eu_black.style.display ='block';
			asia_black.style.display ='block';
			northAmerica_black.style.display ='block';
			africa_black.style.display ='none';
			oceania_black.style.display ='block';
			southAmerica_black.style.display ='block';
			eu_color.style.display ='none';
			asia_color.style.display ='none';
			northAmerica_color.style.display ='none';
			africa_color.style.display ='block';
			oceania_color.style.display ='none';
			southAmerica_color.style.display ='none';
	  });
	  $("#chatting").on("click", ".oceania_black", function () {
		  	alert("오세아니아방에 입장했습니다");
			window.open("http://192.168.0.95:8090/FinalProject/chat-ws-Oceania.jsp", "oceania", "width=450, height=700, left=100, top=50");
			eu_black.style.display ='block';
			asia_black.style.display ='block';
			northAmerica_black.style.display ='block';
			africa_black.style.display ='block';
			oceania_black.style.display ='none';
			southAmerica_black.style.display ='block';
			eu_color.style.display ='none';
			asia_color.style.display ='none';
			northAmerica_color.style.display ='none';
			africa_color.style.display ='none';
			oceania_color.style.display ='block';
			southAmerica_color.style.display ='none';
	  });
	  $("#chatting").on("click", ".southAmerica_black", function () {
		  	alert("남아메리카방에 입장했습니다");
			window.open("http://192.168.0.95:8090/FinalProject/chat-ws-SouthAmerica.jsp", "southAmerica", "width=450, height=700, left=100, top=50");
			eu_black.style.display ='block';
			asia_black.style.display ='block';
			northAmerica_black.style.display ='block';
			africa_black.style.display ='block';
			oceania_black.style.display ='block';
			southAmerica_black.style.display ='none';
			eu_color.style.display ='none';
			asia_color.style.display ='none';
			northAmerica_color.style.display ='none';
			africa_color.style.display ='none';
			oceania_color.style.display ='none';
			southAmerica_color.style.display ='block';
	  });
	});