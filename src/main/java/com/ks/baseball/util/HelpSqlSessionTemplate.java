package com.ks.baseball.util;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

public class HelpSqlSessionTemplate {
    @Autowired
    SqlSessionTemplate sqlSessionTemplate;
    
    public SqlSessionTemplate getSqlSessionTemplate() {
        return sqlSessionTemplate;
    }
}
