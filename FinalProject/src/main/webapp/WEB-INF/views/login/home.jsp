<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<section>
<c:choose>
<c:when test="${sessionID ne null }"><a href="/Controller/logout">로그아웃</a></c:when>
<c:otherwise><a href="/Controller/login">로그인</a></c:otherwise>
</c:choose>
<a href="/Controller/exchange">환율</a>
</section>
