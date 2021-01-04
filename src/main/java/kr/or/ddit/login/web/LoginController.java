package kr.or.ddit.login.web;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*
   (1방법) web.xml에 설정하는 servlet, 
   (2방법) servlet-mapping을 어노테이션을 통해서 설정하는 방법
*/
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//사용자가 userId, pass파라미터를 전송했다는 가정으로 개발한다
		logger.debug("하나의 파라미터 확인");
		logger.debug("req.getParameter(\"userid\"): {}", req.getParameter("userid"));
		logger.debug("req.getParameter(\"pass\"): {}", req.getParameter("pass"));
		
		logger.debug("복수개의 값을 갖는 파라미터 확인");
		logger.debug("req.getPatameterValues(\"userid\") : {}");
		//복수개의 값을 갖는 파라미터가 나오지 않으므로, 향상된 for문 사용한다.
		for(String userid : req.getParameterValues("userid")) {
			logger.debug(userid);
		}
		
		logger.debug("요청에 담긴 파라미터 이름 확인");
		logger.debug("req.getParameterNames(): {}" );
		//요청에 담긴 파라미터 이름 파라미터가 나오지 않으므로,
		Enumeration<String> enumeration = req.getParameterNames();
		while(enumeration.hasMoreElements()) {
			logger.debug(enumeration.nextElement());   //nextElement - 데이터를 꺼내온다 
		}
				
		logger.debug("요청에 담긴 파라미터를 관리하는 Map객체 반환");
		logger.debug("req.getParameterMap():");
		Map<String, String[]> map = req.getParameterMap();
		Set<String> keys = map.keySet();   //entry로도 가능
		
		Iterator<String> it = keys.iterator();
		while(it.hasNext()) {
			logger.debug("{}", map.get(it.next()));   //it.next라고만 하면 key값만 얻어오게 됨.
		}
		
		//ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
		//로그인 프로세스
		/* DB에 저장된 사용자 정보와 일치하는지 검증해야하나, DB연동이 아직 준비되지 않은 관계로 
		   userid가 brown일 때 비밀번호가 brownpass인 경우에 한해 로그인이 성공되었다고 판단한다. (그 외 경우는 로그인 실패로 간주)
		   로그인 성공시 : main.jsp로 forward
		   로그인 실패시 : login.jsp로 redirect
		*/
		//1. userid, pass 파라미터를 문자열 변수에 저장
		//2. userid, pass 값이 지정한 값과 일치하는지 비교
		//3. 2번 비교 사항이 true일 때, webapp/main.jsp로 forward함 
		//4. 2번 비교 사항이 false일 때, webapp/login.jsp로 redirect함
		
		
		//1번
		String userid = req.getParameter("userid");
		String pass = req.getParameter("pass");
		
		//2번
		if(userid.equals("brown") && pass.equals("brownpass")) {
			  // 3. 2번 비교 사항이 true일 때 webapp/main.jsp로 forward ( main.jsp는 생성 )
	         req.getRequestDispatcher("/main.jsp").forward(req, resp);
		}
		else {
			  // 4. 2번 비교 사항이 false일 때 webapp/login.jsp로 redirect
	         resp.sendRedirect(req.getContextPath()+"/login.jsp");

		}

	}
}
