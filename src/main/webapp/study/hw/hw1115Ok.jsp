<%@page import="hw.hw1115VO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	hw1115VO vo = (hw1115VO)request.getAttribute("vo");
%>	

<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>title</title>
	<%@ include file="../../include/BS4.jsp" %>
</head>
<body>
  <p><br/></p>
  <div class="container">
  	이곳은 hw11155Ok.jsp파일입니다.
  	
  	<p>vo값 : ${vo}</p>
  	<p>주문자명 : ${vo.name}</p>
  	<p>주문품목 : ${vo.classification}</p>
  	<p>상품명 : ${vo.products[0]},${vo.products[1]}</p>
  	<p>상품수 : ${vo.strprice[0]},${vo.strprice[1]}</p>
  	<p>상품가격 : ${vo.strnumber[0]},${vo.strnumber[1]}</p>
  	<p>총가격 : ${vo.total}</p>
  	<p>상품추가 수 : ${vo.cnt}</p>
  <p><br/></p>
  </div>
  <p><br/></p>
</body>
</html>