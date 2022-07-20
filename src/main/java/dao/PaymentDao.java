package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import util.Database;
import vo.PaymentInfo;

public class PaymentDao {
	public boolean insertPayment(PaymentInfo paymentInfo) {
		Database db = new Database();
		
		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		
		try {
			String sql = "INSERT INTO payment_info(user_idx, imp_uid, merchant_uid, paid_amount) VALUES (?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, paymentInfo.getUser_idx());
			pstmt.setString(2, paymentInfo.getImp_uid());
			pstmt.setString(3, paymentInfo.getMerchant_uid());
			pstmt.setInt(4, paymentInfo.getPaid_amount());
			
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
