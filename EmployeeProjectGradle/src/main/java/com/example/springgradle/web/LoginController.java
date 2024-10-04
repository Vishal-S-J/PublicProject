package com.example.springgradle.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class LoginController {

//    @GetMapping("/")
//    public String redirectLoginPage(RedirectAttributes redirectAttributes) {
//        return "redirect:/"+View.LOGIN;
//    }

    @GetMapping("/login")
    public String login() {
        return View.LOGIN;
    }
}
