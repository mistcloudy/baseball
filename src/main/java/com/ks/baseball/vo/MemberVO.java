package com.ks.baseball.vo;

import lombok.Data;

@Data
public class MemberVO {

	private String member_number;
	private String member_name;
	private String member_password;
	private String rec_create_date;
	private String rec_update_date;
	private String logical_del_flag;
	
}
