package com.l2c.business.entity;

import com.l2c.business.utils.TableSize;
import com.l2c.business.utils.TableStatus;
import com.l2c.business.validation_group.ValidationGroups;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull
    @Size(min = 3, message = "The table name should have at least three characters.")
    private String name;
    @Size(min = 15, message = "Table description should have at least four characters.")
    private String description;
    @NotNull
    private Double price;
    private int length;
    private int width;
    private int thickness;
    private int weight;
    private int quantity;
    @Enumerated(EnumType.STRING)
    TableSize tableSize;
    @NotNull
    @Enumerated(EnumType.STRING)
    TableStatus tableStatus;

    // TODO: create customer reviews features

}
