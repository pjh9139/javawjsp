<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>test1.jsp</title>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
</head>
<!-- 로그인창에서 '아아디/비밀번호/성명'을 입력후
		 서버로 전송후, 관리자 인증이 되면 인증성공창에서 입렵된
		 '아이디/성명'을 모두 출력하시오.
 -->
<body>
  <p><br/></p>
  <div class="container">
  <form name="myform" method="post" action="test1Ok.jsp">
  	<div><h2 class="text-center">로 그 인</h2></div>
  	<p>
  		아이디 : <input type="text" name="mid" id="mid" value="admin" autofocus required class="form-control"/>
  	</p>
  	<p>
  		비밀번호 : <input type="password" name="pwd" id="pwd" value="1234" class="form-control"/>
  	</p>
  	<p>
  		성명 : <input type="text" name="name" id="name" value="홍길동" class="form-control"/>
  	</p>
  	<div class="row text-center">
  		<div class='col-6'><input type="submit" value="전송" class="btn btn-success form-control"/></div>
  		<div class='col-6'><input type="reset" value="다시입력" class="btn btn-warning form-control"/></div>
  	</div>
  </form>
  	
  <p><br/></p>
  </div>
  <p><br/></p>
</body>
</html>