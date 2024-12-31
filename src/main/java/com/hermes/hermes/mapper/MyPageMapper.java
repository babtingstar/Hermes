package com.hermes.hermes.mapper;


import com.hermes.hermes.dto.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MyPageMapper {
    User myPageService_examp(int user_id);
}
