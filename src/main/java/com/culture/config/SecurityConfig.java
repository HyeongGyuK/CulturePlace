package com.culture.config;

import com.culture.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
//    	http.csrf().disable();
        //차후 구성할 예정
        http.formLogin()
                .loginPage("/users/login") //로그인 페이지 이동
                .defaultSuccessUrl("/") //메인 페이지 이동
                .usernameParameter("MId") // email로 체크
                .passwordParameter("password")
                .failureUrl("/users/login/error")
                .and()
                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout")) //사용하지 않고 logout("/members/logout") 이렇게 바로 사용해도 됨.
                .logoutSuccessUrl("/") ; //메인페이지

        /*
            authorizeRequests : 시큐리티에서 request를 사용하고자 할때 사용하는 메소드 입니다.
            permitAll(): 로그인 하지 않아도 접근 가능하게 할께요.
            anyRequest().authenticated() : 상기 위에서 열거한 내용 이외에 모든 항목 인증을 요구합니다.
        */
        http.authorizeRequests()
                .mvcMatchers("/", "/users/**", "/item/**", "/images/**", "/Culture/images/**", "/CulturePlaceMain/**", "/test/**", "/login/**", "/members/**", "/culturePlace/**", "/move/**").permitAll()
                .mvcMatchers("/", "/users/**", "/item/**", "/images/**", "/Culture/images/**", "/CulturePlaceMain/**", "/test/**", "/CommunityMain/**", "/board/test").permitAll()
                .mvcMatchers("/admin/**").hasRole("ADMIN")
                .anyRequest().authenticated();

        /* 인증받지 못한 사용자가 접근 시도시 http 응답 코드 401울 보여 줍니다. */
        http.exceptionHandling().authenticationEntryPoint((AuthenticationEntryPoint) new CustomAuthenticationEntryPoint());
    }

    @Override
    public void configure(WebSecurity web) throws Exception{
        // 다음 항목들은 인증 절차를 무시하도록 하겠습니다.
        web.ignoring().antMatchers("/css/**", "/js/**", "/img/**", "/CulturePlace/**", "/Culture/**", "/members/**", "/test/**", "/webapp/Culture/CulturePlace/**");
    }
//    권한을 주어야 로그인 화면이 나타납니다.


    @Autowired
    MemberService memberService;


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{

        // 인증 관리자(AuthenticationManager) 객체에 회원 정보를 읽어 오는 UserDetailService 객체를 지정해
        // 주어야 하는 데, memberService 를 지정해줍니다.
        // 그리고, 암호화 객체도 지정해 주어야 하는데 passwordEncoder() 메소드를 호출하면 해결됩니다.
        auth.userDetailsService(memberService).passwordEncoder(passwordEncoder());
    }


    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}




















