package com.example.ex02.mapper;

import com.example.ex02.domain.ProductVO;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Slf4j
public class ProductMapperTests {

/*Autowired는 Mapper만 해준다.*/
    @Autowired
    ProductMapper productMapper;

    @Test
    public void insertProductTest(){
        /*무조건 단위에서 만들어 준다. => new ProductVO를 단위에서만 해줘야 한다. 단위테스트이기 때문이다.*/
        ProductVO productVO = new ProductVO();
        productVO.setProductName("apple");
        productVO.setProductPrice(1200);
        productVO.setProductStock(3);
        productMapper.insert(productVO);
    }

    @Test
    public void updateProductTest(){
        ProductVO productVO = productMapper.select(1L);
        productVO.setProductName("Melon");
        productVO.setProductStock(2);
        productVO.setProductPrice(1000);
        productVO.setProductId(1L);
        productMapper.update(productVO);
    }

    @Test
    public void assertThatTest() {
//       검증, Assertions.assertThat : 친절한 오류 설명 및 빠른 단위 테스트 가능
        List<String> datas = new ArrayList<>(Arrays.asList("A", "B", "C"));
        assertThat(datas.get(0)).isEqualTo("A"); // 값검사 (자주쓴다.)
//        assertThat(datas).isInstanceOf(List.class); // 타입 검사
//        assertThat(datas).isInstanceOf(ArrayList.class); // 타입 검사
        assertThat(datas).isInstanceOfAny(List.class, String.class, ArrayList.class); // 여러 타입 작성 가능, 1개라도 true면 true
        assertThat(productMapper.select(1L)).extracting("productName"); // 객체의 필드 검사 (자주쓴다.)
        assertThat(productMapper.select(1L)).isIn(productMapper.selectAll()); // 자신을 포함한 컬렉션인지 검사 => 내가 isIn에 있는 값에 포함되어 있는지를 검사하는 것이다.
        assertThat(productMapper.select(1L)).isExactlyInstanceOf(ProductVO.class); // 부모 타입이 아닌 본인 타입인지 검사. 정확하게 자신의 타입이어야 true가 나온다.
        assertThat(datas).isSameAs(datas); // 주소값 비교
        assertThat(datas).isEqualTo(new ArrayList<>(Arrays.asList("A", "B", "C"))); // 값 비교
        assertThat(datas).contains("A"); // contains에 있는 값을 assertThat에 있는 것이 포함하는지 검사. = 값 포함 검사 (자주쓴다.)
        assertThat(datas).element(1); // 인덱스 범위 검사
        assertThat(productMapper.select(1L).getProductPrice()).isLessThan(2000); // 보다 작은지 검사
        assertThat(productMapper.select(1L).getProductPrice()).isLessThanOrEqualTo(1000); // 보다 작거나 같은지 검사

    }

    @Test
    public void selectAllTest(){
        assertThat(productMapper.selectAll().get(0).getProductName()).isEqualTo("Melon");
    }

}