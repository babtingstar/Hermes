package com.hermes.hermes.service;

import com.hermes.hermes.dto.User;
import com.hermes.hermes.mapper.MyPageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

public interface MyPageService {
    User myPageService_examp(int user_id);

}
