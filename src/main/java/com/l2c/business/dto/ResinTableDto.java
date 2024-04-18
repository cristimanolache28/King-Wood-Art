package com.l2c.business.dto;


import com.l2c.business.utils.TableSize;
import com.l2c.business.utils.TableStatus;
import lombok.Data;

@Data
public class ResinTableDto {
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
