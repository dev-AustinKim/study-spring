package com.example.ex02.controller;

import com.example.ex02.mapper.ProductMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@SpringBootTest
@Slf4j
public class OrderControllerTests {
    @Autowired
    WebApplicationContext webApplicationContext;

    MockMvc mockMvc;

    @BeforeEach
    public void setUp(){
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    //    perform은 브라우저를 연건다
//    MockMvcRequestBuilders는 url에 클릭해서 칠 준비를 하는 것이다.
//    get은 get 방식인지 post 방식인지를 정하는 것이다.
//    param은 쿼리스트링인것이다. ? 뒤에 있는 것으로 화면에서 보내는 값을 대신해주는거라고 생각하면 된다.
//    andReturn이 엔터를 친거다.
//    getModelAndView.getModelMap은 결과값인 model에 값이 제대로 있는지를 확인해보는 것이다.
//    is3xxRedirection()은 리다이렉트방식인지를 확인하는 것이다. 보내주는 값이 없으면 리다이렉트 방식인지만 확인하면 된다.


//    주문
//    주문 완료
    @Test
    public void orderTest() throws Exception{
        log.info(mockMvc.perform(MockMvcRequestBuilders.get("/order/")
                .param("productId", "3")
                .param("productName", "감자")
                .param("productPrice", "1000")
                .param("productStock", "50")
        ).andReturn().getModelAndView().getModelMap().toString());
        mockMvc.perform(MockMvcRequestBuilders.post("/order/")
                .param("productId", "3")
                .param("productCount", "20")
        ).andExpect(MockMvcResultMatchers.status().is3xxRedirection());
    }

    //    주문내역
    @Test
    public void showListTest() throws Exception{
        log.info(mockMvc.perform(MockMvcRequestBuilders.get("/order/list")).andReturn().getModelAndView().getModelMap().toString());
    }

    //    취소
    @Test
    public void cancelTest() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.post("/order/cancel")
                .param("orderId", "3")
        ).andExpect(MockMvcResultMatchers.status().is3xxRedirection());
    }
}
