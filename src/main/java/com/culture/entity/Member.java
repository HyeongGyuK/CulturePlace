package com.culture.entity;

import com.culture.constant.Role;
import com.culture.dto.MemberFormDto;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;

@Entity
@Table(name = "member")
@Getter @Setter @ToString
public class Member {
    @Id
    @Column(name = "member_idSn") //데이터 베이스 컬림이 됨.
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idSn;

    @Column(unique = true)
    private String MId;

    private String name;

    private String email;

    private String password;

    private String address;

    private String zonecode;

    private String address2;

    private String detailAddress;

    @Enumerated(EnumType.STRING)
    private Role role; //일반인, 관리자 구분
    // 화면에서 넘어 오는 dto 객체와 비번을 암호화 해주는 객체를 사용하여 Member Entity 객체 생성하기
    public static Member createMember(MemberFormDto memberFormDto, PasswordEncoder passwordEncoder){
        Member member = new Member();

        member.setMId(memberFormDto.getMId());
        member.setName(memberFormDto.getName());
        member.setEmail(memberFormDto.getEmail());
        member.setAddress(memberFormDto.getAddress());
        member.setAddress2(memberFormDto.getAddress2());
        member.setAddress2(memberFormDto.getAddress2());
        member.setZonecode(memberFormDto.getZonecode());
        member.setDetailAddress(memberFormDto.getDetailAddress());
        //비밀번호 암호화 하는 방법
        String password = passwordEncoder.encode(memberFormDto.getPassword());
        member.setPassword(password);
        member.setRole(Role.USER); //일반 사용자
        //member.setRole(Role.ADMIN); //관리자

        return member;
    }
}























