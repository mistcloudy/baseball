package com.ks.baseball.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.ks.baseball.dao.GameInfoDAO;
import com.ks.baseball.vo.GameInfoVO;
import com.ks.baseball.vo.MemberVO;


public interface GameInfoService {


	public List<GameInfoVO> selectGameList (String memberNumber) throws DataAccessException;
	
	public void updateGameList (GameInfoVO gameVo) throws DataAccessException;
	
	public void insertGameList (GameInfoVO gameVo) throws DataAccessException;
	
	public void deleteGameList (GameInfoVO gameVo) throws DataAccessException;
	
	
	
//	@Autowired
//	private GameInfoDAO dao;
//	@Autowired
//	private HttpSession session;
//	
//	public List<GameInfoVO> selectGameList(String member_number) {
//		List<GameInfoVO> gameList = new ArrayList<GameInfoVO>();
//		gameList = dao.selectGameList(member_number);
//		return null;
//		
//	}
//	
//	public void updateGameList() {
//		
//	}
//	
//	//
//	
//	public void insertGameList() {
//		
//	}
//	
//	public void deleteGameList() {
//		
//	}
//
//	public void logout() {
//		// TODO Auto-generated method stub
//		
//	}
}
