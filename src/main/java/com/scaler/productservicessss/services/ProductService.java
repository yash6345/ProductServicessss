package com.scaler.productservicessss.services;

import com.scaler.productservicessss.dtos.CreateProductRequestDto;
import com.scaler.productservicessss.exceptions.ProductNotFoundException;
import com.scaler.productservicessss.models.Product;

import java.util.List;

public interface ProductService {
    public Product getProductDetails(Long id) throws ProductNotFoundException;
    public Product createProduct(String title, String description, String image, double price, String category);
    public List<Product> getAllProducts();
}