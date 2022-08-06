package com.ks.baseball.vo;

import lombok.Data;

@Data
public class PointVO {
	
	private int member_number;
	private int point;
	private String rec_create_date;
	private String rec_update_date;
	private String logical_del_flag;
	private String game_finish_flag;

}
