package com.beom.web.dto;

import com.beom.web.model.Role;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class UserDto {

    private Long id;

    @NotBlank(message = "아이디를 입력해 주세요")
    @Size(min = 2, max = 6, message = "아이디는 2~6자 사이로 입력 해주세요")
    private String username;

    @NotBlank(message = "비밀번호를 입력해 주세요")
    private String password;

    @NotBlank(message = "이름을 입력해 주세요")
    private String name;

    private Role role;
}

