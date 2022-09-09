package com.ks.baseball.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.ks.baseball.util.HelpSqlSessionTemplate;
import com.ks.baseball.vo.GameInfoVO;

@Repository
public class GameInfoDAOImpl extends HelpSqlSessionTemplate implements GameInfoDAO {
	
	@Override
	public List<GameInfoVO> selectGameList (String memberNumber) throws DataAccessException {
		return getSqlSessionTemplate().selectList("game.selectGameList", memberNumber);
	}
	@Override
	public void updateGameList (GameInfoVO gameVo) throws DataAccessException{
		getSqlSessionTemplate().update("game.updateGameList", gameVo);
	}
	@Override
	public void insertGameList (GameInfoVO gameVo) throws DataAccessException{
		getSqlSessionTemplate().insert("game.insertGameList", gameVo);
	}
	@Override
	public void deleteGameList (GameInfoVO gameVo) throws DataAccessException{
		getSqlSessionTemplate().update("game.deleteGameList", gameVo);
	}
}
