package com.hermes.hermes.mapper;


import com.hermes.hermes.dto.Purchase;
import com.hermes.hermes.dto.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MyPageMapper {
    // 세션에서 유저 id 받아와서 user_id 가 일치하는 Purchase 리스트 가져오기
    List<Purchase> myPageService_getUserPurchase(String user_id);

    // 세션에서 유저 User 객체 받아와서 user_id 가 일치하는 User 정보 수정하기
    void myPage_infoCorrection();
}

