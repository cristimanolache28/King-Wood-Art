package com.l2c.business.entity;

import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tables")
public class ResinTable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String description;
    private Double price;
    private int length;
    private int width;
    private int thickness;
    private int weight;
    private int quantity;

    // TODO: create customer reviews features

}
