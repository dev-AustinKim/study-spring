package com.example.ex00.dependency;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component // 메인 패키지(ex00)아래에 있어야 ApplicationContext(A.C)가 인식할 수 있다.
@Data
//@NoArgsConstructor // 기본생성자를 만든다.
@RequiredArgsConstructor //    final이 붙어있거나 NonNull이 붙어있는 필드들은 주입대상이기 때문에 그 필드들만 초기화 생성자로 만들어 준다.
public class Coding {
//    필드주입
//    사용 방법이 매우 편하다는 장점이 있다.
//    주입된 객체를 불변(immutable)상태로 만들 수 없기 때문에 외부에서 수정될 위험이 있다.
//    생성 후 주입, 생성 시점에서는 순환 참조 발생 여부를 알 수 없다.

// 필드주입에서는 final을 붙일 수 없다. 다 만들고 나서 final을 붙이려고 하기 때문에 오류가 나는 것이다. 필드가 만들어지고 나서 final을 붙이려고 하기 때문.
//    @Autowired // 주입을 받아야할 때는 final을 붙인다. 주입을 받았는데 변하면 안되기 떄문이다.(불변성) 외부에서 수정이 되면 안되기 떄문이다.
//    private final Computer computer;


//    setter 주입
//    주입받는 객체가 변경될 가능성이 있는 경우에 사용한다.
//    OCP(Open-Closed Principle, 개방-폐쇄 원칙)를 위반하기 떄문에 변경 가능성을 배재하고 불변성을 보장하는 것이 좋다.
//    생성 후 주입, 생성 시점에서는 순환 참조 발생 여부를 알 수 없다.
    
//private Computer computer;
//    @Autowired // setter 주입
//    public Coding(Computer computer) {
//        this.computer = computer;
//    }

// 주입은 받아서 넣는 것인데 기본 생성자는 받을 수가 없어서 기본생성자가 있으면 주입에서 오류가 난다.

//    생성자 주입 (앞으로 이것만 쓰자)
//    불변성이 생기기 때문에 해당 필드에 final 키워드를 작성할 수 있다.
//    컴파일 시점에서 주입 문제 발생을 확인할 수 있으며,
//    객체를 생성하는 시점에서 Bean객체를 필수로 초기화하기 떄문에 NPE를 방어할 수 있다.
//    순환 참조 발생 시 RUntime 시점 이전에 감지가 되기 때문에 안전하다.
//    주입 후 생성 => 결론 : 나머지 주입 말고 생성자 주입으로 사용하자.
//    주입 후 생성, 생성 시 순환참조 발생 여부를 알 수 있기 때문에 Application 실행 시점에서 순환참조 오류를 발견할 수 있다.


    //    final이 붙어있는 필드는 @AutoWired로 생성자 주입을 해줄 필요 없이 
    //    밑에 한 줄과 함께 @RequiredArgsConstructor만 해주면 생성자 주입이 된다.
    private final Computer computer;
//    @Autowired
//    public Coding(Computer computer) {
//        this.computer = computer;
//    }

}
