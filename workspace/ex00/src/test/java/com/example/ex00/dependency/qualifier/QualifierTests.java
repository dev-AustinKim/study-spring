package com.example.ex00.dependency.qualifier;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
@Slf4j
public class QualifierTests {

    @Autowired @Qualifier("desktop") // Qualifier는 어떤 값을 쓸지 정해주는 것이다.테스트 하는 스프링 입장에서는 이게 맞다.
    Computer computer;

    @Test
    public void testComputer() {
        log.info(String.valueOf(computer));
    }

    @Autowired @Qualifier("vips")
    Restaurant restaurant;

    @Test
    public void testRestaurant() {
        log.info(String.valueOf(restaurant));
    }
}
