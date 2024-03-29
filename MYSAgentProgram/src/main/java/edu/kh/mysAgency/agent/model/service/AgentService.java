package edu.kh.mysAgency.agent.model.service;

import java.sql.Connection;
import java.util.List;

import edu.kh.mysAgency.agent.model.dao.AgentDAO;
import edu.kh.mysAgency.agent.model.dto.Agent;
import edu.kh.mysAgency.player.model.dto.Player;

import static edu.kh.mysAgency.common.JDBCTemplate.*;

public class AgentService {

	AgentDAO dao = new AgentDAO();
	
	
	/** 로그인 서비스
	 * @param inputId
	 * @param inputPw
	 * @return agent
	 */
	public Agent login(String inputId, String inputPw) throws Exception {
		
		Connection conn = getConnection();
		
		Agent agent = dao.login(conn, inputId, inputPw);
		
		close(conn);
		
		return agent;
	}


	/** 소속 선수 리스트 조회 서비스
	 * @param agentNo
	 * @return playerList
	 */
	public List<Player> selectAll(int agentNo) throws Exception {
		
		Connection conn = getConnection();
		
		List<Player> playerList = dao.selectAll(conn, agentNo);
		
		close(conn);
		
		
		return playerList;
	}


	/** 회원가입 서비스
	 * @param agent
	 * @return result
	 */
	public int signUp(Agent agent) throws Exception {
		
		Connection conn = getConnection();
		
		int result = dao.signUp(conn, agent);
		
		if(result > 0) commit(conn);
		else			rollback(conn);
		
		close(conn);
		
		return result;
	}


	/** 선수 등록 서비스
	 * @param inputName
	 * @param inputAge
	 * @param inputTeam
	 * @param inputNationality
	 * @param agentNo
	 * @return result;
	 */
	public int insert(String inputName, int inputAge, String inputTeam, String inputNationality, int agentNo) throws Exception {
		
		Connection conn = getConnection();
		
		int result = dao.insert(conn, inputName, inputAge, inputTeam, inputNationality , agentNo);
		
		if(result > 0) commit(conn);
		else			rollback(conn);
		
		close(conn);
		
		
		return result;
	}


	/** 선수 삭제 서비스
	 * @param playerNo
	 * @return result
	 */
	public int delete(String playerNo) throws Exception {
		
		Connection conn = getConnection();
		
		int result = dao.delete(conn, playerNo);
		
		if(result > 0) commit(conn);
		else 			rollback(conn);
		
		close(conn);
		
		return result;
	}


	/** 선수 한명 조회 서비스
	 * @param playerNo
	 * @return player
	 */
	public Player selectOne(String playerNo) throws Exception {
		
		Connection conn = getConnection();
		
		Player player = dao.selectOne(conn, playerNo);
		
		close(conn);
		
		return player;
	}


	/** 선수 정보 수정 서비스
	 * @param inputTeam
	 * @param inputBackNum
	 * @param memo
	 * @param medicalCheck
	 * @param playerNo
	 * @return result
	 */
	public int update(String inputTeam, int inputBackNum, String memo, String medicalCheck, String playerNo) throws Exception {
		
		Connection conn = getConnection();
		
		int result = dao.update(conn, inputTeam, inputBackNum, memo, medicalCheck, playerNo);
		
		if(result > 0) commit(conn);
		else			rollback(conn);
		
		close(conn);
		
		return result;
	}

}
















