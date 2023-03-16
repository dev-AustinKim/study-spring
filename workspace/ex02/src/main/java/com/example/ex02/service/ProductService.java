package com.example.ex02.service;

import com.example.ex02.domain.vo.ProductVO;
import org.springframework.stereotype.Service;

import java.util.List;

// class로 할 수도 있고 interface로 할 수도 있는데
// interface로 하면 유연성을 확보하기 위해서이다.
// 종류가 이거 하나면 굳이 인터페이스로 만들 의미가 없다.

@Service
public interface ProductService {
    //    상품 추가
    public void registerProduct(ProductVO productVO);
    //    상품 수정
    public void updateProduct(ProductVO productVO);
    //    상품 목록
    public List<ProductVO> getList();
    //    상품 조회
    public ProductVO getProduct(Long productId);
}

