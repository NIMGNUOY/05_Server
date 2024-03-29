<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>선수 상세 정보 조회 페이지</title>
	<script src="https://kit.fontawesome.com/fa0ef5fd68.js" crossorigin="anonymous"></script>
	<link rel="stylesheet" href="/resources/css/detail.css">
</head>
<body>

	<main>
	
		<span class="detailTitle">${sessionScope.player.playerName} 선수 상세 정보 조회</span>
		
		<main>
		
			<div class="container">
				<div class="uniform">
					<i class="fa-solid fa-shirt" id="uniformimg"></i>
					<p class="backNum">${sessionScope.player.playerBackNum}</p>
				</div>
				
				<div class="info">
				
					<p>NAME : ${sessionScope.player.playerName}</p>
					<p>AGE : ${sessionScope.player.playerAge}</p>
					<p>TEAM : ${sessionScope.player.playerTeam}</p>
					<p>NATIONALITY : ${sessionScope.player.playerNationality}</p>
					<p>MEDICAL CHECK : ${sessionScope.player.medicalCheck}</p>
					<p>AGENT : ${sessionScope.loginAgent.agentName}</p>
					
					<fieldset>
						<legend>MEMO</legend>
						
						<p>${sessionScope.player.playerMemo}</p>
					</fieldset>
				
				</div>
			</div>
		
		</main>
	
	</main>

</body>
</html>