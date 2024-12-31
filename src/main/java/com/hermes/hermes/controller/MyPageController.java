package com.hermes.hermes.controller;

import com.hermes.hermes.service.MyPageService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyPageController {

    @Autowired
    private MyPageService myPageService;

    @GetMapping("/mypage")
    public String my_page(Model model, HttpSession session) {

        Object loggedInUser = session.getAttribute("loggedInUser");
        if (loggedInUser != null) {
            model.addAttribute("user", loggedInUser);
        }
        return "my_page";
    }

}
