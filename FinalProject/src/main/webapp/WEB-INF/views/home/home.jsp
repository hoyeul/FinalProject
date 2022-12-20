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
body {
  font-family: -apple-system, BlinkMacSystemFont, "Segoe UI", Roboto, Helvetica, Arial, sans-serif, "Apple Color Emoji", "Segoe UI Emoji", "Segoe UI Symbol";
}

.total_wrap{
display: flex;
}
#chartdiv {
  	width: 100%;
  	height: 60vh;
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
>>>>>>> 2e7d40bcda076f10c55961bb5493df41d6b3bac9
</style>
<script src="https://cdn.amcharts.com/lib/5/index.js"></script>
<script src="https://cdn.amcharts.com/lib/5/map.js"></script>
<script src="https://cdn.amcharts.com/lib/5/geodata/worldLow.js"></script>
<script src="https://cdn.amcharts.com/lib/5/themes/Animated.js"></script>
<script type="text/javascript">
//Create root
am5.ready(function() {

var root = am5.Root.new("chartdiv"); 

// Set themes
root.setThemes([
  am5themes_Animated.new(root)
]);

// Create chart
var chart = root.container.children.push(am5map.MapChart.new(root, {
  panX: "rotateX",
  panY: "none",
  projection: am5map.geoNaturalEarth1(),
  rotationX: -155
}));

chart.chartContainer.set("background", am5.Rectangle.new(root, {
	  fill: am5.color(0xd4f1f9),
	  fillOpacity: 1
	}));
	
var backgroundSeries = chart.series.unshift(
	  am5map.MapPolygonSeries.new(root, {})
	);

	backgroundSeries.mapPolygons.template.setAll({
	  fill: am5.color(0xd4f1f9),
	  stroke: am5.color(0xd4f1f9),
	});

	backgroundSeries.data.push({
	  geometry: am5map.getGeoRectangle(90, 180, -90, -180)
	});
// Create polygon series
var polygonSeries = chart.series.push(am5map.MapPolygonSeries.new(root, {
  geoJSON: am5geodata_worldLow,
  exclude: ["AQ"]
}));

// Create point series
var pointSeries = chart.series.push(am5map.MapPointSeries.new(root, {
  latitudeField: "lat",
  longitudeField: "long"
}));

pointSeries.bullets.push(function() {
  var circle = am5.Circle.new(root, {
    radius: 5,
    fill: am5.color(0xff0000),
    tooltipText: "{name}"
  });

  circle.events.on("click", function(ev) {
    alert("Clicked on " + ev.target.dataItem.dataContext.name)
  });

  return am5.Bullet.new(root, {
    sprite: circle
  });
});

pointSeries.data.setAll([{
  long: -73.778137,
  lat: 40.641312,
  name: "New York"
}, {
  long: -0.454296,
  lat: 51.470020,
  name: "London"
}, {
  long: 116.597504,
  lat: 40.072498,
  name: "Beijing"
}]);

}); // end am5.ready()
</script>

</head>
<body>
<section>
	<div id="chartdiv"></div>
		<div class="section_wrap">
			<!-- 지도api -->
			<div class="canvas_wrap">
				<canvas id="canvas"></canvas>
			</div>
			
			<div class="main_center">			
				<!-- 게시판영역 -->
			<div class="canvas_wrap">
				<canvas id="canvas"></canvas>
			</div>
			<div class="main_center">
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
			<script type="text/javascript" src="https://w.fxexchangerate.com/converter.php?fm=USD&ft=EUR&lg=kr&am=1&ty=1"></script>
		</div>
		<!--  End of Currency Converter Script -  FxExchangeRate.com -->
	</div>
	</section>
</body>
</html>