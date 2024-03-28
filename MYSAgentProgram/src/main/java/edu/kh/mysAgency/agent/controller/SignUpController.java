package edu.kh.mysAgency.agent.controller;

import java.io.IOException;

import edu.kh.mysAgency.agent.model.dto.Agent;
import edu.kh.mysAgency.agent.model.service.AgentService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/signup")
public class SignUpController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.getRequestDispatcher("/WEB-INF/views/signup.jsp").forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			
			
			String inputId = req.getParameter("inputId");
			String inputPw = req.getParameter("inputPw");
			String inputName = req.getParameter("inputName");
			String inputEmail = req.getParameter("inputEmail");
			
			Agent agent = new Agent();
			
			agent.setAgentId(inputId);
			agent.setAgentPw(inputPw);
			agent.setAgentName(inputName);
			agent.setEmail(inputEmail);
			
			AgentService service = new AgentService();
			
			int result = service.signUp(agent);
			
			HttpSession session = req.getSession();
			
			if(result > 0) {
				
				session.setAttribute("message", "회원가입이 완료되었습니다");
				resp.sendRedirect("/agent");
				
			} else {
				session.setAttribute("message", "** 회원가입 중 오류 발생 **");
				resp.sendRedirect( req.getHeader("referer") );
			}
			
			
		} catch (Exception e) {
			System.out.println("[회원가입 중 예외 발생]");
			e.printStackTrace();
		}
		
		
	}
	
}

















