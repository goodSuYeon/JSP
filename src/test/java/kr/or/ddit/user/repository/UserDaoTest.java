package kr.or.ddit.user.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.List;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.common.model.PageVo;
import kr.or.ddit.user.model.UserVo;

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
		UserDaoI userDao = new UserDao();
		
//또는	PageVo page = new PageVo(2,5);
		PageVo page = new PageVo();
		page.setPage(2);
		page.setPageSize(5);

		/***When***/
		List<PageVo> pageList = userDao.pagingUser(page);
		
		/***Then***/
		assertEquals(5, pageList.size());
	}
	
}

