package com.kingwoodart.service;

import com.kingwoodart.dto.ProductDto;

public interface ProductService {
    ProductDto createProduct(ProductDto productDto);

    ProductDto getProductById(Integer id);

    void deleteProductById(Integer id);

    ProductDto updateProduct(ProductDto productDto, Integer id);
}
