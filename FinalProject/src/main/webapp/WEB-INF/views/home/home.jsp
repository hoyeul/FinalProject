<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ page import="java.util.ArrayList" %>
    <c:set var="path" value="${pageContext.request.contextPath }"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.section_wrap{
	padding: 50px 0;
}

.canvas_wrap{
	width: 100%;
	margin: 0 auto;
}

.main_center{
	display: flex;
	width: 1000px;
	margin: 0 auto;
	justify-content: space-between;
}

.main_board{
	width: 700px;
	height: 300px;
	padding: 20px 0px;
	text-align: center;
}
table{
	text-align: center;
	margin: 0px auto;
	border-collapse: collapse
}
tr{
	border-top: 0.5px solid grey;
	border-bottom: 0.5px solid grey;
}
table tr:nth-child(1){
	font-weight: bold;
}

td{
	white-space: no-wrap;
	overflow: hidden;
	text-overflow: ellipsis;
	padding: 10px;
	font-size: 13px;
}
</style>
<script src="https://unpkg.com/chart.js@3"></script>
<script src="https://unpkg.com/chartjs-chart-geo@3"></script>
<script type="text/javascript">
fetch('https://unpkg.com/world-atlas/countries-50m.json').then((r) => r.json()).then((data) => {
    const countries = ChartGeo.topojson.feature(data, data.objects.countries).features;

const chart = new Chart(document.getElementById("canvas").getContext("2d"), {
  type: 'choropleth',
  data: {
    labels: countries.map((d) => d.properties.name),
    datasets: [{
      label: 'Countries',
      data: countries.map((d) => ({feature: d, value: Math.random()})),
    }]
  },
  options: {
    showOutline: true,
    showGraticule: true,
    plugins: {
      legend: {
        display: false
      },
    },
    scales: {
      xy: {
        projection: 'equalEarth'
      }
    }
  }
});
});
</script>
</head>
<body>
	<section>
		<div class="section_wrap">
			<!-- 지도api -->
			<div class="canvas_wrap">
				<canvas id="canvas"></canvas>
			</div>
			
			<div class="main_center">
				
				<!-- 게시판영역 -->
				<div class="main_board">
					<table class="mainboard">	
					<caption><h3>최신순</h3></caption>
		            <tr>
		                <td style="width:10%;"></td>
		                <td style="width:50%;">제목</td>
		                <td>작성자</td>
		                <td>날짜</td>
		                <td>조회수</td>
		                <td>추천수</td>
		            </tr>
					<c:forEach var="list" items="${list}">
			        <tr>
			            <td>${list.num2}</td>
			            <td style=" text-align: left;">
				            <span class="b_con">[${list.continent}] </span>
				            <span class="b_sel">[${list.select}] </span>
				            <a href="boardIn?num=${list.num}&number=${list.number}">${list.title}</a>
			            </td>
			            <td>${list.id}</td>
			            <td style="">${list.date}</td>
			            <td>${list.number}</td>
			        </tr> 
					</c:forEach>
					</table>
				</div>
				
				<!-- Currency Converter Script - FxExchangeRate.com  -->
				<div style="width:248px;height:auto;border:1px solid #2D6AB4;text-align:center;font-size:16px;font-family:sans-serif,Arial,Helvetica;border-top-right-radius:5px; border-top-left-radius:5px;background-color:#FFFFFF;">
					<div style="width:100%; height:24px;padding:5px 0px 0px 0px;background-color:#2D6AB4;font-weight:bold;">
						<a rel="nofollow" style="color:#FFFFFF;text-decoration:none;" href="https://www.fxexchangerate.com/">Currency Converter</a>
					</div>
					<script type="text/javascript" src="https://w.fxexchangerate.com/converter.php?fm=USD&ft=EUR&lg=kr&am=1&ty=1"></script>
				</div>
				<!--  End of Currency Converter Script -  FxExchangeRate.com -->
			</div>
		</div>
	</section>
</body>
</html>