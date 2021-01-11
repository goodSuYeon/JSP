package kr.or.ddit.user.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class UserVo {
	private String userid;
	private String usernm;
	private String pass;
	private Date reg_dt;
	private String alias;
	
	// 대다수의 framework는 기본 생성자를 필요로 한다. !!
	public UserVo() {}
	
	// getter, setter, toString 생성
	@Override
	public String toString() {
		return "UserVo [userid=" + userid + ", usernm=" + usernm + ", pass=" + pass + ", reg_dt=" + reg_dt + ", alias="
				+ alias + "]";
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUsernm() {
		return usernm;
	}
	public void setUsernm(String usernm) {
		this.usernm = usernm;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}

	public Date getReg_dt() {
		return reg_dt;
	}

	public void setReg_dt(Date reg_dt) {
		this.reg_dt = reg_dt;
	}
	
	//문자열을 리턴하는 메소드
	public String getReg_dt_fmt() {
		//reg_dt필드가 null값이면 ""문자열 반환
		
		//reg_dt필드가 null값이 아니면 
		// -> SimpleDateFormat을 생성해 yyyy/mm/dd 포맷의 문자열로 반환해 리턴
		if(this.reg_dt == null) {
			return "";
		}else {
			SimpleDateFormat date = new SimpleDateFormat("yyyy/MM/dd");
			return date.format(this.reg_dt);
			
		//또는 return new SimpleDateFormat("yyyy/MM/dd").format(this.reg_dt);
		}
	}

	public String getAlias() {
		return alias;
	}
	public void setAlias(String alias) {
		this.alias = alias;
	}
}