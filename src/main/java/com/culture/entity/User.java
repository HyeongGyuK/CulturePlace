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
import org.springframework.ui.Model;

import com.culture.constant.Role;
import com.culture.dto.UserFormDto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "users")
@Getter @Setter @ToString
public class User {
    @Id
    @Column(name = "user_id") //데이터 베이스 컬림이 됨.
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String password;
    
    private String passwordCheck;
    
    private String name;

    @Column(unique = true)
    private String email;

    private String phone;
    

    private String address;

    @Enumerated(EnumType.STRING)
    private Role role; //일반인, 관리자 구분
    
//     화면에서 넘어 오는 dto 객체와 비번을 암호화 해주는 객체를 사용하여 Member Entity 객체 생성하기
    
    public static User createUser(UserFormDto userFormDto, PasswordEncoder passwordEncoder){
        User user = new User();
        
        user.setId(userFormDto.getId());
        user.setPassword(userFormDto.getPassword());
        user.setPasswordCheck(userFormDto.getPasswordCheck());
        user.setName(userFormDto.getName());
        user.setPhone(userFormDto.getPhone());
        user.setAddress(userFormDto.getAddress());
        user.setRole(Role.USER); //일반 사용자
        //member.setRole(Role.ADMIN); //관리자

        return user;
    }
}























