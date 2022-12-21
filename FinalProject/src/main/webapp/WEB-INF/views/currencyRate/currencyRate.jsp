<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<c:set var="path" value="${pageContext.request.contextPath }"></c:set>
<link rel="stylesheet" href="${path}/resources/css/currencyRate.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/json/currencyAvg.json" type="text/javascript"></script>
<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
<script type="text/javascript">

  google.charts.load('current', {'packages':['corechart']});
  google.charts.setOnLoadCallback(drawChart);

  //대분류 소분류 (대륙/국가)
  var malls = false;

  function update_selected() {
    $("#country").val(0);
    $("#country").find("option[value!=0]").detach();
    $("#country").append(malls.filter(".continent" + $(this).val()));
  }

  $(function() {
    malls = $("#country").find("option[value!=0]");
    malls.detach();
    $("#continent").change(update_selected);
    $("#continent").trigger("change");
  });
  
  //select 변경시 그래프 변경
  let cur_select = "USD";
  function showValue(target){
	cur_select = target.value;
	//alert(cur_select);
	google.charts.setOnLoadCallback(drawChart);
  }
  //Google Chart
  function drawChart() {

	  let country = currencyAvg.filter(function(e){
		    return e.cur_unit === cur_select;
	  });  	
	  var data = google.visualization.arrayToDataTable([
	    ['Year',  country[0]["cur_nm"]],
	    ['2012',  country[0]["2012"]],
	    ['2013',  country[0]["2013"]],
	    ['2014',  country[0]["2014"]],
	    ['2015',  country[0]["2015"]],
	    ['2016',  country[0]["2016"]],
	    ['2017',  country[0]["2017"]],
	    ['2018',  country[0]["2018"]],
	    ['2019',  country[0]["2019"]],
	    ['2020',  country[0]["2020"]],
	    ['2021',  country[0]["2021"]],
	    ['2022',  country[0]["2022"]]
	  ]);
	
	  var options = {
	    curveType: 'function',
	    legend: { position: 'bottom' }
	  };
	
	  var chart = new google.visualization.LineChart(document.getElementById('curve_chart'));
	  chart.draw(data, options);
  } 
</script>
</head>
<body>
<div class="section_wrap">
	<div class="title_wrap">
		<div class="section_title">
			<div class="assignment">
				<span class="material-symbols-outlined assignment">assignment</span>
			</div>
			<div class="section_title_explain">
				<span style="font-size: 24px; font-weight: bold;">환율 그래프</span><br/>
				<span style="font-size: 12px; font-weight: lighter;">국가/화폐별 환율 그래프를 제공합니다.</span>
			</div>
		</div>
		<div class="select_wrap">
			<select id="continent">
			   <option value="0" selected="selected">대륙</option>
			   <option value="1">북남미</option>
			   <option value="2">유럽</option>
			   <option value="3">아시아</option>
			   <option value="4">오세아니아</option>
			   <option value="5">아프리카</option>
			</select>
			<select id="country" onchange="showValue(this)">
			   <option value="0">국가</option>
			   <option class="continent1" value="USD" >미국</option>
			   <option class="continent3" value="JPY" >일본</option>
			   <option class="continent2" value="EUR" >유럽</option>
			   <option class="continent2" value="GBP" >영국</option>
			   <option class="continent1" value="CAD" >캐나다</option>
			   <option class="continent2" value="CHF" >스위스</option>
			   <option class="continent3" value="HKD" >홍콩</option>
			   <option class="continent3" value="CNY" >중국</option>
			   <option class="continent3" value="THB" >태국</option>
			   <option class="continent3" value="IDR" >인도네시아</option>
			   <option class="continent2" value="SEK" >스웨덴</option>
			   <option class="continent3" value="AUD" >호주</option>
			   <option class="continent2" value="DKK" >덴마크</option>
			   <option class="continent2" value="NOK" >노르웨이</option>
			   <option class="continent3" value="SAR" >사우디</option>
			   <option class="continent3" value="KWD" >쿠웨이트</option>
			   <option class="continent3" value="BHD" >바레인</option>
			   <option class="continent3" value="AED" >U.A.E</option>
			   <option class="continent3" value="SGD" >싱가포르</option>
			   <option class="continent3" value="MYR" >말레이지아</option>
			   <option class="continent4" value="NZD" >뉴질랜드</option>
			   <option class="continent3" value="TWD" >타이완</option>
			   <option class="continent3" value="PHP" >필리핀</option>
			   <option class="continent3" value="VND" >베트남</option>
			   <option class="continent2" value="PLN" >폴란드</option>
			   <option class="continent2" value="RUB" >러시아</option>
			   <option class="continent5" value="ZAR" >남아공</option>
			   <option class="continent3" value="INR" >인도</option>
			   <option class="continent3" value="PKR" >파키스탄</option>
			   <option class="continent3" value="BDT" >방글라데시</option>
			   <option class="continent5" value="EGP" >이집트</option>
			   <option class="continent1" value="MXN" >멕시코</option>
			   <option class="continent1" value="BRL" >브라질</option>
			   <option class="continent3" value="BND" >브루나이</option>
			   <option class="continent3" value="ILS" >이스라엘</option>
			   <option class="continent3" value="JOD" >요르단</option>
			   <option class="continent2" value="CZK" >체코</option>
			   <option class="continent3" value="MNT" >몽골</option>
			   <option class="continent4" value="FJD" >피지</option>
			   <option class="continent3" value="KHR" >캄보디아</option>
			   <option class="continent2" value="TRY" >터키</option>
			   <option class="continent2" value="HUF" >헝가리</option>
			   <option class="continent3" value="QAR" >카타르</option>
			   <option class="continent3" value="KZT" >카자흐스탄</option>		   
			</select>
		</div>
	</div>
	<div id="curve_chart"></div>
</div>
</body>
</html>
