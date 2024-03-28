package edu.kh.mysAgency.player.model.dto;

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
public class Player {
	
	private int playerNo;
	private String playerName;
	private int playerAge;
	private String playerTeam;
	private int playerBackNum;
	private String playerNationality;
	private String playerMemo;
	private String medicalCheck;
	private int agentNo;

}
