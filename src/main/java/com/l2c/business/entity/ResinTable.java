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
@Table(name = "tables")
public class ResinTable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(groups = ValidationGroups.Update.class)
    @Size(min = 3, message = "The table name should have at least three characters.")
    private String name;

    @NotNull(groups = ValidationGroups.Update.class)
    @Size(min = 15, message = "Table description should have at least four characters.")
    private String description;

    @NotNull(groups = ValidationGroups.Update.class)
    private Double price;

    @NotNull
    private int length;

    @NotNull
    private int width;

    @NotNull
    private int thickness;

    @NotNull
    private int weight;

    @NotNull
    private int quantity;

    @NotNull
    @Enumerated(EnumType.STRING)
    TableSize tableSize;

    @NotNull
    @Enumerated(EnumType.STRING)
    TableStatus tableStatus;

    // TODO: create customer reviews features

}
