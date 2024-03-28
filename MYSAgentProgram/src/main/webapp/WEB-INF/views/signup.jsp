<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>회원가입</title>
</head>
<body>

	<main>
	
		<h1>회원가입</h1>
		
		<form action="/signup" method="post" onsubmit="return validate()">
		
			<p>아이디</p>
			<input type="text" name="inputId" id="inputId" required>
		
			<p>비밀번호</p>
			<input type="password" name="inputPw" id="inputPw" required>
		
			<p>비밀번호 확인</p>
			<input type="password" name="inputPw2" id="inputPw2" required>
			<span id="pwMessage"></span>
			
			<p>이름</p>
			<input type="text" name="inputName" id="inputName" required>
			<span id="nameMessage"></span>
			
			<p>E-mail</p>
			<input type="email" name="inputEmail" id="inputEmail" required>

			<br>
			
			<button>가입하기</button>
		</form>
	
	
	</main>

	<script src="/resources/js/signup.js"></script>

</body>
</html>