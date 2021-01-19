package kr.or.ddit.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ApplicationListener implements ServletContextListener{

	private static final Logger logger = LoggerFactory.getLogger(ApplicationListener.class);
	
	@Override
	public void contextInitialized(ServletContextEvent sce) {  // 서버가 최초 기동되었을 때
		logger.debug("INIT");
		ServletContext sc = sce.getServletContext(); // ServletContext가 application
		sc.setAttribute("cp", sc.getContextPath());
	}
 
	@Override
	public void contextDestroyed(ServletContextEvent sce) {

		
	}

}
