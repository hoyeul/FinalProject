<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="path" value="${pageContext.request.contextPath }"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	.section_wrap{
		padding: 20px;
	}
	
	.searchbar{
		width: 780px;
		margin: 0 auto;
		border: 2px solid black;
		padding: 10px;
		background-color: white;
	}
	
	.searchbar input{
		width: 100%;
		border: none;
		outline: none;
		font-size: 30px;
	}
	
	table{
		border: 1px solid black;
		border-collapse: collapse;
		margin: 0 auto;
		width: 800px;
		margin-top: 50px;
	}
	
	td{
		border: 1px solid black;
		padding: 10px;
		text-align: center;
	}
	
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
$(function(){
	
	$("#searchID").on("keyup", function(){
		let searchbar = $('#searchID').prop('value');
		$.ajax({
			url: '/FinalProject/manager',
			type: 'post',
			data: {id: searchbar},
			success: function(data){
				var html = '';
				$.each(data, function(index , item){
					html += '<tr>';
					html += '<td>'+item.id+'</td>';
					html += '<td>'+item.grade+'</td>';
					html += '<td>'+'asdf'+'</td>';
					html += '</tr>';
				});
				$("#tbody").empty();
				$("#tbody").append(html);
			},
			error: function(){
				alert("error");
			}
		});
	});
	
});
</script>
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
					<td>${item.grade }</td>
					<td>asdf</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</section>
</body>
</html>