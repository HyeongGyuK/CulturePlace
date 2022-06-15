package com.culture.service;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

import com.culture.dto.UserFormDto;
import com.culture.entity.User;

@SpringBootTest
@Transactional // 테스트가 완료되고 나면, 자동으로 롤백이 됩니다.
public class UserServiceTest {
    @Autowired // 반드시 값을 넣어야 합니다.
    UserService userService;

    // required : 필요하면 넣어라
    @Autowired(required = false)
    PasswordEncoder passwordEncoder;

    //우리가 form에서 입력하여 넣은 데이터라고 보면 됩니다.
    private User createUser(){
        UserFormDto userFormDto = new UserFormDto();
        userFormDto.setEmail("test@email.com");
        userFormDto.setName("홍길동");
        userFormDto.setAddress("서울시 마포구 합정동");
        userFormDto.setPassword("1234");
        userFormDto.setPasswordCheck("1234");

        return User.createUser(userFormDto, passwordEncoder);
    }
    
    @Test //해당 메소드를 테스트용 메소드로 사용하겠습니다.
    @DisplayName("회원가입 테스트")
    public void saveUser(){
    User user = createUser(); // 사용자가 기입한 값

    //실제로 jpa를 통하여 데이터베이스에 저정된 값
    User savedUser = userService.saveUser(user);

        //assertEquals(기입한 값, 저장된 값) : 두 개의 값에 대한 비교를 수행합니다.
        Assertions.assertEquals(user.getEmail(), savedUser.getEmail());
        Assertions.assertEquals(user.getName(), savedUser.getName());
        Assertions.assertEquals(user.getAddress(), savedUser.getAddress());
        Assertions.assertEquals(user.getPassword(), savedUser.getPassword());
        Assertions.assertEquals(user.getRole(), savedUser.getRole());
    }

    @Test
    @DisplayName("이메일 중복인지 테스트 하기")
    public void saveDuplicateTest(){
        // 이미 저장되어 있는 회원
        User user1 = createUser();

        // 이번에 저장할 회원 정보
        User user2 = createUser();

        userService.saveUser(user1); // 1번 회원 저장
        
        Throwable err = Assertions.assertThrows(IllegalStateException.class, ()-> {
           userService.saveUser(user2); // 동일한 이메일을 가지고 2번 회원 저장하기
        });
        System.out.println("예외 메세지 검증하기");
        Assertions.assertEquals("이미 가입된 회원입니다.", err.getMessage());
        err.printStackTrace();
    }
}



























