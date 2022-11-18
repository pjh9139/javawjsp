<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>회원가입</title>
  <jsp:include page="../../include/BS4.jsp"></jsp:include>
  <script>
  	'use strict';
  	
  	function fCheck() {
  		const regsu = /^[a-zA-Z0-9가-힣]{1,20}$/g
  		const regBlank = /\s/g;
  		
  		/* 폼의 내용을 가져와서 유효성 검사...(아이디/비밀번호/성명은 모두 20자 이하...)) */
  		let mid = document.getElementById("mid").value;
  		let pwd = document.getElementById("pwd").value;
  		let name = document.getElementById("name").value;
  		
  		
  		if(mid.trim()==""||pwd.trim()==""||name.trim()==""){
  			alert("모든창을 입력하세요...");
  			return false;
  		}
  		else if(regBlank.test(mid)||regBlank.test(pwd)||regBlank.test(name)){
  			alert("입력창에 ' ',공백은 넣을수 없습니다");
  			return false;
  		}
  		else if(!regsu.test(mid)){
  			alert("입력창은 최대 20자만 가능합니다");
  			return false;
  		}
  		else{
  			 myform.submit();
  		}
  	}
  </script>
</head>
<body>
  <p><br/></p>
  <div class="container">
  	
  	  <div class="border text-center">
  	<form name="myform" method = "post" action="${pageContext.request.contextPath}/database/JoinOk">
  		<div class="row m-10">
	  		<div class="col-12">회원가입</div>
  		</div>
  		<div class="row m-3">
	  		<div class="col-3">아이디</div>
	  		<div class="col-9"><input type="text" name="mid" id="mid" required autofocus class="form-control"/></div>
  		</div>
  		<div class="row m-3">
	  		<div class="col-3">비밀번호</div>
	  		<div class="col-9"><input type="password" name="pwd" id="pwd" required class="form-control"/></div>
  		</div>
  		<div class="row m-3">
	  		<div class="col-3">성명</div>
	  		<div class="col-9"><input type="text" name="name" id="name" required class="form-control"/></div>
  		</div>
		  <hr/>
		  <div class="row">
		    <div class="col">
		    <input type="button" onclick="fCheck()" value="전송" class="btn btn-success form-control">
		    </div>
		    <div class="col"><input type="reset" value="다시입력" class="btn btn-warning form-control"></div>
		    <div class="col"><input type="button" onclick="location.href='${pageContext.request.contextPath}/study/1120_Database/login.jsp';" value="돌아가기" class="btn btn-danger form-control"></div>
		  </div>
		  <br/>
		  <br/>
  	</form>
  </div>
  	
  </div>
  <p><br/></p>
</body>
</html>