package kr.or.ddit.user.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.common.model.PageVo;
import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.service.UserService;
import kr.or.ddit.user.service.UserServiceI;

@WebServlet("/pagingUser")
public class PagingUser extends HttpServlet {

	private static final Logger logger = LoggerFactory.getLogger(allUser.class);
	
	private UserServiceI userService = new UserService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    // left.jsp : /pagingUser?page=1&pageSize=5
	      // ==> /pagingUser

	      // doGet 메소드에서 page, pageSize 파라미터가 request 객체에 존재 하지 않을 때
	      // page는 1로, pageSize 5로 생각을 코드를 작성
	      // 파라미터가 존재하면 해당 파라미터를 이용
	      req.setCharacterEncoding("UTF-8");

	      // if/else ==> ?//조건 ? true 일때 반환할 값 : false일때 반환할 값(삼항연산자)
	      // refactoring : 코드를 (깔끔하게)바꾸는데 기존 동작방식을 유지한채로 변경하는 기법
	      
	      //파라미터 획득
	      String pageParam = req.getParameter("page");
	      String pagesizeParam = req.getParameter("pagesize");
	      
	      int page = pageParam == null ? 1 : Integer.parseInt(pageParam);
	      int pagesize = pagesizeParam == null ? 5 : Integer.parseInt(pagesizeParam);

	      PageVo pagevo = new PageVo(page, pagesize);
	      
	      //UserService map
	      Map<String, Object> map = userService.selectPagingUser(pagevo);
	      
	      List<UserVo> userList =(List<UserVo>) map.get("userList");
	     
	      int userCnt = (int)map.get("userCnt");
	      int pagination = (int)Math.ceil((double)userCnt/pagesize);
	      
	      req.setAttribute("userList", userList);
	      req.setAttribute("pagination", pagination);
	      req.setAttribute("pagevo", pagevo);
	      
	      
	      req.getRequestDispatcher("/user/pagingUser.jsp").forward(req, resp);
	      
	   }

}
