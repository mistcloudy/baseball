package com.ks.baseball.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.ks.baseball.vo.GameInfoVO;


public interface GameInfoDAO {
	
	
	public List<GameInfoVO> selectGameList (String memberNumber) throws DataAccessException;
	
	public void updateGameList (GameInfoVO gameVo) throws DataAccessException;
	
	public void insertGameList (GameInfoVO gameVo) throws DataAccessException;
	
	public void deleteGameList (GameInfoVO gameVo) throws DataAccessException;
	
	
//	@Autowired
//	private SqlSession session;
//	
//	public List<GameInfoVO> selectGameList(String member_number) {
//		List<GameInfoVO> game = null;
//		try {
//			GameInfoMapper mapper = session.getMapper(GameInfoMapper.class);
//			game = mapper.selectGameList(member_number);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return game;
//	}
//	
//	public String updateGameList(GameInfoVO entered_number) {
//		String enter = "0";
//		try {
//			GameInfoMapper mapper = session.getMapper(GameInfoMapper.class);
//			enter = mapper.updateGameList(entered_number);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return enter;
//	}
//	
//	//
//	
//	public String insertGameList(GameInfoVO entered_number) {
//		String enter = "0";
//		try {
//			GameInfoMapper mapper = session.getMapper(GameInfoMapper.class);
//			enter = mapper.insertGameList(entered_number);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return enter;
//	}
//	
//	public String deleteGameList(GameInfoVO logical_del_flag) {
//		String del ="0";
//		try {
//			GameInfoMapper mapper = session.getMapper(GameInfoMapper.class);
//			del = mapper.updateGameList(logical_del_flag);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return del;
//	}
}
