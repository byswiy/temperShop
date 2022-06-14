package vo;

import java.time.LocalDateTime;

public class MemberInfo {
	private int userIdx;
	private String id;
	private String pw;
	private String name;
	private String tel;
	private String addr;
	private String emial;
	private LocalDateTime joinDate;
	
	public MemberInfo() {
		
	}
	
	public MemberInfo(int userIdx, String id, String pw, String name, String tel, String addr, String emial, LocalDateTime joinDate) {
		this.userIdx = userIdx;
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.tel = tel;
		this.addr = addr;
		this.emial = emial;
		this.joinDate = joinDate;
	}

	public int getUserIdx() {
		return userIdx;
	}

	public void setUserIdx(int userIdx) {
		this.userIdx = userIdx;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getEmial() {
		return emial;
	}

	public void setEmial(String emial) {
		this.emial = emial;
	}

	public LocalDateTime getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(LocalDateTime joinDate) {
		this.joinDate = joinDate;
	}
	
	
}
