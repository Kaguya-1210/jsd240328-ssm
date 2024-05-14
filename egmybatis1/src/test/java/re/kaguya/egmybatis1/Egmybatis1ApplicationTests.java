package re.kaguya.egmybatis1;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import re.kaguya.egmybatis1.mapper.ProductMapper;
import re.kaguya.egmybatis1.pojo.entity.Product;

@SpringBootTest
class Egmybatis1ApplicationTests {

    @Autowired
    ProductMapper productMapper;

    @Test
    void ins() {
        Product product = new Product();
        product.setTitle("tes4t");
        product.setPrice(12314.1);
        product.setStock(1249L);
        productMapper.insertProduct(product);
    }

    @Test
    void contextLoads() {
    }

    @Test
    void selectProduct() {
        System.out.println(productMapper.selectProduct(1L));
    }

    @Test
    void deleteProduct() {
        productMapper.deleteProduct(1L);
    }

    @Test
    void selectAllTest() {
        System.out.println(productMapper.selectAllProduct());
    }

}