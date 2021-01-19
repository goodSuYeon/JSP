package kr.or.ddit.filter;

import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class DefaultParameterRequestWrapper extends HttpServletRequestWrapper {

	private Map<String, String[]> customMap;
	
	//생성자를 만들어야 하는 이유?
	// 부모클래스에는 기본생성자가 없음 그래서, 인자가 있는 생성자를 만들어야함
	public DefaultParameterRequestWrapper(HttpServletRequest request) {
		super(request);
		
		customMap = new HashMap<String, String[]>(request.getParameterMap());
		
		//사전에 의해서 모든 요청객체에 UNT_CD파라미터로 DDIT문자열 값을 넣어줘야 하는 상황
		customMap.put("UNT_CD", new String[]{("DDIT")});
	}
	
	public String getParameter(String name) {
		//키에 해당하는 값중에서 첫번째값을 반환
		//키에 해당하는 값이 없을 때 ? ==> null
		String[] values = customMap.get(name);
		if(values == null || values.length == 0) {
			return null;
		}
		else {
			return values[0];
		}
		
	}
	
	public Map<String, String[]> getParameterMap(){
		return customMap;
	
	}
	
	//문자열을 제네릭으로 하는 Enumeration  
	public Enumeration<String> getParameterNames(){
		return Collections.enumeration(customMap.keySet());
		
	}
	
	public String[] getParameterValues(String name) {
		return customMap.get(name);
		
	}

}
