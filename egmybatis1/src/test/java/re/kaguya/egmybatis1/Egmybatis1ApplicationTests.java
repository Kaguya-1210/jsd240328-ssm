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
        product.setTitle("test");
        product.setPrice(1231.1);
        product.setStock(129L);
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

}