<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>title</title>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
</head>
<body>
  <p><br/></p>
  <div class="container">
  	<h2>컨트롤러가 2개 이상의 URL 제어 연습</h2>
  	<p>1개의 폼안에서 POST/GET 방식의 제어</p>
  	<hr/>
  	<%-- <form name="myform" method="post" action="<%=request.getContextPath()%>/j1114_Test5"> --%>
  	<form name="myform" method="post" action="<%=request.getContextPath()%>/j1114_T5">
	  	<p>
	  		<input type="submit" value="전송(submit:post방식)"  class="btn btn-success"/>
	  		<input type="button" value="전송(Location:get방식)" onclick="location.href='<%=request.getContextPath()%>/j1114_Test5';" class="btn btn-primary"/>
			</p>
			<input type="hidden" name="name" value="홍길동" />
		</form>
  </div>
  <p><br/></p>
</body>
</html>