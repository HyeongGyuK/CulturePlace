package com.culture.service;

import com.culture.repository.MemberRepository;
import com.culture.repository.UserCheckRepository;
import com.culture.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserCheckService{

    @Autowired
    private UserCheckRepository userCheckRepository;

    // 아이디 중복 체크

    @Override
    public int idCheck(String MId) {
        int cnt = userCheckRepository.idCheck(MId);
        return cnt;
    }
}
