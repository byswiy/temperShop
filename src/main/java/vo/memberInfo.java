package vo;

import java.time.LocalDateTime;

public class MemberInfo {
	private int userIdx;
	private String id;
	private String pw;
	private String name;
	private String tel;
	private String postalCode;
	private String addr;
	private String email;
	private LocalDateTime joinDate;
	
	public MemberInfo() {
		
	}
	
	

	public MemberInfo(int userIdx, String id, String pw, String name, String tel, String postalCode, String addr,
			String email, LocalDateTime joinDate) {
		super();
		this.userIdx = userIdx;
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.tel = tel;
		this.postalCode = postalCode;
		this.addr = addr;
		this.email = email;
		this.joinDate = joinDate;
	}



	public MemberInfo(String id, String pw, String name, String tel, String postalCode, String addr, String email, LocalDateTime joinDate) {
		this(0, id, pw, name, tel, postalCode, addr, email, joinDate);
	}

	public MemberInfo(String id, String name, String tel, String postalCode, String addr, String email) {
		this(0, id, null, name, tel, postalCode, addr, email, null);
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
	
	

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDateTime getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(LocalDateTime joinDate) {
		this.joinDate = joinDate;
	}
	
	
}
