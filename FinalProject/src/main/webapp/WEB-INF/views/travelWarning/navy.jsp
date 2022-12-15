<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.*" %>
<%@ page import="com.FinalProject.Model.TravelWarning.NavyDto " %>
<% List<NavyDto> navy = (List<NavyDto>)request.getAttribute("navy"); %>
<c:set var="path" value="${pageContext.request.contextPath }"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${path }/resources/css/navy.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="${path }/resources/js/navy.js"></script>
</head>
<body>
<section>
<div class="section_wrap">
	<div class="section_title">
		<div class="assignment">
			<span class="material-symbols-outlined assignment">assignment</span>
		</div>
		<div class="section_title_explain">
			<span style="font-size: 24px; font-weight: bold;">단계별 여행경보</span><br/>
			<span style="font-size: 12px; font-weight: lighter;">단계별 여행경보 발령 현황을 안내합니다.</span>
		</div>
	</div>
	<div class="levelPart">
		<div class="levelPart_div">
			<div class="level level1">
				<div class="level_left navy">
					<div class="inner_level_left">
						<span>1단계</span><br/>
						<hr/>
						<span>남색경보</span>
					</div>
				</div>
				<div class="level_right">
					<span>여행유의</span><br/>
					<span>신변안전 위험 요인 숙지·대비</span>
				</div>
			</div>
			<div class="level level2">
				<div class="level_left yellow">
					<div class="inner_level_left">
						<span>2단계</span><br/>
						<hr/>
						<span>황색경보</span>
					</div>
				</div>
				<div class="level_right">
					<span>여행자제</span><br/>
					<span>(여행예정자) 불필요한 여행 자제<br/>(체류자) 신변안전 특별유의</span>
				</div>
			</div>
		</div>
		<div class="levelPart_div">
			<div class="level level3">
				<div class="level_left red">
					<div class="inner_level_left">
						<span>3단계</span><br/>
						<hr/>
						<span>적색경보</span>
					</div>
				</div>
				<div class="level_right">
					<span>출국권고</span><br/>
					<span>(여행예정자) 여행 취소·연기<br/>(채류자) 긴요한 용무가 아닌 한 출국</span>
				</div>
			</div>
			<div class="level level4">
				<div class="level_left black">
					<div class="inner_level_left">
						<span>4단계</span><br/>
						<hr/>
						<span>흑색경보</span>
					</div>
				</div>
				<div class="level_right">
					<span>여행금지</span><br/>
					<span>(여행예정자) 여행금지 준수<br/>(체류자) 즉시 대피·철수</span>
				</div>
			</div>
		</div>
	</div>
	<table>
		<tr>
			<td>중동/아프리카</td>
			<td>
			<% for(int i = 0; i < navy.size(); i++){
				if(navy.get(i).getContinent().equals("중동/아프리카")){
			%>	
			<%=navy.get(i).getCountryName() %> (<%=navy.get(i).getAttentionNote() %>)<br/>
			<% }} %>
			</td>
		</tr>
		<tr>
			<td>미주</td>
			<td>
			<% for(int i = 0; i < navy.size(); i++){
				if(navy.get(i).getContinent().equals("미주")){ %>
			<%=navy.get(i).getCountryName() %> (<%=navy.get(i).getAttentionNote() %>)<br/>
			<% }} %>
			</td>
		</tr>
		<tr>
			<td>유럽</td>
			<td>
			<% for(int i = 0; i < navy.size(); i++){
				if(navy.get(i).getContinent().equals("유럽")){ %>	
			<%=navy.get(i).getCountryName() %> (<%=navy.get(i).getAttentionNote() %>)<br/>
			<% }} %>
			</td>
		</tr>
		<tr>
			<td>아시아/태평양</td>
			<td>
			<% for(int i = 0; i < navy.size(); i++){
				if(navy.get(i).getContinent().equals("아시아/태평양")){ %>
			<%=navy.get(i).getCountryName() %> (<%=navy.get(i).getAttentionNote() %>)<br/>
			<% }} %>
			</td>
		</tr>
</table>
</div>
</section>
</body>
</html>