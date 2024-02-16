package com.example.demo.user;


import java.sql.Date;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserCreateForm {
	 @Size(min = 3, max = 25, message = "아이디 길이는 3~25 사이여야 합니다.")
	    @NotEmpty(message = "사용자ID는 필수항목입니다.")
	    @Pattern(regexp = "^[^@]+$", message = "아이디에 '@' 문자를 포함할 수 없습니다.") 
	private String username;

	 @NotBlank(message = "비밀번호를 입력해주세요.")
	    @Size(min = 8, max = 20, message = "비밀번호는 8자 이상 20자 이하로 입력해주세요.")
	    private String password1;
    
	 @NotBlank(message = "비밀번호를 다시 입력해주세요.")
	    @Size(min = 8, max = 20, message = "비밀번호는 8자 이상 20자 이하로 입력해주세요.")
	    private String password2;

	 @NotBlank(message = "닉네임을 입력해주세요.")
	    @Size(min = 2, max = 10, message = "닉네임은 2자 이상 10자 이하로 입력해주세요.")
	    private String nick;
	 
	 
    @NotBlank(message = "휴대폰 번호를 입력해주세요.")
    @Pattern(regexp = "(01[016789])(\\d{3,4})(\\d{4})", message = "올바른 휴대폰 번호를 입력해주세요.")
    private String phone;
    
    @NotNull(message = "생년월일은 필수항목입니다.")
    private Date birth;


    @NotBlank(message = "이메일 주소를 입력해주세요.")
    @Email(message = "올바른 이메일 주소를 입력해주세요.")
    private String email;
}