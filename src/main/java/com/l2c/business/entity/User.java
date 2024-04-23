package com.l2c.business.entity;

import com.l2c.business.validation_group.ValidationGroups;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(groups = ValidationGroups.Update.class)
    private String firstName;

    @NotNull(groups = ValidationGroups.Create.class)
    private String secondName;

    @NotNull(groups = ValidationGroups.Update.class)
    @Column(unique = true)
    private String username;

    @NotNull(groups = ValidationGroups.Create.class)
    @Column(unique = true)
    @Email
    private String email;

    @Column(unique = true)
    @NotNull(groups = ValidationGroups.Update.class)
    private String phoneNumber;

    @NotNull(groups = ValidationGroups.Update.class)
    private String city;

    @NotNull(groups = ValidationGroups.Update.class)
    private String password;
    // TODO: add two fields of password and check them


    @CreationTimestamp
    private Date contCreated;

//    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//    @JoinTable(
//            name = "users_roles",
//            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
//            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id")
//    )
//    private Set<Role> roles;
}
