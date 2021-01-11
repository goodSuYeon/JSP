package kr.or.ddit.emp.service;

import java.util.List;

import kr.or.ddit.emp.model.EmpVo;
import kr.or.ddit.emp.respository.EmpDao;

public class EmpService implements EmpServiceI {

	private EmpDao dao = new EmpDao();

	@Override
	public List<EmpVo> selectAllEmp() {
		
		return dao.selectAllEmp();
	}
	
	
}
