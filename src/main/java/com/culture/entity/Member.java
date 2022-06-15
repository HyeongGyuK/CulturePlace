package com.culture.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.security.crypto.password.PasswordEncoder;

import com.culture.constant.Role;
import com.culture.dto.MemberFormDto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "member")
@Getter @Setter @ToString
public class Member {
    @Id
    @Column(name = "member_id") //데이터 베이스 컬림이 됨.
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @Column(unique = true)
    private String email;

    private String password;

    private String address;

    @Enumerated(EnumType.STRING)
    private Role role; //일반인, 관리자 구분
    // 화면에서 넘어 오는 dto 객체와 비번을 암호화 해주는 객체를 사용하여 Member Entity 객체 생성하기
    public static Member createMember(MemberFormDto memberFormDto, PasswordEncoder passwordEncoder){
        Member member = new Member();
        
        member.setName(memberFormDto.getId());
        member.setEmail(memberFormDto.getEmail());
        member.setAddress(memberFormDto.getAddress());
        //비밀번호 암호화 하는 방법
        String password = passwordEncoder.encode(memberFormDto.getPassword());
        member.setPassword(password);
        member.setRole(Role.USER); //일반 사용자
        //member.setRole(Role.ADMIN); //관리자

        return member;
    }
}























