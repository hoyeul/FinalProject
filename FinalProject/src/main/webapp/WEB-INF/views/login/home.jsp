<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="path" value="${pageContext.request.contextPath }"></c:set>
<link rel="stylesheet" href="${path}/resources/css/home.css">
<section>

<!-- Currency Converter Script - FxExchangeRate.com  -->
<div class="Currency_Converter" style="width:248px;height:auto;border:1px solid #2D6AB4;text-align:center;font-size:16px;font-family:sans-serif,Arial,Helvetica;border-top-right-radius:5px; border-top-left-radius:5px;background-color:#FFFFFF;">
	<div style="width:100%; height:24px;padding:5px 0px 0px 0px;background-color:#2D6AB4;font-weight:bold;">
		<a rel="nofollow" style="color:#FFFFFF;text-decoration:none;" href="https://www.fxexchangerate.com/">Currency Converter</a>
	</div>
	<script type="text/javascript" src="https://w.fxexchangerate.com/converter.php?fm=USD&ft=EUR&lg=kr&am=1&ty=1"></script>
</div>
<!--  End of Currency Converter Script -  FxExchangeRate.com -->

</section>