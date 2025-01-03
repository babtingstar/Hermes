package com.hermes.hermes.controller;

import com.hermes.hermes.dto.User;
import com.hermes.hermes.service.MyPageService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class MyPageController {

    @Autowired
    private MyPageService myPageService;

    @GetMapping("/mypage")
    public String my_page(Model model, HttpSession session) {

        User error_user = new User(1, "error", "error", null, "error", "error");
        User myPageGetUser = (User) session.getAttribute("user");
        List<Map<String, Object>> purchases = new ArrayList<>();

        Object loggedInUser = session.getAttribute("loggedInUser"); // 세션에 로그인한 유저를 loggedInUser 라는 Object 로 선언
        if (loggedInUser != null) { // 로그인 유저가 있다면(=not null) 이라면
            model.addAttribute("user", loggedInUser); // loggedInUser 를 model을 통해 user 라는 이름으로 전달
            purchases = myPageService.myPageService_getUserPurchase(myPageGetUser.getUser_id());
        } else { // 로그인 유저가 없다면(else), error 유저를 반환(session 미구현 중 출력용)
            model.addAttribute("user", error_user);
            purchases = myPageService.myPageService_getUserPurchase(error_user.getUser_id());
        }

        model.addAttribute("purchases", purchases);

        return "mypage"; // mypage를 리턴
    }

    @GetMapping("/myPage_infoCorrection")
    public String myPage_infoCorrection() {
        return "myPage_infoCorrection";
    }

    @PostMapping("/myPage_infoCorrection_success")
    public String myPage_infoCorrection_success(Model model, HttpSession session, @RequestParam String user_verification_answer, @RequestParam String user_pw) {
        User error_user = new User(
                1,
                "error",
                "error",
                null,
                "error",
                "error");

        User myPageGetUser = (User) session.getAttribute("user");
        Object loggedInUser = session.getAttribute("loggedInUser");
        if (loggedInUser != null) {
            myPageService.myPage_infoCorrection(
                    myPageGetUser.getUser_reg_num(),
                    myPageGetUser.getUser_name(),
                    user_pw,
                    myPageGetUser.getUser_history(),
                    user_verification_answer,
                    myPageGetUser.getUser_name()
            );
        } else {
            myPageService.myPage_infoCorrection(
                    error_user.getUser_reg_num(),
                    error_user.getUser_name(),
                    error_user.getUser_pw(),
                    error_user.getUser_history(),
                    error_user.getUser_verification_answer(),
                    error_user.getUser_name()
            );
        }
        return "myPage_infoCorrection_success";
    }
}
