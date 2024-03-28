<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>선수 등록</title>
</head>
<body>

	<main>
	
	
		<h1>선수 등록</h1>
	
		<form action="/insert" method="post" onsubmit="return validate()">
	
			<p>선수 이름</p>
			<input type="text" name="inputName" id="inputName" required>
			<span id="nameMessage"></span>
		
			<p>나이</p>
			<input type="number" name="inputAge" id="inputAge" required>
		
			<p>소속팀</p>
			<input type="text" name="inputTeam" id="inputTeam" required>
		
			<p>국적</p>
			<input type="text" name="inputNationality" id="inputNationality" required>
		
			<br><br>
		
			<button>선수 등록하기</button>
	
		</form>
	
	</main>
	
	<script src="/resources/js/insert.js"></script>


</body>
</html>