package com.example.ex03.controller;

import com.example.ex03.domain.vo.UserVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

@RestController
@Slf4j
public class ExampleController {

    //    전체
    @GetMapping(value = "/ex01", produces = "text/plain; charset=utf-8")
    public ResponseEntity<String> ex01() throws UnsupportedEncodingException {
        return new ResponseEntity<>(new String("ex01".getBytes(), "UTF-8"), HttpStatus.OK);
    }

    @GetMapping("/ex02")
    public String ex02(){
        return "ex02";
    }

    @GetMapping("/ex03")
    public String ex03(String name){
        return name + "님";
    }

    @PostMapping("/ex04")
    public String ex04(String name, Integer age) {
        return name + "(" + age + ")";
    }

    @PostMapping("/ex05")
    public UserVO ex05(){
        UserVO userVO = new UserVO();
        userVO.setUserId(1L);
        userVO.setUserName("한동석");
        userVO.setUserAge(20);
        return userVO;
    }

    @PostMapping("/ex06")
//    RequestBody는 화면에서 전달하는 값을 나에게 가져올 때 담는 그릇같은 것이다.
//    우리가 맨 처음에 Model 객체를 담을 그릇으로 보냈듯 화면에서 입력받은 값을 requestBody에 담아서 가져온다.
//    화면에서 JSON 형식으로 오는데 JSON 형식을 바로 이해 못하니까 @RequestBody를 써줘서 인식하게 해준다.
//    ResponseBody는 HTML요청에 내 DB에 있는 값을 보여줄 때(전달해 줄 떼) 하는 것이고,
//    RequestBody는 HTML에 있는 값을 내가 요청할 때 어떻게 받을 지에 대해서 쓰는 것이다
    public String ex06(@RequestBody UserVO userVO){
        log.info(userVO.toString());
        return "success";
    }

    @PostMapping("/ex07")
    public List<UserVO> ex07(){
        List<UserVO> users = new ArrayList<>();
        UserVO userVO1 = new UserVO();
        UserVO userVO2 = new UserVO();

        userVO1.setUserId(1L);
        userVO1.setUserName("한동석");
        userVO1.setUserAge(20);

        userVO2.setUserId(1L);
        userVO2.setUserName("한동석");
        userVO2.setUserAge(20);

        users.add(userVO1);
        users.add(userVO2);
        return users;
    }

    //   PutMapping : 전체 수정할 때
//    PatchMapping : 부분 수정할 때 사용
//    PutMapping 어노테이션뒤에 있는 {userId} 선언한것이다.
    @PutMapping("/update/users/{userId}")
//    PathVariable : 화면단에서 url에 파라미터로 받아온 값이다.
    public String updateAll(@PathVariable("userId") Long userId){
        return "전체 수정: " + userId;
    }

    @PatchMapping("/update/users/{userId}")
    public String update(@PathVariable("userId") Long userId){
        return "부분 수정: " + userId;
    }

    @DeleteMapping("/delete/users/{userId}")
    public Long delete(@PathVariable("userId") Long userId){
        return userId;
    }
}












