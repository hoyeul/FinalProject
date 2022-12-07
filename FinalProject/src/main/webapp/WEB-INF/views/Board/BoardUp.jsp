<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
* {
    padding: 0px;
    margin: 0px;
}

table, td {
    border: none;
    /*border: 1px solid black;*/
    text-align: center;
    border-collapse: collapse;
}
table{
width: 800px;
margin: 0px auto;
border-bottom: 3px solid  #ef3e61;
}

caption{
    padding: 15px;
    font-size: 24px;
    font-weight: 800;
}

a {
	text-decoration: none;
	color: black;
}
/*============================================================================*/
.board-order{
    font-size: 15px;
    font-weight: bold;
    

}
.board-order td{
    padding: 10px;
    border-top: 3px solid  #ef3e61;
    border-bottom: 2px solid  #ef3e61;
    border-left: 1px dashed #ef3e61;

}
.board-order__item td {
    border-top: 1px solid  #ef3e61;
    border-left: 1px dashed #ef3e61;
    padding: 5px 0px;
    margin: 5px 0px;
}
.board-order__item td:first-child,
.board-order td:first-child{
    border-left: none;
}

.enter__btn {
    height: 50px;
    padding: 10px;
    text-align: right;
    border-bottom: 3px solid  #ef3e61;
    border-top: 2px solid  #ef3e61;
  }

.enter__btn button {
    width: 100px;
    height: 40px;
    margin-right: 10px;
    font-size: 16px;
    font-weight: 700;
    border: none;
    border-radius: 15px;
    color: white;
    background-color: #ef3e61;
}
textarea{
width:800px;
resize:none;
padding:15px;
outline:none;
}
</style>
<body>
<form action="/Controller/boardUp" method="post">
 <table>
            <caption>게시판</caption>
            <tr class="board-order">
                <td>번호</td>
                <td>대륙</td>
                <td>종류</td>
                <td>제목</td>
                <td>작성자</td>
                <td>날짜</td>
                <td>조회</td>
            </tr>

        <tr class="board-order__item">
            <td><input type=number value="${a.num}" name="num" readonly="readonly"></td>
            <td><input type=text value="${a.continent}" name="continent"></td>
            <td><input type=text value="${a.select}" name="select"></td>
            <td><input type=text value="${a.title}" name="title"></td>
            <td>${a.id}</td>
            <td>${a.date}</td>
            <td>${a.number}</td>
       </tr>
       <tr>
            <td  class="enter__btn" colspan="8">
              <textarea name="text"> ${a.text}</textarea>
            </td>
       </tr>
        <tr >
            <td  class="enter__btn" colspan="8">
                <button>수정완료</button>            
            </td>
        </tr>
        </table>
 </form>
</body>
</html>