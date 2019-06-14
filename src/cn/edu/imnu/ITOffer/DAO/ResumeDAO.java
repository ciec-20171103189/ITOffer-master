package cn.edu.imnu.ITOffer.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;


import cn.edu.imnu.ITOffer.Bean.ResumeBasicinfo;
import cn.edu.imnu.ITOffer.DButil.DBUtil;

public class ResumeDAO {

	public int add(ResumeBasicinfo basicinfo, int applicantID) {
		// TODO Auto-generated method stub
		int basicinfoID = 0;
		String sql = "INSERT INTO tb_resume_basicinfo(realname,gender,birthday,current_Loc,resident_loc,telephone,email,job_intension,job_experience,head_shot,applicant_id)VALUES(?,?,?,?,?,?,?,?,?,'QST.jpg',?)";
		Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		try {
			System.out.println(applicantID);
			//conn.setAutoCommit(false);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, basicinfo.getRealName());
			pstmt.setString(2, basicinfo.getGender());
			pstmt.setString(3, null);
			pstmt.setTimestamp(3, basicinfo.getBirthday() == null ? null : new Timestamp(basicinfo.getBirthday().getTime()));
			pstmt.setString(4, basicinfo.getcurrentLoc());
			pstmt.setString(5, basicinfo.getresidentLoc());
			pstmt.setString(6, basicinfo.getTelephone());
			pstmt.setString(7, basicinfo.getEmail());
			pstmt.setString(8, basicinfo.getJobIntension());
			pstmt.setString(9, basicinfo.getJobExperience());
			pstmt.setInt(10, applicantID);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.closeJDBC(null, pstmt, conn);
		}
		return basicinfoID;
	}

	
	public void updateHeadShot(int basicinfoId, String newFileName) {
		// TODO Auto-generated method stub
		String sql = "UPDATE tb_resume_basicinfo Set head_shot = ? WHERE basicinfo_id = ?";
		Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, newFileName);
			pstmt.setInt(2, basicinfoId);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.closeJDBC(null, pstmt, conn);
		}
		
	}

}
