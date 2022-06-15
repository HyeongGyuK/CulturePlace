package com.culture.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// Dto 객체 : 가입 화면에서 데이터(Data)가 전송(Transfer)될 때 값을 저장할 객체(Object)
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class UserFormDto {




//	@NotEmpty(message = "아이디는 필수 입력 값입니다.")
	@Pattern(regexp = "[a-zA-Z0-9]{2,9}",
	message = "아이디는 영문, 숫자만 가능하며 2 ~ 10자리까지 가능합니다.")
    private Long id;

//	@NotBlank(message = "비밀번호는 필수 입력값입니다.", groups = ValidationGroups.NotEmptyGroup.class)
//    @Pattern(regexp = "^(?=.*\\d)(?=.*[a-zA-Z])[0-9a-zA-Z]{8,16}",
//             message = "비밀번호는 영문과 숫자 조합으로 8 ~ 16자리까지 가능합니다.")
//	@NotEmpty(message = "비밀번호는 필수 입력 값입니다.")
	
    @Length(min = 8, max = 16, message = "비밀번호는 8자 이상 16자 이하로 입력해주세요.")
    private String password;
	
//	@NotEmpty(message = "비밀번호를 한번 더 입력해주세요.")
    @Length(min = 8, max = 16, message = "비밀번호를 정확히 입력해주세요.")
    private String passwordCheck;

	@NotEmpty(message = "이름은 필수 입력 값입니다.")
    private String name;

	
	@NotEmpty(message = "전화번호는 필수 입력 값입니다.")
	@Pattern(regexp = "[0-9]",
	message = "전화번호는 숫자만 가능합니다.")
	private String phone;

	
//	@NotBlank(message = "이메일은 필수 입력값입니다." , groups = ValidationGroups.NotEmptyGroup.class)
//	@Pattern(regexp = "^[0-9a-zA-Z]([-_\\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\\.]?[0-9a-zA-Z])*\\.[a-zA-Z]{2,3}",
//			message = "올바르지 않은 이메일 형식입니다.", groups = ValidationGroups.PatternCheckGroup.class)
//	@Email(message = "이메일 형식으로 넣어주세요.")
	@NotEmpty(message = "이메일을 입력해주세요.")
    @Email(message = "이메일 형식으로 넣어주세요.")
	private String email;
	 
//    @NotEmpty(message = "주소는 필수 입력 값입니다.", groups = ValidationGroups.NotEmptyGroup.class)
	@NotEmpty(message = "주소는 필수 입력 값입니다.")
    private String address;

}
