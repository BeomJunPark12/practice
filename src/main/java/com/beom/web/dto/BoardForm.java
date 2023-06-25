package com.beom.web.dto;

import com.beom.web.model.Board;
import com.beom.web.model.User;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
public class BoardForm {

    @NotBlank
    @Size(min = 2, max = 30, message = "제목은 2자 이상 30자 이하입니다.")
    private String title;

    private String content;


}
