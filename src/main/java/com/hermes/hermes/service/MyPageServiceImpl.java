package com.hermes.hermes.service;

import com.hermes.hermes.mapper.MyPageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyPageServiceImpl {

    @Autowired
    private MyPageMapper myPageMapper;


}
