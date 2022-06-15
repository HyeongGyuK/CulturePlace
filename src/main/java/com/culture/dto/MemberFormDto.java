package com.culture.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import com.culture.controller.Member.ValidationGroups;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

// Dto 객체 : 가입 화면에서 데이터(Data)가 전송(Transfer)될 때 값을 저장할 객체(Object)
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class MemberFormDto {

	@NotBlank(message = "아이디는 필수 입력값입니다.")
	@Pattern(regexp = "[a-zA-Z0-9]{2,9}",
			message = "아이디는 영문, 숫자만 가능하며 2 ~ 10자리까지 가능합니다.")
    private String id;

	@NotBlank(message = "비밀번호는 필수 입력값입니다.")
    @Pattern(regexp = "^(?=.*\\d)(?=.*[a-zA-Z])[0-9a-zA-Z]{8,16}",
             message = "비밀번호는 영문과 숫자 조합으로 8 ~ 16자리까지 가능합니다.")
    private String password;

	@NotBlank(message = "이메일은 필수 입력값입니다.")
	@Pattern(regexp = "^[0-9a-zA-Z]([-_\\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\\.]?[0-9a-zA-Z])*\\.[a-zA-Z]{2,3}",
			message = "올바르지 않은 이메일 형식입니다.")
	@Email(message = "이메일 형식으로 넣어주세요.")
	private String email;
	 
    @NotEmpty(message = "주소는 필수 입력 값입니다.")
    private String address;

}
