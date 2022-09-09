package com.ks.baseball.service;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.ks.baseball.dao.MemberDAOImpl;
import com.ks.baseball.vo.MemberVO;

@Service("memberService")
public class MemberServiceImpl implements MemberService  {
	@Inject
	private MemberDAOImpl dao;
	

    @Override
    public List<MemberVO> getLoginMemberList(String member_number) throws DataAccessException {

        List<MemberVO> memberList = new ArrayList<MemberVO>();
        memberList = dao.selectMemberList(member_number);

        return memberList;
    }
}
