package com.l2c.business.service;

import com.l2c.business.dto.ProductDto;

public interface ProductService {
    ProductDto createProduct(ProductDto productDto);

    ProductDto getProductById(Integer id);

    void deleteProductById(Integer id);

    ProductDto updateProduct(ProductDto productDto, Integer id);
}
