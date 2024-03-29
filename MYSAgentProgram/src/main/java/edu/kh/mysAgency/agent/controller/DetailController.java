package edu.kh.mysAgency.agent.controller;

import java.io.IOException;

import edu.kh.mysAgency.agent.model.service.AgentService;
import edu.kh.mysAgency.player.model.dto.Player;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet("/detail")
public class DetailController extends HttpServlet {
	
	AgentService service = new AgentService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			
			String playerNo = req.getParameter("playerNo");
			
			HttpSession session = req.getSession();
			
			Player player = service.selectOne(playerNo);
			session.setAttribute("player", player);
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		
		req.getRequestDispatcher("/WEB-INF/views/detail.jsp").forward(req, resp);
		
	}
	
}
