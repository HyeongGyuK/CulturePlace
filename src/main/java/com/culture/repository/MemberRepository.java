package com.culture.repository;

import com.culture.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

//상속 받고 entity 이름 pk 매개변수로 넣어줘야함
public interface MemberRepository extends JpaRepository<Member, String> {
    // findByEmail: 이메일을 이용하여 회원 검색, 가입시 중복 체크
//    Member findByEmail(String email);
    Member findByMId(String mId);

}
