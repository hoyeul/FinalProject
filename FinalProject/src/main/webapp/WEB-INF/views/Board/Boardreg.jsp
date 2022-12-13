<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.ArrayList" %>
<c:set var="path" value="${pageContext.request.contextPath }"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" href="${path}/resources/css/boardreg.css">
<script src="${path}/resources/js/board.js"></script>

<body>
	<section>
	<form name="regfrm" action="/Controller/boardreg" method="post">
		<table>
			<caption>게시글 등록</caption>
	            <tr class="board-order">
	            	<td>게시판</td>
	                <td>
	                	<select id="continent" name="continent">
	                		<option value="">선택하세요</option>
	                		<option value="아시아">아시아</option>
	                		<option value="아프리카">아프리카</option>
	                		<option value="유럽">유럽</option>
	                		<option value="오세아니아">오세아니아</option>
	                		<option value="북아메리카">북아메리카</option>
	                		<option value="남아메리카">남아메리카</option>
	                	</select>
	                </td>
	                <td>말머리</td>
	                <td>
						<select id="select" name="select">
	                		<option value="">선택하세요</option>
	                		<option value="자유">자유</option>
	                		<option value="질문">질문</option>
	                		<option value="후기">후기</option>
	                		<option value="정보">정보</option>
	                	</select>
					</td>
	            </tr>
	            <tr>
	            	<td colspan="3">
	                	<input type="text" class="reg_title" name="title">
	                </td>
	            </tr>
				<tbody>
			            <tr>
			                <td class="board_text" colspan="4">
			                   <textarea name="text" class="in_text" contenteditable="true"></textarea>
			                </td>
			            </tr>
			            <tr>
			                <td class="content_btn" colspan="3">
			                    <button type="button" onclick="boardreg()">등록</button>
			                    <button type="button" onclick="window.location.href='/Controller/board'">목록으로</button>
			                </td>
			            </tr>
				</tbody>
		</table>
	</form>
	</section>
</body>
</html>