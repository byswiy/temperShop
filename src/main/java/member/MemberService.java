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
	
	public boolean existTelOrEmail(String id, String tel, String email) {
		// 로그인 한 회원 정보에 들어있는 id를 사용해서 회원 정보 조회
		MemberInfoDao dao = new MemberInfoDao();
		MemberInfo oldMemberInfo = dao.selectById(id);
		
		// 회원 정보를 수정할 때 이메일을 바꾼다면 이메일 중복 여부 확인
		// 조회한 회원 정보의 이메일과 email로 전달 받은 이메일이 다르다면 이메일을 수정한다
		String oldEmail = oldMemberInfo.getEmail();
		if(!oldEmail.equals(email)) {
			MemberInfo memberInfo = dao.selectByEmail(email);
			
			if(memberInfo != null) {
				return true;
			} else {
				return false;
			}
		}
		String oldTel = oldMemberInfo.getTel();
		if(!oldTel.equals(tel)) {
			MemberInfo memberInfo = dao.selectByTel(tel);
			
			if(memberInfo != null) {
				return true;
			} else {
				return false;
			}
		}
		return false;
	}

	public int join(MemberInfo memberInfo) {
		MemberInfoDao dao = new MemberInfoDao();

		boolean result = dao.insert(memberInfo);

		if (result) {
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