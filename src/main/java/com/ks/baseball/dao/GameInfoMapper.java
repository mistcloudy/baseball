package com.ks.baseball.dao;

import java.util.List;

import com.ks.baseball.vo.GameInfoVO;

public interface GameInfoMapper {
	
	public List<GameInfoVO> selectGameList(String member_number);
	
	public String updateGameList(GameInfoVO entered_number);
	
	//
	
	public String insertGameList(GameInfoVO entered_number);
	
	public String deleteGameList(GameInfoVO logical_del_flag);
	
}
