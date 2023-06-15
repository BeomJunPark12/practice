package com.beom.web.controller;

import com.beom.web.controller.login.LoginForm;
import com.beom.web.entity.User;
import com.beom.web.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
@Slf4j
public class LoginController {

    private final UserService userService;

    /**
     * 로그인 화면으로 이동
     */

    @GetMapping("user/login")
    public String loginForm(Model model) {
        model.addAttribute("loginForm", new LoginForm());
        return "user/loginForm";
    }

    /**
     * 로그인 처리
     */

    @PostMapping("user/login")
    public String login(@Valid LoginForm form, BindingResult result, HttpServletRequest request) {

        if (result.hasErrors()) {
            log.info("result: " + result);
            return "/user/loginForm";
        }

        User loginUser = userService.login(form.getLoginId(), form.getPassword());

        if (loginUser == null) {
            log.info("로그인 실패");
            result.reject("loginFail", "아이디 또는 비밀번호가 일치하지 않습니다.");
            return "user/loginForm";
        }

        // 세션 생성
        HttpSession session = request.getSession();

        // 세션 저장
        session.setAttribute(SessionConst.LOGIN_USER, loginUser);
        return "redirect:/";
    }

    /**
     * 로그아웃
     */
    @GetMapping("/user/logout")
    public String logout(HttpServletRequest request) {
        HttpSession session = request.getSession(false);

        if (session != null) {
            session.invalidate();
        }
        return "redirect:/";
    }
}
