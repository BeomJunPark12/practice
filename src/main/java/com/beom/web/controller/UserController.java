package com.beom.web.controller;

import com.beom.web.config.auth.PrincipalDetail;
import com.beom.web.dto.LoginForm;
import com.beom.web.dto.UserForm;
import com.beom.web.model.Role;
import com.beom.web.model.User;
import com.beom.web.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
@Slf4j
public class UserController {

    private final UserService userService;


    /**
     * 회원가입 폼으로 이동
     */

    @GetMapping("/auth/joinForm")
    public String joinForm() {
        return "user/joinForm";
    }

    /**
     * 로그인 폼으로 이동
     */

    @GetMapping("/auth/loginForm")
    public String loginForm(Model model) {
        model.addAttribute("loginForm", new LoginForm());
        return "user/loginForm";
    }

    /**
     * 회원수정 폼
     */
    @GetMapping("/user/updateForm")
    public String updateForm(@AuthenticationPrincipal PrincipalDetail principal) {
        return "user/updateForm";
    }
}
