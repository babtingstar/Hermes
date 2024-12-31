package com.hermes.hermes.service;

import com.hermes.hermes.dto.User;
import com.hermes.hermes.mapper.MyPageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyPageServiceImpl implements MyPageService {

    @Autowired
    private MyPageMapper myPageMapper;

    @Override
    public User myPageService_examp(int user_id) {
        return myPageMapper.myPageService_examp(user_id);
    }

}
