package edu.kh.mysAgency.agent.model.dao;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import edu.kh.mysAgency.agent.model.dto.Agent;
import edu.kh.mysAgency.player.model.dto.Player;

import static edu.kh.mysAgency.common.JDBCTemplate.*;

public class AgentDAO {
	
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private Properties prop;
	
	
	public AgentDAO() {
		
		try {
			
			prop = new Properties();
			
			String filePath = AgentDAO.class.getResource("/edu/kh/mysAgency/sql/agent-sql.xml").getPath();
			
			prop.loadFromXML( new FileInputStream(filePath) );
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	

	/** 로그인 SQL 수행 DAO
	 * @param conn
	 * @param inputId
	 * @param inputPw
	 * @return agent
	 */
	public Agent login(Connection conn, String inputId, String inputPw) throws Exception {
		
		Agent agent = null;
		
		try {
			
			String sql = prop.getProperty("login");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, inputId);
			pstmt.setString(2, inputPw);
			
			rs = pstmt.executeQuery();
			
			if( rs.next() ) {
				
				agent = new Agent();
				
				agent.setAgentNo( rs.getInt("AGENT_NO") );
				agent.setAgentName( rs.getString("AGENT_NAME") );
				agent.setEmail( rs.getString("AGENT_EMAIL") );
				agent.setPhone( rs.getString("AGENT_PHONE") );
				agent.setAgentNationality( rs.getString("AGENT_NATIONALITY") );
				agent.setAgentId( rs.getString("AGENT_ID") );
				
				
			}
			
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return agent;
	}


	/** 소속 선수 리스트 조회 SQL 수행 DAO
	 * @param conn
	 * @param agentNo
	 * @return playerList
	 */
	public List<Player> selectAll(Connection conn, int agentNo) throws Exception {
		
		List<Player> playerList = new ArrayList<Player>();
		
		try {
			
			String sql = prop.getProperty("selectAll");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, agentNo);
			
			rs = pstmt.executeQuery();
			
			while ( rs.next() ) {
				
				Player player = new Player();
				
				int playerNo = rs.getInt("PLAYER_NO");
				String playerName = rs.getString("PLAYER_NAME");
				int playerAge = rs.getInt("PLAYER_AGE");
				String playerTeam = rs.getString("PLAYER_TEAM");
				int playerBackNum = rs.getInt("PLAYER_BACKNUM");
				String playerNationality = rs.getString("PLAYER_NATIONALITY");
				String playerMemo = rs.getString("PLAYER_MEMO");
				String medicalCheck = rs.getString("MEDICAL_CHECK");
				int agentNum = rs.getInt("AGENT_NO");
				
				player.setPlayerNo(playerNo);
				player.setPlayerName(playerName);
				player.setPlayerAge(playerAge);
				player.setPlayerTeam(playerTeam);
				player.setPlayerBackNum(playerBackNum);
				player.setPlayerNationality(playerNationality);
				player.setPlayerMemo(playerMemo);
				player.setMedicalCheck(medicalCheck);
				player.setAgentNo(agentNum);
				
				playerList.add(player);
				
			}
			
		} finally {
			close(rs);
			close(pstmt);
		}
		
		
		return playerList;
	}


	/** 회원가입 SQL 수행 DAO
	 * @param conn
	 * @param agent
	 * @return result
	 */
	public int signUp(Connection conn, Agent agent) throws Exception {
		
		int result = 0;
		
		try {
			
			String sql = prop.getProperty("signUp");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, agent.getAgentName());
			pstmt.setString(2, agent.getEmail());
			pstmt.setString(3, agent.getPhone());
			pstmt.setString(4, agent.getAgentNationality());
			pstmt.setString(5, agent.getAgentId());
			pstmt.setString(6, agent.getAgentPw());
			
			result = pstmt.executeUpdate();
			
		} finally {
			close(pstmt);
		}
		
		
		return result;
	}


	/** 선수등록 SQL 수행 DAO
	 * @param conn
	 * @param inputName
	 * @param inputAge
	 * @param inputTeam
	 * @param inputNationality
	 * @param agentNo
	 * @return result
	 */
	public int insert(Connection conn, String inputName, int inputAge, String inputTeam, String inputNationality,
			int agentNo) throws Exception {
		
		int result = 0;
		
		try {
			
			String sql = prop.getProperty("insert");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, inputName);
			pstmt.setInt(2, inputAge);
			pstmt.setString(3, inputTeam);
			pstmt.setString(4, inputNationality);
			pstmt.setInt(5, agentNo);
			
			result = pstmt.executeUpdate();
			
		} finally {
			close(pstmt);
		}
		
		return result;
		
	}


	/** 선수 삭제 SQL 수행 DAO
	 * @param conn
	 * @param playerNo
	 * @return result
	 */
	public int delete(Connection conn, String playerNo) throws Exception {
		
		int result = 0;
		
		try {
			
			String sql = prop.getProperty("delete");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, playerNo);
			
			result = pstmt.executeUpdate();
			
		} finally {
			close(pstmt);
		}
		
		
		return result;
	}


	/** 선수 한명 조회 SQL 수행 DAO
	 * @param conn
	 * @param playerNo
	 * @return player
	 */
	public Player selectOne(Connection conn, String playerNo) throws Exception {
		
		Player player = null;
		
		try {
			
			String sql = prop.getProperty("selectOne");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, playerNo);
			
			rs = pstmt.executeQuery();
			
			if( rs.next() ) {
				
				player = new Player();
				
				player.setPlayerNo( rs.getInt("PLAYER_NO") );
				player.setPlayerName( rs.getString("PLAYER_NAME") );
				player.setPlayerAge( rs.getInt("PLAYER_AGE") );
				player.setPlayerTeam( rs.getString("PLAYER_TEAM") );
				player.setPlayerBackNum( rs.getInt("PLAYER_BACKNUM") );
				player.setPlayerNationality( rs.getString("PLAYER_NATIONALITY") );
				player.setPlayerMemo( rs.getString("PLAYER_MEMO") );
				player.setMedicalCheck( rs.getString("MEDICAL_CHECK") );
				player.setAgentNo( rs.getInt("AGENT_NO") );
				
			}
			
		} finally {
			close(rs);
			close(pstmt);
		}
		
		
		return player;
	}


	/** 선수 정보 수정 SQL 수행 DAO
	 * @param conn
	 * @param inputTeam
	 * @param inputBackNum
	 * @param memo
	 * @param medicalCheck
	 * @param playerNo
	 * @return result
	 */
	public int update(Connection conn, String inputTeam, int inputBackNum, String memo, String medicalCheck,
			String playerNo) throws Exception {
		
		int result = 0;
		
		try {
			
			String sql = prop.getProperty("update");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, inputTeam);
			pstmt.setInt(2, inputBackNum);
			pstmt.setString(3, memo);
			pstmt.setString(4, medicalCheck);
			pstmt.setString(5, playerNo);
			
			result = pstmt.executeUpdate();
			
		} finally {
			close(pstmt);
		}
		
		return result;
	}

}















