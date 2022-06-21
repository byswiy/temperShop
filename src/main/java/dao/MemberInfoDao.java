package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

import util.Database;
import vo.MemberInfo;

public class MemberInfoDao {
	// 아이디, 연락처, 이메일을 SELECT하는 쿼리
	public MemberInfo selectIdOrTelOrEmail(String id, String tel, String email) {
		Database db = new Database();
		
		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		MemberInfo memberInfo = null;
		
		try {
			String sql = "SELECT * FROM temperShop WHERE id=? AND tel=? AND email=?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, tel);
			pstmt.setString(3, email);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				int userIdx = rs.getInt("userIdx");
				String pw = rs.getString("pw");
				String name = rs.getString("name");
				String addr = rs.getString("addr");
				String date = rs.getString("joinDate");
				date = date.substring(0, 19);
				date = date.replace(' ', 'T');
				LocalDateTime joinDate = LocalDateTime.parse(date);
				
				memberInfo = new MemberInfo(userIdx, id, pw, name, tel, addr, email, joinDate);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.closeResultSet(rs);
			db.closePstmt(pstmt);
			db.closeConn(conn);
		}
		return memberInfo;
	}
	
	// 회원 정보를 삽입하는 INSERT 쿼리
	public boolean insert(MemberInfo memberInfo) {
		Database db = new Database();
		
		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		
		try {
			String sql = "INSERT INTO member_info(id, pw, name, tel, addr, email, joinDate) VALUES(?, ?, ?, ?, ?, ?, ?)";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberInfo.getId());
			pstmt.setString(2, memberInfo.getPw());
			pstmt.setString(3, memberInfo.getName());
			pstmt.setString(4, memberInfo.getTel());
			pstmt.setString(5, memberInfo.getAddr());
			pstmt.setString(6, memberInfo.getEmail());
			pstmt.setString(7, memberInfo.getJoinDate().toString());
			
			int count = pstmt.executeUpdate();
			
			return count == 1;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.closePstmt(pstmt);
			db.closeConn(conn);
		}
		
		return false;
	}
	
	// 회원 아이디를 사용해서 정보를 SELECT 하는 쿼리
	public MemberInfo selectById(String id) {
		Database db = new Database();
		
		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		MemberInfo memberInfo = null;
		
		try {
			String sql = "SELECT * FROM member_info WHERE id=?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				int userIdx = rs.getInt("userIdx");
				String pw = rs.getString("pw");
				String name = rs.getString("name");
				String tel = rs.getString("tel");
				String addr = rs.getString("addr");
				String email = rs.getString("email");
				String date = rs.getString("joinDate");
				date = date.substring(0, 19);
				date = date.replace(' ', 'T');
				LocalDateTime joinDate = LocalDateTime.parse(date);
				
				memberInfo = new MemberInfo(userIdx, id, pw, name, tel, addr, email, joinDate);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.closeResultSet(rs);
			db.closePstmt(pstmt);
			db.closeConn(conn);
		}
		return memberInfo;
	}
	
	// 회원 정보를 수정하기 위한 UPDATE 쿼리
	public void update(MemberInfo memberInfo) {
		Database db = new Database();
		
		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		
		try {
			String sql = "UPDATE member_info SET name=?, tel = ?, addr = ?, email = ? WHERE id = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberInfo.getName());
			pstmt.setString(2, memberInfo.getTel());
			pstmt.setString(3, memberInfo.getAddr());
			pstmt.setString(4, memberInfo.getEmail());
			pstmt.setString(5, memberInfo.getId());
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.closePstmt(pstmt);
			db.closeConn(conn);
		}
	}
	
	// 비밀번호 수정을 위한 UPDATE 쿼리
	public void updatePassword(String id, String newPw) {
		Database db = new Database();
		
		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		
		try {
			String sql = "UPDATE SET pw = ? WHERE id = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, newPw);
			pstmt.setString(2, id);
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.closePstmt(pstmt);
			db.closeConn(conn);
		}
		
	}
	
	// 회원 번호를 select 해서 회원 정보를 가져오는 쿼리
	public MemberInfo selectByUserIdx(int userIdx) {
		Database db = new Database();

		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		MemberInfo memberInfo = null;

		try {
			String sql = "SELECT * FROM member_info WHERE id=?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, userIdx);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				String id = rs.getString("id");
				String pw = rs.getString("pw");
				String name = rs.getString("name");
				String tel = rs.getString("tel");
				String addr = rs.getString("addr");
				String email = rs.getString("email");
				String date = rs.getString("joinDate");
				date = date.substring(0, 19);
				date = date.replace(' ', 'T');
				LocalDateTime joinDate = LocalDateTime.parse(date);

				memberInfo = new MemberInfo(userIdx, id, pw, name, tel, addr, email, joinDate);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.closeResultSet(rs);
			db.closePstmt(pstmt);
			db.closeConn(conn);
		}
		return memberInfo;
	}
	
	public boolean deleteId(String id) {
		Database db = new Database();

		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		
		
		try {
			String sql = "DELETE FROM member_info WHERE id = ?";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, id);
			
			int count = pstmt.executeUpdate();
			
			return count == 1;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.closePstmt(pstmt);
			db.closeConn(conn);
		}
		return false;
	}
}	
