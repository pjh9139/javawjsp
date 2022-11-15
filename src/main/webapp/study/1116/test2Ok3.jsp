<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	 
	String strVo = request.getParameter("vo");
	System.out.println("strVO :"+ strVo);
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
  <h2>이곳은 test2Ok3.jsp입니다.</h2>
	<p>
		<%-- strVo : <%=strVo%> --%>
	</p>  
  <p><br/></p>
  <p><a href="test2.jsp">돌아가기</a></p>
  <p><br/></p>
  </div>
</body>
</html>