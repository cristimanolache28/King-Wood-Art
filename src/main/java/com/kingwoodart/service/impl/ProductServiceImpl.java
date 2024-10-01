package com.kingwoodart.service.impl;

import com.kingwoodart.dto.ProductDto;
import com.kingwoodart.entity.Product;
import com.kingwoodart.exception.ResourceNotFoundException;
import com.kingwoodart.repository.ProductRepository;
import com.kingwoodart.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ProductDto createProduct(ProductDto productDto) {
        Product product = mapToEntity(productDto);

        Product newProduct = productRepository.save(product);

        ProductDto resinTableResponse = mapToDto(newProduct);
        return resinTableResponse;

    }

    @Override
    public ProductDto getProductById(Integer id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product", "id", id));

        ProductDto productDto = mapToDto(product);
        return productDto;
    }

    @Override
    public void deleteProductById(Integer id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product", "id", id));

        productRepository.delete(product);
    }

    @Override
    public ProductDto updateProduct(ProductDto tableDto, Integer id) {
        Product table = productRepository.findById(id)
                        .orElseThrow(() -> new ResourceNotFoundException("Product", "id", id));

        table.setName(tableDto.getName());
        table.setDescription(tableDto.getDescription());
        table.setPrice(tableDto.getPrice());
        table.setLength(tableDto.getLength());
        table.setWidth(tableDto.getWidth());
        table.setThickness(tableDto.getThickness());
        table.setWidth(tableDto.getWeight());
        table.setQuantity(tableDto.getQuantity());
        table.setTableSize(tableDto.getTableSize());
        table.setTableStatus(tableDto.getTableStatus());

        Product updatedTable = productRepository.save(table);

        return mapToDto(updatedTable);
    }

    // convert dto to entity
    private Product mapToEntity(ProductDto productDto) {
        Product product = modelMapper.map(productDto, Product.class);
        return product;
    }

    // convert entity to dto
    private ProductDto mapToDto(Product product) {
        ProductDto productDto = modelMapper.map(product, ProductDto.class);
        return productDto;
    }
}
