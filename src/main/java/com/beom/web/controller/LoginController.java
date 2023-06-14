package com.beom.web.controller;

import com.beom.web.entity.User;
import com.beom.web.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
@Slf4j
public class LoginController {

    private final UserService userService;

    @GetMapping("user/login")
    public String loginForm(Model model) {
        model.addAttribute("loginForm", new LoginForm());
        return "user/loginForm";
    }

    @PostMapping("user/login")
    public String login(@Valid LoginForm form, BindingResult result) {

        if (result.hasErrors()) {
            log.info("result: " + result);
            return "/user/loginForm";
        }

        User login = userService.login(form.getLoginId(), form.getPassword());

        if (login == null) {
            log.info("로그인 실패");
            result.reject("loginFail", "아이디 또는 비밀번호가 일치하지 않습니다.");
            return "user/loginForm";
        }
        return "redirect:/";
    }
}
