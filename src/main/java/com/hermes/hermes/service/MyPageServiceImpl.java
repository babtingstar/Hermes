package com.hermes.hermes.service;

import com.hermes.hermes.dto.Purchase;
import com.hermes.hermes.dto.User;
import com.hermes.hermes.mapper.MyPageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class MyPageServiceImpl implements MyPageService {

    @Autowired
    private MyPageMapper myPageMapper;

    @Override
    public List<Map<String, Object>> myPageService_getUserPurchase(String user_id) {
        List<Purchase> purchaseList = myPageMapper.myPageService_getUserPurchase(user_id);
        return purchaseList.stream().map(purchase -> {
            Map<String, Object> purchaseMap = new HashMap<>();
            purchaseMap.put("purchase_reg_num", purchase.getPurchase_reg_num());
            purchaseMap.put("purchase_product_reg_num", purchase.getPurchase_product_reg_num());
            purchaseMap.put("purchase_order_id", purchase.getPurchase_order_id());
            purchaseMap.put("purchase_product_size", purchase.getPurchase_product_size());
            purchaseMap.put("purchase_user_id", purchase.getPurchase_user_id());
            purchaseMap.put("purchase_date", purchase.getPurchase_date());
            purchaseMap.put("purchase_status", purchase.getPurchase_status());
            return purchaseMap;
        }).collect(Collectors.toList());
    }

    @Override
    public void myPage_infoCorrection(
            int user_reg_num,
            String user_id,
            String user_pw,
            String user_history,
            String user_verification_answer,
            String user_name) {

            User user = new User();
            user.setUser_reg_num(user_reg_num);
            user.setUser_id(user_id);
            user.setUser_pw(user_pw);
            user.setUser_history(user_history);
            user.setUser_verification_answer(user_verification_answer);
            user.setUser_name(user_name);

            myPageMapper.myPage_infoCorrection();
    }


}
