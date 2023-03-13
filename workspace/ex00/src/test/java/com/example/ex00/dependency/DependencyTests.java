package com.example.ex00.dependency;


import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest // Test용도이다.
@Slf4j // 로그를 사용하기 위함.
public class DependencyTests {

     // AutoWired란 의존관계 주입(DI)을 할 때 사용하는 어노테이션(Annotation)이며,
     // IoC컨테이너에 존재하는 빈(Bean)을 찾아 주입하는 역할을 한다.
     @Autowired // 단위테스트에서는 필드 주입만 사용이 가능하다.
     Coding coding;

    @Test
    public void testCoding() {
        // 정보만 확인하고 싶을 때
        log.info(String.valueOf(coding));
//      NPE(NullPoingException)을 방지하기 위해서 이렇게는 안쓴다.
//        log.info(coding.toString());
    }

    @Autowired
    Restaurant restaurant;

    @Test
    public void testRestaurant() {
        log.info(String.valueOf(restaurant));
    }

    @Autowired
    Teacher teacher;

    @Autowired
    Student student;

    @Autowired
    School school;

    @Autowired
    Class studentClass;

    @Test
    public void testTeacher(){
        log.info(String.valueOf(teacher));
    }

    @Test
    public void testClass(){
        log.info(String.valueOf(studentClass));
    }

    @Test
    public void testStudent(){
        log.info(String.valueOf(student));
    }

    @Test
    public void testSchool(){
        log.info(String.valueOf(school));
    }
}
