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

header{
	padding: 20px;
	background-color: black;
	color: white
}

nav{
	background-color: aqua;
	padding: 20px;
}

nav ul{
	list-style: none;
}

section{
	padding: 50px;
}

footer{
	padding: 20px;
	background-color: blue;
}
</style>
</head>
<body>

<!-- header 부분 -->
<tiles:insertAttribute name="header" />

<!-- nav 부분 -->
<tiles:insertAttribute name="nav" />

<!-- section 부분 -->
<tiles:insertAttribute name="section" />


<!-- footer 부분 -->
<tiles:insertAttribute name="footer" />

</body>
</html>