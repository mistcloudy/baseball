package com.ks.baseball.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.ks.baseball.util.HelpSqlSessionTemplate;
import com.ks.baseball.vo.MemberVO;

@Repository
public class MemberDAOImpl  extends HelpSqlSessionTemplate implements MemberDAO {

    @Override
    public List<MemberVO> selectMemberList(String member_number) throws DataAccessException {
        return getSqlSessionTemplate().selectList("member.selectMemberList", member_number);
    }
}
