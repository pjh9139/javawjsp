<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>loginMember</title>
  <jsp:include page="../../include/BS4.jsp"></jsp:include>
  <script >
  	'use '
 		function searchMid() {
    	let mid = prompt("찾고자 하는 아이디를 입력하세요?")
    	location.href="${pageContext.request.contextPath}/database/SearchMid?mid="+mid;
    }
  </script>
</head>
<body>
  <p><br/></p>
  <div class="container">
  	<h2>회원전용방</h2>
  	<p><font color="blue">${sName}</font>님 로그인 중이십니다.</p>
  	<hr/>
  	<p><img src="${pageContext.request.contextPath}/img/짱구.png" width="300px"></p>
  	<hr/>
  	<p>
  		현재 보유중인 포인트 : ${point} <br/>
  		최종 방문일자 : <font color='red'><b>${sLastDate}</b></font><br/>
  	</p>
  	<div class = "row">
	  	<div class = "col"><p><a href="javascript:searchMid()" class="btn btn-info form-control">회원 개별조회</a></p></div>
	  	<div class = "col"><p><a href="${pageContext.request.contextPath}/database/MemberList" class="btn btn-info form-control">회원 전체조회</a></p></div>
	  	<div class = "col"><p><a href="${pageContext.request.contextPath}/database/LogOut" class="btn btn-success form-control">로그아웃</a></p></div>
  	</div>
  	<hr/>
  </div>
  <p><br/></p>
</body>
</html>