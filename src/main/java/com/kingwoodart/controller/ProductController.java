package com.kingwoodart.controller;

import com.kingwoodart.dto.ProductDto;
import com.kingwoodart.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/create")
    public ResponseEntity<ProductDto> createNewProduct(@RequestBody ProductDto productDto) {
        return new ResponseEntity<>(productService.createProduct(productDto), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDto> getProductById(@PathVariable(name = "id") Integer id) {
        return new ResponseEntity<>(productService.getProductById(id), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteProductById(@PathVariable(name = "id") Integer id) {
        productService.deleteProductById(id);
        return new ResponseEntity<>("The table was deleted with successfully!", HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductDto> updateProduct(@PathVariable(name = "id") Integer id, @RequestBody ProductDto tableDto) {
        ProductDto updateTableDto = productService.updateProduct(tableDto, id);
        return new ResponseEntity<>(updateTableDto, HttpStatus.OK);
    }

}
