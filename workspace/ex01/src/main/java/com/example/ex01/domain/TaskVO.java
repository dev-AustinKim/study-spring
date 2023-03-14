package com.example.ex01.domain;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component // bean을 따로 등록하지 않아도 된다.
public class TaskVO {
    private Integer num;
    private Integer kor;
    private Integer eng;
    private Integer math;

// 처음에 spring이 컴포넌트를 스캔할 때 기본생성자를 호출한다. 사용할 때가 아닌 처음에 서버가 시작되자마자 다 컨테이너에 올라간다.
//    public TaskVO() {
//        total = kor + eng + math;
//        average = total / 3.0;
//    }

    public Integer getTotal() {
        return kor + eng + math;
    }

    public Double getAverage() {
        return getTotal()/3.0;
    }

}
