<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>login.jsp</title>
  <jsp:include page="../../include/BS4.jsp"></jsp:include>
</head>
<body>
  <p><br/></p>
  <div class="container">
  	<form name="myform" method="post" action="${pageContext.request.contextPath}/database/LoginOk">
  		<div class="table table-bordered text-center">
  		<div class="row">
  			<div class="col-xl-12 pt-3">
  				<p>로그인</p>
  			</div>
  		</div>
  		<div class="row">
  			<div class="col-md-3 pt-3"><p>아이디</p></div>
  			<div class="col-md-9">
  				<input type="text" name="mid" value="${mid}" autofocus required class="form-control"/>
				</div>
  		</div>
  		<div class="row">
  			<div class="col-md-3 pt-3"><p>비밀번호</p></div>
  			<div class="col-md-9">
  				<input type="password" name="pwd" required class="form-control"/>
  			</div>
  		</div>
  		<div class="row">
  			<div class="col-4">
  				<input type="submit" value="로그인" class="btn btn-success form-control"/>
  			</div>
  			<div class="col-4">
  				<input type="reset" value="다시입력" class="btn btn-warning form-control"/>
  			</div>
  			<div class="col-4">
  				<input type="button" value="회원가입" onclick="location.href='join.jsp'" class="btn btn-primary form-control"/>
  			</div>
  		</div>
  		</div>
  	</form>
  </div>
  <p><br/></p>
</body>
</html>