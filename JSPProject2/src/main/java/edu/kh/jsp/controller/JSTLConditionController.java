package edu.kh.jsp.controller;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/jstl/condition")
public class JSTLConditionController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setAttribute("name", "손흥민");
		req.setAttribute("money", 50000);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/jstl/condition.jsp");
		
		dispatcher.forward(req, resp);
		
	}
	
}
