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
<script src="${path}/resources/js/boardreg.js"></script>

<body>
	<section>
		<table>
			<caption>게시글 등록</caption>
	            <tr class="board-order">
	            	<td>게시판</td>
	                <td></td>
	                <td>말머리</td>
	                <td></td>
	            </tr>
	            <tr>
	            	<td colspan="3"></td>
	            </tr>
				<tbody>
		            <tr>
		                <td class="board_text" colspan="4">
		                   <textarea name="text" class="in_text" contenteditable="true">
		                   	
		                   </textarea>
		                </td>
		            </tr>
		            <tr>
		                <td class="content_btn" colspan="3">
		                    <button type="button" onclick="window.location.href='/Controller/board'">목록으로</button>
		                </td>
		            </tr>
				</tbody>
		</table>
	</section>
</body>
</html>