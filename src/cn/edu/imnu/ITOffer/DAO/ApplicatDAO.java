package cn.edu.imnu.ITOffer.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

import cn.edu.imnu.ITOffer.DButil.DBUtil;

public class ApplicatDAO {

	public boolean isExistEmail(String email) {
		// TODO Auto-generated method stub
		Connection conn = DBUtil.getConnection();
		PreparedStatement psm = null;
		ResultSet rus =null;
		String sql = "SELECT * FROM tb_applicant WHERE applicant_email = ?";
		try {
			psm = conn.prepareStatement(sql);
			psm.setString(1, email);
			rus = psm.executeQuery();
			if(rus.next()) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.closeJDBC(rus, psm, conn);
		}		
		return false;
	}

	public void save(String mail, String password) {
		// TODO Auto-generated method stub
		Connection conn = DBUtil.getConnection();
		PreparedStatement psm = null;
		String sql = "INSERT INTO tb_applicant(applicant_email,applicant_pwd,applicant_registdate) VALUES(?,?,?)";
		try {
			psm = conn.prepareStatement(sql);
			psm.setString(1, mail);
			psm.setString(2, password);
			psm.setTimestamp(3, new Timestamp(new Date().getTime()));
			psm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.closeJDBC(null, psm, conn);
		}
		
	}

	public int login(String email, String password) {
		// TODO Auto-generated method stub
		int applicatID = 0;
		Connection conn = DBUtil.getConnection();
		PreparedStatement pst = null;
		ResultSet rs = null;
		String sql = "SELECT applicant_id FROM tb_applicant WHERE applicant_email=? and applicant_pwd=?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, email);
			pst.setString(2, password);
			rs = pst.executeQuery();
			if(rs.next()) {
				applicatID = rs.getInt("applicant_id");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.closeJDBC(rs, pst, conn);
		}
		return applicatID;
	}

	public int isExistResume(int applicantID) {
		// TODO Auto-generated method stub
		int resumeID = 0;
		Connection conn = DBUtil.getConnection();
		PreparedStatement pst = null;
		ResultSet rs = null;
		String sql = "SELECT basicinfo_id FROM tb_resume_basicinfo WHERE applicant_id =?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, applicantID);
			rs = pst.executeQuery();
			if(rs.next()) {
				resumeID = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.closeJDBC(rs, pst, conn);
		}
		return resumeID;
	}
	
}
