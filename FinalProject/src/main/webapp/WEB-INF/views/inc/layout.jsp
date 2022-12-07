<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="path" value="${pageContext.request.contextPath }"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>title</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<link rel="stylesheet" href="${path}/resources/css/layout.css">
<script src="${path}/resources/js/layout.js"></script>
</head>
<body>

<div class="wrap">
	<!-- header 부분 -->
	<tiles:insertAttribute name="header" />
	
	<div class="underHeader">
		<!-- nav 부분 -->
		<tiles:insertAttribute name="nav" />
	
		<!-- section 부분 -->
		<tiles:insertAttribute name="section" />
	</div>
</div>
</body>
</html>