package edu.kh.servlet.controller;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/coffee")
public class ExampleController3 extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String orderer = req.getParameter("orderer");
		String coffee = req.getParameter("coffee");
		String type = req.getParameter("type");
		
		/*	
		 * 	name 속성값이 같은 파라미터가 여러개인 경우
		 *  String[] 로 한번에 반환 받는 getParameterValues("name") 사용
		 */
		
		String[] optionArr = req.getParameterValues("opt");	// 체크박스는 중복 선택 가능하기 때문에 배열형태
		
		System.out.println(orderer);
		System.out.println(coffee);
		System.out.println(type);
		System.out.println(optionArr); 	// 주소값
		for(String opt : optionArr) {
			System.out.println(opt);
		}
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/result2.jsp");
		
		dispatcher.forward(req, resp);
		
		
	}
	
	
}
