package com.ks.baseball.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.ks.baseball.dao.PointDAOImpl;
import com.ks.baseball.vo.PointVO;

@Service("pointService")
public class PointServiceImpl implements PointService {
	
	@Inject
	private PointDAOImpl dao;
	
	
	@Override
	public List<PointVO> selectPointList (String memberNumber) throws DataAccessException {
		return dao.selectPointList(memberNumber);
	}
	@Override
	public void insertPointList (PointVO pointVo) throws DataAccessException {
		dao.insertPointList(pointVo);
	}
	@Override
	public void updatePointList (PointVO pointVo) throws DataAccessException {
		dao.updatePointList(pointVo);
	}
	@Override
	public void  endPointList (PointVO pointVo) throws DataAccessException {
		dao.endPointList(pointVo);
	}
	
}
