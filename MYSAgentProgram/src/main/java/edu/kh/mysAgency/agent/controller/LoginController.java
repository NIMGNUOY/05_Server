package edu.kh.mysAgency.agent.controller;

import java.io.IOException;
import java.util.List;

import edu.kh.mysAgency.agent.model.dto.Agent;
import edu.kh.mysAgency.agent.model.service.AgentService;
import edu.kh.mysAgency.player.model.dto.Player;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginController extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			
			String inputId = req.getParameter("inputId");
			String inputPw = req.getParameter("inputPw");
			
			AgentService service = new AgentService();
			
			Agent loginAgent = service.login(inputId, inputPw);
			
			HttpSession session = req.getSession();
			
			if(loginAgent != null) {
				
				session.setAttribute("loginAgent", loginAgent);
				
				session.setMaxInactiveInterval(60 * 60);
				
				List<Player> playerList = service.selectAll(loginAgent.getAgentNo());
				
				session.setAttribute("playerList", playerList);
				
				resp.sendRedirect("/agent");
			
			} else {
				
				session.setAttribute("message", "** 아이디 또는 비밀번호 불일치 **");
				
				String referer = req.getHeader("referer");
				
				resp.sendRedirect(referer);
				
			}
			
			
		} catch(Exception e) {
			System.out.println("[로그인 중 예외 발생]");
			e.printStackTrace();
		}
		
		
		
	}
	
}
