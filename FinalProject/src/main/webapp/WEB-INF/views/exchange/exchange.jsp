<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
$(function(){
	$.ajax({
	    url:'/FinalProject/exchange', //request 보낼 서버의 경로
	    type:'post',
	    dataType:'json',
	    success: function(data) {
	        //console.log(data);
	    	str = '<TR>';
            $.each(data , function(i){
               	str += '<TD>' + data[i].cur_nm + '</TD>';
                str += '<TD>' + data[i].cur_unit + '</TD>';
                str += '<TD>' + data[i].deal_bas_r + '</TD>';        
                str += '</TR>';
            });
       		$('#tbody').append(str);
	    },
	    error: function(err) {
	        alert("error");
	    }
	});
});
</script>
<style>
	table{
		border: 1px solid black;
		border-collapse: collapse;
		margin: 0 auto;
	}
	td{
		border: 1px solid black;
		padding: 10px;
	}
</style>
</head>
<body>
<section>
<table>
	<thead>
	<tr>
		<td>통화명</td>
		<td>통화코드</td>
		<td>환율(원)</td>
	</tr>
	</thead>
	<tbody id="tbody"></tbody>
</table>
</section>
</body>
</html>