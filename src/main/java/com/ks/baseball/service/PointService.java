package com.ks.baseball.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.ks.baseball.dao.PointDAO;
import com.ks.baseball.vo.PointVO;

public interface PointService {

//	@Autowired
//	private PointDAO dao;
//	@Autowired
//	private HttpSession session;
	
	public List<PointVO> selectPointList (String memberNumber) throws DataAccessException;
	
	public void insertPointList (PointVO pointVo) throws DataAccessException;
	
	public void updatePointList (PointVO pointVo) throws DataAccessException;
	
	public void  endPointList (PointVO pointVo) throws DataAccessException;
	
	
}
