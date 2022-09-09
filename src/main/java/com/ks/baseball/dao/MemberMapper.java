package com.ks.baseball.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.ks.baseball.vo.MemberVO;

public interface MemberMapper {

	public List<MemberVO> selectMemberList (String member_number) throws DataAccessException;
}
