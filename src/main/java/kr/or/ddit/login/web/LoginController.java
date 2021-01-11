package kr.or.ddit.login.web;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.service.UserService.UserService;
import kr.or.ddit.user.service.UserServiceI.UserServiceI;

/*
   (1방법) web.xml에 설정하는 servlet, 
   (2방법) servlet-mapping을 어노테이션을 통해서 설정하는 방법
*/
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	private UserServiceI userService = new UserService();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
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
		
		UserVo user = userService.selectUser(userid);
		//로그인 성공 -> service를  통해서 데이터베이스에 저장된 값과 일치할 때
		// session에 데이터베이스 조회한 사용자 정보(userVo)를 지정
		//2번
		if(user != null && pass.equals(user.getPass())) {    //사용자가 로그인한 비밀번호와 DB에 저장된 비밀번호 비교
 			  // 3. 2번 비교 사항이 true일 때 webapp/main.jsp로 forward ( main.jsp는 생성 )
	         req.getRequestDispatcher("/main.jsp").forward(req, resp);
		}
		else {
			  // 4. 2번 비교 사항이 false일 때 webapp/login.jsp로 redirect
	         resp.sendRedirect(req.getContextPath()+"/login.jsp");

		}

	}
}
