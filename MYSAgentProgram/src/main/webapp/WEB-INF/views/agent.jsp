<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	
	<link rel="stylesheet" href="/resources/css/agent.css">
	
	<title>에이전트 페이지</title>
</head>
<body>

	<main>
	
		<c:choose>
			<c:when test="${empty sessionScope.loginAgent}">

				<div class="loginContainer">



					<div class="loginForm">


						<span class="loginTitle">Login</span>
						
						<form action="/login" method="post" class="login-form">
							
							<p>ID</p>
							<input type="text" name="inputId" class="inputBox">
							
							<p>PassWord</p>
							<input type="password" name="inputPw" class="inputBox">
							
							<br><br>
							
							<div class="btnArea">
								<button class="loginBtn">Login</button>
								&nbsp;&nbsp;
								<a href="/signup" class="signBtn">SignUp</a>
							</div>
							
						</form>

					</div>
				

				</div>
				
			</c:when>
			
			<c:otherwise>
				
				<span class="title">${sessionScope.loginAgent.agentName} 의 담당 선수 리스트</span>
				
				<br><br><br>
				
				<c:choose>
				
					<c:when test="${empty playerList}">
						<h2>관리중인 선수 없음</h2>
					</c:when>
					
					<c:otherwise>
					
						<table class="listTable">
				
							<c:forEach var="player" items="${playerList}" varStatus="vs">
								<tr>
									<td>${vs.count}</td>
									<td class="line">|</td>
									<td><a href="/detail?playerNo=${player.playerNo}" class="playerName">${player.playerName}</a></td>
									
									<td>(${player.playerAge})</td>
									<td class="line">|</td>
									<td>${player.playerTeam}</td>
									<td class="line">|</td>
									<td>${player.playerNationality}</td>
									<td class="line">|</td>
									<td><a href="/update?playerNo=${player.playerNo}"
											onclick="return confirm('${player.playerName}선수 정보를 수정하시겠습까?')">수정</a></td>
									<td class="line">|</td>
									<td><a href="/delete?playerNo=${player.playerNo}"
											onclick="return confirm('${player.playerName}선수를 리스트에서 삭제하시겠습니까?')">삭제</a></td>
								</tr>
							</c:forEach>
				
						</table>
					
					
					</c:otherwise>
				
				</c:choose>
				
				<br><br>
				
				<div class="agentBtn">
					<a href="/insert">등록하기</a>
					<a href="/logout">로그아웃</a>
				</div>
				
				<br><br><br>
				
				<span class="title">Contact</span>
				<div>
					<p>Email : ${sessionScope.loginAgent.email}</p>
					<p>Phone : ${sessionScope.loginAgent.phone}</p>
					<p>Nationality : ${sessionScope.loginAgent.agentNationality}</p>
				</div>
				
			</c:otherwise>
		</c:choose>
	
	</main>
	
	<c:if test="${not empty sessionScope.message}">
		
		<script>
			// EL , JSTL 구문이 자바스크립트보다 먼저 해석되는데
			// 문자열이 들어가있는 데이터의 경우 따옴표가 없는 상태이니 붙여줘야 한다!
			alert('${message}');
		</script>
		
		<%-- 
			session 에 message 를 추가하면 브라우저 종료 또는 만료전까지 계속 메시지가 출력된다
			-> 1회 출력후 session 에서 message 삭제
		 --%>
		 
		 <c:remove var="message" scope="session"/>
		
	</c:if>
	

</body>
</html>