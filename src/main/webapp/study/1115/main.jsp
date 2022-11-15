<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String sw = request.getParameter("sw")==null? "" : request.getParameter("sw");
%>

<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>title</title>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
  <style>
    body {
      width: 1000px;
      margin: 0px auto;
      padding: 0px;
    }
    #header {
      background-color: aqua;
      text-align: center;
      height: 85px;
    }
    #footer {
      background-color: #ccc;
      text-align: center;
      height: 75px;
    }
    #content {
	    background-color: #fff;
      text-align: center;
    }
  </style>
</head>
<body>
  <div class="container">
		<!-- 헤더영역('메뉴/로고')를 표시한다. -->
		<div id="header">
			<%@ include file="menu.jsp" %>
		</div>
		<!-- 본문영역 -->
		<div id="content">
			<br/>
			<%if(sw.equals("guest")){ %>
				<%@ include file="guest.jsp" %>
			<%} else if(sw.equals("borad")) { %>	
				<%@ include file="board.jsp" %>
			<%} else if(sw.equals("pds")) { %>	
				<%@ include file="pds.jsp" %>
			<%} else if(sw.equals("photo")) { %>	
				<%-- <%@ include file="photo.jsp" %> --%>
				<jsp:include page="photo.jsp"></jsp:include>
			<%} else { %>	
				<h2>이곳은 메인 화면 입니다.</h2>		
				<br/>
				<p><img src="../../img/짱구.png"></p>
			<%} %>	
			<br/>
		</div>
		<!-- 푸터영역 -->
		<div id="footer">
			<%@ include file="footer.jsp" %>
		</div>
  <p><br/></p>
  </div>
  <p><br/></p>
</body>
</html>