package com.culture.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;




// PersonDto 클래스를 이용하여 thymeleaf 코드를 작성햐여 보세요.
@Getter @Setter @ToString
public class PersonDto {
    private Long id;
    private String name;
    private Integer age;
    private String address;
    private String gender;
    private LocalDateTime regTime;
}
