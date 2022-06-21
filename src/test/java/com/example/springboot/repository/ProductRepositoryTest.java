package com.example.springboot.repository;

import com.example.springboot.entity.Product;
import com.example.springboot.util.StringUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {
    @Autowired
    ProductRepository productRepository;

    @Test
    public void testSaveProduct() {
        Product product = Product.builder()
                .name("Cuong")
                .description("Free")
                .slug(StringUtil.toSlug("Cuong"))
                .thumbnail("cuong.png")
                .price(1000)
                .status(1)
                .build();
        productRepository.save(product);
    }

    @Test
    public void testGetList() {
        List<Product> products = productRepository.findAll();
        for (Product product : products) {
            System.out.println(product.toString());
        }
    }

    @Test
    public void testGetById() {
        Optional<Product> optionalProduct = productRepository.findById(1);
        if (optionalProduct.isPresent()) {
            Product product = optionalProduct.get();
            System.out.println(product.getName().equals("Cuong"));
        }
    }

    @Test
    public void testDelete() {
        List<Product> products = productRepository.findAll();
        for (Product product : products) {
            System.out.println(product.toString());
        }
    }
}