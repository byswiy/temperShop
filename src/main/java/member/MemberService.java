package member;

import dao.MemberInfoDao;
import vo.MemberInfo;

public class MemberService {
	
	// 아이디, 연락처, 이메일을 사용중인지 확인
	public boolean existIdOrTelOrEmail(String id, String tel, String email) {
		MemberInfoDao dao = new MemberInfoDao();
		
		MemberInfo memberInfo = dao.selectIdOrTelOrEmail(id, tel, email);
		
		if (memberInfo == null) {
			return false;
		} else {
			return true;
		}
	}
	
	public int join(MemberInfo memberInfo) {
		MemberInfoDao dao = new MemberInfoDao();
		
		boolean result = dao.insert(memberInfo);
		
		if(result) {
			return 200;
		} else {
			return 400;
		}
	}
	
	public MemberInfo selectId(String id) {
		MemberInfoDao dao = new MemberInfoDao();
		
		return dao.selectById(id);
	}
	
	public boolean deleteMemberInfo(String id) {
		MemberInfoDao dao = new MemberInfoDao();
		
		return dao.deleteId(id);
	}
	
	public void updateExclusionPw(MemberInfo memberInfo) {
		MemberInfoDao dao = new MemberInfoDao();
		dao.update(memberInfo);
	}
	
	public void updatePw(String id, String newPw) {
		MemberInfoDao dao = new MemberInfoDao();
		dao.updatePassword(id, newPw);
	}
}