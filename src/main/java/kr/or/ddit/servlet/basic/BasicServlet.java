package kr.or.ddit.servlet.basic;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class BasicServlet extends HttpServlet {

	private static final Logger logger = LoggerFactory.getLogger(BasicServlet.class);

	//doXXX 메소드 인자 : req, res
	//GET, POST, DELETE, PUSH, HEAD ... : HTTP메소드
	public void init() throws ServletException{
		System.out.println("basicServlet.init()");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		logger.debug("basicServlet.doGet()");
		
		/* 만약에 log level를 debug보다 높은 레벨로 설정할 경우
		   로그를 생성하지는 않지만, 메소드 인자를 문자열+문자열 -> 문자열 결합 연산을 발생한다.
		*/ 
		logger.debug("basicServlet.doGet() userid paramter: {} {}" ,
				req.getParameter("userid") , req.getParameter("password"));
		
		resp.setContentType("text/html; charset=utf-8");
		
		//servlet의 라이프 사이클
		
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("	<head>");
		out.println("		<title>basic Servlet</title>");
		out.println("	</head>");
		out.println("<body>");
		out.println("	Hello, World" + new Date());
		out.println("</body>");
		out.println("</html>");
		
		out.flush();	//더이상 작성할 내용이 없으므로 작업을 마무리한다.
		out.close();	//그리고, 사용할 자원 반납한다.
	}

	
}
