<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="path" value="${pageContext.request.contextPath }"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${path }/resources/css/TravelWarning/red.css">
<script src="${path }/resources/js/TravelWarning/red.js"></script>
</head>
<body>
<section>
<div class="section_wrap">
<!-- menu -->	
<%@ include file="/WEB-INF/views/travelWarning/inc/menu.jsp" %>

<table>
	<tr>
		<td>중동/아프리카</td>
		<td>
			<c:forEach var="item" items="${red }">
				<c:if test="${item.continent eq '중동/아프리카' }">
					<c:out value="${item.countryName }" /> (<c:out value="${item.limitaNote }" />)<br/>
				</c:if>
		 	</c:forEach>
		</td>
	</tr>
	<tr>
		<td>미주</td>
		<td>
			<c:forEach var="item" items="${red }">
				<c:if test="${item.continent eq '미주' }">
					<c:out value="${item.countryName }" /> (<c:out value="${item.limitaNote }" />)<br/>
				</c:if>
		 	</c:forEach>
		</td>
	</tr>
	<tr>
		<td>유럽</td>
		<td>
			<c:forEach var="item" items="${red }">
				<c:if test="${item.continent eq '유럽' }">
					<c:out value="${item.countryName }" /> (<c:out value="${item.limitaNote }" />)<br/>
				</c:if>
		 	</c:forEach>
		</td>
	</tr>
	<tr>
		<td>아시아/태평양</td>
		<td>
			<c:forEach var="item" items="${red }">
				<c:if test="${item.continent eq '아시아/태평양' }">
					<c:out value="${item.countryName }" /> (<c:out value="${item.limitaNote }" />)<br/>
				</c:if>
		 	</c:forEach>
		</td>
	</tr>
</table>
</div>
</section>
</body>
</html>