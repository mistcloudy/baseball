package com.ks.baseball.dao;

import com.ks.baseball.vo.PointVO;

public interface PointMapper {

	public PointVO selectPointList (int member_number);
	
	public int insertPointList (PointVO point);
	
	public int updatePointList (PointVO point);
	
	public String endPointList (PointVO game_finish_flag);
}
