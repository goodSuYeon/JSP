package kr.or.ddit.emp.respository;

import java.util.List;

import kr.or.ddit.emp.model.EmpVo;

public interface EmpDaoI {
	
	List<EmpVo> selectAllEmp();
}
