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
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="${path}/resources/js/Board/board.js">
</script>
<link rel="stylesheet" href="${path}/resources/css/Board/board.css">

<body>
<section>
<div class="boardwrap">
	<form name="frm" action="/FinalProject/board" method="get">
		<div class="board_head">
			<a href="/FinalProject/board">전체 게시판</a>	
		</div>
		<div class="board_nav">
			<div class="board_all"><a href="" class="first_a">인기</a></div>
			<div class="tb_nav">
	  			<input type="radio" class="radio" id="전체" name="continent" value="" onclick="location='/FinalProject/board'"checked>
	            <input type="radio" class="radio" id="아시아" name="continent" value="아시아" onclick="location='/FinalProject/board?continent=아시아'" checked>
	            <input type="radio" class="radio" id="아프리카" name="continent" value="아프리카" onclick="location='/FinalProject/board?continent=아프리카'" checked>
	            <input type="radio" class="radio" id="유럽" name="continent" value="유럽" onclick="location='/FinalProject/board?continent=유럽'" checked>
	            <input type="radio" class="radio" id="오세아니아" name="continent" value="오세아니아" onclick="location='/FinalProject/board?continent=오세아니아'" checked>
	            <input type="radio" class="radio" id="북아메리카" name="continent" value="북아메리카" onclick="location='/FinalProject/board?continent=북아메리카'" checked>
	            <input type="radio" class="radio" id="남아메리카" name="continent" value="남아메리카" onclick="location='/FinalProject/board?continent=남아메리카'" checked>
			    <label for="전체">전체</label>
			    <label for="아시아">아시아</label>
			    <label for="아프리카">아프리카</label>
			    <label for="유럽">유럽</label>
			    <label for="오세아니아">오세아니아</label>
			    <label for="북아메리카">북아메리카</label>
			    <label for="남아메리카">남아메리카</label>
			</div>
		</div>
		<table class="mainboard">

            <tr>
                <td style="width:10%;"></td>
                <td style="width:60%;">제목</td>
                <td>작성자</td>
                <td>날짜</td>
                <td>조회수</td>
                <td>추천수</td>
            </tr>
			<c:forEach var="item" items="${list}">
	        <tr>
	            <td>${item.num2}</td>
	            <td style=" text-align: left;">
		            <span class="b_con">[${item.continent}] </span>
		            <span class="b_sel">[${item.select}] </span>
		            <a href="boardIn?num=${item.num}&number=${item.number}">${item.title}</a>
	            </td>
	            <td>${item.id}</td>
	            <td style="">${item.date}</td>
	            <td>${item.number}</td>
	            <td>${item.recommend}</td>
	        </tr> 
			</c:forEach>
		</table>
		<div class="page-move-button-wrap">
			<div class="p-g-b-inner-wrap">
		        <%
				 int currentPage=1;
				 if( request.getAttribute("p") != null){
				 	 currentPage  =(Integer) request.getAttribute("p");
				 }
				 int countpage  =(Integer) request.getAttribute("a");
				 int totRecords =countpage ; 
				 int pageSize = 10; 
				 int totalPage;               	 
				 int grpSize = 5;             
				 int currentGrp = 0;  	  	 	 
				 int reamin = totRecords  %  pageSize ;		 
				 if( reamin == 0 )
					 totalPage = totRecords / pageSize;		 
				 else 
					 totalPage = totRecords / pageSize +1;
				 int remain2 = currentPage % grpSize;    
				 if( remain2 == 0 )
					 currentGrp  = currentPage  / grpSize ;     		 
				 else 
					 currentGrp = currentPage  / grpSize  +1;   	 
				 int grpStartPage = ( currentGrp -1 ) * grpSize +1 ;  
				 int grpEndPage = currentGrp * grpSize;                
				 if( grpEndPage > totalPage){
					 grpEndPage = totalPage;    
				 }	 	 
				 int index = grpStartPage;	 
				 if( currentGrp >1){
			 	%>		 
				 <button class="movepage-btn" name="page" value="<%=index-1 %>">＜이전</button> 	    
				 <%
				 } 	 
				 while( index <= grpEndPage){		 
				 %>
				 	<button class="pagebtn" name="page" value="<%=index%>"><%=index %> </button>
			        <%
					  index ++;       
				 }	 
				 if( index <= totalPage){%>	
				 <button class="movepage-btn" name="page" value="<%=index %>">다음＞</button>
				<% }
				%>
			</div>
		</div>
       	<div class="search_wrap">
       		<div class="search_area">
       			<div class="search-inner-area">
		     		<select name="selecttype" value="${type}">
		            		<option value="">전체</option>
		            		<option value="자유">자유</option>
		            		<option value="질문">질문</option>
		            		<option value="후기">후기</option>
		            		<option value="정보">정보</option>
		     		</select>
		     		<select name="selectcontent" value="${content}">
		              		<option value="">전체</option>
		              		<option value="제목">제목/내용</option>
		              		<option value="작성자">작성자</option>
	  				</select>	
	       			<input type = text name="text" value="${text}">
	       			<button class="search-btn-area"><img class="search-img" alt="" src="<c:url value="resources/image/searchIcon.png"/>"></button>
      				</div>
      			</div>
        	</div>
<input type="hidden" name="selecttypeH" value="${type}">
<input type="hidden" name="selectcontentH" value="${content}">
<input type="hidden" name="continentH" value="${continent}">
<input type="hidden" name="sessionId" value="${sessionID }" id="user_id">
	</form>
	<div class="edit-btn">
		<button type="button" onclick="boardregbtn()">글쓰기</button>
	</div>
</div>
</section>
</body>
</html>