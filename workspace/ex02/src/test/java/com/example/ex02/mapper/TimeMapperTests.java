package com.example.ex02.mapper;


import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class TimeMapperTests {
    @Autowired
    TimeMapper timeMapper;

    @Test
    public void getTimeTest() {
        log.info(timeMapper.getTime());
    }
}
