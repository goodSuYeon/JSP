package kr.or.ddit.user.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.service.UserService;
import kr.or.ddit.user.service.UserServiceI;


@WebServlet("/allUser")
public class allUser extends HttpServlet {
	
	private static final Logger logger = LoggerFactory.getLogger(allUser.class);
	
	private UserServiceI userService = new UserService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<UserVo> userList = userService.selectAllUser();
		
		req.setAttribute("userList", userList);
		
		logger.debug("userList: {} ",userList);
		
		req.getRequestDispatcher("/user/allUser.jsp").forward(req, resp);

	}
	
}
