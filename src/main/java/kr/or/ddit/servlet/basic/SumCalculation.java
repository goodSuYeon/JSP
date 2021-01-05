package kr.or.ddit.servlet.basic;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.servlet.basic.BasicServlet;

@WebServlet("/sumCalculation")  //!!!!! 어노테이션 앞에 / 빼지말것 !!!!!
public class SumCalculation extends HttpServlet{
	
	private static final Logger logger = LoggerFactory.getLogger(SumCalculation.class);
 
	
	  @Override protected void doGet(HttpServletRequest req, HttpServletResponse
	  resp) throws ServletException, IOException {
	  
		  super.doPost(req, resp);
	  }

	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		logger.debug("paramter: {} {}", req.getParameter("start") , req.getParameter("end"));
		
		int start = Integer.parseInt(req.getParameter("start"));
		int end = Integer.parseInt(req.getParameter("end"));
		
		int sum = 0;
		for(int i = start; i <= end; i++) {
			sum += i;
		}
		
		logger.debug("값: ", sum);
		
		
	}
}
