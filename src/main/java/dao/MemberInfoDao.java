package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

import util.Database;
import vo.MemberInfo;

public class MemberInfoDao {
	public MemberInfo selectIdOrTelOrEmail(String id, String tel, String email) {
		Database db = new Database();
		
		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		MemberInfo memberInfo = null;
		
		try {
			String sql = "SELECT * FROM temperShop WHERE id=?, tel=?, email=?";
			
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
	
	public boolean insert(MemberInfo memberInfo) {
		Database db = new Database();
		
		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		
		try {
			String sql = "INSERT INTO temoerShop(id, pw, name, tel, addr, email, joinDate) VALUES(?, ?, ?, ?, ?, ?, ?)";
			
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
	
	public MemberInfo selectById(String id) {
		Database db = new Database();
		
		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		MemberInfo memberInfo = null;
		
		try {
			String sql = "SELECT * FROM temperShop WHERE id=?";
			
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
}
