package kr.or.ddit.emp.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.emp.model.EmpVo;
import kr.or.ddit.emp.service.EmpService;
import kr.or.ddit.user.controller.AllUser.allUser;
import kr.or.ddit.user.model.UserVo;

@WebServlet("/allEmp")
public class allEmp extends HttpServlet {
	
	private static final Logger logger = LoggerFactory.getLogger(allUser.class);
	
	private EmpService empservice = new EmpService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<EmpVo> empList = empservice.selectAllEmp();
		
		req.setAttribute("empList", empList);
		
		logger.debug("empList: {} ",empList);
		req.getRequestDispatcher("/emp/allEmp.jsp").forward(req, resp);
	}
}
