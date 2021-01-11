package kr.or.ddit.user.controller.AllUser;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.common.model.PageVo;
import kr.or.ddit.user.service.UserService.UserService;
import kr.or.ddit.user.service.UserServiceI.UserServiceI;

@WebServlet("/pagingUser")
public class PagingUser  extends HttpServlet { 
	
	private static final Logger logger = LoggerFactory.getLogger(allUser.class);
	
	private UserServiceI userService = new UserService();
	
	//left.jsp : pagingUser?page=1&pageSize=5
	// =====> paginUser
	
	//doGet 메소드에서 page,pageSize파라미터가 request객체에 존재하지 않을 경우 (각각)
	// -> page는 1로, pageSize는 5로 생각해 코드작성
	// -> 파라미터가 존재하면 해당 파라미터를 이용
	// refactoring : 코드를 (깔끔하게) 바꾸는데 기존 동작방식을 유지한채로 변경하는 기법
	
	@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pageParam = req.getParameter("page");
		String pageSizeParam = req.getParameter("pageSize");
		
		int page = pageParam == null ? 1 : Integer.parseInt(pageParam);
		int pageSize = pageSizeParam == null ? 5 : Integer.parseInt(pageSizeParam);

			
		PageVo pagevo = new PageVo(page, pageSize);
		List<PageVo> userList = userService.pagingUser(pagevo);
								userService.s
		
		req.setAttribute("userList", userList);
		req.setAttribute("pagination", 4);
		
		logger.debug("userList: {} ",userList);
		
		req.getRequestDispatcher("/user/pagingUser.jsp").forward(req, resp);
		
		}
}
