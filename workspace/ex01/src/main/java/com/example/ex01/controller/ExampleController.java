package com.example.ex01.controller;

import com.example.ex01.domain.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;

@Controller // spring이 관리하는 대상이 된다.
@RequestMapping("/ex/*") // ex/~ 로 시작되는 url은 여기로 온다. // 쓸지 않쓸지는 선택이다. but 볼 때 편하기 때문에 그냥 쓰자.
@Slf4j
public class ExampleController {

    @RequestMapping(value = "ex01", method = RequestMethod.GET) // ~ 부분이 ex01이면 이 메소드 실행한다.
    public String ex01() {
        log.info("ex01..................");
        return "ex01";
    }

    @GetMapping("ex02") // value만 쓸 때는 생략이 가능하다.
    public void ex02() {
        log.info("ex02......................");
    }

    @GetMapping("ex03")
    public void ex03(HttpServletRequest request) {
        String name = request.getParameter("name");
        log.info(name);
    }

    @GetMapping("ex04")
    /*받을게 하나면 @ModelAttribute("키값") 하면 된다. */
    public void ex04(@ModelAttribute("name") String name /*Model model*/) { /*request 객체를 쓰기 싫어서 model객체사용.*/
//       model.addAttribute는 request.setAttribute랑 같다.
//        model.addAttribute("name", name); // request 객체랑 똑같다. 화면애서 쓰고 싶은것을 model.addAttribute에 key와 value 값으로 담아준다.
        log.info(name);
    }

//    이름, 나이, 성별 받고 출력
    @GetMapping("ex05")
    /*내가 만든 객체는 맨 앞에만 소문자로 바뀐게 key값으로 간다. 즉, MemberVO의 맨 앞이 소문자로 바뀐 memberVO가 key값이다.*/
    public void ex05(MemberVO memberVO) {
        log.info("이름 : " + memberVO.getName());
        log.info("나이 : " + memberVO.getAge() + "살");
        log.info("성별 : " + memberVO.getGender());
    }


    @GetMapping("ex06")
    public void ex06(MemberVO memberVO, @RequestParam("address") String city) {
        log.info("이름 : " + memberVO.getName());
        log.info("나이 : " + memberVO.getAge() + "살");
        log.info("성별 : " + memberVO.getGender());
        log.info(String.valueOf("사는 도시 : " + city));
    }


//    강사님 방식 ex06
//    @GetMapping("ex06")
//    public void ex06(MemberVO memberVO, @RequestParam("address") String city, Model model) {
//        log.info("이름 : " + memberVO.getName());
//        log.info("나이 : " + memberVO.getAge() + "살");
//        log.info("성별 : " + memberVO.getGender());
//        log.info(String.valueOf("사는 도시 : " + city));
//        model.addAttribute("city", city);
//    }

