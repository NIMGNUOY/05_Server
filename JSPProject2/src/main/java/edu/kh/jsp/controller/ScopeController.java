package edu.kh.jsp.controller;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

// Servlet 매핑할때 주소 앞에 "/" 반드시 작성(필수)
// 서블릿 매핑에서 유효하지 않은 url pattern...
@WebServlet("/scope")
public class ScopeController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/scope/scope.jsp");
		
		// 1. page scope -> JSP 에서 확인(page scope는 jsp 파일 내에서만 사용가능)
		
		// 2. request scope -> 요청받은 곳 + 위임받은 페이지
		req.setAttribute("reqValue", "1234");
		
		// 3. session scope -> 브라우저당 1개
		// 					-> 브라우저 종료 또는 session 만료까지 유지
		
		// session 객체 얻어오는 방법
		HttpSession session = req.getSession();
		session.setAttribute("sessionValue", "9999");
		
		// 4. application scope -> 서버가 켜져있는 동안 유지
		
		// application 객체 얻어오는 방법
		// -> request, session 객체에서 얻어오기 가능
		ServletContext application = req.getServletContext();
//		ServletContext application = session.getServletContext();
		application.setAttribute("appValue", 100000);
		
		
		// ** 모든 scope 는 속성을 세팅하고 얻어오는 방법 동일 !! **
		
		// *********************************************************************************************
		
		// << 우선순위 확인 & scope 생명주기 확인>>
		
		// 모든 범위에 같은 key 로 속성 세팅
		req.setAttribute("str", "request 범위에 세팅된 문자열");
		
		session.setAttribute("str", "session 범위에 세팅된 문자열");
		
		application.setAttribute("str", "application 범위에 세팅된 문자열");
		
		// *********************************************************************************************
		
		// scope.jsp 로 위임
		dispatcher.forward(req, resp);
		
	}
	
}
















