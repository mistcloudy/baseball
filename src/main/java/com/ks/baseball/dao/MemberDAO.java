package com.ks.baseball.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.ks.baseball.vo.MemberVO;


public interface MemberDAO {
	  public List<MemberVO> selectMemberList(String member_number)  throws DataAccessException;
	
	
	
	
//	@Autowired
//	private SqlSession session;
//
//	public List<MemberVO> selectMemberList(String member_number) throws DataAccessException {
//		List<MemberVO> member = null;
//		MemberMapper mapper = session.getMapper(MemberMapper.class);
//		member = mapper.selectMemberList(member_number);
//
//		return member;
//	}
}
