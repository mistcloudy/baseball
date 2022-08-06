package com.ks.baseball.vo;

import lombok.Data;

@Data
public class GameInfoVO {

	private int game_number;
	private int member_number;
	private String entered_number;
	private String rec_create_date;
	private String rec_update_date;
	private String logical_del_flag;
}
