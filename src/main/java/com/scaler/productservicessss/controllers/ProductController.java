package com.scaler.productservicessss.controllers;

import com.scaler.productservicessss.dtos.CreateProductRequestDto;
import com.scaler.productservicessss.dtos.ErrorDto;
import com.scaler.productservicessss.exceptions.ProductNotFoundException;
import com.scaler.productservicessss.models.Product;
import com.scaler.productservicessss.services.FakeStoreProductService;
import com.scaler.productservicessss.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    private ProductService productService;


    public ProductController(@Qualifier("databaseProductService") ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/products/{id}")
    public Product getProductDetails(@PathVariable("id") Long id) throws ProductNotFoundException {
        return productService.getProductDetails(id);
    }

    @PostMapping("/products")
    public ResponseEntity<Product> createProduct(@RequestBody CreateProductRequestDto requestDto) {
        Product product = productService.createProduct(
                requestDto.getTitle(),
                requestDto.getDescription(),
                requestDto.getImage(),
                requestDto.getPrice(),
                requestDto.getCategory()
        );


        ResponseEntity<Product> responseEntity =
                new ResponseEntity<>(product, HttpStatusCode.valueOf(201));

        return responseEntity;
    }
}
