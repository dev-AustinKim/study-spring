package com.example.ex00.dependency.qualifier;


import lombok.Data;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Data
@Component
@Qualifier(value = "laptop") //Computer 타입이 두개라서 단일 매칭을 원하는 스프링 입장에서 볼 때 이름을 정해줘서 테스트 때 모호성이 발생하지 않도록 한다.
public class Laptop implements Computer{

    @Override
    public int getScreenWidth() {
        return 1920;
    }
}
