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


@WebServlet("/update")
public class UpdateController extends HttpServlet {

	AgentService service = new AgentService();

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			
			HttpSession session = req.getSession();
			
			String playerNo = req.getParameter("playerNo");
			
			Player player = service.selectOne(playerNo);
			
			session.setAttribute("player", player);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		
		req.getRequestDispatcher("/WEB-INF/views/update.jsp").forward(req, resp);
		
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		try {
			
			HttpSession session = req.getSession();
			Agent agent = (Agent) session.getAttribute("loginAgent");
			
			String playerNo = req.getParameter("playerNo");
			
			String inputTeam = req.getParameter("inputTeam");
			int inputBackNum = Integer.parseInt( req.getParameter("inputBackNumber") );
			String memo = req.getParameter("memo");
			String medicalCheck = req.getParameter("medicalCheck");
			
			int result = service.update(inputTeam, inputBackNum, memo, medicalCheck, playerNo);
			
			if(result > 0) {
				session.setAttribute("message", "선수 정보 수정이 완료되었습니다");
				
				List<Player> playerList = service.selectAll(agent.getAgentNo());
				session.setAttribute("playerList", playerList);
				
				resp.sendRedirect("/agent");
			} else {
				session.setAttribute("message", "선수 정보 수정 실패");
				
				resp.sendRedirect( req.getHeader("referer") );
			}
			
			
		} catch(Exception e) {
			System.out.println("[선수 정보 수정 중 예외 발생]");
			e.printStackTrace();
		}
		
		
	}
	
	
}
















