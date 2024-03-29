package edu.kh.mysAgency.agent.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Agent {
	
	private int agentNo;
	private String agentName;
	private String email;
	private String phone;
	private String agentNationality;
	private String agentId;
	private String agentPw;

}
