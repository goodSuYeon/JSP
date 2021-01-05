package kr.or.ddit.servlet.basic;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/scope")
public class Scope extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		req.getRequestDispatcher("/jsp/scope.jsp").forward(req, resp);
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String scopeParameter = req.getParameter("scope");
		
		req.setAttribute("request", scopeParameter+ "_request");
		
		HttpSession sesion = req.getSession();
		sesion.setAttribute("session", scopeParameter+ "_session");
		
		ServletContext application = getServletContext();
		application.setAttribute("application", scopeParameter+ "_application");
	
		req.getRequestDispatcher("/jsp/scopeResult.jsp").forward(req, resp);
	}
}
