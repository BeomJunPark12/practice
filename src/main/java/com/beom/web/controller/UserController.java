package com.beom.web.controller;

import com.beom.web.controller.user.UserForm;
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
public class UserController {

    private final UserService userService;

    /**
     * 회원가입 폼으로 이동
     */

    @GetMapping("/user/new")
    public String createForm(Model model) {
        model.addAttribute("userForm", new UserForm());
        return "user/createForm";
    }

    /**
     * 회원가입
     */

    @PostMapping("/user/new")
    public String create(@Valid UserForm userForm, BindingResult result) {

        if (result.hasErrors()) {
            log.info("result: " + result);
            return "user/createForm";
        }

        User user = User.builder()
                .loginId(userForm.getLoginId())
                .password(userForm.getPassword())
                .name(userForm.getName())
                .build();

        userService.join(user);
        return "redirect:/";
    }
}
