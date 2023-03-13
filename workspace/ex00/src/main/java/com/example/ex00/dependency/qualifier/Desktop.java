package com.example.ex00.dependency.qualifier;

import lombok.Data;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Data
@Component
@Qualifier("desktop") @Primary // value는 생략할 수 있다. @Primary는 보통 자주 사용하는 것에 붙인다.
// 컴퓨터 타입에서 구현체를 주입요청할 때 Qualifier를 작성하지 않으면 desktop이 호출된다.
public class Desktop implements Computer{
    @Override
    public int getScreenWidth() {
        return 2180;
    }
}
