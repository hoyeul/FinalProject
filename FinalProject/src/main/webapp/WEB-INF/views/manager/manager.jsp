<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="path" value="${pageContext.request.contextPath }"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${path }/resources/css/MemberInfo/manager.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="${path }/resources/js/MemberInfo/manager.js"></script>
</head>
<body>
<section>
	<div class="section_wrap">
		<div class="searchbar">
			<input type="text" id="searchID" value="" placeholder="id를 입력하세요">
		</div>
		<table>
			<thead>
			<tr>
				<td>아이디</td>
				<td>등급</td>
				<td></td>
			</tr>
			</thead>
			<tbody id="tbody">
				<c:forEach var="item" items="${list }">
				<tr>
					<td>${item.id }</td>
					<td>
						<select>
							<option selected="selected" hidden>${item.grade }</option>
							<option value="admin">admin</option>
							<option value="member">member</option>
						</select>
					</td>
					<td>
						<button type="button" class="updateBtn">수정</button>
						<button type="button" class="deleteBtn">삭제</button>
					</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</section>
</body>
</html>