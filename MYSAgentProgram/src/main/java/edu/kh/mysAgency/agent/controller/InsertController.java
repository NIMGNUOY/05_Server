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

@WebServlet("/insert")
public class InsertController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.getRequestDispatcher("/WEB-INF/views/insert.jsp").forward(req, resp);
		
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			
			String inputName = req.getParameter("inputName");
			int inputAge = Integer.parseInt(req.getParameter("inputAge"));
			String inputTeam = req.getParameter("inputTeam");
			String inputNationality = req.getParameter("inputNationality");
			
//			Player player = new Player();
//			
//			player.setPlayerName(inputName);
//			player.setPlayerAge( inputAge );
//			player.setPlayerTeam(inputTeam);
//			player.setPlayerNationality(inputNationality);
			
			AgentService service = new AgentService();
			
			
			HttpSession session = req.getSession();
			
			Agent agent = (Agent) session.getAttribute("loginAgent");
			
			int result = service.insert(inputName, inputAge, inputTeam, inputNationality , agent.getAgentNo());
			
			if(result > 0) {
				
				session.setAttribute("message", "선수등록이 완료되었습니다");
				
				List<Player> playerList = service.selectAll(agent.getAgentNo());
				
				session.setAttribute("playerList", playerList);
				
				resp.sendRedirect("/agent");
				
			} else {
				session.setAttribute("message", "** 선수등록에 실패했습니다 **");
				resp.sendRedirect( req.getHeader("referer") );
			}
			
			
		} catch(Exception e) {
			System.out.println("[선수 등록 중 예외 발생]");
			e.printStackTrace();
		}
		
	}
	
}













