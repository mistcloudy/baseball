package com.ks.baseball.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.ks.baseball.dao.MemberDAO;
import com.ks.baseball.vo.MemberVO;


public interface MemberService {
	
	public List<MemberVO> getLoginMemberList(String member_number) throws DataAccessException;
	
	
//	@Autowired
//	private MemberDAO dao;
//	@Autowired
//	private HttpSession session;
//	
//
//	public List<MemberVO> selectMemberList(String member_number) throws DataAccessException {
//		// TODO Auto-generated method stub
//		List<MemberVO> memberList = new ArrayList<MemberVO>();
//		memberList = dao.selectMemberList(member_number);
//		return memberList;
//	}

}
