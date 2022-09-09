package com.ks.baseball.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.ks.baseball.dao.GameInfoDAOImpl;
import com.ks.baseball.vo.GameInfoVO;

@Service("gameInfoService")
public class GameInfoServiceImpl  implements GameInfoService {
	

	@Inject
	private GameInfoDAOImpl dao;
	
	@Override
	public List<GameInfoVO> selectGameList (String memberNumber) throws DataAccessException {
		return dao.selectGameList(memberNumber);
	}
	
	@Override
	public void updateGameList (GameInfoVO gameVo) throws DataAccessException{
		dao.updateGameList(gameVo);
	}
	
	@Override
	public void insertGameList (GameInfoVO gameVo) throws DataAccessException{
		dao.insertGameList(gameVo);
	}
	
	@Override
	public void deleteGameList (GameInfoVO gameVo) throws DataAccessException{
		dao.deleteGameList(gameVo);
	}
}
