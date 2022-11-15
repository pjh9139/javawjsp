<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>test4</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
  <script>
    'use strict';
    let cnt = 1;
    
    $(document).ready(function (){                
      $('#addproduct').click (function (){
    	  cnt++;
        $('#addDiv').append (
	      	'<b>상품명 : </b><input type="text" id="product'+cnt+'" name="product" style="width:60px; height:20px;"/>'+
	      	'<b> 수 량 : </b><input type="number" id="'+cnt+'" name="number" style="width:60px; height:20px;"/>'+
	      	'<b> 금 액 : </b><input type="number" id="'+cnt+'" name="price" style="width:60px; height:20px;"/>'+
	      	'   '+'<button type="button" class="btnRemove btn-danger">삭제</button><br/>'
          );                     
          $('.btnRemove').on('click', function () { 
          $(this).prev().remove();   
          $(this).prev().remove();  
          $(this).prev().remove(); 
          $(this).prev().remove(); 
          $(this).prev().remove(); 
          $(this).prev().remove();
        	$(this).next().remove();    // <br> 삭제
        	$(this).remove();           // 버튼삭제
       		});
      	});                                      
   		});
    
    
    function fCheck() {
    	let product1 = document.getElementById("product1").value;
    	
    	if(product1 == "") {
    		alert("첫번째 상품은 꼭 등록하셔야 주문이 완료됩니다.");
    		document.getElementById("product1").focus();
    	}
    	else {
    		myform.submit();
    	}
    }
  </script>
</head>
<body>
<p><br/></p>
<div class="container">
  <h2>상 품 등 록</h2>
  <form name="myform" method="post" action="<%=request.getContextPath()%>/j1114/Test4Ok">
  	<p>구매자 : <input type="text" name="name" id="name" autofocus /></p>
  	<div>
  		상품분류 : <select class="form-contorl mb-2" id="Classification" name="Classification">
	      <option value="">선택하세요</option>
	      <option value="의류">의류</option>
	      <option value="식품">식품</option>
	      <option value="생필품">생필품</option>
	      <option value="가전제품">가전제품</option>
	      <option value="디지털">디지털</option>
  		</select>
  	</div>
    <input type="button" value="상품추가" id="addproduct" class="btn btn-success" width="500px" />
    
    <div id="addDiv">
	  	<b>상품명 : </b><input type="text" id="product1" name="product"  style="width:60px; height:20px;"/>
	    <b>수 량 : </b><input type="number" id="price1" name="price" style="width:60px; height:20px;"/>
	    <b>금 액 : </b><input type="number" id="number1" name="number" style="width:60px; height:20px;"/><br/>
    </div>
    <p>
      <input type="button" value="전송" onclick="fCheck()"/>
      <input type="reset" value="취소"/>
    </p>
  </form>
</div>
<p><br/></p>
</body>
</html>