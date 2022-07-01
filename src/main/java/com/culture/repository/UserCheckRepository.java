package com.culture.repository;

public interface UserCheckRepository {
    // 아이디 중복 체크
    public int idCheck(String MId);
}
