package kr.or.ddit.cookie;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CookieUtil {
	
	private static final Logger logger = LoggerFactory.getLogger(CookieUtil.class);
	
	/**
	 * Method : getCookieValue
	 * 작성자 : PC-07
	 * 변경이력 :
	 * @param cookieStr
	 * @param cookieName
	 * @return
	 * Method 설명 : cookieStr에서 cookieName에 해당하는 쿠키 값을 조회
	 */
	// 쿠키의 값을 요청
	// 첫번째인자 (userid=brown; rememberme=Y; test=testcookie)
	// 두번째인자 (cookieName : userid, rememberme)
	// return : brown , Y
	public static String getCookieValue(String cookieStr, String cookieName) {

		//userid=brown; rememberme=Y; test=testcookie 이 값을 ; 기준으로 잘라서 cookies에 넣는다
		String[] cookies = cookieStr.split("; ");
		
		
		for(int i = 0; i < cookies.length; i++) {
			String[] cookie = cookies[i].split("=");
			
			if(cookie[0].equals(cookieName)) {
				return cookie[1];
			}
		}

		return "";
		
	}	
}
