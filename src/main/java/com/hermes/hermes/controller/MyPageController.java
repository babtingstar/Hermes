package com.hermes.hermes.controller;

import com.hermes.hermes.dto.Purchase;
import com.hermes.hermes.dto.User;
import com.hermes.hermes.mapper.MyPageMapper;
import com.hermes.hermes.service.MyPageService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Controller
public class MyPageController {

    @Autowired
    private MyPageService myPageService;

    @GetMapping("/mypage")
    public String my_page(Model model, HttpSession session) {

        User test = new User(1, "error", "error", null, "error", "error");

        Object loggedInUser = session.getAttribute("loggedInUser"); // 세션에 로그인한 유저를 loggedInUser 라는 Object 로 선언
        if (loggedInUser != null) { // 로그인 유저가 있다면(=not null) 이라면
            model.addAttribute("user", loggedInUser); // loggedInUser 를 model을 통해 user 라는 이름으로 전달
        } else { // 로그인 유저가 없다면(else), error 유저를 반환(session 미구현 중 출력용)
            model.addAttribute("user", test);
        }

        User myPageGetUser = (User) session.getAttribute("user");
        List<Map<String, Object>> purchases = myPageService.myPageService_getUserPurchase(test.getUser_id());
        model.addAttribute("purchases", purchases);

        return "mypage"; // mypage를 리턴
    }

    @GetMapping("/myPage_infoCorrection")
    public String myPage_infoCorrection(Model model, HttpSession session) {
        User test = new User(1, "error", "error", null, "error", "error");

        Object loggedInUser = session.getAttribute("loggedInUser"); // 세션에 로그인한 유저를 loggedInUser 라는 Object 로 선언
        if (loggedInUser != null) { // 로그인 유저가 있다면(=not null) 이라면
            model.addAttribute("user", loggedInUser); // loggedInUser 를 model을 통해 user 라는 이름으로 전달
        } else { // 로그인 유저가 없다면(else), error 유저를 반환(session 미구현 중 출력용)
            model.addAttribute("user", test);
        }

        return "myPage_infoCorrection";
    }
}
