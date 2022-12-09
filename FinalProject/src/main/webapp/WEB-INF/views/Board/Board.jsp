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

<link rel="stylesheet" href="${path}/resources/css/board.css">

<body>

<section>
<form name="frm" action="/Controller/board" method="get">
<div>
              		<button name="continent" value="all">전체</button>
	                <button name="continent" value="아시아">아시아</button>
	                <button name="continent" value="아프리카">아프리카</button>
	                <button name="continent" value="유럽">유럽</button>
	                <button name="continent" value="오세아니아">오세아니아</button>
	                <button name="continent" value="북아메리카">북아메리카</button>
	                <button  value="남아메리카">남아메리카</button>
</div>
	<table>
		<caption>문의 게시판</caption>
            <tr class="board-order">
                <td>번호</td>
                <td>대륙</td>
                <td>종류</td>
                <td>제목</td>
                <td>작성자</td>
                <td>날짜</td>
                <td>조회수</td>
            </tr>
<c:forEach var="item" items="${list}">
        <tr class="board-order__item">
            <td>${item.num2}</td>
            <td>${item.continent}</td>
            <td>${item.select}</td>
            <td><a href="boardIn?num=${item.num}&number=${item.number}">${item.title}</a></td>
            <td>${item.id}</td>
            <td>${item.date}</td>
            <td>${item.number}</td>
        </tr> 
</c:forEach>
        <tr>
        <td colspan="7">
        <%
	int currentPage=1;
	 if( request.getAttribute("p") != null){
	 	 currentPage  =(Integer) request.getAttribute("p");
	 }
	 int countpage  =(Integer) request.getAttribute("a");
	 int totRecords =countpage ; 
	 int pageSize =10; 
	 int totalPage;               	 
	 int grpSize=5;             
	 int currentGrp =0;  	  	 	 
	 int reamin = totRecords  %  pageSize ;		 
	 if( reamin ==0 )
		 totalPage = totRecords / pageSize;		 
	 else 
		 totalPage = totRecords / pageSize +1;
	 int remain2 = currentPage % grpSize;    
	 if( remain2 ==0 )
		 currentGrp  = currentPage  / grpSize ;     		 
	 else 
		 currentGrp = currentPage  / grpSize  +1;   	 
	 int grpStartPage = ( currentGrp -1 ) * grpSize +1 ;  
	 int grpEndPage = currentGrp * grpSize;                
	 if( grpEndPage > totalPage){
		 grpEndPage = totalPage;    
	 }	 	 
	 int index = grpStartPage;	 
	 if( currentGrp >1){	%>		 
	 <button name="page" value="<%=index-1 %>">이전  </button> 	    
	 <%   
	 } 	 
	 while( index <= grpEndPage){		 
	 %>
	 	<button name="page" value="<%=index %>"><%=index %> </button>
        <%
		  index ++;       
	 }	 
	 if( index <= totalPage){%>	
	 <button name="page" value="<%=index %>">다음 </button>

	<% }
	%>
        </td>
        </tr>
        <tr>
         <td colspan="7">
	     	<select name="selecttype" >
	                		<option value="all">전체</option>
	                		<option value="자유">자유</option>
	                		<option value="질문">질문</option>
	                		<option value="후기">후기</option>
	                		<option value="정보">정보</option>
	     	</select>
	     <select name="selectcontent">
	                		<option value="all">전체</option>
	                		<option value="제목">제목/내용</option>
	                		<option value="작성자">작성자</option>
	     	</select>	
         <input type =text name="text" value="${text}"><<button>검색</button>
         </td>
        </tr>
        </table>
        </form>
        <table>
            <tr >
            <td class="enter__btn" colspan="7">
               <a href="/Controller/boardreg"><button>등록</button></a>
            </td>
        </tr>
        </table>
</section>
</body>
</html>