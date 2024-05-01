package com.l2c.business.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "roles")
@Data
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length = 15, nullable = false)
    private String name;
    @Column(length = 250)
    private String description;

    public Role(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Role(String name) {
        this.name = name;
    }

    public Role() {
    }
}
