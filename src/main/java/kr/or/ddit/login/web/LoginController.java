package kr.or.ddit.login.web;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

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
		
	}
}
