package com.ks.baseball.vo;

import lombok.Data;

@Data
public class GameInfoVO {

	private String game_number;
	private String member_number;
	private String hidden_number;
	private String entered_number;
	private String rec_create_date;
	private String rec_update_date;
	private String logical_del_flag;
}
