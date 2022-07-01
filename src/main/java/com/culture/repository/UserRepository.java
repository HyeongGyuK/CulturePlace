package com.culture.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.culture.entity.User;

//상속 받고 entity 이름 pk 매개변수로 넣어줘야함
public interface UserRepository extends JpaRepository<User, Long> {
    // findByEmail: 이메일을 이용하여 회원 검색, 가입시 중복 체크
	User findByEmail(String email);
}
