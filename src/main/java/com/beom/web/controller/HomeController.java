package com.beom.web.controller;

import com.beom.web.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
@Slf4j
public class HomeController {

//    @GetMapping("/")
//    public String main() {
//        log.info("HomeController");
//        return "home";
//    }

    @GetMapping("/")
    public String loginHome() {
        return "home";
    }
}
