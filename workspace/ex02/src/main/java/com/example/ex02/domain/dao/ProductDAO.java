package com.example.ex02.domain.dao;


import com.example.ex02.domain.vo.ProductVO;
import com.example.ex02.mapper.ProductMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository // -> 구현되어 있는 구현체이다.
@RequiredArgsConstructor
public class ProductDAO { // ProductMapper에서 이름과 리턴타입만 바뀌는 정도이다.

    private final ProductMapper productMapper;

    //    상품 추가
    public void save(ProductVO productVO) {
        productMapper.insert(productVO);
    }

    //    상품 수정
    public void setProductVO(ProductVO productVO) {
        productMapper.update(productVO);
    }

    //    상품 목록
    // DAO에서 select는 무조건 find이다.
    public List<ProductVO> findAll() {
        return productMapper.selectAll();
    }

    //    상품 조회
//    Id는 PK라고 알고있자
    public ProductVO findById(Long productId) {
        return productMapper.select(productId);
    }

}
