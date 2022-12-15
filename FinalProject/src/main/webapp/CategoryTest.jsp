<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script type="text/javascript">
var malls = false;

function update_selected() {
  $("#mallSelect").val(0);
  $("#mallSelect").find("option[value!=0]").detach();

  $("#mallSelect").append(malls.filter(".mall" + $(this).val()));
}

$(function() {
  malls = $("#mallSelect").find("option[value!=0]");
  malls.detach();

  $("#productSelect").change(update_selected);
  $("#productSelect").trigger("change");
});

</script>

</head>
<body>
						
<select id="productSelect">
   <option value="0" selected="selected">제품군 선택</option>
   <option value="1">TGD클리너 500ml</option>
   <option value="2">TGD클린키트</option>
   <option value="3">TGD클린팩</option>
</select>
>
<select id="mallSelect">
   <option value="0">판매몰 선택</option>
   <option value="500-OWN" class="mall1">트라움샵</option>
   <option value="500-WM" class="mall1">위메프</option>
   <option value="kit-OWN" class="mall2">트라움샵</option>
   <option value="pack-OWN" class="mall3">트라움샵</option>
</select>

</body>
</html>