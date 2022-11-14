<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>숙제</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
  <script>
      'use strict'
      function fCheck() {
        let name = myform.name.value;
        let age = myform.age.value;
        let email = myform.email.value;
        let com = myform.com.value;
        let birthday = myform.birthday.value;
        let hobby = myform.hobby.value;
        
        if(name == ""){
            alert("이름을 입력하세요");
            myform.name.focus();
            return false;
        }
        else if(age == ""){
            alert("나이를 입력하세요");
            myform.age.focus();
            return false;
         }
        else if(email == ""){
            alert("이메일을 입력하세요");
            myform.age.focus();
            return false;
        }
        else if(com == ""){
            alert("제대로된 도메인을 선택해주세요");
            myform.age.focus();
            return false;
        }
        else if(birthday == ""){
            alert("생년월일을 입력하세요");
            myform.birthday.focus();
            return false;
         }
/*         else if(hobby == ""){
            myform.hobby.value = "선택없음"
         } */
        else{
            myform.submit();
        }
    }
  </script>
</head>
<body>
  <p><br/></p>
  <div class="container">
      <h2>값 전송하기 (숙제)</h2>
      <form name="myform" method="post" action="../../test12Ok">
          성명 : <input type="text" name="name" class="form-control"/>
          나이 : <input type="number" name="age" class="form-control"/>
          <div>
          <div>
              이메일
                <input type="email" name="email" size="10" id ="email" /> @ 
                  <select name="com" id="com">
                  <option value="" selected>도메인 선택</option>
                  <option value="naver.com">naver.com</option>
                  <option value="anmail.net">hanmail.net</option>
                  <option value="daum.net">daum.net</option>
                  <option value="nate.net">nate.net</option>
                  <option value="gmail.com">gmail.com</option>
                  </select>              
          </div>
          성별 :     <input type="radio" name="gender" value="남자" checked/>남자
                      <input type="radio" name="gender" value="여자" />여자
                      <input type="radio" name="gender" value="미공개" />미공개
          </div>
          생년월일 : <input type="date" name="birthday" id="birthday"/>
 
          <div>
              취미 : 
                      <input type="checkbox" name="hobby" value="등산">등산
                      <input type="checkbox" name="hobby" value="낚시">낚시
                      <input type="checkbox" name="hobby" value="독서">독서
                      <input type="checkbox" name="hobby" value="게임">게임
                      <input type="checkbox" name="hobby" value="커피">커피
          </div>
          <input type="reset" value="다시입력" class ="btn btn-warning"/>
          <input type ="button" value="전송" onclick="fCheck()" class = "btn btn-success"/>
      </form>
  <p><br/></p>
  </div>
  <p><br/></p>
</body>
</html>
