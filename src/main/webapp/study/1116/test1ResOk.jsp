<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
  request.setCharacterEncoding("utf-8");

	String mid = request.getParameter("mid")==null ? "" : request.getParameter("mid");
	String name = request.getParameter("name")==null ? "" : request.getParameter("name");
	String flag = request.getParameter("flag")==null ? "" : request.getParameter("flag");
%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>test1Res.jsp</title>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
</head>
<body>
  <p><br/></p>
  <div class="container">
  	<h2>이곳은 최종 목적지 입니다..</h2>
  	<p>아이디 : <%=mid %></p>
  	<p>성명 : <%=name %></p>
  	<p>flag : <%=flag %></p>
  	<p><a href="test1.jsp" class="btn btn-success">돌아가기</a></p>
  <p><br/></p>
  </div>
  <p><br/></p>
</body>
</html>