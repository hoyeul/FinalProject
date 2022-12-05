<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>title</title>
<style>
*{
	padding: 0;
	margin: 0;
}

.wrap{
	min-width: 1000px;
}

header{
	height: 25px;
	padding: 20px;
	background-color: black;
	position: relative;
	line-height: 25px;
	font-size: 17px;
}

header a{
	text-decoration: none;
	color: white
}

.header_left div{
	float: left;
}

.header_lefthomeBtn{
	padding: 0 15px;
}

.navIcon{
	width: 27px;
	height: 27px;
	background-image: url("resources/image/menuIcon.png");
	background-size: cover;
	background-position: center;
}

.myPageIcon{
	width: 25px;
	height: 25px;
	background-image: url("resources/image/mypageIcon.png");
	background-size: cover;
	background-position: center;
}

.header_right{
	position: absolute;
	right: 50px;
}

.header_right div{
	float: left;
	padding: 0 10px;
}

.underHeader{
	display: flex;
}

.navPart{
	width: 15%;
}

.sectionAndFooterPart{
	width: 85%;
}

nav{
	background-color: aqua;
	padding: 20px;
	height: 700px;
}

nav ul{
	list-style: none;
}

section{
	padding: 50px;
	height: 560px;
}

footer{
	padding: 20px;
	background-color: blue;
	height: 40px;
}
</style>
</head>
<body>
<div class="wrap">
	<!-- header 부분 -->
	<tiles:insertAttribute name="header" />
	
	<div class="underHeader">
		<div class="navPart">
			<!-- nav 부분 -->
			<tiles:insertAttribute name="nav" />
		</div>
		<div class="sectionAndFooterPart">
			<!-- section 부분 -->
			<tiles:insertAttribute name="section" />
			
			<!-- footer 부분 -->
			<tiles:insertAttribute name="footer" />
		</div>
	</div>
</div>
</body>
</html>