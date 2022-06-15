package com.culture.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.culture.entity.User;
import com.culture.repository.UserRepository;

import lombok.RequiredArgsConstructor;


@Service
@Transactional
@RequiredArgsConstructor // final이나 @NotNull이 붙어 있는 변수에 생성자를 만들어 줍니다.
public class UserService implements UserDetailsService {
    // final : 읽기 전용
    private final UserRepository userRepository;

    public User saveUser(User user){
        validateDuplicateUser(user);
        return userRepository.save(user);
    }

    private void validateDuplicateUser(User user) {
        //이메일로 체크함, null이 아니면 이미 존재하는 아이디
    	User findMember = userRepository.findByEmail(user.getEmail());
        if(findMember != null){
            throw new IllegalStateException("이미 가입된 회원입니다.");
            
        }
    }

    @Override //이메일을 이용하여 회원 정보 찾기 (email이 PK 역할을 합니다.)
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
    	User user = userRepository.findByEmail(email);
        if (user == null){// 회원이 존재하지 않는 경우
            throw new UsernameNotFoundException(email);
        }
        //내장클래스에 들어있는 USER이다
        return org.springframework.security.core.userdetails.User.builder()
        		.username(user.getEmail())
				.password(user.getPassword())
				.roles(user.getRole().toString())
				.build()
				;
               
    }

}






























