package com.culture.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryImpl implements UserCheckRepository {
    @Autowired
    private SqlSession sqlSession;

    private static final String NAMESPACE = "mybatis.mapper.UserMapper";

    // 아이디 중복 체크
    @Override
    public int idCheck(String MId) {
        int cnt = sqlSession.selectOne(NAMESPACE+".idCheck", MId);
        return cnt;
    }
}