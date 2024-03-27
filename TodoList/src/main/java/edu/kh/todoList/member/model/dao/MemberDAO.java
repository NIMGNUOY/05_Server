package edu.kh.todoList.member.model.dao;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

import static edu.kh.todoList.common.JDBCTemplate.*;
import edu.kh.todoList.member.model.dto.Member;

public class MemberDAO {

	
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private Properties prop;
	
	public MemberDAO() {
		
		try {
			prop = new Properties();
			
			String filePath
			= MemberDAO.class.getResource("/edu/kh/todoList/sql/member-sql.xml").getPath();
			
			prop.loadFromXML( new FileInputStream(filePath) );
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

	/** 로그인 SQL 수행 DAO
	 * @param conn
	 * @param inputId
	 * @param inputPw
	 * @return loginMember
	 */
	public Member login(Connection conn, String inputId, String inputPw) throws Exception {
		
		Member loginMember = null;
		
		try {
			
			String sql = prop.getProperty("login");
			
			System.out.println(sql);
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, inputId);
			pstmt.setString(2, inputPw);
			
			rs = pstmt.executeQuery();
			
			System.out.println("rs::"+rs);
			
			if( rs.next() ) {
				
				loginMember = new Member();
				loginMember.setMemberNo( rs.getInt("MEMBER_NO") );
				loginMember.setMemberId( rs.getString("MEMBER_ID") );
				loginMember.setMemberNickname( rs.getString("MEMBER_NICKNAME") );
				loginMember.setEnrollDate( rs.getString("ENROLL_DATE") );
				
			}
			
		} finally {
			close(rs);
			close(pstmt);
		}
		
		System.out.println(loginMember);
		
		return loginMember;
	}

	
	
	/**	회원가입 SQL 수행 DAO
	 * @param conn
	 * @param member
	 * @return result
	 */
	public int signUp(Connection conn, Member member) throws Exception {
		
		int result = 0;
		
		try {
			
			String sql = prop.getProperty("signUp");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, member.getMemberId());
			pstmt.setString(2, member.getMemberPw());
			pstmt.setString(3, member.getMemberNickname());
			
			result = pstmt.executeUpdate();
			
		} finally {
			close(pstmt);
		}
		
		return result;
	}
}






















