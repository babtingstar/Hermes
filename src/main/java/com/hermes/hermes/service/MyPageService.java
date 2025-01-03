package com.hermes.hermes.service;

import com.hermes.hermes.dto.User;
import com.hermes.hermes.mapper.MyPageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

public interface MyPageService {
    //세션에서 유저 id 받아와서 user_id 가 일치하는 Purchase 리스트 가져오기
    List<Map<String, Object>> myPageService_getUserPurchase(String user_id);

    // 세션에서 User 받아와서 user_id 가 일치하는 User 정보 수정하기
    void myPage_infoCorrection(
            String user_id,
            String user_pw,
            String user_verification_answer
    );

}
