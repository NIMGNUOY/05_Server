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

@WebServlet("/delete")
public class DeleteController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			
			String playerNo = req.getParameter("playerNo");

			AgentService service = new AgentService();
			
			int result = service.delete(playerNo);
			
			HttpSession session = req.getSession();
			Agent agent = (Agent) session.getAttribute("loginAgent");
			
			
			if(result > 0) {
				
				session.setAttribute("message", "선수 삭제 완료");
				
				List<Player> playerList = service.selectAll(agent.getAgentNo());
				session.setAttribute("playerList", playerList);
				
				
			} else {
				session.setAttribute("message", "선수 삭제 실패");
			}
			
			resp.sendRedirect("/agent");
			
		} catch (Exception e) {
			System.out.println("[선수 삭제 중 예외 발생]");
			e.printStackTrace();
		}
		
		
		
	}
	
}
