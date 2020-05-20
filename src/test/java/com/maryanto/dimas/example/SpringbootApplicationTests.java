package com.maryanto.dimas.example;

import com.maryanto.dimas.example.entity.Product;
import com.maryanto.dimas.example.entity.ProductPrimaryKey;
import com.maryanto.dimas.example.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Slf4j
@SpringBootTest
class SpringbootApplicationTests {

    @Autowired
    private ProductService service;

    @Test
    void contextLoads() {
    }

    @Test
    public void testSelectAllData() {
        List<Product> list = service.findAll();
        log.info("products: {}", list);

        Assertions.assertEquals(list.stream().count(), 3, "list of products");
    }

    @Test
    public void testSaveData() {
        Product ipadPro = service.save(
                new Product(
                        "ipad-pro",
                        "2018",
                        "Ipad Pro 11\" 64GB",
                        new BigDecimal(1500000),
                        1,
                        Timestamp.valueOf(LocalDateTime.now()),
                        "testing"
                ));

        Product iphone = service.save(
                new Product(
                        "iphone",
                        "7-plus",
                        "Iphone 7 Plus 64GB",
                        new BigDecimal(8000000),
                        1,
                        Timestamp.valueOf(LocalDateTime.now()),
                        "testing"
                ));

        log.info("list products: {}", service.findAll());

        Optional<Product> optional = service.findId(new ProductPrimaryKey(ipadPro.getCode(), ipadPro.getVersion()));
        Assertions.assertTrue(optional.isPresent(), "Data telah di save");
        service.remove(ipadPro);

        optional = service.findId(new ProductPrimaryKey(ipadPro.getCode(), ipadPro.getVersion()));
        Assertions.assertFalse(optional.isPresent(), "Data telah dihapus");

        optional = service.findId(new ProductPrimaryKey(iphone.getCode(), iphone.getVersion()));
        Assertions.assertTrue(optional.isPresent(), "Data telah di save");
        service.remove(iphone);

        optional = service.findId(new ProductPrimaryKey(iphone.getCode(), iphone.getVersion()));
        Assertions.assertFalse(optional.isPresent(), "Data telah dihapus");
    }

}
