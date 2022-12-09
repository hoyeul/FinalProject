<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.FinalProject.Model.Board.BoardDao" %>
<c:set var="path" value="${pageContext.request.contextPath }"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" href="${path}/resources/css/board.css">

<body>

<section>
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
        <tr >
            <td class="enter__btn" colspan="7">
               <a href="/Controller/boardreg"><button>등록</button></a>
            </td>
        </tr>
	</table>
</section>
<%
	int currentPage=1;
	if( request.getAttribute("p") != null){
		 currentPage  =(Integer) request.getAttribute("p");
	}
 
	
     
	 int totRecords =5 ; // 총 레코드 수 
	 int pageSize =2;    //페이지 사이즈  (데이터 건수 , 한 페이징 보이는 레코드 수 )
	 	 
 
	 
	 int totalPage;             // 총 페이지수: 전체 페이수   	 
	 int grpSize=5;             // 한 그룹에 5깨씩 보겟다
	 int currentGrp =0;  	    // 현재그룹
	// int currentPage =1;
	 	 
	 
	 int reamin = totRecords  %  pageSize ;		 
	 //총 페이지수 구하기
	 if( reamin ==0 )
		 totalPage = totRecords / pageSize;
		 
	 else 
		 totalPage = totRecords / pageSize +1;
	     
	  
	 
	 // 현재그룹 구하기
	 // 현재그룹의 시작번호
	 // 현재그룹의 끝번호
	 int remain2 = currentPage % grpSize;    // 7 => 그룹2  ,  시작 6 , 끝 10
	 
	 
	 if( remain2 ==0 )
		 currentGrp  = currentPage  / grpSize ;     //  10 /5 =>2  , 2번째 그룹 
		 
	 else 
		 currentGrp = currentPage  / grpSize  +1;   //  4 /5 + 1 => 1번째 그룹 ,  7 /5 => 1 +1 => 2그룹 
	 
		 
	 int grpStartPage = ( currentGrp -1 ) * grpSize +1 ;  // 그룹의 시작번호   현재그룹 1 => 1  , 현재그룹 2 -> 6
	 int grpEndPage = currentGrp * grpSize;               // 그룹의 끝번호    1-> 5  , 2-> 10
	 
	 
	 if( grpEndPage > totalPage){
		 grpEndPage = totalPage;    // 그룹의 끝번호   10 -> 9로 변경 , 그룹의 끝번호가 마지막페이지번호 크다면
	 }
	 
	 
	 int index = grpStartPage;
	 
	 if( currentGrp >1){	%>
		 
	     <a href="/Controller/board?p=<%=index-1%>">[ 이전 ]</a>  
	    
	 <%   
	 } 
	 
	 while( index <= grpEndPage){		 
	 %>
		  <a href="/Controller/board?p=<%=index%>">[  <%=index %> ]</a> 
        <%
		  index ++;
        
	 }
	 
	 if( index <= totalPage){%>
	
		   <a href="/Controller/board?p=<%=index%>">[ 다음 ]</a>  
	<% }
	%>
</body>
</html>