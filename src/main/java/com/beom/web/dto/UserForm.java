package com.beom.web.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class UserForm {

    @NotBlank(message = "아이디를 입력해주세요")
    private String username;

    @NotBlank(message = "비밀번호를 입력해주세요")
    private String password;

    @NotBlank(message = "이름을 입력해주세요")
    private String name;
}
