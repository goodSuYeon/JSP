package kr.or.ddit.user.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.common.model.PageVo;
import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.service.UserService;
import kr.or.ddit.user.service.UserServiceI;

public class UserDaoTest {
	
	private static final Logger logger = LoggerFactory.getLogger(UserDaoTest.class);
	//전체 사용자 조회 테스트
//	@Test
//	public void selectAllUsertest() {
		/**Given**/
//		UserDaoI userDao = new UserDao();
		
		/**When**/
//		List<UserVo> userList = userDao.selectAllUser();
		
		/**Then**/
//		assertEquals(5, userList.size());
//	}
	
	//사용자 아이디를 사용자가 특정 사용자 정보 조회 
	@Test
	public void selectUserTest() {
		
		/***Given***/
		UserDaoI userDao = new UserDao();
		String userid = "brown";

		/***When***/
		UserVo user = userDao.selectUser(userid);
		
		/***Then***/
		assertEquals("브라운", user.getUsernm());
		
	}
	
	//사용자 아이디가 존재하지 않을 때, 특정 사용자 조회
	@Test
	public void selectUserNotExsistTest() {
		/***Given***/
		UserDaoI userDao = new UserDao();
		String userid = "broqwndasdawqez";

		/***When***/
		UserVo user = userDao.selectUser(userid);
		
		/***Then***/
		assertNull(user);     
	}
	
	@Test
	public void pagingUserTest() {
		/***Given***/
		UserServiceI userService = new UserService();
		

		/***When***/
		PageVo pagevo = new PageVo(2,5);
		Map<String, Object> map = userService.selectPagingUser(pagevo);
		List<UserVo> userList = (List<UserVo>)map.get("userList");
		int usercnt = (int) map.get("userCnt");
		
		/***Then***/
		assertEquals(5, userList.size());
		assertEquals(16, usercnt);
	}
	
	@Test
	public void modifyUserTest() {
		/*** Given ***/
		UserDaoI userDao = new UserDao();
		
		//userid, usernm, pass, reg_dt, alias, addr1, addr2, zipcode
		UserVo userVo = new UserVo("ddit","대덕인재","dditpass", new Date(),
								   "개발원 m", "대전시 중구 중앙로76","4층 대덕인재개발원","34940");
		
		/*** When ***/
		int updateCnt = userDao.modifyUser(userVo);
		
		/*** Then ***/
		assertEquals(1, updateCnt);
		
	}
}

