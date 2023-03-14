package com.example.ex01.domain;


import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class UserVO {
    private String userId;
    private String userPassWord;
}