    @GetMapping("ex07")
    public void ex07(String name, Integer age) {;}

//    [실습 1]
//    외부에서 상품명, 상품가격, 상품재고, 브랜드 전달받아서 화면에 전송
//    화면에서 4개 정보 입력 후 form태그로 전송한다.
//    @GetMapping("product")
//    public String managerProduct(Model model) {
//        model.addAttribute(new ProductVO());
//        return "/product/register";
//    }
//
//    @PostMapping("register") // url이 달라도 매핑방식이 다르면 매핑 방식에 따라 다른 메소드가 실행된다.
//    화면에서 입력받은 값은 메소드의 매개변수로 쓴다. 값이 4개니까 그냥 하나에 담아서 한다.
//    public RedirectView registerProduct(ProductVO productVO, RedirectAttributes redirectAttributes) {
//        redirectAttributes.addFlashAttribute() ->  화면으로 다이렉트로 간다.
//        redirectAttributes.addAttribute() -> 쿼리스트링으로 보낸다. 컨트롤러로 간다.
        
//        forward   : 그냥 리턴하면 된다. .html로 즉시 이동
        
//        redirect  : RedirectView 객체로 리턴, 생성자에 원하는 컨트롤러의 경로 작성, 컨트롤러에서 다시 Mapping, 컨트롤러를 들려서 데이터를 가져간다.

//        addAttribute() : URL뒤에 쿼리스트링을 붙여준다. 컨트롤러의 매개변수로 전달할 때 사용한다. 즉, 화면에서 쓸 게 아니라 컨트롤러에서 사용할 때 addAttribute사용한다.
        
//        redirectAttributes.addAttribute("productName", productVO.getProductName());
//        redirectAttributes.addAttribute("productPrice", productVO.getProductPrice());
//        redirectAttributes.addAttribute("productStock", productVO.getProductStock());
//        redirectAttributes.addAttribute("productBrand", productVO.getProductBrand());

//        addFlashAttribute() : Flash 영역을 사용하여, 화면에 데이터를 전달할 때 사용한다. 응답 페이지(마지막 페이지)에서만 쓸 수 있는게 flash이다.
        
        
//        redirectAttributes.addFlashAttribute("productName", productVO.getProductName());
//        redirectAttributes.addFlashAttribute("productPrice", productVO.getProductPrice());
//        redirectAttributes.addFlashAttribute("productStock", productVO.getProductStock());
//        redirectAttributes.addFlashAttribute("productBrand", productVO.getProductBrand());
//        위에처럼 할 필요없이 redirectAttributes.addFlashAttribute(productVO);만 해줘도 된다.
//        redirectAttributes.addFlashAttribute(productVO);
//        return new RedirectView("/ex/list"); // 컨트롤러 경로를 써주는 것이다.
//    }

//    입력받은 상품명 수정 후 목록으로 출력
//    @PostMapping("update")
//    public RedirectView update(ProductVO productVO, RedirectAttributes redirectAttributes) {
//        productVO.setProductName("감자");
//        redirectAttributes.addFlashAttribute(productVO);
//        return new RedirectView("/ex/list");
//    }
//
//    @GetMapping("list")
//    public String list(ProductVO productVO) {
//        return "/product/list";
//    }

//    [실습 2]
//    TaskVO 선언
//    int num, int kor, int eng, int math 선언
//    총점과 평균 점수 화면에 출력
    @GetMapping("register") // 데이터를 보여준다.
    public String register(Model model) { // 모델로 받아서 화면에 넘긴다. 화면에 넘기는 결과객체
        model.addAttribute(new TaskVO());
        return "/score/register";
    }

    @PostMapping("register")
    public RedirectView grade(TaskVO taskVO, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute(taskVO);
        return new RedirectView("/ex/list");
    }

    @GetMapping("list")
    public String list() {
        return "/score/list";
    }


//    [실습 3]
//    아이디와 비밀번호를 입력받은 후 아이디가 admin일 경우 admin.html로 이동
//    아이디가 user일 경우 user.html로 이동
//
//    - login.html : 아이디와 비밀번호 입력 페이지 출력
//    - admin.html : 관리자 페이지 출력
//    - user.html : 일반 회원 페이지 출력

    @GetMapping("login")
    public String login(Model model){ // Model 객체를 만들었다는건 화면에 무엇인가를 보내겠다는 것이다. model은 화면에 뿌려진다.
//        redirectView를 안썼기 때문에 foward 방식이다.
        model.addAttribute(new UserVO());
        return "/user/login";
    }

    @PostMapping("login")
    public RedirectView login(UserVO userVO) {
        return new RedirectView(userVO.getUserId().equals("admin") ? "/ex/admin" : "/ex/user");
    }

    @PostMapping("user")
    public String goUser() {
        return "user/user";
    }

    @PostMapping("admin")
    public String goAdmin() {
        return "user/admin";
    }

//    [실습 4]
//    이름을 입력하고 출근 또는 퇴근 버튼을 클릭한다.
//    출근 시간은 09:00이며, 퇴근 시간은 17:00이다.
//    출근 버튼 클릭 시 9시가 넘으면 지각으로 처리하고,
//    퇴근 버튼 클릭 시 17시 전이라면 퇴근이 아닌 업무시간으로 처리한다.
//    - getToWork.html
//    - leaveWork.html
//    - late.html
//    - work.html
@GetMapping("check-in")
public String checkIn() { return "/work/check-in";}

    @GetMapping("get-to-work")
    public String getToWork(String name) {
        LocalTime now = LocalTime.now();

        int hour = now.getHour();
        int minute = now.getMinute();

        boolean lateCondition = hour >= 9 && minute > 0;

        return "/check-in/" + (lateCondition ? "late" : "get-to-work");
    }

    @GetMapping("leave-work")
    public String leaveWork(String name){
        LocalTime now = LocalTime.now();

        int hour = now.getHour();
        int minute = now.getMinute();

        boolean leaveWorkCondition = hour >= 17 && minute >= 0;

        return "/check-in/" + (leaveWorkCondition ? "leave-work" : "work");
    }
}

