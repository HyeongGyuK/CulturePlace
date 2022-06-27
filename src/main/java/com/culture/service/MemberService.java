package com.culture.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.culture.entity.Member;
import com.culture.repository.MemberRepository;

import lombok.RequiredArgsConstructor;


@Service
@Transactional
@RequiredArgsConstructor // final이나 @NotNull이 붙어 있는 변수에 생성자를 만들어 줍니다.
public class MemberService implements UserDetailsService {
    // final : 읽기 전용
    private final MemberRepository memberRepository;

    public Member saveMember(Member member){
        validateDuplicateMember(member);
        return memberRepository.save(member);
    }

    private void validateDuplicateMember(Member member) {
        //이메일로 체크함, null이 아니면 이미 존재하는 아이디
//        Member findMember = memberRepository.findByEmail(member.getEmail());
        Member findMember = memberRepository.findByMId(member.getMId());
        if(findMember != null){
            throw new IllegalStateException("이미 가입된 회원입니다.");
            
        }
    }

    @Override //이메일을 이용하여 회원 정보 찾기 (email이 PK 역할을 합니다.)
    public UserDetails loadUserByUsername(String MId) throws UsernameNotFoundException {
//        Member member = memberRepository.findByEmail(id);
        Member member = memberRepository.findByMId(MId);
        if (member == null){// 회원이 존재하지 않는 경우
            throw new UsernameNotFoundException(MId);
        }
        return User.builder()
                .username(member.getMId())
                .password(member.getPassword())
                .roles(member.getRole().toString())
                .build()
                ;
    }


}






























