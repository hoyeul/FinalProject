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
   <option value="0" selected="selected">��ǰ�� ����</option>
   <option value="1">TGDŬ���� 500ml</option>
   <option value="2">TGDŬ��ŰƮ</option>
   <option value="3">TGDŬ����</option>
</select>
>
<select id="mallSelect">
   <option value="0">�ǸŸ� ����</option>
   <option value="500-OWN" class="mall1">Ʈ���</option>
   <option value="500-WM" class="mall1">������</option>
   <option value="kit-OWN" class="mall2">Ʈ���</option>
   <option value="pack-OWN" class="mall3">Ʈ���</option>
</select>

</body>
</html>