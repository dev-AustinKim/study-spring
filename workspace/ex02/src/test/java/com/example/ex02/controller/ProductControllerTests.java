package com.example.ex02.controller;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Controller;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@SpringBootTest
@Slf4j
public class ProductControllerTests {
    @Autowired
    WebApplicationContext webApplicationContext;

    MockMvc mockMvc;

    @BeforeEach // 각 단위테스트마다 이전에 이 메소드를 실행해라.
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void registerTest() throws Exception{
        log.info(mockMvc.perform(MockMvcRequestBuilders.get("/product/register")).andReturn().getModelAndView().getModelMap().toString()); // 무조건 perform을 사용한다. 브라우저를 열었다라고 생각하면 된다.
        mockMvc.perform(MockMvcRequestBuilders.post("/product/register").param("productName","옥수수").param("productPrice","2000").param("productStock","20")
        ).andExpect(MockMvcResultMatchers.status().is3xxRedirection());
    }

    @Test
    public void updateTest() throws Exception{
        log.info(mockMvc.perform(MockMvcRequestBuilders.get("/product/update").param("productId", "3"))
                .andReturn().getModelAndView().getViewName()); //    getViewName = 응답하는 페이지의 경로
        // addAttribute면 getModelMap으로 확인가능하고 flashAddAttribute면 getflashMap으로 확인 가능하다.

        log.info(mockMvc.perform(MockMvcRequestBuilders.post("/product/update")
                .param("productId", "3")
                .param("productName", "옥수수")
                .param("productPrice", "2000")
                .param("productStock", "80")
        ).andReturn().getModelAndView().getModelMap().toString());
    }

    @Test
    public void showListTest() throws Exception{
        log.info(mockMvc.perform(MockMvcRequestBuilders.get("/product/list")).andReturn().getModelAndView().getModelMap().toString());
    }
}
