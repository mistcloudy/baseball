package com.ks.baseball.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.ks.baseball.vo.GameInfoVO;
import com.ks.baseball.vo.PointVO;

public interface PointDAO {

	public List<PointVO> selectPointList (String memberNumber) throws DataAccessException;
	
	public void insertPointList (PointVO pointVo) throws DataAccessException;
	
	public void updatePointList (PointVO pointVo) throws DataAccessException;
	
	public void  endPointList (PointVO pointVo) throws DataAccessException;
	
	
//	@Autowired
//	private SqlSession session;
//	
//	public PointVO selectPointList(int member_number) {
//		PointVO point = null;
//		
//		try {
//			PointMapper mapper = session.getMapper(PointMapper.class);
//			point = mapper.selectPointList(member_number);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return point;
//	}
//	
//	public int insertPointList (PointVO point) {
//		int cnt = 0;
//		try {
//			PointMapper mapper = session.getMapper(PointMapper.class);
//			cnt = mapper.insertPointList(point);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return cnt;
//	}
//	
//	public int updatePointList (PointVO point) {
//		int cnt = 0;
//		try {
//			PointMapper mapper = session.getMapper(PointMapper.class);
//			cnt = mapper.updatePointList(point);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return cnt;
//	}
//	
//	public String endPointList (PointVO game_finish_flag) {
//		String end ="0";
//		try {
//			PointMapper mapper = session.getMapper(PointMapper.class);
//			end = mapper.endPointList(game_finish_flag);
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return end;
//	}
}
