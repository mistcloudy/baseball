package com.ks.baseball.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.ks.baseball.util.HelpSqlSessionTemplate;
import com.ks.baseball.vo.PointVO;

@Repository
public class PointDAOImpl extends HelpSqlSessionTemplate implements PointDAO {
	@Override
	public List<PointVO> selectPointList (String memberNumber) throws DataAccessException {
		return getSqlSessionTemplate().selectList("point.selectPointList", memberNumber);
	}
	@Override
	public void insertPointList (PointVO pointVo) throws DataAccessException {
		getSqlSessionTemplate().insert("point.insertPointList", pointVo);
	}
	@Override
	public void updatePointList (PointVO pointVo) throws DataAccessException {
		getSqlSessionTemplate().update("point.updatePointList", pointVo);
	}
	@Override
	public void  endPointList (PointVO pointVo) throws DataAccessException {
		getSqlSessionTemplate().update("point.endPointList", pointVo);
	}
	
	
}
