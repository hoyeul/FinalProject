<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<style type="text/css">
body {
  width: 100vw;
  height: 100vh;
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
	<canvas id="canvas"></canvas>
</body>
</html>