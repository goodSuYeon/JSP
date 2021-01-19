package kr.or.ddit.listener;

import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.user.model.UserVo;

public class LoginUserListener implements HttpSessionAttributeListener {
	
	private Set<String> users = new HashSet<String>();
	private static final Logger logger = LoggerFactory.getLogger(LoginUserListener.class);
	
	@Override
	public void attributeAdded(HttpSessionBindingEvent event) {    //추가
		if(event.getName().equals("S_USER")) {
			UserVo user = (UserVo)event.getValue();
			logger.debug("add user: {}" , user.getUsernm());
			users.add(user.getUsernm());  //추가할 속성은 사용자이름
			
			event.getSession().getServletContext().setAttribute("USER_SET", users);
		}
		
	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent event) {  //삭제
		UserVo user = (UserVo)event.getValue();   //value값을 가져온다
		
		logger.debug("remove user: {}" , user.getUsernm());
		users.remove(user.getUsernm());			 //해당 사용자를 제거한다
		
	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent event) { //교체
		// TODO Auto-generated method stub
		
	}

}
