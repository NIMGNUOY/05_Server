<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	
	<link rel="stylesheet" href="/resources/css/update.css">
	
	<title>선수 정보 수정 페이지</title>
</head>
<body>

	<main>
	
		<span class="updateTitle">선수 정보 수정</span>
		
		<form action="/update" method="post">
		
			<p>* TEAM</p>
			<input type="text" name="inputTeam" value="${player.playerTeam}" class="input">
			
			<p>* BACKNUMBER</p>
			<input type="number" name="inputBackNumber" value="${player.playerBackNum}" class="input">
			
			<p>* MEMO</p>
			<textarea name="memo" style="resize:none; font-size: 15px;" cols="30" rows="5"  class="input">${player.playerMemo}</textarea>
			
			<p>* MEDICAL CHECK</p>
			Y <input type="radio" name="medicalCheck" value="Y">
			N <input type="radio" name="medicalCheck" value="N">
			
			<input type="hidden" name="playerNo" value="${player.playerNo}">
			
			<br><br>
			
			<button class="btn">수정하기</button>
		
		</form>
	
	</main>

</body>
</html>