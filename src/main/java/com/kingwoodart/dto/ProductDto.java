package com.kingwoodart.dto;


import com.kingwoodart.utils.TableStatus;
import com.kingwoodart.utils.TableSize;
import lombok.Data;

@Data
public class ProductDto {
    private Integer id;
    private String name;
    private String description;
    private Double price;
    private int length;
    private int width;
    private int thickness;
    private int weight;
    private int quantity;
    private TableSize tableSize;
    private TableStatus tableStatus;
}
